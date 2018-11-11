<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		<s:iterator value="categorys" var="category">
			<!--1级分类开始-->
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[
					<a href="http://htc:8080/dang/main/bookListAction?category.id=2&category.parentId=1" target="right"><s:property value="name" /> </a>]
				</h3>
				<ul class="ul_left_list">
					<s:iterator value="#category.subCategorys">
						<!--2级分类开始-->
						<li>
							<a
								href='${pageContext.request.contextPath}/main/bookListAction?category.id=${id}&category.parentId=${parentId}'><s:property
									value="name" /> </a>
						</li>

						<!--2级分类结束-->
					</s:iterator>
				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
			<!--1级分类结束-->
		</s:iterator>

		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
