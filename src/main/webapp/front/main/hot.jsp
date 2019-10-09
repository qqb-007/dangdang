<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<c:forEach items="${requestScope.saleBook}" var="sb">
	<div class="second_d_wai">
		<div class="img">
			<a href="${pageContext.request.contextPath }/main/main_showBookAction?bookId=${sb.id }" target='_blank'>
				<img class="book-cover" src="${sb.cover }" border=0 /> 
			</a>
		</div>
		<div class="shuming">
			<a href="${pageContext.request.contextPath }/main/main_showBookAction?bookId=${sb.id }" target="_blank">${sb.name }</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			${sb.price }
		</div>
		<div class="price">
			${sb.dprice }
		</div>
		<div class="price">
			销量：<font color="red">${sb.sale }</font>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	</c:forEach>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>