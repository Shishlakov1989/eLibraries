<%--
  Created by IntelliJ IDEA.
  User: skorp
  Date: 25.07.19
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>Add person</title>
</head>
<body>
    <c:url value="/addPerson" var="var" />
    <form action="${var}" method="post">
        <label for="fio">FIO</label>
        <input type="text" name="fio" id="fio">
        <label for="birthdate">Birthdate</label>
        <input type="date" name="birthdate" id="birthdate">
        <label for="libNum">Номер библиотеки</label>
        <input type="number" name="libNum" id="libNum">
        <label for="giveAccLitres">Litres</label>
        <input type="checkbox" name="giveAccLitres" id="giveAccLitres">
        <label for="giveAccNonfiction">Non-fiction</label>
        <input type="checkbox" name="giveAccNonfiction" id="giveAccNonfiction">
        <input type="submit" value="Add person">
    </form>
</body>
</html>
