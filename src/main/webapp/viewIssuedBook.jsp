<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/23/2017
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="LibrarianPage.jsp"%>
<html>
<head>
    <title>View Books</title>
</head>
<body>
<TABLE BORDER="3" width="100%" class="table">
    <tr>
        <th width="16%">Book Name</th>
        <th width="16%">Book Number</th>
        <th width="16%">Student Registration Number</th>
        <th width="16%">Student Name</th>
        <th width="16%">Date issued</th>
        <th width="16%">Date to return</th>

    </tr>
    <c:forEach var="books" items="${booklist}">
        <tr>
            <td width="16%"><c:out value="${books.book.name}"></c:out></td>
            <td width="16%"><c:out value="${books.book.book_number}"></c:out></td>
            <td width="16%"><c:out value="${books.student.regNo}"></c:out></td>
            <td width="16%"><c:out value="${books.student.name}"></c:out></td>
            <td width="16%"><c:out value="${books.dateofIssue}"></c:out></td>
            <td width="16%"><c:out value="${books.datetoreturn}"></c:out></td>
        </tr>
    </c:forEach>
</TABLE>
</body>
</html>
