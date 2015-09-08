<%-- 
    Document   : avg
    Created on : Sep 7, 2015, 6:09:25 PM
    Author     : bunchr
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.shcbts.cablemodemreporter.dao.Query"%>
<%@page import="com.shcbts.cablemodemreporter.dao.AverageVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>avg</title>
        <link rel="stylesheet" href="js/style.css" type="text/css" />
        <script type='text/javascript' src='js/common.js'></script>
        <script type='text/javascript' src='js/css.js'></script>
        <script type='text/javascript' src='js/standardista-table-sorting.js'></script>
    </head>
    <body>
        <h1>avg</h1>
        <a href="uninterrupted.jsp">uninterrupted</a>
        
        <table class="sortable autostripe">
            <thead>
            <th>dtg</th>
            <th>count</th>
            <th>avg uninterr mins</th>
        </thead>
        <tbody>
            <%
                Query.init();
                List<AverageVO> list = Query.avg();
                for (AverageVO vo : list) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            %>
            <tr>
                <td><%=sdf.format(vo.getDtg())%></td>
                <td><%=vo.getCount()%></td>
                <td><%=vo.getAvgUninterruptedMins()%></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
