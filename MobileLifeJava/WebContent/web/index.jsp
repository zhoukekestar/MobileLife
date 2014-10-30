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
   
   <%@include file="/web/ctrl-led.jsp"%>
   <%@include file="/web/ctrl-voice.jsp"%>
</body>
</html>
