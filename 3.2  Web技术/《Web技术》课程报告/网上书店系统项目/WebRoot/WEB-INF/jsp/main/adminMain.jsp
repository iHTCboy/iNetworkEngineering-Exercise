<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>网上书店后台</title>
<style type="text/css">
ul{
	background-image: url( './img/admin/title_bg_hide.gif' );
}
li{
	list-style: none;
	height:25px;
}
a{
	color:#d81e7a;
	font-size:15px;
	text-decoration: none;
}
a:hover
{
	font-size:18px;
	color: green;
	text-decoration: underline;
}
</style>
<script language="javascript">

</script>
</head>


<body>

<table cellpadding=0 cellspacing=0 width=158 align=left>
	
	
	<h1>
	后台管理
	</h1>
	<tr><td>图书管理</td></tr>
	<tr><td>
	<ul>
		<li><a href="http://htc:8080/dang/main/adminBook?category.id=2&category.parentId=1" target="right">图书管理</a></li>
		<li>
		<a href="${pageContext.request.contextPath}/main/toAddBookAtion"
					class="b">添加图书</a>
	<!--
	
		<a href="http://htc:8080/dang/main/adminBookList.jsp" target="right">添加图书</a>
	
	
		<s:form action="toLoginAction" id="ctl00" namespace="/main">
		<input type="submit" id="btnSignCheck" class="button_enter"
										value="添加图书" />
		
		</s:form>  
		-->
	
		</li>
	</ul></td></tr>

	<tr><td>订单管理</td></tr>
	<tr><td>
	<ul>
		<li><a href="AdminGetAllOrders.action?CurrentPage=1&PageSize=6" target="right">订单管理</a></li>
		<li><a href="adminGetSendOrders.action?CurrentPage=1&PageSize=6" target="right">处理订单</a></li>
	</ul></td></tr>
	
	<tr><td>用户管理</td></tr>
	<tr><td>
	<ul>
		<li><a href="AdminUserManage.action?CurrentPage=1&PageSize=2" target="right">会员管理</a></li>
		<li><a href="adminChangePassword.jsp" target="right">修改密码</a></li>
	</ul></td></tr>
</table>
</body>
</html>