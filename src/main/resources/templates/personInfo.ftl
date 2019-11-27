<#import "blocks/page.ftl" as p>
<#include "blocks/security.ftl">

<@p.main "Редактирование читателя">
    <form action="/person" method="post">
        <div class="form-group row">
            <label for="surname" class="col-sm-2 col-form-label">Фамилия</label>
            <div class="col-sm-5">
                <input type="text" class="form-control border-0" <#if pform.surname??>value="${pform.surname}"</#if> name="surname" id="surname" />
            </div>
        </div>
        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">Имя</label>
            <div class="col-sm-5">
                <input type="text" class="form-control border-0" <#if pform.name??>value="${pform.name}"</#if>  name="name" id="name" />
            </div>
        </div>
        <div class="form-group row">
            <label for="patronymic" class="col-sm-2 col-form-label">Отчество</label>
            <div class="col-sm-5">
                <input type="text" class="form-control border-0" <#if pform.patronymic??>value="${pform.patronymic}"</#if>  name="patronymic" id="patronymic" />
            </div>
        </div>
        <div class="form-group row">
            <label for="birthdate" class="col-sm-2 col-form-label">Дата рождения</label>
            <div class="col-sm-5">
                <input type="date" class="form-control border-0" name="birthdate" id="birthdate" <#if pform.birthdate??>value="${pform.birthdate}"</#if> />
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-2">Litres</div>
            <div class="col-sm-5">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="giveLitres" id="giveLitres" <#if pform.giveLitres??>value="on" disabled checked</#if> />
                </div>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-2">Non-fiction</div>
            <div class="col-sm-5">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="giveNonfiction" id="giveNonfiction" <#if pform.giveNonfiction??>value="on" disabled checked</#if> />
                </div>
            </div>
        </div>
        <input type="hidden" name="id" value="${pform.id?c}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary">Сохранить</button>
    </form>
    <table class="table mt-5">
        <thead class="thead-light">
            <tr>
                <th scope="col">Название ЭБ</th>
                <th scope="col">Логин</th>
                <th scope="col">Пароль</th>
                <th scope="col">Дата выдачи</th>
                <th scope="col">Филиал</th>
            </tr>
        </thead>
        <tbody>
            <#if litres??>
                <tr>
                    <form action="/person/passLR" method="post">
                        <td>Литрес</td>
                        <td>${litres.login}</td>
                        <td>
                            <#if isAdmin>
                                <input type="text" name="lrPassword" class="border-0" value="${litres.password}" />
                            <#else>
                                ${litres.password}
                            </#if>
                        </td>
                        <td>
                            <#if litres.dateOfIssue??>
                                ${litres.dateOfIssue}
                            <#else>
                                Нет данных
                            </#if>
                        </td>
                        <td>${litres.filial}</td>
                        <#if isAdmin>
                            <td>
                                <input type="hidden" name="lrId" value="${litres.id?c}" />
                                <input type="hidden" name="pId" value="${pform.id?c}" />
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                <button type="submit" class="btn btn-secondary">Редактировать пароль Литрес</button>
                            </td>
                        </#if>
                    </form>
                </tr>
            </#if>
            <#if nonfiction??>
                <tr>
                    <form action="/person/passNF" method="post">
                        <td>Нон-фикшн</td>
                        <td>${nonfiction.login}</td>
                        <td>
                            <#if isAdmin>
                                <input type="text" name="nfPassword" class="border-0" value="${nonfiction.password}" />
                            <#else>
                                ${nonfiction.password}
                            </#if>
                        </td>
                        <td>
                            <#if nonfiction.dateOfIssue??>
                                ${nonfiction.dateOfIssue}
                            <#else>
                                Нет данных
                            </#if>
                        </td>
                        <td>${nonfiction.filial}</td>
                        <#if isAdmin>
                            <td>
                                <input type="hidden" name="nfId" value="${nonfiction.id?c}" />
                                <input type="hidden" name="pId" value="${pform.id?c}" />
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                <button type="submit" class="btn btn-secondary">Редактировать пароль Нон-фикшн</button>
                            </td>
                        </#if>
                    </form>
                </tr>
            </#if>
        </tbody>
    </table>
</@p.main>