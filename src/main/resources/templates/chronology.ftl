<#import "parts/common.ftl" as common>
<@common.page>
    <main class="page chronology">
        <section class="clean-block clean-form dark" style="width: 100vw;height: 90vh;">
            <div class="container" style="box-shadow: 0px 0px;">
                <div class="block-heading" style="padding-top: 20px;"></div>
                <#if errorMessages?? && (errorMessages?size > 0)>
                    <#list errorMessages as errorMessage>
                        <div role="alert" class="alert alert-danger">
                            <span>Ошибка при добавлении хронологии: ${errorMessage}</span></div>
                    </#list>
                </#if>

                <div style="padding: 15px;box-shadow: 0px 0px 6px 1px rgba(33,37,41,0.16);border-radius: 4px;">


                    <#if chronologies?? && (chronologies?size > 0)>

                        <div class="table-responsive table" id="table" style="border-radius: 4px;margin-top: 16px;">
                            <table class="table" id="table">
                                <thead>
                                <tr class="table-primary">
                                    <th class="table-secondary" style="width: 25%;">Болезнь</th>
                                    <th class="table-secondary" style="width: 25%;max-width: 33%">Текст</th>
                                    <th class="table-secondary" style="width: 25%;">Дата</th>
                                </tr>
                                </thead>
                                <tbody id="tableBody">

                                <#list chronologies as chronology>
                                    <tr>
                                        <td class="table-primary"
                                            style="max-width: 155px;border-radius: 4px;background: linear-gradient(90deg, var(--bs-table-bg) 90%, rgba(255,255,255,0) 100%);"
                                            back>
                                            <strong>${chronology.disease}</strong>
                                        </td>
                                        <td style="max-width: 65px;  text-wrap: normal; word-wrap: break-word; white-space: pre-wrap;">${chronology.text!"Не указан"}</td>

                                        <td style="max-width: 65px;">C ${chronology.startdate!"-"} по ${chronology.enddate!"-"}</td>

                                    </tr>
                                </#list>

                                </tbody>
                            </table>
                        </div>

                    <#else>
                        <div role="alert" class="alert alert-warning">
                                <span>У вас ещё нет данных о болезнях. Для добавления, нажмите на кнопку
                                    &quot;Добавить хронологию&quot;</span>
                        </div>
                    </#if>
                    <div>
                        <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addChronology"
                                type="button" style="margin-top: 12px;margin-bottom: 12px;margin-right: 12px;">Добавить
                            хронологию
                        </button>
                    </div>
                </div>
            </div>
        </section>
        <div class="modal fade" role="dialog" tabindex="-1" id="addChronology">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Добавить запись</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="/chronology" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <div class="mb-3">
                                <input class="form-control" type="text" style="margin-bottom: 12px;" name="disease" placeholder="Болезнь">
                            </div>
                            <div class="mb-3"><textarea class="form-control" name="text"></textarea></div>
                            <div class="mb-3" style="margin-top: 12px;"><input class="form-control"
                                                                               type="date" name="startdate"
                                                                               style="margin-bottom: 12px;"></div>
                            <div class="mb-3" style="margin-top: 12px;"><input class="form-control"
                                                                               type="date" name="enddate"
                                                                               style="margin-bottom: 12px;"></div>
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