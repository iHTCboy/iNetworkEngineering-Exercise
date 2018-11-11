<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 <%@ page import="test.Person"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title>useBean动作示例</title>
	</head>
	<jsp:useBean id="personInfo" scope="page" class="test.Person"/>
	<% personInfo.setName("吴萌萌");
	   personInfo.setAge(23);
	%>
	<body>
	<h3 align="center">显示JavaBean中的信息</h3>
	<hr>
	<%=personInfo.getName() %> <%=personInfo.getAge() %>
	</body>
</html>