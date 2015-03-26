<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- page -->
<div data-role="page" id="index-control-voice">

	<!-- header -->
	<jsp:include page="/web/common/header.jsp" flush="true">
		<jsp:param name="title" value="Voice" />
	</jsp:include>
	<!-- /header -->

	<!-- content -->
	<div role="main"
		class="ui-content ui-page-header-fixed ui-page-footer-fixed">
		<ul data-role="listview" data-inset="true">
			<li class="ui-field-contain">
				<img src="/MobileLifeJava/images/voice.gif">
				<label for="flip2">声音</label> 
				<input type="range" name="slider2" class="slide" id="slider231" value="0" min="0" max="100" data-highlight="true" onchange="send($(this).val());">
			</li>
		</ul>
	</div>
	<script>
		function send(val)
		{
			console.log("音量：" + val);
		}
    </script>
	<!-- /content -->
</div>
<!-- /page -->