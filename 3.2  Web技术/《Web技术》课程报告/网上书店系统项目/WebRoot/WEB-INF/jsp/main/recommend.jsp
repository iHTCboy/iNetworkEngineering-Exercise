<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='#' target='_blank'><img src="${pageContext.request.contextPath}/productImages/<s:property value='book1.productPic'/>" width=70 border=0 /> </a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='#' target='_blank' title='book1.productName'><s:property value="book1.productName" /></a>
				</h3>
				<h4>
					作者：<s:property value="book1.author" /> 
					<br />
					出版社：<s:property value="book1.publishing"/> &nbsp;&nbsp;&nbsp;&nbsp;出版时间：<s:property value="book1.publishTime"/>
				</h4>
				<h5>
					<s:property value="book1.description"/>
				</h5>
				<h6>
					定价：￥<s:property value="book1.fixedPrice"/>&nbsp;&nbsp;当当价：￥<s:property value="book1.dangPrice"/>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
		
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='#' target='_blank'><img src="${pageContext.request.contextPath}/productImages/<s:property value='book2.productPic'/>" width=70 border=0 /> </a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='#' target='_blank' title='输赢'><s:property value="book2.productName" /></a>
				</h3>
				<h4>
					作者：<s:property value="book2.author" /> 
					<br />
					出版社：<s:property value="book2.publishing"/> &nbsp;&nbsp;&nbsp;&nbsp;出版时间：<s:property value="book2.publishTime"/>
				</h4>
				<h5>
					<s:property value="book2.description"/>
				</h5>
				<h6>
					定价：￥<s:property value="book2.fixedPrice"/>&nbsp;&nbsp;当当价：￥<s:property value="book2.dangPrice"/>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
	</div>
</div>
