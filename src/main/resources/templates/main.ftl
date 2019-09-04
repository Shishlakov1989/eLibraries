<#import "blocks/page.ftl" as p>
<#import "blocks/login.ftl" as l>

<@p.main "Главная страница">
<div>
    <@l.logout />
</div>
<div><a href="/addPerson">Добавить читателя</a></div>
<div>Список пользователей</div>
<#list persons as person>
    <div>
        ${person.fio}
        ${person.birthdate}
    </div>
<#else>
Нет читателей
</#list>
</@p.main>