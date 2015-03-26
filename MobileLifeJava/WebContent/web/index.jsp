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
                <li><a href="#index-info-btn" data-transition="flow">按钮监视</a></li>
                <li><a href="#index-info-ad" data-transition="flow">Ad输入监视</a></li>
            </ul>
        </div>
        <!-- /content -->
        
        <div data-role="panel" data-position="right" data-position-fixed="true" data-display="overlay" data-theme="a" id="login-form">
	        <form class="userform">
	            <h2>登陆</h2>
	            <label for="name">用户名:</label>
	            <input type="text" name="name" id="name" value="" data-clear-btn="true" data-mini="true">
	            <label for="password">密码:</label>
	            <input type="password" name="password" id="password" value="" data-clear-btn="true" autocomplete="off" data-mini="true">
	            <div class="ui-grid-a">
	                <div class="ui-block-a"><a href="#" data-rel="close" class="ui-btn ui-shadow ui-corner-all ui-btn-b ui-mini">Cancel</a></div>
	                <div class="ui-block-b"><a href="#" data-rel="close" class="ui-btn ui-shadow ui-corner-all ui-btn-a ui-mini">Login</a></div>
	            </div>
	        </form>
    	</div>
    </div>
    <!-- /page -->
   
   <%@include file="/web/ctrl-led.jsp"%>
   <%@include file="/web/ctrl-voice.jsp"%>
   <%@include file="/web/info-ad.jsp"%>
   <%@include file="/web/info-btn.jsp"%>
</body>
</html>
