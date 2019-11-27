<#import "../blocks/page.ftl" as p>

<@p.main "Список пользователей">
    <h3 class="text-center">Список пользователей</h3>
    <a class="btn btn-secondary" href="/registration">
        Добавить пользователя
    </a>
    <#if (users?exists)>
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
                    <td>
                        <a href="/user/${user.id?c}">Редактировать</a>
                        <br/>
                        <a href="/user/delete/${user.id?c}">Удалить</a>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    </#if>
</@p.main>