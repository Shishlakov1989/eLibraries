<#import "blocks/page.ftl" as p>
<#import "blocks/login.ftl" as l>

<@p.main "Регистрация">
    ${message}
    <@l.login "/registration" />
</@p.main>