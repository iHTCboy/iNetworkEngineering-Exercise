	<%@ page language="java" pageEncoding="UTF-8"%>
	 <%@ page import="test.Counter"%>
	<html>
	<head>
	<title>具有session作用域的Bean</title>
	</head>
	<jsp:useBean id="CountBean" scope="session" class="test.Counter"/>
	<body bgcolor="#ffffff">
	    <h3>这是一个具有session作用域的Bean</h3>
	    <h1>
	             你好，你是第<%=CountBean.getCount() %>位访客</h1>
	</body>
	</html>