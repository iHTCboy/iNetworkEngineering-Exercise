<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	   <title>jsp:param动作示例forward1</title>
	</head>
	<body>
	   <jsp:forward page="forward2.jsp">
	   <jsp:param name="param2" value="world"/>
	   </jsp:forward>
	</body>
	</html>