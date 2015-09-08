package com.shcbts.cablemodemreporter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bunchr
 */
public class Query {

    private static Connection conn;

    public static List<UninterruptedVO> uninterrupted() {
        List<UninterruptedVO> list = new ArrayList<>();
        try {
            String sql = "select a.*, \n"
                    + "  round(a.elapsed_secs/60) as elapsed_mins, \n"
                    + "  round(a.elapsed_secs/(60*60)) as elapsed_hours,\n"
                    + "  round(a.elapsed_secs/(60*60*24)) as elapsed_days\n"
                    + "from (\n"
                    + "  select to_char(dtg,'YYYY-MM-DD HH24:MI:SS') as dtg, \n"
                    + "  round((dtg-lag(dtg) over (order by dtg))*86400) as elapsed_secs\n"
                    + "  from log \n"
                    + "  where 1=1\n"
                    + "  and description like 'Unicast Ranging Received Abort Response%' \n"
                    + ") a order by 1 desc";
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
            // deal w/ results
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                UninterruptedVO vo = new UninterruptedVO();
                vo.setDtg(rs.getTimestamp("DTG"));
                vo.setElapsedSecsCount(rs.getInt("ELAPSED_SECS"));
                vo.setElapsedMinsCount(rs.getInt("ELAPSED_MINS"));
                vo.setElapsedHoursCount(rs.getInt("ELAPSED_HOURS"));
                vo.setElapsedDaysCount(rs.getInt("ELAPSED_DAYS"));
                list.add(vo);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static List<AverageVO> avg() {
        List<AverageVO> list = new ArrayList<>();
        try {
            String sql = "select to_char(trunc(dtg),'YYYY-MM-DD') as dtg, count(*) as ct, round(1440/count(*)) as avg_uninterr_mins from log \n"
                    + "where description like 'Unicast Ranging Received Abort Response%'\n"
                    + "group by to_char(trunc(dtg),'YYYY-MM-DD') order by 1 desc";
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
            // deal w/ results
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                AverageVO vo = new AverageVO();
                // just the date, no time
                vo.setDtg(new Date(rs.getDate("DTG").getTime()));
                vo.setCount(rs.getInt("CT"));
                vo.setAvgUninterruptedMins(rs.getInt("AVG_UNINTERR_MINS"));
                list.add(vo);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void init() {
        if (null == conn) {
            try {
                Class.forName("oracle.jdbc.OracleDriver");

                conn = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:xe", "monitor", "version3");
//            connection.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
//        return connection;
        }
    }

    public static void main(String[] args) {
        init();
        System.out.println(avg());
        System.out.println("\n\n\n");
        System.out.println(uninterrupted());
    }
}
