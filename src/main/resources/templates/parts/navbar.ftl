<#include "security.ftl">

<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <div class="container">
        <a class="navbar-brand link-danger logo" href="/"
           style="font-family: Montserrat, sans-serif;font-weight: bold;">
            <i class="fas fa-clinic-medical" data-bss-hover-animate="wobble" style="margin: 4px;"></i>
            МедДруг
        </a>
        <button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1">
            <span class="visually-hidden">Навигационная панель</span>
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="navbar-nav ms-auto">
                <#if user??>
                    <li class="nav-item"><a class="nav-link float-start" href="/index">Домой</a></li>
                    <li class="nav-item"><a class="nav-link float-start" href="/appointment">Записи</a></li>
                    <li class="nav-item"><a class="nav-link float-start" href="/chronology">Хронологии</a></li>
                    <li class="nav-item"><a class="nav-link float-start" href="/analysis">Анализы</a></li>
                    <li class="nav-item"><a class="nav-link float-start" href="/logout">Выход</a></li>
                <#else>
                    <li class="nav-item"><a class="nav-link float-start" href="/index">Домой</a></li>
                    <li class="nav-item"><a class="nav-link float-start" href="/features">Особенности</a></li>
                    <li class="nav-item"><a class="nav-link float-start" href="/about">О сервисе</a></li>
                    <li class="nav-item"><a class="nav-link float-start" href="/login">Вход</a>
                    </#if>
            </ul>
        </div>
    </div>
</nav>