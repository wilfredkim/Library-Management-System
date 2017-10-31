<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/30/2017
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="AdminPage.jsp"%>
<html>
<head>
    <title>Add Librarian</title>
</head>
<body>
<form method="post" action="addLibrarian">
    <center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Add Librarian</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td> Name</td>
                <td><input type="text" name="name" value="" required/></td>
            </tr>

            <tr>
                <td>Email</td>
                <td><input type="text" name="email" value="" required/></td>
            </tr>
            <tr>
                <td>Work Number</td>
                <td><input type="text" name="worknum" value="" required/></td>
            </tr>
            <tr>
                <td>PassWord</td>
                <td><input type="password" name="pass" value="" required/></td>
            </tr>
            <tr>
                <td> Confirm PassWord</td>
                <td><input type="password" name="cpass" value="" required/></td>
            </tr>



            <tr>
                <td><input type="submit" value="AddLibrarian"/></td>
                <td><input type="reset" value="Reset"/></td>
            </tr>

            </tbody>
        </table>
    </center>
</form>
</body>
</html>
