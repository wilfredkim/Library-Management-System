<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/30/2017
  Time: 12:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
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

            <li><a href="addLibrarian">Add Librarian</a></li>

            <li><a href="viewLibrarian">View Librarian</a></li>

            <li><a href="adminLogout">Logout</a></li>

            <li><a href="#">About Us</a></li>
        </ul>
    </div>
</nav>
</body>
</html>
