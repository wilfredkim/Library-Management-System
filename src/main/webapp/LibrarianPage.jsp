<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/23/2017
  Time: 12:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Library Management System</a>
        </div>
        <ul class="nav navbar-nav">

            <li class="active"><a href="index.jsp">Home</a></li>
            <%-- <li><a href="addvisitor">Visitor</a></li>--%>

            <li><a href="addbook">Add Book</a></li>
            <li><a href="addStudent">Add Student</a></li>
            <li><a href="viewAllBooks">View Books</a></li>
            <li><a href="issueBook">Issue Book</a></li>
            <li><a href="viewIssuedbooks"> view Issued Book</a></li>
            <li><a href="returnBook">Return Book</a></li>
            <li><a href="librarianLogout">Logout</a></li>

            <li><a href="#">About Us</a></li>
        </ul>
    </div>
</nav>
</body>
</html>
