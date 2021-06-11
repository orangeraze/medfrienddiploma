<#import "parts/common.ftl" as common>
<@common.page>
    <main class="page showAnalysis">
        <section class="clean-block clean-form dark" style="width: 100vw;height: 90vh;">
            <div class="container" style="box-shadow: 0px 0px;">
                <div class="block-heading" style="padding-top: 20px;"></div>
                <#if errorMessages?? && (errorMessages?size > 0)>
                    <#list errorMessages as errorMessage>
                        <div role="alert" class="alert alert-danger">
                            <span>Ошибка при добавлении анализа: ${errorMessage}</span></div>
                    </#list>
                </#if>
                <#if !(analyzes?? && (analyzes?size > 0))>
                    <div role="alert" class="alert alert-warning">
                        <span>У вас ещё нет анализов. Для добавления, нажмите на кнопку
                            &quot;Добавить анализ&quot;</span>
                    </div>
                </#if>

                <div style="padding: 15px;box-shadow: 0px 0px 6px 1px rgba(33,37,41,0.16);border-radius: 4px;">
                    <a class="btn btn-primary" role="button" href="/analysis">Назад</a>
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
                                            back><strong>${analysis.name}</strong></td>
                                        <td style="max-width: 65px;">${analysis.value} ${analysis.unit}</td>
                                        <td style="max-width: 65px;">${analysis.norm!"Не указана"}</td>
                                        <td style="max-width: 65px;">${analysis.date!"Не указана"}</td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                    <#--                        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#showGraph" type="button"-->
                    <#--                                style="margin-left: 12px;">Показать график-->
                    <#--                        </button>-->
                        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#showGraph"
                                type="button">Показать график
                        </button>
                        <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addAnalysis"
                                type="button" style="margin-left: 12px;">Добавить анализ
                        </button>

                    <#else>
                        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addAnalysis"
                                type="button"
                                style="margin-left: 12px;">Добавить анализ
                        </button>
                    </#if>
                </div>
            </div>
        </section>
        <div class="modal fade" role="dialog" tabindex="-1" id="showGraph">
            <div class="modal-dialog modal-xl" role="document">
                <div class="modal-content">
                    <div class="modal-header text-center" style="border-bottom-style: none;"><label class="form-label modal-title w-100"
                                                                 style="font-size: 27px;"><strong>График анализа
                                "${RequestParameters.name}"</strong></label>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="container">
                        <div id="chart">
                            <script>
                                $(document).on('shown.bs.modal', "#showGraph", function () {
                                    $("#chart").shieldChart({
                                        theme: "light",
                                        primaryHeader: {
                                            text: ""
                                        },
                                        exportOptions: {
                                            image: false,
                                            print: false
                                        },
                                        axisX: {
                                            categoricalValues: [${dateList?join(", ")}]
                                        },
                                        tooltipSettings: {
                                            chartBound: true,
                                            axisMarkers: {
                                                enabled: true,
                                                mode: 'xy'
                                            }
                                        },
                                        dataSeries: [{
                                            seriesType: 'line',
                                            collectionAlias: "Значение анализа",
                                            data: [${valueList?join(", ")}]
                                        }]
                                    });
                                });
                            </script><!-- /.График -->
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
                                <#if RequestParameters.name?exists >
                                    <input type="hidden" name="name" value="${RequestParameters.name}"/>
                                <#else>
                                    <input class="form-control" type="text"
                                           placeholder="Название"
                                           style="margin-bottom: 12px;"
                                           name="name">                                </#if>
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <input class="form-control" type="text"
                                       placeholder="Значение"
                                       style="margin-bottom: 12px;"
                                       name="value">
                                <input
                                        class="form-control" type="text" placeholder="Единица измерения"
                                        style="margin-bottom: 12px;" name="unit">
                                <input class="form-control" type="text"
                                       placeholder="Норма"
                                       style="margin-bottom: 12px;"
                                       name="norm">
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