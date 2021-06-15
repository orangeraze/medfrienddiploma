<#import "parts/common.ftl" as common>
<@common.page>
    <main class="page analysis">
        <section class="clean-block clean-form dark" style="width: 100vw;height: 90vh;">
            <div class="container" style="box-shadow: 0px 0px;">
                <div class="block-heading" style="padding-top: 20px;"></div>
                <#if errorMessages?? && (errorMessages?size > 0)>
                    <#list errorMessages as errorMessage>
                        <div role="alert" class="alert alert-danger">
                            <span>Ошибка при добавлении анализа: ${errorMessage}</span></div>
                    </#list>
                </#if>
                <div style="padding: 15px;box-shadow: 0px 0px 6px 1px rgba(33,37,41,0.16);border-radius: 4px;">

                    <#if analyzes?? && (analyzes?size > 0)>

                        <div class="table-responsive table" id="table" style="border-radius: 4px;margin-top: 16px;">
                            <table class="table" id="table">
                                <thead>
                                <tr class="table-primary">
                                    <th class="table-secondary">Анализ</th>
                                    <th class="table-secondary">Значение</th>
                                    <th class="table-secondary">Норма</th>
                                    <th class="table-secondary">Дата</th>
                                </tr>
                                </thead>
                                <tbody id="tableBody">
                                <#list analyzes as analysis>
                                    <tr>
                                        <td class="table-primary"
                                            style="max-width: 155px;border-radius: 4px;background: linear-gradient(90deg, var(--bs-table-bg) 90%, rgba(255,255,255,0) 100%);"
                                            back>
                                            <a href="/analysis/name?name=${analysis.name}"><strong>${analysis.name}</strong></a>
                                        </td>
                                        <td style="max-width: 65px;">${analysis.value}</td>
                                        <td style="max-width: 65px;">${analysis.minnorm}-${analysis.maxnorm} ${analysis.unit}</td>
                                        <td style="max-width: 65px;">${analysis.date!"Не указана"}</td>
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
                                <span>У вас ещё нет анализов. Для добавления, нажмите на кнопку
                                    &quot;Добавить анализ&quot;</span>
                        </div>
                    </#if>
                    <div>
                        <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addAnalysis"
                                type="button" style="margin-top: 12px;margin-bottom: 12px;margin-right: 12px;">Добавить
                            анализ
                        </button>
                    </div>
                </div>
            </div>
        </section>
        <div class="modal fade" role="dialog" tabindex="-1" id="showGraph">
            <div class="modal-dialog modal-xl" role="document">
                <div class="modal-content">
                    <div class="modal-header text-center"><label class="form-label modal-title w-100"
                                                                 style="font-size: 27px;"><strong>График анализа
                                "Гемоглобин"</strong></label>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="container">
                        <div style="margin-bottom: 16px;padding-bottom: 16px;">
                            <canvas data-bss-chart="{&quot;type&quot;:&quot;line&quot;,&quot;data&quot;:{&quot;labels&quot;:[&quot;Дата 1&quot;,&quot;Дата 2&quot;,&quot;Дата 3&quot;,&quot;Дата 4&quot;],&quot;datasets&quot;:[{&quot;label&quot;:&quot;Значение&quot;,&quot;backgroundColor&quot;:&quot;#0d6efd&quot;,&quot;borderColor&quot;:&quot;#4e73df&quot;,&quot;data&quot;:[&quot;70&quot;,&quot;90&quot;,&quot;70&quot;,&quot;100&quot;,&quot;40&quot;],&quot;fill&quot;:true},{&quot;label&quot;:&quot;Норма&quot;,&quot;fill&quot;:true,&quot;data&quot;:[&quot;100&quot;,&quot;100&quot;,&quot;120&quot;,&quot;110&quot;],&quot;borderWidth&quot;:&quot;&quot;,&quot;backgroundColor&quot;:&quot;rgba(42,210,0,0.1)&quot;,&quot;borderColor&quot;:&quot;rgba(42,210,0,0.1)&quot;}]},&quot;options&quot;:{&quot;maintainAspectRatio&quot;:true,&quot;legend&quot;:{&quot;display&quot;:true,&quot;position&quot;:&quot;top&quot;,&quot;reverse&quot;:false},&quot;title&quot;:{&quot;display&quot;:false,&quot;text&quot;:&quot;Анализ&quot;,&quot;fontSize&quot;:&quot;27&quot;},&quot;scales&quot;:{&quot;xAxes&quot;:[{&quot;gridLines&quot;:{&quot;drawBorder&quot;:true,&quot;drawOnChartArea&quot;:true},&quot;ticks&quot;:{&quot;beginAtZero&quot;:false}}],&quot;yAxes&quot;:[{&quot;gridLines&quot;:{&quot;drawBorder&quot;:true,&quot;drawOnChartArea&quot;:true},&quot;ticks&quot;:{&quot;beginAtZero&quot;:false}}]}}}"></canvas>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" role="dialog" tabindex="-1" id="addAnalysis">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Добавить анализ</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="/analysis" method="post">
                            <div>
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <input class="form-control" type="text" placeholder="Название"
                                       style="margin-bottom: 12px;" name="name">
                                <input class="form-control" type="text"
                                       placeholder="Значение"
                                       style="margin-bottom: 12px;"
                                       name="value">
                                <input
                                        class="form-control" type="text" placeholder="Единица измерения"
                                        style="margin-bottom: 12px;" name="unit">
                                <input class="form-control" type="text"
                                       placeholder="Минимальное значение нормы"
                                       style="margin-bottom: 12px;"
                                       name="minnorm">
                                <input class="form-control" type="text"
                                       placeholder="Максимальное значение нормы"
                                       style="margin-bottom: 12px;"
                                       name="maxnorm">
                                <input class="form-control" type="date"
                                       name="date" style="margin-bottom: 12px;"/>
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