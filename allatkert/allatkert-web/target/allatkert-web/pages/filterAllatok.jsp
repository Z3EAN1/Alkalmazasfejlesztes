<%@ page import="java.sql.*" %>
<%@ page import="hu.alkfej.config.Configuration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% Class.forName("org.sqlite.JDBC"); %>

<html>
<head>
    <link rel="stylesheet" href="../css/style2.css">
    <%@ include file="header.jsp" %>
    <TITLE>Vadaspark</TITLE>
</head>
<body>
<h1>Örökbefogadott állatok</h1>

<%
    Connection connection = DriverManager.getConnection(Configuration.getValue("db.url"));

    Statement statement = connection.createStatement() ;
    ResultSet result = statement.executeQuery("SELECT orokbefogadhatoallat.nev, faj, fenykep, szoveg, szuldatum FROM OROKBEFOGADHATOALLAT INNER JOIN KONYVELES ON orokbefogadhatoallat.id = orokbefogadhato_allat_id GROUP BY orokbefogadhatoallat.nev");
%>


<table class="tabla">
    <TR>
        <TH>NÉV</TH>
        <TH>FAJ</TH>
        <TH>FÉNYKÉP</TH>
        <TH>BEMUTATKOZÓ SZÖVEG</TH>
        <TH>SZÜLETÉSI DÁTUM</TH>
    </TR>
    <% while(result.next()){
    %>
    <TR class="tabla2">
        <TD> <%= result.getString(1) %></TD>
        <TD> <%= result.getString(2) %></TD>
        <td><img src="result.getString(3)"></td>
        <TD> <%= result.getString(4) %></TD>
        <TD> <%= result.getString(5) %></TD>
    </TR>
    <% } %>
</table>






</body>
</html>
