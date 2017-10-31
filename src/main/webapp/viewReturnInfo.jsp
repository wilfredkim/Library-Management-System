<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/31/2017
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="LibrarianPage.jsp"%>
<html>
<head>
    <title>View Return Info</title>
</head>
<body>
<TABLE BORDER="3" width="100%" class="table">
    <tr>
        <th width="11%">Book Name</th>
        <th width="11%">Book Number</th>
        <th width="11%">Student Registration Number</th>
        <th width="11%">Student Name</th>
        <th width="11%">Date issued</th>
        <th width="11%">Date to return</th>
        <th width="11%">Actual Date Return</th>
        <th width="11%">Late days</th>
        <th width="11%">Penalty</th>

    </tr>
    <c:forEach var="info" items="${infolist}">
        <tr>
            <td width="11%"><c:out value="${info.issuedBook.book.name}"></c:out></td>
            <td width="11%"><c:out value="${info.issuedBook.book.book_number}"></c:out></td>
            <td width="11%"><c:out value="${info.issuedBook.student.regNo}"></c:out></td>
            <td width="11%"><c:out value="${info.issuedBook.student.name}"></c:out></td>
            <td width="11%"><c:out value="${info.issuedBook.dateofIssue}"></c:out></td>
            <td width="11%"><c:out value="${info.issuedBook.datetoreturn}"></c:out></td>
            <td width="11%"><c:out value="${info.date}"></c:out></td>
            <td width="11%"><c:out value="${info.late_days}"></c:out></td>
            <td width="11%"><c:out value="${info.penalty}"></c:out></td>
        </tr>
    </c:forEach>
</TABLE>
</body>
</html>
