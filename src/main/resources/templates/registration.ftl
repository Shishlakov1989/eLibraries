<#import "blocks/page.ftl" as p>
<#import "blocks/login.ftl" as l>

<@p.main "Регистрация">
    <#if (message?exists)>
        ${message}
    </#if>
    <@l.login "/registration" "Регистрация"/>
</@p.main>