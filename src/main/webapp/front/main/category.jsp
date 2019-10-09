<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始-->
			<c:forEach items="${requestScope.categoryList}" var="c1">
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='${pageContext.request.contextPath }/main/main_scendAction?parentId=${c1.id}&page=1&childId=0'>${c1.name}</a>]
				</h3>
				<ul class="ul_left_list">
                     <c:forEach items="${c1.categories }" var="c2">
						
						<li>
							<a href='${pageContext.request.contextPath }/main/main_scendAction?parentId=${c1.id}&childId=${c2.id}&page=1'>${c2.name}</a>
						</li>
						
						</c:forEach>
						<!--2级分类结束-->

				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
			</c:forEach>
		<!--1级分类结束-->
		

		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
