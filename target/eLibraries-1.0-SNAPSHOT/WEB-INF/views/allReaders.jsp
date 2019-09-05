<%--
  Created by IntelliJ IDEA.
  User: vitaliy
  Date: 03.07.19
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
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
            <td>${person.birthdate}</td>
            <c:if test="${person.id_litres != 0}">
                <c:if test="${!empty litresses}">
                    <c:forEach var="litres" items="${litresses}">
                        <c:if test="${person.id_litres == litres.id_accLitres}">
                            <td><style>
                                    .del { display: none; }
                                    .del:not(:checked) + label + * { display: none; }

                                    /* тут редактируем вид кнопки */
                                    .del:not(:checked) + label,
                                    .del:checked + label {
                                        display: inline-block;
                                        padding: 2px 10px;
                                        border-radius: 2px;
                                        color: #fff;
                                        background: #4e6473;
                                        cursor: pointer;
                                    }
                                    .del:checked + label {
                                        background: #e36443;
                                    }
                                </style>

                                <input type="checkbox" id="lr${person.id}" class="del"/>
                                <label for="lr${person.id}" class="del">${litres.login}</label>
                                <div>
                                    ${litres.password}
                                </div>
                            </td>
                        </c:if>
                    </c:forEach>
                </c:if>
            </c:if>
            <c:if test="${empty person.giveAccLitres}">
                <td>Учетная запись отсутствует</td>
            </c:if>

            <c:if test="${person.id_nonfiction != 0}">
                <c:if test="${!empty nonfictions}">
                    <c:forEach var="nonfiction" items="${nonfictions}">
                        <c:if test="${person.id_nonfiction == nonfiction.id_accNonfiction}">
                            <td>
                                <style>
                                    .del { display: none; }
                                    .del:not(:checked) + label + * { display: none; }

                                    /* тут редактируем вид кнопки */
                                    .del:not(:checked) + label,
                                    .del:checked + label {
                                        display: inline-block;
                                        padding: 2px 10px;
                                        border-radius: 2px;
                                        color: #fff;
                                        background: #4e6473;
                                        cursor: pointer;
                                    }
                                    .del:checked + label {
                                        background: #e36443;
                                    }
                                </style>

                                <input type="checkbox" id="nf${person.id}" class="del"/>
                                <label for="nf${person.id}" class="del">${nonfiction.login}</label>
                                <div>
                                    ${nonfiction.password}
                                </div>
                            </td>
                        </c:if>
                    </c:forEach>
                </c:if>
            </c:if>
            <c:if test="${empty person.giveAccNonfiction}">
                <td>Учетная запись отсутствует</td>
            </c:if>
            <td>
                <a href="/edit/${person.id}">Редактировать</a>
                <br />
                <a href="/person/${person.id}">Подробная информация</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>