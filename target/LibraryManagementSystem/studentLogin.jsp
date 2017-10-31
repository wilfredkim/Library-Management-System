<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/24/2017
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp"%>
<html>
<head>
    <title>Student Login</title>
</head>
<body>
<form  action="studentLogin" method="post">
    <center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Sign-In</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <td>Email</td>
                <td><input type="text" name="email" id="email"  required/></td>
            </tr>

            <tr>
                <td>PassWord</td>
                <td><input type="password" name="pass" value=""required /></td>
            </tr>

            <td><input type="submit" value="Sign-In" /></td>
            <td><input type="reset" value="Reset" /></td>
            </tr>

            </tbody>
        </table>
    </center>
</form>
</body>
</html>
