<#--<!DOCTYPE html>-->
<#--<html>-->
<#--<head>-->
<#--    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">-->
<#--    <script type="text/javascript">-->
<#--        window.onload = function() {-->

<#--            var dps = [[]];-->
<#--            var chart = new CanvasJS.Chart("chartContainer", {-->
<#--                theme: "light2", // "light1", "dark1", "dark2"-->
<#--                animationEnabled: true,-->
<#--                title: {-->
<#--                    text: "Анализ"-->
<#--                },-->
<#--                subtitles: [{-->
<#--                    text: "Гемоглобин"-->
<#--                }],-->
<#--                axisX: {-->
<#--                    valueFormatString: "####"-->
<#--                },-->
<#--                axisY: {-->
<#--                    title: "Значение"-->
<#--                },-->
<#--                data: [{-->
<#--                    type: "spline",-->
<#--                    xValueFormatString: "####",-->
<#--                    yValueFormatString: "#,##0.0 million carats",-->
<#--                    dataPoints: dps[0]-->
<#--                }]-->
<#--            });-->

<#--            var xValue;-->
<#--            var yValue;-->

<#--            <#list dataPointsList as dataPoints>-->
<#--                <#list dataPoints as dataPoint>-->

<#--            xValue = parseInt("${dataPoint.x}");-->
<#--            yValue = parseInt("${dataPoint.y}");-->
<#--            dps[parseInt("${dataPoints?index}")].push({-->
<#--                x : xValue,-->
<#--                y : yValue-->
<#--            });-->
<#--            </#list>-->
<#--            </#list>-->


<#--            chart.render();-->

<#--        }-->
<#--    </script>-->


<#--    -->
<#--</head>-->
<#--<body>-->
<#--<div id="chartContainer" style="height: 370px; width: 100%;"></div>-->
<#--<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>-->
<#--</body>-->
<#--</html>-->


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>
    <link type="text/css" rel="StyleSheet" href="https://bootstraptema.ru/plugins/2016/shieldui/style.css"/>
    <script src="https://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
    <script src="https://bootstraptema.ru/plugins/2016/shieldui/script.js"></script>
</head>
<body>
<br><br><br>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">

            <!-- График -->
            <div id="chart">

                <script>


                    $(document).ready(function () {
                        $("#chart").shieldChart({
                            theme: "light",
                            primaryHeader: {
                                text: "Обзор бюджета"
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
            </div><!-- /.col-md-8 col-md-offset-2 -->
        </div><!-- /.row -->
    </div>
    <!-- /.container -->
</body>