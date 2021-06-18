<%@ page import="java.sql.*" %>
<%@ page import="hu.alkfej.config.Configuration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% Class.forName("org.sqlite.JDBC"); %>

<html>
<head>
<%--   <link rel="stylesheet" href="../css/index.css">--%>
    <link rel="stylesheet" href="../css/style2.css">
    <%@ include file="header.jsp" %>
    <title>Vadaspark</title>
</head>

<body>

<div>
    <h3>Már örökbefogadott állatok listája:</h3>
    <form  action="filterAllatok.jsp" method="post">
        <button class="gomb1" id="submit" type="submit" class="btn btn-primary">Örökbefogadott állatok.</button>
    </form>
</div>


<div>
    <h3>Még nem örökbefogadott állatok listája:</h3>
    <form  action="filter2Allat.jsp" method="post">
        <button class="gomb2" id="sub" type="submit" class="btn btn-primary">Még nem örökbefogadott állatok.</button>
    </form>
</div>


</br>


<h1>Vadaspark állatai</h1>

<%
    Connection connection = DriverManager.getConnection(Configuration.getValue("db.url"));

    Statement statement = connection.createStatement() ;
    ResultSet rs = statement.executeQuery("SELECT nev, faj, fenykep, szoveg, szuldatum FROM OROKBEFOGADHATOALLAT") ;
%>

<table >
    <TR >
        <TH>NÉV</TH>
        <TH>FAJ</TH>
        <TH>FÉNYKÉP</TH>
        <TH>BEMUTATKOZÓ SZÖVEG</TH>
        <TH>SZÜLETÉSI DÁTUM</TH>
    </TR>
    <% while(rs.next()){
    %>

    <TR class="tabla2">
        <TD> <%= rs.getString(1) %></TD>
        <TD> <%= rs.getString(2) %></TD>
        <TD> <%= rs.getString(3) %></TD>
        <TD> <%= rs.getString(4) %></TD>
        <TD> <%= rs.getString(5) %></TD>
    </TR>
    <% } %>

</table>





</body>
</html>
