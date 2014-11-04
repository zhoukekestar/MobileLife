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
		</style>
		<ul data-role="listview" class="led-control" data-inset="true">

			<li class="ui-field-contain"><label for="flip1">LED1</label> <select
				name="flip1" id="flip1" data-role="slider">
					<option value="0">关</option>
					<option value="1">开</option>
			</select></li>

			<li class="ui-field-contain"><label for="flip2">LED2</label> <select
				name="flip2" id="flip2" data-role="slider">
					<option value="0">关</option>
					<option value="1">开</option>
			</select></li>
			<li class="ui-field-contain"><label for="flip3">LED3</label> <select
				name="flip3" id="flip3" data-role="slider">
					<option value="0">关</option>
					<option value="1">开</option>
			</select></li>
			<li class="ui-field-contain"><label for="flip4">LED4</label> <select
				name="flip4" id="flip4" data-role="slider">
					<option value="0">关</option>
					<option value="1">开</option>
			</select></li>
		</ul>
	</div>
	<script>
            $(function () {
                var url = "http://localhost:8080/MobileLifeJava/ctrl";
                $("#flip4").bind("change", function (event) {
                    $.tools.getData(url + "?typeid=1&id=4&switchNum=" + $(this).val(), function (d) {
                        //alert(d.msg);
                    });
                });
                $("#flip3").bind("change", function (event) {
                    $.tools.getData(url + "?typeid=1&id=3&switchNum=" + $(this).val(), function (d) {
                        //alert(d.msg);
                    });
                });
                $("#flip2").bind("change", function (event) {
                    $.tools.getData(url + "?typeid=1&id=2&switchNum=" + $(this).val(), function (d) {
                       // alert(d.msg);
                    });
                });
                $("#flip1").bind("change", function (event) {
                    $.tools.getData(url + "?typeid=1&id=1&switchNum=" + $(this).val(), function (d) {
                        //alert(d.msg);
                    });
                });
            })
        </script>
	<!-- /content -->
</div>
<!-- /page -->