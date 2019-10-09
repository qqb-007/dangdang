<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
	
	<c:forEach items="${requestScope.radomBook}" var="rb">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='${pageContext.request.contextPath }/main/main_showBookAction?bookId=${rb.id }' target='_blank'>
					<img class="book-cover" src="${rb.cover}" width=70 border=0 /> 
				</a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='${pageContext.request.contextPath }/main/main_showBookAction?bookId=${rb.id }' target='_blank' title='输赢'>${rb.name}</a>
				</h3>
				<h4>
					作者：${rb.author} 著
					<br />
					出版社：${rb.press}&nbsp;&nbsp;&nbsp;&nbsp;
					出版时间：${rb.pressDate}
				</h4>
				<h5>
					简介:${rb.contentAbstract}
				</h5>
				<h6>
					定价：￥${rb.price}&nbsp;&nbsp;
					当当价：￥${rb.dprice}
					销量：<font color="red">${rb.sale}</font>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
		</c:forEach>
		
		
		
	</div>
</div>
