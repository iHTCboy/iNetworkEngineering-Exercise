<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>对不起，操作失败!</title>
 <link type="text/css" href="./css/admin.css"  rel=stylesheet />
</head>
<body>
	<center><img src="./images/sorry.gif" title="对不起，操作失败!"/><br/>
	<strong>对不起，操作失败!</strong>
	 <div class="redText">
		<s:fielderror></s:fielderror>
	</div>
	<% if(session.getAttribute("LoginName")==null)
		{%>
	<a href="adminLogin.jsp">返回登录界面</a>
	<%} %>
	</center>
</body>
</html>