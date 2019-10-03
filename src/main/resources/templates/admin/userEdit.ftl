<#import "../blocks/page.ftl" as p>

<@p.main "Редактирование пользователя ${user.username}">
    <form action="/users" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Имя пользователя: </label>
            <div class="col-sm-4">
                <input type="text" name="username" class="form-control border-0 bg-white" readonly id="username" value="${user.username}" />
            </div>
        </div>
        <#list roles as role>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="${role}">${role}</label>
                <div class="col-sm-4">
                    <input type="checkbox" class="form-check-input" name="${role}" id="${role}" ${user.roles?seq_contains(role)?string("checked","")} />
                </div>
            </div>
        </#list>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Филиал: </label>
            <div class="col-sm-4">
                <input type="number" name="filial" class="form-control" id="filial" value="${user.filial}" />
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Новый пароль: </label>
            <div class="col-sm-4">
                <input type="password" name="password" class="form-control" id="password" />
            </div>
        </div>
        <!--<input type="text" name="username" value="${user.username}">-->
        <input type="hidden" name="userId" value="${user.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary mt-4">Сохранить</button>
    </form>
</@p.main>