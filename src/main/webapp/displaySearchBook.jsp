<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/28/2017
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="StudentPage.jsp"%>
<html>
<head>
    <title>Search Books</title>
</head>
<body>
<TABLE BORDER="3" width="100%" class="table">
    <tr>

        <th width="16%">Book Author</th>
        <th width="16%">Year of publication of book</th>
        <th width="16%">Book Category</th>
        <th width="16%">Book Location</th>
        <th width="16%">Book Status</th>


    </tr>

    <c:forEach var="books" items="${booklist}">
        <tr>

            <td width="16%"><c:out value="${books.author}"></c:out></td>
            <td width="16%"><c:out value="${books.yearofPublications}"></c:out></td>
            <td width="16%"><c:out value="${books.bookCategory}"></c:out></td>
            <td width="16%"><c:out value="${books.bookLocation}"></c:out></td>
            <td width="16%"><c:out value="${books.status}"></c:out></td>
        </tr>
    </c:forEach>
        <%--<tr>
            <td width="16%"><%=session.getAttribute("name")%></td>
            <td width="16%"><%=session.getAttribute("number")%></td>
            <td width="16%"><%=session.getAttribute("author")%></td>
            <td width="16%"><%=session.getAttribute("yop")%></td>
            <td width="16%"><%=session.getAttribute("category")%></td>
            <td width="16%"><%=session.getAttribute("location")%></td>

        </tr>--%>

</TABLE>
</body>
</html>
