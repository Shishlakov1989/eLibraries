<#import "blocks/page.ftl" as m>
<#import "blocks/login.ftl" as l>
<#import "blocks/pager.ftl" as p>
<#include "blocks/security.ftl">

<@m.main "Главная страница">
    <#if isLogged>
        <a class="btn btn-secondary" data-toggle="collapse" href="#addReader" role="button" aria-expanded="false" aria-controls="addReader">
            Добавить читателя
        </a>
        <a class="btn btn-info ml-4" data-toggle="collapse" href="#findReader" role="button" aria-expanded="false" aria-controls="findReader">
            Найти читателя
        </a>
        <div class="collapse mt-5 <#if form??>show</#if>" id="addReader">
            <form method="post">
                <div class="form-group row">
                    <label for="surname" class="col-sm-2 col-form-label">Фамилия</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control ${(surnameError??)?string('is-invalid','')}" <#if form??>value="${form.surname}"</#if> name="surname" id="surname" />
                        <#if surnameError??>
                            <div class="invalid-feedback">
                                ${surnameError}
                            </div>
                        </#if>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label">Имя</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control ${(nameError??)?string('is-invalid','')}" <#if form??>value="${form.name}"</#if>  name="name" id="name" />
                        <#if nameError??>
                            <div class="invalid-feedback">
                                ${nameError}
                            </div>
                        </#if>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="patronymic" class="col-sm-2 col-form-label">Отчество</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control ${(patronymicError??)?string('is-invalid','')}" <#if form??>value="${form.patronymic}"</#if>  name="patronymic" id="patronymic" />
                        <#if patronymicError??>
                            <div class="invalid-feedback">
                                ${patronymicError}
                            </div>
                        </#if>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="birthdate" class="col-sm-2 col-form-label">Дата рождения</label>
                    <div class="col-sm-5">
                        <input type="date" class="form-control ${(birthdateError??)?string('is-invalid','')}" <#if form??>value="${form.birthdate}"</#if> name="birthdate" id="birthdate" />
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
                            <input class="form-check-input ${(accountsError??)?string('is-invalid','')}" type="checkbox" name="giveLitres" id="giveLitres" />
                            <#if accountsError??>
                                <div class="invalid-feedback">
                                    ${accountsError}
                                </div>
                            </#if>
                            <#if lrError??>
                                <div class="invalid-feedback">
                                    ${lrError}
                                </div>
                            </#if>
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-2">Non-fiction</div>
                    <div class="col-sm-5">
                        <div class="form-check">
                            <input class="form-check-input ${(accountsError??)?string('is-invalid','')}" type="checkbox" name="giveNonfiction" id="giveNonfiction" />
                            <#if accountsError??>
                                <div class="invalid-feedback">
                                    ${accountsError}
                                </div>
                            </#if>
                            <#if nfError??>
                                <div class="invalid-feedback">
                                    ${nfError}
                                </div>
                            </#if>
                        </div>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
        <div class="collapse mt-5" id="findReader">
            <form method="get">
                <div class="col-sm-5">
                    <input type="text" class="form-control" name="filter" value="${filter?ifExists}">
                    <button type="submit" class="btn btn-primary mt-3">Найти</button>
                </div>
            </form>
        </div>

        <#if (persons?exists)>
            <table class="table mt-5">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">ФИО</th>
                        <th scope="col">Дата рождения</th>
                        <th scope="col">Литрес</th>
                        <th scope="col">Нон-фикшн</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <#list persons.content as person>
                    <tr>
                        <td>
                            <#if person.fio??>
                                ${person.fio}
                            <#else>
                                Нет данных
                            </#if>
                        </td>
                        <td>
                            <#if person.birthdate??>
                                ${person.birthdate}
                            <#else>
                                Нет данных
                            </#if>
                        </td>
                        <td>
                            <#if person.litres??>
                                <a data-toggle="collapse" href="#lrcollapseExample${person.id}" role="button" aria-expanded="false" aria-controls="lrcollapseExample${person.id}">
                                    ${person.litres.login}
                                </a>
                                <div class="collapse" id="lrcollapseExample${person.id}">
                                    ${person.litres.password}
                                </div>
                            <#else>
                                Отсутствует
                            </#if>
                        </td>
                        <td>
                            <#if person.nonfiction??>
                                <a data-toggle="collapse" href="#nfcollapseExample${person.id}" role="button" aria-expanded="false" aria-controls="nfcollapseExample${person.id}">
                                    ${person.nonfiction.login}
                                </a>
                                <div class="collapse" id="nfcollapseExample${person.id}">
                                    ${person.nonfiction.password}
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
            <@p.pager url persons />
        </#if>
    <#else>
        <a href="/login" class="btn btn-secondary">Авторизация</a>
    </#if>
</@m.main>