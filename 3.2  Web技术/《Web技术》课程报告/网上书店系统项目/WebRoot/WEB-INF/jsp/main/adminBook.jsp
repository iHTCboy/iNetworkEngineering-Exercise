<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/prototype-1.6.0.3.js">
</script>
		<link href="${pageContext.request.contextPath}/css/book.css"
			rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/second.css"
			rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/secBook_Show.css"
			rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/list.css"
			rel="stylesheet" type="text/css" />
	</head>
	<body>
			<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath}/user/toAdminMainAction'>后台管理</a>
			&gt;&gt;
			<font style='color: #cc3300'><strong><s:property value="yourPosition"/></strong> </font>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
						<div class="clear"></div>
							<s:iterator value="categorys">
								<!--2级分类开始-->
								<s:if test="category.id==id">
									<li>
										<div>
											<div class=second_fenlei>
												&middot;
											</div>
											<div class=second_fenlei>
												<a  
													href="${pageContext.request.contextPath}/main/adminBook?category.id=${id}&category.parentId=${parentId} "
													style="color: red"><s:property value="name" /> &nbsp;(<s:property
														value="countProduct" />)</a>
											</div>
										</div>
									</li>
								</s:if>
								<s:else>
									<li>
										<div>
											<div class=second_fenlei>
												&middot;
											</div>
											<div class=second_fenlei>
												<a
													href="${pageContext.request.contextPath}/main/adminBook?category.id=${id}&category.parentId=${parentId} "><s:property
														value="name" /> &nbsp;(<s:property value="countProduct" />)</a>
											</div>
										</div>
									</li>
								</s:else>
								<div class="clear"></div>

								<!--2级分类结束-->
							</s:iterator>
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<s:if test="page.pageNo>1">
								<div class='list_r_title_text3a'>
									<a name=link_page_next
										href="${pageContext.request.contextPath}/main/adminBook?category.id=${category.id}&category.parentId=${category.parentId}&page.pageNo=${page.pageNo-1}">
										<img
											src='${pageContext.request.contextPath}/images/page_up.gif' />
									</a>
								</div>
							</s:if>
							<s:else>
								<div class='list_r_title_text3a'>
									<img
										src='${pageContext.request.contextPath}/images/page_up_gray.gif' />
								</div>
							</s:else>
							<div class='list_r_title_text3b'>
								第${page.pageNo }页/共${page.countPage }页
							</div>
							<s:if test="page.pageNo < page.countPage">
								<div class='list_r_title_text3a'>
									<a name=link_page_next
										href="${pageContext.request.contextPath}/main/adminBook?category.id=${category.id}&category.parentId=${category.parentId}&page.pageNo=${page.pageNo+1}">
										<img
											src='${pageContext.request.contextPath}/images/page_down.gif' />
									</a>
								</div>
							</s:if>
							<s:else>

								<div class='list_r_title_text3a'>
									<img
										src='${pageContext.request.contextPath}/images/page_down_gray.gif' />
								</div>
							</s:else>

							<!--分页导航结束-->
						</div>
					</div>

					<!--商品条目开始-->

					<div class="list_r_line"></div>
					<div class="clear"></div>
					<s:iterator value="books">
						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img"
								href='#'> <img
										src="${pageContext.request.contextPath}/productImages/<s:property value='productPic'/>" />
							</a> </span>
							<h2>
								<a name="link_prd_name" href='#'><s:property
										value="productName" />
								</a>
							</h2>
							<h3>
								顾客评分：100
							</h3>
							<h4 class="list_r_list_h4">
								作 者:
								<a href='#' name='作者'><s:property value="author" />
								</a>
							</h4>
							<h4>
								出版社：
								<a href='#' name='出版社'><s:property value="publishing"/></a>
							</h4>
							<h4>
								出版时间：
								<s:date name="publishTime" format="yyyy年MM月dd日" />
							</h4>
							<h5>
								<s:property value="description"/>
							</h5>
							<div class="clear"></div>

							<span class="list_r_list_button"> <a href="${pageContext.request.contextPath}/cart/buyAction?id=${id}"> 
							<img src='${pageContext.request.contextPath}/images/delete.gif' />
							</a> <span id="cartinfo"></span>
						</div>
						<div class="clear"></div>


						<!--商品条目结束-->
					</s:iterator>
					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="/common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
