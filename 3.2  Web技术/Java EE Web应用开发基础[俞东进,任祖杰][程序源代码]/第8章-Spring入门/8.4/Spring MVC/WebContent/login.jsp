<%@ page language="java" 
contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Spring MVC Demo 登录</title>
</head>
<body>
  <h3>Spring MVC Demo 用户登录</h3>
  <form action="user.do" method="post">
  <table>
  <tr><td>ID：</td><td><input type="text" name="id" /></td></tr>
  <tr><td>Name：</td><td><input type="text" name="name" /></td></tr>
  <tr><td>CardID：</td><td><input type="text" name="cardID" /></td></tr>
  <tr><td><input type="submit" value="submit"/></td>
<td align="center"><input type="reset" value="reset"/></td></tr>
  </table>
  </form>
</body>
</html>
