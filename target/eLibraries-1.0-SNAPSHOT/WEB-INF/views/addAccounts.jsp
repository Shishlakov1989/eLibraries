<%--
  Created by IntelliJ IDEA.
  User: skorp
  Date: 13.08.19
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>Добавление учетных записей Литрес</title>
</head>
<body>
    <c:url value="/addAccounts" var="var" />
    <form action="${var}" enctype="multipart/form-data" method="post">
        <label for="fileName">Путь к файлу новых учетных записей Литрес/Нон-фикшн</label>
        <br />
        <input type="file" name="fileName" id="fileName">
        <br />
        <input type="submit" value="Добавить аккаунты">
    </form>
</body>
</html>
