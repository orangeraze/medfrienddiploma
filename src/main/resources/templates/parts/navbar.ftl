<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <div class="container"><a class="navbar-brand link-danger logo" href="/" style="font-family: Montserrat, sans-serif;font-weight: bold;"><i class="fas fa-clinic-medical" data-bss-hover-animate="wobble" style="margin: 4px;"></i>МедДруг</a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="/index">Домой</a></li>
                <li class="nav-item"><a class="nav-link" href="/features">Особенности</a></li>
                <li class="nav-item"><a class="nav-link" href="/about">О сервисе</a></li>
                <li class="nav-item"><a class="nav-link border rounded-pill border-primary shadow-sm" href="/login">Вход</a></li>
            </ul>
        </div>
    </div>
</nav>