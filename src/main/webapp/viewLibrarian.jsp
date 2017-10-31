<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/30/2017
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="AdminPage.jsp"%>
<html>
<head>
    <title>View Libraian</title>
</head>
<body>
<TABLE BORDER="3" width="100%" class="table">
    <tr>
        <th width="16%">Name</th>
        <th width="16%">Work Number</th>
        <th width="16%">Email</th>
        <th width="16%">Ation</th>
        <th width="16%">Ation</th>



    </tr>

    <c:forEach var="librarian" items="${librarianlist}">
        <tr>
            <td width="16%"><c:out value="${librarian.name}"></c:out></td>
            <td width="16%"><c:out value="${librarian.workNumber}"></c:out></td>
            <td width="16%"><c:out value="${librarian.email}"></c:out></td>
            <form action="#" method="post">
                <td width="16%"><input type="submit"value="EDIT"> </td>
                <input type="hidden" name="number" value="${librarian.workNumber}">
            </form>

            <form action="deleteLibrarian" method="post">
                <td width="16%"><input type="submit"value="DELETE"> </td>
                <input type="hidden" name="number" value="${librarian.workNumber}">

            </form>


        </tr>
    </c:forEach>
</TABLE>
</body>
</html>
