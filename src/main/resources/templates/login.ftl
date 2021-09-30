<#import "parts/common.ftl" as common>
<@common.page>
    <main class="page login-page">
        <section class="clean-block clean-form dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Вход</h2>
                    <p>Чтобы пользоваться всеми возможностями сервиса, пожалуйста, авторизуйтесь</p>
                </div>
                <form action="/login" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                    <div class="mb-3"><label class="form-label" for="email">Электронная почта</label><input name="username" class="form-control item" type="email" id="email"></div>
                    <div class="mb-3"><label class="form-label" for="password">Пароль</label><input name="password" class="form-control" type="password" id="password"></div>
                    <div class="mb-3">
                        <div class="form-check"><input class="form-check-input" type="checkbox" id="checkbox"><label class="form-check-label" for="checkbox">Запомнить меня</label></div>
                    </div><button class="btn btn-primary" type="submit">Вход</button><a class="btn btn-success float-end" role="button" href="/registration">Регистрация</a>
                </form>
            </div>
        </section>
    </main>
    <#include "parts/footer.ftl">
</@common.page>