<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<c:forEach items="${requestScope.dateBook}" var="db">
	<div class="second_d_wai">
		<div class="img">
			<a href="${pageContext.request.contextPath }/main/main_showBookAction?bookId=${db.id }" target='_blank'>
				<img class="book-cover" src="${db.cover }" border=0 /> 
			</a>
		</div>
		<div class="shuming">
			<a href="${pageContext.request.contextPath }/main/main_showBookAction?bookId=${db.id }" target="_blank">${db.name }</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			${db.price }
		</div>
		<div class="price">
			${db.dprice }
		</div>
		<div class="price">
			销量：<font color="red">${db.sale }</font>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	</c:forEach>

</div>
<div class="clear"></div>