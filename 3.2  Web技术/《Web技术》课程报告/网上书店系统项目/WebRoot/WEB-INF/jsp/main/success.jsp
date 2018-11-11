<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>恭喜，操作成功!</title>
<link type="text/css" href="./css/admin.css"  rel=stylesheet />
</head>
<body>
<center><img src="./images/success.gif" title="恭喜，操作成功!"/><br>
<strong>恭喜，操作成功!</strong><br>
<% if(session.getAttribute("LoginName")==null) 
{%>
<a href="adminLogin.jsp">赶快去登录吧!</a>
<%} %>
</center>

</body>
</html>