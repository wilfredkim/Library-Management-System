<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/23/2017
  Time: 9:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="LibrarianPage.jsp"%>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
<form method="post" action="addStudent">
<center>
    <table border="1" width="30%" cellpadding="5">
        <thead>
        <tr>
            <th colspan="2">Add Student</th>
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
            <td>Registration Number</td>
            <td><input type="text" name="regno" value="" required/></td>
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
            <td>Year of Study</td>
            <td><input type="text" name="yos" value="" required/>
            </td>
        </tr>


        <tr>
            <td><input type="submit" value="AddStudent"/></td>
            <td><input type="reset" value="Reset"/></td>
        </tr>

        </tbody>
    </table>
</center>
</form>
</body>
</html>
