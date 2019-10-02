<#import "../blocks/page.ftl" as p>
<#import "../blocks/login.ftl" as l>

<@p.main "Регистрация">
    <#if (message?exists)>
        <div class="text-nowrap mb-4">${message}</div>
    </#if>
    <@l.registration/>
</@p.main>