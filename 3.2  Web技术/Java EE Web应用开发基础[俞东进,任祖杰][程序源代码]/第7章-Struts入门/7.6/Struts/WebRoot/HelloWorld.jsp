<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Hello World!!</title>
</head>
<body>
<!—form的action指向定义的action名称 -->
<form id="id1" name="form1" method="post" action="HelloWorld.action">
<p>Username：
<label>
<input name="name" type="text" />
</label>
</p>
<p>Password：
<label>
<input name="password" type="password" />
</label>
</p>
<p>
<label>
<input type="submit" name="Submit" value="提交" />
</label>
</p>
</form>
</body>
</html>
