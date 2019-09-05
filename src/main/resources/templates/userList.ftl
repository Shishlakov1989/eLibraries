<#import "blocks/page.ftl" as p>

<@p.page "Список пользователей">
    Список пользователей
    <table>
        <thead>
        <tr>
            <th>Пользователь</th>
            <th>Роль</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
            <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">Редактировать</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
</@p.page>