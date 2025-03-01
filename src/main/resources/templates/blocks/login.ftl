<#macro login>
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Логин: </label>
            <div class="col-sm-4">
                <input type="text" name="username" class="form-control" />
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Пароль: </label>
            <div class="col-sm-4">
                <input type="password" name="password" class="form-control" />
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="form-group row">
            <div class="col-sm-10">
                <input type="submit" value="Войти" class="btn btn-primary" />
            </div>
        </div>
    </form>
</#macro>

<#macro registration>
    <form action="/registration" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Имя пользователя: </label>
            <div class="col-sm-4">
                <input type="text" name="username" class="form-control" />
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Пароль: </label>
            <div class="col-sm-4">
                <input type="password" name="password" class="form-control" />
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Номер филиала: </label>
            <div class="col-sm-4">
                <input type="number" name="filial" class="form-control" />
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="form-group row">
            <div class="col-sm-10">
                <input type="submit" value="Добавить" class="btn btn-primary" />
            </div>
        </div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-light ml-3">Выйти</button>
    </form>
</#macro>