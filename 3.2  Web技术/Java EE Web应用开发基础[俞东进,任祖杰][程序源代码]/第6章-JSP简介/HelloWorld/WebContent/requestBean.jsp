	<%@ page language="java" pageEncoding="UTF-8"%>

	<html>
	<head>
	<title>具有request作用域的Bean</title>
	</head>
	<jsp:useBean id="reqBean" scope="request" class="test.RequestURL"/>
	<body bgcolor="#ffffff">
	    <h3>调用页：requestBean.jsp</h3>
	    <%reqBean.setURL("requestBean.jsp"); %>
	    <jsp:include page="request.jsp"/>
	</body>
	</html>