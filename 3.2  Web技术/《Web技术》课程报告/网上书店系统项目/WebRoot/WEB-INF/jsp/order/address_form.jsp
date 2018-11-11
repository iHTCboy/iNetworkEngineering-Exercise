<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="<%=request.getContextPath() %>/css/login.css" rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath() %>/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<style type="">
			.red{
				color:red;
			}
		</style>	
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.min.js"></script>		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/address_form.js"></script>	
	</head>
	<body>
		<%@include file="/common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址：
				<select id="address" onchange="change(this.value);">
					<option value="hh">
						--请选择--
					</option>
						<option value="old">
						使用原有地址
					</option>
					<option value="new">
						填写新地址
					</option>
				</select>
			</p>
			<s:form name="ctl00" id="f" action="successAction" namespace="/order" theme="simple" onsubmit="return form_submit();">
				<s:textfield name="address.id" id="addressId" cssStyle="display:none;"></s:textfield>
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
						<s:textfield cssClass="text_input" name="address.receiveName" id="receiveName"></s:textfield>
							<div class="text_left" id="nameValidMsg">
								<p>
									汉字或英文姓名<span class="red" id="receiveName_info"></span>
								</p>
								
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<s:textfield cssClass="text_input"  name="address.fullAddress" id="fullAddress"></s:textfield>
							<div class="text_left" id="addressValidMsg">
								<p>
									有效的详细地址<span class="red" id="fullAddress_info"></span>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
							<s:textfield cssClass="text_input" name="address.postalCode" id="postalCode"></s:textfield>
							<div class="text_left" id="codeValidMsg">
								<p>
									6位数字邮政编码<span class="red" id="postalCode_info"></span>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<s:textfield cssClass="text_input"  name="address.phone" 	id="phone"></s:textfield>
							<div class="text_left" id="phoneValidMsg">
								<p>
									11位数字电话<span class="red" id="phone_info"></span>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							手机
						</td>
						<td>
							<s:textfield cssClass="text_input" name="address.mobile" id="mobile"></s:textfield>
							<div class="text_left" id="mobileValidMsg">
								<p>
									11位数字手机<span class="red" id="mobile_info"></span>
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input id="btnClientRegister" class="button_1" name="submit"
					type="button" value="取消" onclick="location='${pageContext.request.contextPath}/cart/cartListAction'"/>
			
				<input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" />
				</div>
			</s:form>
		</div>
		<%@include file="/common/foot1.jsp"%>
	</body>
</html>

