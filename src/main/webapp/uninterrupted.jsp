<%-- 
    Document   : avg
    Created on : Sep 7, 2015, 6:09:25 PM
    Author     : bunchr
--%>

<%@page import="java.util.List"%>
<%@page import="com.shcbts.cablemodemreporter.dao.Query"%>
<%@page import="com.shcbts.cablemodemreporter.dao.UninterruptedVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>uninterrupted</title>
        <link rel="stylesheet" href="js/style.css" type="text/css" />
        <script type='text/javascript' src='js/common.js'></script>
        <script type='text/javascript' src='js/css.js'></script>
        <script type='text/javascript' src='js/standardista-table-sorting.js'></script>
    </head>
    <body>
        <h1>uninterrupted</h1>
        <a href="avg.jsp">avg</a>

        <table class="sortable autostripe">
            <thead>
                <th>dtg</th>
                <th>elapsed secs</th>
                <th>elapsed mins</th>
                <th>elapsed hours</th>
                <th>elapsed days</th>
            </thead>
            <tbody>
            <% 
                Query.init();
                List<UninterruptedVO> list = Query.uninterrupted();
                for (UninterruptedVO vo : list) {
                    %>
                    <tr>
                        <td><%=vo.getDtg()%></td>
                        <td><%=vo.getElapsedSecsCount()%></td>
                        <td><%=vo.getElapsedMinsCount()%></td>
                        <td><%=vo.getElapsedHoursCount()%></td>
                        <td><%=vo.getElapsedDaysCount()%></td>
                    </tr>
                    <%
                }
            %>
            </tbody>
        </table>
    </body>
</html>
