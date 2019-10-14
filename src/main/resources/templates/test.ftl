<#import "blocks/page.ftl" as m>

<@m.main "Главная страница">
    <#if acc??>
        ${acc.login}
        <br />
        ${acc.password}
    </#if>
</@m.main>