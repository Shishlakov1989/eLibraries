<%--
  Created by IntelliJ IDEA.
  User: skorp
  Date: 02.08.19
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Подробная информация</title>
</head>
<body>
    <table>
        <tr>
            <td>ФИО</td>
            <td>${person.fio}</td>
        </tr>
        <tr>
            <td>Дата рождения</td>
            <td>${person.birthdate}</td>
        </tr>
        <c:if test="${!empty litres}">
            <tr>
                <td>Логин Литрес</td>
                <td>${litres.login}</td>
            </tr>
            <tr>
                <td>Пароль Литрес</td>
                <td>${litres.password}</td>
            </tr>
            <tr>
                <td>Дата выдачи логина</td>
                <td>${litres.dateOfIssue}</td>
            </tr>
            <tr>
                <td>Филиал выдачи</td>
                <td>${litres.libraryNum}</td>
            </tr>
        </c:if>
        <c:if test="${!empty nonfiction}">
            <tr>
                <td>Логин Нон-фикшн</td>
                <td>${nonfiction.login}</td>
            </tr>
            <tr>
                <td>Пароль Нон-фикшн</td>
                <td>${nonfiction.password}</td>
            </tr>
            <tr>
                <td>Дата выдачи логина</td>
                <td>${nonfiction.dateOfIssue}</td>
            </tr>
            <tr>
                <td>Филиал выдачи</td>
                <td>${nonfiction.libraryNum}</td>
            </tr>
        </c:if>
    </table>
</body>
</html>
