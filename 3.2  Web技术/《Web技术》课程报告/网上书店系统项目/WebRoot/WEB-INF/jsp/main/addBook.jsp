<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/css/login.css"
			rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css"
			rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.min.js">
</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js">
</script>

		
	</head>
	<body>
<h1><center>添加图书</center> </h1>
<hr />

		<div class="fill_message">
			<s:form name="ctl00" id="f" action="addBookAtion" namespace="/main">
				<h2>
					以下均为必填项
				</h2>
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							书名：
						</td>
						<td>
							<s:textfield name="product.product_name" id="product_name"
								cssClass="text_input" />
							<div class="text_left" id="product_nameValidMsg">
								<span id="product_nameInfo" style="color: red"></span>
							</div>
						</td>
					</tr>
										<tr>
						<td valign="top" class="w1">
							作者：
						</td>
						<td>
							<s:textfield name="book.author" id="author"
								cssClass="text_input" />
							<div class="text_left" id="authorValidMsg">
								<span id="authorInfo" style="color: red"></span>
							</div>
						</td>
					</tr>
										<tr>
						<td valign="top" class="w1">
							图片编号：
						</td>
						<td>
							<s:textfield name="product.product_pic" id="product_pic"
								cssClass="text_input" />
							<div class="text_left" id="product_picValidMsg">
								<span id="product_picInfo" style="color: red"></span>
							</div>
						</td>
					</tr>
										<tr>
						<td valign="top" class="w1">
							出版社：
						</td>
						<td>
							<s:textfield name="book.publishing" id="publishing"
								cssClass="text_input" />
							<div class="text_left" id="publishingValidMsg">
								<span id="publishingInfo" style="color: red"></span>
							</div>
						</td>
					</tr>
				    <tr>
						<td valign="top" class="w1">
							出版日期：
						</td>
						<td>
							<s:textfield name="book.publish_time" id="publish_time"
								cssClass="text_input" />
							<div class="text_left" id="publish_timeValidMsg">
								<span id="publish_timeInfo" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							图书分类：
						</td>
						<td>
							<s:textfield name="category.id" id="id"
								cssClass="text_input" />
							<div class="text_left" id="idValidMsg">
								<span id="idInfo" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							原价：
						</td>
						<td>
							<s:textfield name="product.fixed_price" id="fixed_price"
								cssClass="text_input" />
							<div class="text_left" id="fixed_priceValidMsg">
								<span id="fixed_priceInfo" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							一口价：
						</td>
						<td>
							<s:textfield name="product.dang_price" id="publish_time"
								cssClass="text_input" />
							<div class="text_left" id="dang_priceValidMsg">
								<span id="dang_priceInfo" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							图书简介：
						</td>
						<td>
							<s:textfield name="product.description" id="description"
								cssClass="text_input" />
							<div class="text_left" id="descriptionValidMsg">
								<span id="descriptionInfo" style="color: red"></span>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input id="btnClientRegister" class="button_1" name="submit"
						type="submit" value="添加" />
				</div>

			</s:form>
		</div>
		<%@include file="/common/foot1.jsp"%>
		
	</body>
</html>

