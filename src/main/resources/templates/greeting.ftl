<#import "blocks/page.ftl" as p>
<#include "blocks/security.ftl">

<@p.main "Greeting">
<div>Hello</div>
    <#if isLogged>
        <a class="btn btn-secondary" data-toggle="collapse" href="#addReader" role="button" aria-expanded="false" aria-controls="addReader">
            Добавить читателя
        </a>
        <a class="btn btn-info ml-4" data-toggle="collapse" href="#findReader" role="button" aria-expanded="false" aria-controls="findReader">
            Найти читателя
        </a>
        <div class="collapse mt-5" id="addReader">
            <form action="/readers" method="post">
                <label for="fio">FIO</label>
                <input type="text" name="fio" id="fio" />
                <label for="birthdate">Birthdate</label>
                <input type="date" name="birthdate" id="birthdate" />
                <label for="hasLitres">Litres</label>
                <input type="checkbox" name="hasLitres" id="hasLitres" />
                <label for="hasNonfiction">Non-fiction</label>
                <input type="checkbox" name="hasNonfiction" id="hasNonfiction" />
                <label for="libNum">Library number</label>
                <input type="number" name="libNum" id="libNum" />
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button type="submit">Добавить</button>
            </form>
        </div>
        <div class="collapse mt-5" id="findReader">
            <form method="get" action="/readers">
                <input type="text" name="filter" value="${filter?ifExists}">
                <button type="submit">Найти</button>
            </form>
        </div>
    <#else>
        <a class="btn btn-primary mt-3" href="/login">
            Авторизация
        </a>
    </#if>
</@p.main>