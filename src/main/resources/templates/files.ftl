<#import "parts/common.ftl" as common>
<@common.page>
    <main class="page files">
        <section class="clean-block clean-form dark" style="width: 100vw;height: 90vh;">
            <div class="container" style="box-shadow: 0px 0px;">
                <div class="block-heading" style="padding-top: 20px;"></div>
                <#if errorMessages?? && (errorMessages?size > 0)>
                    <#list errorMessages as errorMessage>
                        <div role="alert" class="alert alert-danger">
                            <span>Ошибка при добавлении файла: ${errorMessage}</span></div>
                    </#list>
                </#if>
                <div style="padding: 15px;box-shadow: 0px 0px 6px 1px rgba(33,37,41,0.16);border-radius: 4px;">

                    <#if files?? && (files?size > 0)>

                        <div class="table-responsive table" id="table" style="border-radius: 4px;margin-top: 16px;">
                            <table class="table" id="table">
                                <thead>
                                <tr class="table-primary">
                                    <th class="table-secondary">Имя файла</th>
                                    <th class="table-secondary">Тип</th>
                                    <th class="table-secondary">Дата</th>
                                </tr>
                                </thead>
                                <tbody id="tableBody">
                                <#list files as file>
                                    <tr>
                                        <td class="table-primary"
                                            style="max-width: 155px;border-radius: 4px;background: linear-gradient(90deg, var(--bs-table-bg) 90%, rgba(255,255,255,0) 100%);"
                                            back>
                                            <a href="/files/${file.id}"><strong>${file.name}</strong></a>
                                        </td>
                                        <td style="max-width: 65px;">Картинка</td>
                                        <td style="max-width: 65px;">${file.date!"${.now?date?string.iso}"}</td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                    <#--                        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#showGraph" type="button"-->
                    <#--                                style="margin-left: 12px;">Показать график-->
                    <#--                        </button>-->
                    <#else>
                        <div role="alert" class="alert alert-warning">
                                <span>У вас ещё нет файлов. Для добавления, нажмите на кнопку
                                    &quot;Добавить файл&quot;</span>
                        </div>
                    </#if>
                    <div>
                        <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addFile"
                                type="button" style="margin-top: 12px;margin-bottom: 12px;margin-right: 12px;">Добавить
                            файл
                        </button>
                    </div>
                </div>
            </div>
        </section>
        <div class="modal fade" role="dialog" tabindex="-1" id="addFile">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Добавить файл</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="/files" method="post" enctype="multipart/form-data">
                            <div>
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <input type="file" name="file"/>
                            </div>
                            <div class="modal-footer">
                                <button class="btn btn-light" type="button" data-bs-dismiss="modal">Закрыть</button>
                                <button class="btn btn-primary" type="submit">Добавить</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </main>
    <#include "parts/footer.ftl">
</@common.page>