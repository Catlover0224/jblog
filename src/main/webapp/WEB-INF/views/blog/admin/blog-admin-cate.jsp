<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
</head>

<body>
	<div id="wrap">

		<!-- 개인블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>

		<div id="content">
			<ul id="admin-menu" class="clearfix">
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/blog/${blog.id}/admin/basic">기본설정</a></li>
				<li class="tabbtn selected"><a href="${pageContext.request.contextPath}/blog/${blog.id}/admin/category">카테고리</a></li>
				<li class="tabbtn"><a href="">글작성</a></li>
			</ul>
			<!-- //admin-menu -->

			<div id="admin-content">

				<table id="admin-cate-list">
					<colgroup>
						<col style="width: 50px;">
						<col style="width: 200px;">
						<col style="width: 100px;">
						<col>
						<col style="width: 50px;">
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>카테고리명</th>
							<th>포스트 수</th>
							<th>설명</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody id="cateList">
						<!-- 리스트 영역 -->
						<c:forEach var="cate" items="${cate}">
							<tr>
								<td>${cate.cateNo}</td>
								<td>${cate.cateName}</td>
								<td>7</td>
								<td>${cate.description}</td>
								<td class='text-center'><img class="btnCateDel" src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
							</tr>
						</c:forEach>
						<!-- 리스트 영역 -->
						<!-- 새로운 카테고리 -->
						<tr id="newCategoryRow" style="display: none;">
							<td></td>
							<td id="newCategoryName"></td>
							<td>7</td>
							<td id="newCategoryDesc"></td>
							<td class='text-center'><img class="btnCateDel" src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
						</tr>
					</tbody>
				</table>

				<table id="admin-cate-add">
					<colgroup>
						<col style="width: 100px;">
						<col style="">
					</colgroup>
					<tr>
						<td class="t">카테고리명</td>
						<td><input type="text" name="name" value=""></td>
					</tr>
					<tr>
						<td class="t">설명</td>
						<td><input type="text" name="desc"></td>
					</tr>
				</table>

				<div id="btnArea">
					<button id="btnAddCate" class="btn_l" type="submit">카테고리추가</button>
					<input id="blogId" hidden="none" value="${blog.id}">
				</div>

			</div>
			<!-- //admin-content -->
		</div>
		<!-- //content -->


		<!-- 개인블로그 푸터 -->
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>


	</div>
	<!-- //wrap -->
</body>

<script type="text/javascript">
	//아이디 체크 버튼 클릭했을때
	$("#btnAddCate").on(
			"click",
			function() {
				console.log("버튼 클릭");

				//추출
				var cateName = $("[name=name]").val();
				var description = $("[name=desc]").val();
				var id = $("#blogId").val()

				console.log(cateName);
				console.log(description);
				console.log(id);

				//통신 id
				$.ajax({
					url : "${pageContext.request.contextPath}/blog/" + id + "/admin/categoryInsert",
					type : "post",

					data : {
						cateName : cateName,
						description : description
					},

					dataType : "json",
					success : function(categoryVo) {
						// 새로운 카테고리 정보 추출
						var newCateNo = categoryVo.cateNo;
						var newCateName = categoryVo.cateName;
						var newCateDesc = categoryVo.description;
						console.log("김냐옹냐옹");
						console.log(newCateNo);
						console.log(newCateName);
						console.log(newCateDesc);

						// 새로운 카테고리 출력
						var newCategoryRow = $("#newCategoryRow").clone();
						newCategoryRow.removeAttr("id");
						newCategoryRow.removeAttr("style");
						newCategoryRow.find("td").eq(0).text(newCateNo);
						newCategoryRow.find("td").eq(1).text(newCateName);
						newCategoryRow.find("td").eq(3).text(newCateDesc);

						$("#cateList").append(newCategoryRow);

					},
					error : function(XHR, status, error) {

						console.error(status + " : " + error);
					}
				});
			}); //$("#btnIdCheck").on
</script>



</html>