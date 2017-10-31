<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/28/2017
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="StudentPage.jsp"%>
<html>
<head>
    <title>Search Book</title>
</head>

<body>
<form method="post" action="searchbook">
    <center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Search Book</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Book Name</td>
                <td><input type="text" name="name" value="" required/></td>
            </tr>

            <tr>
                <td> Book Number</td>
                <td><input type="text" name="booknum" value="" required/></td>
            </tr>

            <tr>
                <td><input type="submit" value="Search Book"/></td>
                <td><input type="reset" value="Reset"/></td>
            </tr>

            </tbody>
        </table>
    </center>
</form>
</body>
</html>
