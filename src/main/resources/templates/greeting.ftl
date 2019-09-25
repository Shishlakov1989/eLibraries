<#import "blocks/page.ftl" as p>
<#import "blocks/login.ftl" as l>
<#include "blocks/security.ftl">

<@p.main "Главная страница">
    <#if isLogged>
    <#if birthdateError??>
        ${birthdateError}
    </#if>
        <a class="btn btn-secondary" data-toggle="collapse" href="#addReader" role="button" aria-expanded="false" aria-controls="addReader">
            Добавить читателя
        </a>
        <a class="btn btn-info ml-4" data-toggle="collapse" href="#findReader" role="button" aria-expanded="false" aria-controls="findReader">
            Найти читателя
        </a>
        <div class="collapse mt-5" id="addReader">
            <form action="/addReader" method="post">
                <div class="form-group row">
                    <label for="fio" class="col-sm-2 col-form-label">FIO</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control"  name="fio" id="fio" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="birthdate" class="col-sm-2 col-form-label">Birthdate</label>
                    <div class="col-sm-5">
                        <input type="date" class="form-control " name="birthdate" id="birthdate" />

                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-2">Litres</div>
                    <div class="col-sm-5">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="hasLitres" id="hasLitres" />
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-2">Non-fiction</div>
                    <div class="col-sm-5">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="hasNonfiction" id="hasNonfiction" />
                        </div>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
        <div class="collapse mt-5" id="findReader">
            <form method="get">
                <input type="text" name="filter" value="${filter?ifExists}">
                <button type="submit">Найти</button>
            </form>
        </div>

        <#if (persons?exists)>
            <table class="table mt-5">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">ФИО</th>
                        <th scope="col">Дата рождения</th>
                        <th scope="col">Литрес</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <#list persons as person>
                    <tr>
                        <td>${person.fio}</td>
                        <td>${person.birthdate}</td>
                        <td>
                            <#if person.litres??>
                                <a data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                    ${person.litres.login}
                                </a>
                                <div class="collapse" id="collapseExample">
                                    ${person.litres.password}
                                </div>
                            <#else>
                                Отсутствует
                            </#if>
                        </td>

                        <td><a href="/person/${person.id}">Редактировать</a></td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </#if>
    <#else>
        <@l.login />
    </#if>
</@p.main>