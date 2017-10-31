<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/23/2017
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="LibrarianPage.jsp"%>
<html>
<head>
    <title>Issue Book</title>
</head>
<body>
<body>
<form  action="issueBook" method="post">
    <center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Issue Book</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <td>Student Registration Number</td>
                <td><input type="text" name="regno"   required/></td>
            </tr>
            <tr>
                <td>Book Number</td>
                <td><input type="text" name="booknum"   required/></td>
            </tr>
            <tr>
                <td>Issue Date</td>
                <td><input type="date" name="issuedate"   required/></td>
            </tr>
            <tr>
                <td>Return Date</td>
                <td><input type="date" name="returndate"   required/></td>
            </tr>



            <td><input type="submit" value="Issue"/></td>
            <td><input type="reset" value="Reset" /></td>
            </tr>

            </tbody>
        </table>
    </center>
</form>
</body>
</body>
</html>
