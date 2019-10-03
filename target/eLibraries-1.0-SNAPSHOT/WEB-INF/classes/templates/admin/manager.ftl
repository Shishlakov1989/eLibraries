<#import "../blocks/page.ftl" as p>

<@p.main "Панель управления">
    <form method="post" enctype="multipart/form-data" action="/manager">
        <div class="form-group">
            <label for="file">Ожидается текстовый файл в кодировке UTF-8</label>
            <input type="file" name="file" class="form-control-file" accept=".txt">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit" class="btn btn-primary mt-2">Загрузить</button>
        </div>
    </form>

    <div>
        <#if (message?exists)>
            ${message}
        </#if>
    </div>
</@p.main>