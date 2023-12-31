<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<div id="header" class="clearfix">
	<h1>
		<a href="">${blog.blogTitle}</a>
	</h1>

	<c:choose>
		<c:when test="${empty user.id}">
			<ul class="clearfix">
			<!-- 	로그인 전 메뉴 -->
				<li><a class="btn_s" href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
			</ul>
		</c:when>

		<c:when test="${!empty user.id}">
			<ul class="clearfix">
				<!-- 로그인 후 메뉴 -->
				<li><a class="btn_s" href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
				<c:choose>
					<c:when test="${user.id==blog.id}">
						<!-- 자신의 블로그일때만 관리 메뉴가 보인다. -->
						<li><a class="btn_s" href="${pageContext.request.contextPath}/blog/${user.id}/admin/basic">내블로그 관리</a></li>
					</c:when>
				</c:choose>
			</ul>
		</c:when>

	</c:choose>



</div>
<!-- //header -->
