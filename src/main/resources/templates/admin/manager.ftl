<#import "../blocks/page.ftl" as p>

<@p.main "Панель управления">
    <form method="post" enctype="multipart/form-data" action="/manager">
        <label for="file">Ожидается текстовый файл в кодировке UTF-8</label>
        <input type="file" name="file" accept=".txt">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary">Загрузить</button>
    </form>

    <div>
        <#if (message?exists)>
            ${message}
        </#if>
    </div>
</@p.main>