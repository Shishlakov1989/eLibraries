<#import "blocks/page.ftl" as p>
<#import "blocks/login.ftl" as l>
<#include "blocks/security.ftl">

<@p.main "Главная страница">
    <#if isLogged>
        <a class="btn btn-secondary" data-toggle="collapse" href="#addReader" role="button" aria-expanded="false" aria-controls="addReader">
            Добавить читателя
        </a>
        <a class="btn btn-info ml-4" data-toggle="collapse" href="#findReader" role="button" aria-expanded="false" aria-controls="findReader">
            Найти читателя
        </a>
        <div class="collapse mt-5" id="addReader">
            <form method="post">
                <div class="form-group row">
                    <label for="surname" class="col-sm-2 col-form-label">Фамилия</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control"  name="surname" id="surname" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label">Имя</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control"  name="name" id="name" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="patronymic" class="col-sm-2 col-form-label">Отчество</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control"  name="patronymic" id="patronymic" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="birthdate" class="col-sm-2 col-form-label">Birthdate</label>
                    <div class="col-sm-5">
                        <input type="date" class="form-control ${(birthdateError??)?string('is-invalid','')}" name="birthdate" id="birthdate" />
                        <#if birthdateError??>
                            <div class="invalid-feedback">
                                  ${birthdateError}
                            </div>
                        </#if>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-2">Litres</div>
                    <div class="col-sm-5">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="giveLitres" id="giveLitres" />
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-2">Non-fiction</div>
                    <div class="col-sm-5">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="giveNonfiction" id="giveNonfiction" />
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
                        <td>${person.surname} ${person.name} ${person.patronymic}</td>
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
        <a href="/login" class="btn btn-secondary">Авторизация</a>
    </#if>
</@p.main>