<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- page -->
<div data-role="page" id="index-control-led">

	<!-- header -->
	<jsp:include page="/web/common/header.jsp" flush="true">
		<jsp:param name="title" value="LED" />
	</jsp:include>
	<!-- /header -->
	<!-- content -->
	<div role="main"
		class="ui-content ui-page-header-fixed ui-page-footer-fixed">
		<style>
		.led-control .ui-slider {
			float: right !important;
		}
		
		.led-control label {
			float: left;
			line-height: 2.4em;
			margin-bottom: 0;
		}
		.led-control input{
		float: right;
		}
		</style>
		<ul data-role="listview" class="led-control" data-inset="true">

			<li class="ui-field-contain"><label for="flip1">LED1</label> <input type="checkbox" id="filp1" data-role="none" class="uiswitch"></li>

			<li class="ui-field-contain"><label for="flip2">LED2</label> <input type="checkbox" id="filp2" data-role="none"  class="uiswitch"></li>
			<li class="ui-field-contain"><label for="flip3">LED3</label> <input type="checkbox" id="filp3" data-role="none"  class="uiswitch"></li>
			<li class="ui-field-contain"><label for="flip4">LED4</label> <input type="checkbox" id="filp4" data-role="none"  class="uiswitch"></li>
		</ul>
	</div>
	<script>
            $(function () {
                var url = "http://localhost:8080/MobileLifeJava/ctrl";
                $("#flip4").bind("click", function (event) {
                   	localStorage["LED_4"] = $(this).val();
                    $.tools.getData(url + "?typeid=1&id=4&switchNum=" + $(this).val(), function (d) {
                        //alert(d.msg);
                    });
                });
                $("#flip3").bind("change", function (event) {
                   	localStorage["LED_3"] = $(this).val();
                    $.tools.getData(url + "?typeid=1&id=3&switchNum=" + $(this).val(), function (d) {
                        //alert(d.msg);
                    });
                });
                $("#flip2").bind("change", function (event) {
                   	localStorage["LED_2"] = $(this).val();
                    $.tools.getData(url + "?typeid=1&id=2&switchNum=" + $(this).val(), function (d) {
                       // alert(d.msg);
                    });
                });
                $("#flip1").bind("change", function (event) {
                   	localStorage["LED_1"] = $(this).val();
                    $.tools.getData(url + "?typeid=1&id=1&switchNum=" + $(this).val(), function (d) {
                        //alert(d.msg);
                    });
                });
            })
        </script>
	<!-- /content -->
</div>
<!-- /page -->