<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<s:iterator value="books" var ="book">
	<div class="second_d_wai">
		<div class="img">
			<a href="#" target='_blank'><img
					src="${pageContext.request.contextPath}/productImages/<s:property value="productPic"/>" border=0 /> </a>
		</div>
		<div class="shuming">
			<a href="#" target="_blank"><s:property value="productName" /></a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥<s:property value="fixedPrice"/>
		</div>
		<div class="price">
			当当价：￥<s:property value="dangPrice"/>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	</s:iterator>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>