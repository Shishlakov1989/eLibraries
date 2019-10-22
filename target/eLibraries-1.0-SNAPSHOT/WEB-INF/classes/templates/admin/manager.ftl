<#import "../blocks/page.ftl" as p>

<@p.main "Панель управления">
    <form method="post" enctype="multipart/form-data" action="/manager">
        <div class="form-group">
            <label for="file">Загрузите текстовый файл в стандартной кодировке Windows</label>
            <input type="file" name="file" class="form-control-file" accept=".txt">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit" class="btn btn-secondary mt-2">Загрузить</button>
        </div>
    </form>

    <div>
        <#if (message?exists)>
            ${message}
        </#if>
    </div>
</@p.main>