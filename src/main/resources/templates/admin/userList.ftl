<#import "../blocks/page.ftl" as p>

<@p.main "Список пользователей">
    <p class="text-center">Список пользователей</p>
    <a class="btn btn-secondary" href="/registration">
        Добавить пользователя
    </a>
    <table class="table mt-5">
        <thead class="thead-light">
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
</@p.main>