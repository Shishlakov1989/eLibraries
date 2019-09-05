<%--
  Created by IntelliJ IDEA.
  User: skorp
  Date: 24.07.19
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>Edit person</title>
</head>
<body>
    <a href="/">Main</a>
    <br />
    <c:url value="/edit" var="var" />
    <form action="${var}" method="post">
        <input type="hidden" name="id" value="${person.id}">
        <label for="fio">FIO</label>
        <input type="text" name="fio" id="fio">
        <label for="birthdate">Birthdate</label>
        <input type="date" name="birthdate" id="birthdate">
        <input type="hidden" name="id_litres" id="id_litres" value="${person.id_litres}">
        <input type="hidden" name="id_nonfiction" id="id_nonfiction" value="${person.id_nonfiction}">
        <input type="submit" value="Edit person">
    </form>
</body>
</html>