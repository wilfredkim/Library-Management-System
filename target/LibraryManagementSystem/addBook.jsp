<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/23/2017
  Time: 12:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="LibrarianPage.jsp"%>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<form method="post" action="addbook">
    <center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Add Book</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Book Name</td>
                <td><input type="text" name="name" value="" required/></td>
            </tr>

            <tr>
                <td>Book Author</td>
                <td><input type="text" name="author" value="" required/></td>
            </tr>
            <tr>
                <td> Book Number</td>
                <td><input type="text" name="booknum" value="" required/></td>
            </tr>
            <tr>
                <td> Book ISB Number</td>
                <td><input type="text" name="isb" value="" required/></td>
            </tr>
            <tr>
                <td>Year of Publication</td>
                <td><input type="date" name="yop" value="" required/>
                </td>
            </tr>
            <tr>
                <td> Book Category</td>
                <td><select name="category">
                    <option>Languages</option>
                    <option>Mathematics</option>
                    <option>Sciences</option>
                    <option>Humanities</option>
                    <option>Agricluture and Business</option>
                    <option>General</option>
                </select></td>
            </tr>
            <tr>
                <td>Book Location</td>
                <td><input type="text" name="location" value="" required/></td>
            </tr>
            <tr>


            <tr>
                <td><input type="submit" value="AddBook"/></td>
                <td><input type="reset" value="Reset"/></td>
            </tr>

            </tbody>
        </table>
    </center>
</form>
</body>
</html>
