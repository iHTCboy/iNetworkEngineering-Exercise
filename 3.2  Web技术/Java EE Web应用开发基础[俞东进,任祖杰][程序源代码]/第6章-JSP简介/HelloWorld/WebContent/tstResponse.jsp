<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	  <head>
	     <title>response对象设置响应报头示例</title>
	  </head>
	<body>
		   自动更新时间
		 <h3>现在时间是：<%=new Date() %></h3>
		 <%response.setHeader("Refresh","3"); %> 
	</body>
	</html>