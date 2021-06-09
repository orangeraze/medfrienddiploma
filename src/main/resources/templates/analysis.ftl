<#import "parts/common.ftl" as common>
<@common.page>
    <main class="page analysis">
        <section class="clean-block clean-form dark">
            <div class="container" style="box-shadow: 0px 0px;">
                <div class="block-heading"></div>
                <div style="padding: 15px;box-shadow: 0px 0px 6px 1px rgba(33,37,41,0.16);border-radius: 20px;">
                    <div class="table-responsive table" id="table" style="border-radius: 20px;">
                        <table class="table" id="table">
                            <thead>
                            <tr class="table-primary">
                                <th>Анализ</th>
                                <th>Значение</th>
                                <th>Норма</th>
                            </tr>
                            </thead>
                            <tbody id="tableBody">
                            <tr>
                                <td style="max-width: 155px;">Гемоглобин</td>
                                <td style="max-width: 65px;">145 г/л</td>
                                <td style="max-width: 65px;">130-160 г/л</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <button class="btn btn-primary" id="addRow" type="button" data-complete-text="finished">Добавить
                    </button>
                    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modal1" type="button"
                            style="margin-left: 12px;">Показать график
                    </button>
                    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addAnalysis" type="button"
                            style="margin-left: 12px;">Добавить анализ
                    </button>
                </div>
            </div>
        </section>
        <div class="modal fade" role="dialog" tabindex="-1" id="modal1">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="container">
                        <#--                        <div style="margin-bottom: 16px;padding-bottom: 16px;">-->
                        <#--                            <canvas data-bss-chart="{&quot;type&quot;:&quot;line&quot;,&quot;data&quot;:{&quot;labels&quot;:[&quot;{date?index}&quot;,&quot;{date?index}&quot;,&quot;{date?index}&quot;,&quot;{date?index}&quot;,&quot;{date?index}&quot;,&quot;{date?index}&quot;],&quot;datasets&quot;:[{&quot;label&quot;:&quot;Revenue&quot;,&quot;backgroundColor&quot;:&quot;#4e73df&quot;,&quot;borderColor&quot;:&quot;#4e73df&quot;,&quot;data&quot;:[&quot;4500&quot;,&quot;5300&quot;,&quot;6250&quot;,&quot;7800&quot;,&quot;9800&quot;,&quot;15000&quot;],&quot;fill&quot;:true}]},&quot;options&quot;:{&quot;maintainAspectRatio&quot;:true,&quot;legend&quot;:{&quot;display&quot;:false,&quot;position&quot;:&quot;top&quot;,&quot;reverse&quot;:false},&quot;title&quot;:{&quot;display&quot;:true,&quot;text&quot;:&quot;${analysis}&quot;,&quot;fontSize&quot;:&quot;27&quot;},&quot;scales&quot;:{&quot;yAxes&quot;:[{&quot;gridLines&quot;:{&quot;drawOnChartArea&quot;:true}}]}}}"></canvas>-->
                        <#--                        </div>-->
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
                        <form action="post">
                            <div>
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
                                       placeholder="Норма"
                                       style="margin-bottom: 12px;"
                                       name="norm">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-light" type="button" data-bs-dismiss="modal">Закрыть</button>
                        <button class="btn btn-primary" type="button">Добавить</button>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <#include "parts/footer.ftl">
</@common.page>