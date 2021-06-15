<#macro page>
    <!DOCTYPE html>
    <html lang="ru">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Home - MedFriend</title>
        <meta name="description" content="Сайт для хранения данных о здоровье себя и семьи">
        <link rel="stylesheet" href="../static/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="../static/assets/fonts/fontawesome-all.min.css">
        <link rel="stylesheet" href="../static/assets/fonts/simple-line-icons.min.css">
        <link rel="stylesheet" href="../static/assets/fonts/typicons.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
        <link rel="stylesheet" href="../static/assets/css/vanilla-zoom.min.css">
        <link type="text/css" rel="StyleSheet" href="https://bootstraptema.ru/plugins/2016/shieldui/style.css"/>
        <script src="../static/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="../static/assets/js/bs-init.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
        <script src="../static/assets/js/vanilla-zoom.js"></script>
        <script src="../static/assets/js/theme.js"></script>
        <script src="https://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
        <script src="https://bootstraptema.ru/plugins/2016/shieldui/script.js"></script>
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/exporting.js"></script>
        <script src="https://code.highcharts.com/modules/export-data.js"></script>
        <script src="https://code.highcharts.com/modules/accessibility.js"></script>
    </head>
    <body>
    <#include "navbar.ftl">
    <#nested>

    </body>
    </html>
</#macro>