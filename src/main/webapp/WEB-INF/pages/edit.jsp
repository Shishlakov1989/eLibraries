<%--
  Created by IntelliJ IDEA.
  User: skorp
  Date: 10.06.19
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<c:url value="/edit" var="var" />
<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${person.id}">
    <label for="fio">ФИО</label>
    <input type="text" name="fio" id="fio">
    <label for="birth">Родился</label>
    <input type="text" name="birth" id="birth">
    <label for="litres">Литрес</label>
    <input type="text" name="litres" id="litres">
    <label for="nonfiction">Нон-фикшн</label>
    <input type="text" name="nonfiction" id="nonfiction">
    <input type="submit" value="Edit person">
</form>
<a href="/">Back</a>
</body>
</html>