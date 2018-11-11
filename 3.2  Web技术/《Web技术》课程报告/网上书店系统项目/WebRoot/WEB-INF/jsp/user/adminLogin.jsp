<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 后台</title>
	</head>
	<body>

					<div class="main">


						<s:form action="toAdminAction" id="ctl00" namespace="/user">
							<table border="0" align="center" cellpadding="0" cellspacing="0">
							<ul>
									<h1>登录后台
					            	</h1>
								<li>
									<span>用户名：</span>
									<s:textfield  name="LoginName" id="txtUsername" cssClass="textbox" />
								</li>
								<li>
									<span class="blank">密码：</span>
									<s:password  name="password" id="txtPassword"
										cssClass="textbox" />
								</li>
								<li>
									<input type="submit" id="btnSignCheck" class="button_enter"
										value="登 录" />
								</li>
							</ul>
							<input type="hidden" name="uri" value="${uri}" />
							
						<div class="user_new">
						
						<p class="set_up">
						<a href="${pageContext.request.contextPath}/user/loginAction"
					class="b">前台登陆</a>
						</p>
					</div>
							</table>
						</s:form>
					</div>

				</div>
			</div>
		</div>

		<%@include file="/common/foot1.jsp"%>

	</body>
</html>

