<#macro login path submit>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">User name: </label>
            <div class="col-sm-4">
                <input type="text" name="username" class="form-control" />
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password: </label>
            <div class="col-sm-4">
                <input type="password" name="password" class="form-control" />
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="form-group row">
            <div class="col-sm-10">
                <input type="submit" value="${submit}" class="btn btn-primary" />
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