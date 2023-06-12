<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
</head>
<body>
	<div id="center-content">
		
		
		<!-- 메인 해더 -->
		<c:import url="/WEB-INF/views/includes/main-header.jsp"></c:import>
		<!-- //header -->

		<div id="loginForm">
			<form id="loginCheck" method="post" action="${pageContext.request.contextPath}/user/login">
	      		<table>
			      	<colgroup>
						<col style="width: 100px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td><label for="textId">아이디</label></td>
		      			<td><input id="textId" type="text" name="id"></td>
		      		</tr>
		      		<tr>
		      			<td><label for="textPassword">패스워드</label> </td>
		      			<td><input id="textPassword" type="password" name="password"></td>   
		      			   			
		      		</tr> 
		      		<tr>
		      			<td colspan="2" id="tdMsg" colspan="2">
		      				<span>아이디 또는 비번을 확인해 주세요.</span>
		      			</td>
		      		</tr> 
		      	</table>
	      		<div id="btnArea">
					<button class="btn" type="submit" >로그인</button>
				</div>
			</form>
		</div>
		
		<!-- 메인 푸터  자리-->
		<c:import url="/WEB-INF/views/includes/main-footer.jsp"></c:import>
		<!-- //nav -->
		
	</div>
	
</body>

<script type="text/javascript">
	// 회원가입 폼 제출 시 처리
	$("#loginCheck").on("submit", function(){
		console.log("전송 클릭");
		
		// 아이디 체크
		var id = $("#textId").val();
		if(id.length < 1){
			alert("아이디를 입력해주세요");
			return false;
		}
		
		// 패스워드 체크
		var pwd = $("#textPassword").val();
		if(pwd.length < 1){
			alert("비밀번호를 입력해주세요");
			return false;
		}
		return true;
	});
</script>

</html>