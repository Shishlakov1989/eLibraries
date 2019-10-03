<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-md navbar-light bg-light">
    <a class="navbar-brand" href="/">eLibraries</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/manager">Manager</a>
            </li>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">Список пользователей</a>
                </li>
            </#if>
        </ul>

        <#if isLogged>
            <div class="navbar-text">${name}</div>
            <@l.logout />
        </#if>
    </div>
</nav>