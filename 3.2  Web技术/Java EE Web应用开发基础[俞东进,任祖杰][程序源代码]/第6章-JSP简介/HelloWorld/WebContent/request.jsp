	<%@ page language="java" pageEncoding="UTF-8"%>
	<html>
	<head>
	<title>具有request作用域的Bean</title>
	</head>
	<jsp:useBean id="reqBean" scope="request" class="test.RequestURL"/>
	<body bgcolor="#ffffff">
	    <h3>被调用页：request.jsp</h3>
	    <h3>本页面由：<%=reqBean.getURL() %>调用</h3>
	</body>
	</html>