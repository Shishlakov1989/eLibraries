<#import "blocks/page.ftl" as p>

<@p.main "Список пользователей">
    Список пользователей
    <table>
        <thead>
        <tr>
            <th>Читатель</th>
            <th>Роль</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
            <#list persons as person>
            <tr>
                <td>${person.fio}</td>
                <td>
                    <#if person.litres??>
                        ${person.litres.login}
                    <#else>
                        none
                    </#if>
                </td>
                <td><a href="/user/${person.id}">Редактировать</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
</@p.main>