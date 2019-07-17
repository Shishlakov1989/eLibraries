<%--
  Created by IntelliJ IDEA.
  User: vitaliy
  Date: 03.07.19
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Все читатели электронных библиотек</title>
</head>
<body>
<h2>Список всех читателей</h2>
<table>
    <tr>
        <th>ID</th>
        <th>FIO</th>
        <th>Birthday</th>
        <th>LitRes</th>
        <th>Non-fiction</th>
        <th>action</th>
    </tr>
    <c:forEach var="person" items="${persons}">
        <tr>
            <td>${person.id}</td>
            <td>${person.fio}</td>
            <td>${person.birthdate.getTime()}</td>
            <td>${person.id_accLitres}</td>
            <td>${person.id_accNonfiction}</td>
            <td>
                <a href="/edit/${person.id}">Edit</a>
                <a href="/delete/${person.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add" />
    <a href="${add}">Add new person</a>
</body>
</html>
