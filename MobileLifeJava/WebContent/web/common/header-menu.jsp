<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="ui-alt-icon ui-header-fixed" data-role="header">
    <a href="#" data-rel="back" class="ui-btn ui-icon-carat-l ui-btn-icon-left ui-btn-icon-notext ui-corner-all"></a>
	<h1>${param.title}</h1>
    <a href="#mypanel-321" class="ui-btn ui-icon-bars ui-btn-icon-left ui-btn-icon-notext ui-corner-all"></a>
</div>
<script>
    function menu(){
        
    }
</script>
<div data-role="panel" id="mypanel-321" data-position="right" data-display="push" data-position-fixed="true">
    <a href="#my-header" data-rel="close" class="ui-btn ui-corner-all">取消</a>
    <ul data-role="listview" data-inset="true" class="ui-alt-icon ui-nodisc-icon" style="margin-top: 0.5em;">
        <li><a href="PhoneWeb/GoodsDetails/GoosDetails.jsp" data-ajax="false">宝贝详情</a></li>
        <li><a href="PhoneWeb/inviteFriend/inviteFriend.jsp" data-ajax="false">邀请好友</a></li>
        <li><a href="PhoneWeb/lottery/lottery.jsp" data-ajax="false">摇奖</a></li>
        <li><a href="PhoneWeb/leaflets/leaflets.jsp" data-ajax="false">宣传单</a></li>
        <li><a href="lottery" data-ajax="false">摇奖请求随机数</a></li>
        <li><a href="PhoneWeb/shop/shop.jsp" data-ajax="false">我的店铺</a></li>
        <li><a href="PhoneWeb/login/login.jsp" data-ajax="false">登录</a></li>
    </ul>
</div>