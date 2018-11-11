<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//如果没有登录就跳转到登录页面
	
	if ("".equals(session.getAttribute("LoginName")) || null == session.getAttribute("LoginName")) {
%>
	<jsp:forward page="/admin/adminLogin.jsp"/>
<%}%>