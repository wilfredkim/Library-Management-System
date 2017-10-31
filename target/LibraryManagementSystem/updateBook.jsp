<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/30/2017
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="LibrarianPage.jsp" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" class="panel" role="form" action="updatingBook">

    <div class="wrapper">
        <div class="page-head">
            <h3 class="m-b-less">
                UPDATE BOOK
            </h3>
        </div>
        <br>
        <div class="form-group">
            <label class="col-lg-2 control-label"> Book Name</label>

            <div class="col-lg-4">
                <input type="text" class=" form-control" name="name" value="<%= session.getAttribute("name")%>"
                       required>
            </div>
        </div>
        <br>
        <div class="form-group">
            <label class="col-lg-2 control-label">Book Number</label>

            <div class="col-lg-4">
                <input type="text" class=" form-control" name="number" value="<%= session.getAttribute("number")%>"
                       required>
            </div>
        </div>
        <br>
        <div class="form-group">
            <label class="col-lg-2 control-label">Book ISB Number</label>

            <div class="col-lg-4">
                <input type="text" class=" form-control" name="isb" value="<%= session.getAttribute("isb")%>"
                       required>
            </div>
        </div>
        <br>

        <div class="form-group">
            <label class="col-lg-2 control-label">Book Author</label>

            <div class="col-lg-4">
                <input type="text" class=" form-control" name="author" value="<%= session.getAttribute("author")%>"
                       required>
            </div>
        </div>


        <br>

        <div class="form-group">
            <label class="col-lg-2 control-label">Year of Publications</label>

            <div class="col-lg-4">
                <input type="text" class=" form-control" name="yop" value="<%= session.getAttribute("yop")%>" required>
            </div>
        </div>


        <br>
        <div class="form-group">
            <label class="col-lg-2 control-label">Book Category</label>

            <div class="col-lg-4">
                <input type="text" class=" form-control" name="category" value="<%= session.getAttribute("category")%>"
                       required>
            </div>
        </div>
        <br>
        <div class="form-group">
            <label class="col-lg-2 control-label">Book Location</label>

            <div class="col-lg-4">
                <input type="text" class=" form-control" name="location" value="<%= session.getAttribute("location")%>"
                       required>
            </div>
        </div>
        <br>
        <div class="form-group">
            <label class="col-lg-2 control-label">Book Status</label>

            <div class="col-lg-4">
                <input type="text" class=" form-control" name="status" value="<%= session.getAttribute("status")%>"
                       required>
            </div>
        </div>


        <br>

        <p class="submit"><input class="btn btn-info m-b-10" type="submit" name="assign" value="UPDATE">

    </div>
</form>

</body>
</html>
