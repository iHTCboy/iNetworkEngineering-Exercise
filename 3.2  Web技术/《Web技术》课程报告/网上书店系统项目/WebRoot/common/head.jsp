<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<link href="${pageContext.request.contextPath}/css/book_head090107.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.4.min.js">
</script>

<script type="text/javascript">
$(function() {
	ShowTime();
	window.setInterval(ShowTime, 1000);
	function ShowTime() {
		var now = new Date();
		$('#timespan').html(now.toLocaleString());
	}
});
</script>
<div class="head_container">
	<div class="head_welcome">
		<div class="head_welcome_right">
			<span class="head_welcome_text"> </span>
			<span class="head_welcome_text"> <span class="little_n">
					| <a href="#" name="mydangdang" class="head_black12a">我的信息</a> 
					| </span> </span>
			<div class="cart gray4012">
				<a href="${pageContext.request.contextPath }/cart/cartListAction">购物车</a>
			</div>
		</div>
		<span class="head_toutext" id="logininfo"> <b><s:property
					value="#session['user'].nickname" />您好，欢迎光临七彩网</b> <s:if
				test="#session['user']!=null">
		[&nbsp;<a href="${pageContext.request.contextPath}/user/logoutAction"
					class="b">登出</a>&nbsp;]
		</s:if> <s:else>
		[&nbsp;<a href="${pageContext.request.contextPath}/user/loginAction"
					class="b">登录</a>&nbsp;|&nbsp;<a
					href="${pageContext.request.contextPath}/user/doRegistAction"
					class="b">注册</a>&nbsp;]
		</s:else> </span>
	</div>
	<div class="head_head_list">
		<div class="head_head_list_left">
			<span class="head_logo"><a
				href="${pageContext.request.contextPath}/mainAction"
				name="backtobook"><img
						src="${pageContext.request.contextPath}/images/booksaleimg/book_logo.gif" />
			</a> </span>
		</div>
		<div class="head_head_list_right">

			<div class="head_head_list_right_b">
			</div>
		</div>
	</div>
	<div class="head_search_div">
		<span id="timespan" class="head_timespan"></span>
		<s:form action="searchAction" namespace="/main">
		<input class="head_search_button" type="submit" value="搜索"/>
		<span class="head_search_input" ><s:textfield name="key"/></span>
		</s:form>
	</div>
	<div class="head_search_bg"></div>
</div>
