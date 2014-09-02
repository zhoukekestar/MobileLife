<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <%@include file="/web/common/head.jsp"%>
    
</head>
<body>
    <!-- page -->
    <div data-role="page" id="index-controls">

        <!-- header -->
        <jsp:include page="/web/common/header.jsp" flush="true">
            <jsp:param name="title" value="CONTROLS" />
        </jsp:include>
        <!-- /header -->
        <!-- content -->
        <div role="main" class="ui-content ui-page-header-fixed ui-page-footer-fixed">
            <ul data-role="listview" data-inset="true">
                <li><a href="#index-control-voice" data-transition="flow">声音控制</a></li>
                <li><a href="#index-control-led" data-transition="flow">LED控制</a></li>
            </ul>
        </div>
        <!-- /content -->
    </div>
    <!-- /page -->
    <!-- page -->
    <div data-role="page" id="index-control-voice">

        <!-- header -->
        <jsp:include page="/web/common/header.jsp" flush="true">
            <jsp:param name="title" value="Voice" />
        </jsp:include>
        <!-- /header -->
        <!-- content -->
        <div role="main" class="ui-content ui-page-header-fixed ui-page-footer-fixed">
            <ul data-role="listview" data-inset="true">
                <li class="ui-field-contain">
                    <label for="flip2">声音</label>
                    <input type="range" name="slider2" class="slide" id="slider231" value="0" min="0" max="100" data-highlight="true">
                    <input id="abc" />
                </li>
            </ul>
        </div>
        <script>
            $(function () {
                $("#abc,#slider231").bind("change", function (event, ui) {
                    var e = event;
                    var u = ui;
                    var a = 1;
                });
            })
        </script>
        <!-- /content -->
    </div>
    <!-- /page -->
    <!-- page -->
    <div data-role="page" id="index-control-led">

        <!-- header -->
        <jsp:include page="/web/common/header.jsp" flush="true">
            <jsp:param name="title" value="LED" />
        </jsp:include>
        <!-- /header -->
        <!-- content -->
        <div role="main" class="ui-content ui-page-header-fixed ui-page-footer-fixed">
            <style>
                .led-control .ui-slider {
                    float: right !important;
                }

                .led-control label {
                    float: left;
                    line-height: 2.4em;
                    margin-bottom: 0;
                }
            </style>
            <ul data-role="listview" class="led-control" data-inset="true">

                <li class="ui-field-contain">
                    <label for="flip1">LED1</label>
                    <select name="flip1" id="flip1" data-role="slider">
                        <option value="off">关</option>
                        <option value="on">开</option>
                    </select>
                </li>

                <li class="ui-field-contain">
                    <label for="flip2">LED2</label>
                    <select name="flip2" id="flip2" data-role="slider">
                        <option value="off">关</option>
                        <option value="on">开</option>
                    </select>
                </li>
                <li class="ui-field-contain">
                    <label for="flip3">LED3</label>
                    <select name="flip3" id="flip3" data-role="slider">
                        <option value="off">关</option>
                        <option value="on">开</option>
                    </select>
                </li>
                <li class="ui-field-contain">
                    <label for="flip4">LED4</label>
                    <select name="flip4" id="flip4" data-role="slider">
                        <option value="off">关</option>
                        <option value="on">开</option>
                    </select>
                </li>
            </ul>
        </div>
        <script>
            $(function () {
                var url = "http://localhost:8080/MobileLifeJava/ctrl";
                $("#flip4").bind("change", function (event) {
                    $.tools.getData(url + "?type=led&id=4&action=" + $(this).val(), function (d) {
                        //alert(d.msg);
                    });
                });
                $("#flip3").bind("change", function (event) {
                    $.tools.getData(url + "?type=led&id=3&action=" + $(this).val(), function (d) {
                        //alert(d.msg);
                    });
                });
                $("#flip2").bind("change", function (event) {
                    $.tools.getData(url + "?type=led&id=2&action=" + $(this).val(), function (d) {
                       // alert(d.msg);
                    });
                });
                $("#flip1").bind("change", function (event) {
                    $.tools.getData(url + "?type=led&id=1&action=" + $(this).val(), function (d) {
                        //alert(d.msg);
                    });
                });
            })
        </script>
        <!-- /content -->
    </div>
    <!-- /page -->
</body>
</html>
