<#import "blocks/page.ftl" as p>

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
            <label for="birthdate" class="col-sm-2 col-form-label">Birthdate</label>
            <div class="col-sm-5">
                <input type="date" class="form-control" name="birthdate" id="birthdate" <#if pform.birthdate??>value="${pform.birthdate}"</#if> />
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
        <input type="hidden" name="id" value="${pform.id}">
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
                    <td>Литрес</td>
                    <td>${litres.login}</td>
                    <td>${litres.password}</td>
                    <td>${litres.dateOfIssue}</td>
                    <td>${litres.filial}</td>
                </tr>
            </#if>
            <#if nonfiction??>
                <tr>
                    <td>Нон-фикшн</td>
                    <td>${nonfiction.login}</td>
                    <td>${nonfiction.password}</td>
                    <td>${nonfiction.dateOfIssue}</td>
                    <td>${nonfiction.filial}</td>
                </tr>
            </#if>
        </tbody>
    </table>
</@p.main>