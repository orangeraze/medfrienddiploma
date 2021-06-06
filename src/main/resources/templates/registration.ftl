<#import "parts/common.ftl" as common>
<@common.page>
    <main class="page registration-page">
        <section class="clean-block clean-form dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Регистрация</h2>
                    <p>Чтобы начать пользоваться сервисом, пожалуйста, зарегистрируйтесь</p>
                </div>
                <form>
                    <div class="mb-3"></div>
                    <div class="mb-3"><label class="form-label" for="name">Имя</label><input class="form-control item" type="text" id="name"><label class="form-label" for="email">Электронная почта</label><input class="form-control item" type="email" id="email"><label class="form-label" for="password">Пароль</label><input class="form-control item" type="password" id="password"></div>
                    <div class="mb-3"></div><button class="btn btn-primary" type="submit">Регистрация</button>
                </form>
            </div>
        </section>
    </main>
    <#include "parts/footer.ftl">
</@common.page>