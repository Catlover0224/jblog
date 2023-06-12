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

		<div>
			<form id="joinForm" method="post" action="${pageContext.request.contextPath}/user/join">
				<table>
					<colgroup>
						<col style="width: 100px;">
						<col style="width: 170px;">
						<col style="">
					</colgroup>
					<tr>
						<td><label for="txtId">아이디</label></td>
						<td><input id="txtId" type="text" name="id"></td>
						<td><button id="btnIdCheck" type="button">아이디체크</button></td>
					</tr>
					<tr>
						<td></td>
						<td id="tdMsg" colspan="2">아이디체크를 눌러주세요.</td>
					</tr>
					<tr>
						<td><label for="txtPassword">패스워드</label></td>
						<td><input id="txtPassword" type="password" name="password" value=""></td>
						<td></td>
					</tr>
					<tr>
						<td><label for="txtUserName">이름</label></td>
						<td><input id="txtUserName" type="text" name="userName" value=""></td>
						<td></td>
					</tr>
					<tr>
						<td><span>약관동의</span></td>
						<td colspan="3"><input id="chkAgree" type="checkbox" name="agree" value="y"> <label for="chkAgree">서비스 약관에 동의합니다.</label></td>
					</tr>
				</table>
				<div id="btnArea">
					<button id="btnJoin" class="btn" type="submit">회원가입</button>
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
	$("#joinForm").on("submit", function(){
		console.log("전송 클릭");
		
		// 아이디 체크
		var id = $("#txtId").val();
		if(id.length < 1){
			alert("아이디를 입력해주세요");
			return false;
		}
		
		// 패스워드 체크
		var pwd = $("#txtPassword").val();
		if(pwd.length < 1){
			alert("비밀번호를 입력해주세요");
			return false;
		}
		
		// 이름 체크
		var name = $("#txtUserName").val();
		if(name.length < 1){
			alert("이름를 입력해주세요");
			return false;
		}

		// 약관 동의 유무
		var agree = $("#chkAgree").is(":checked");
		if(agree == false){
			alert("약관에 동의해주세요");
			return false;
		}
		
		return true;
	});
</script>

<script type="text/javascript">
	//아이디 체크 버튼 클릭했을때
	$("#btnIdCheck").on("click", function() {
		console.log("버튼 클릭");

		//id 추출
		var id = $("[name=id]").val();

		console.log(id);

		//통신 id
		$.ajax({
			url : "${pageContext.request.contextPath}/user/idcheck",
			type : "post",

			data : {id : id},

			dataType : "json",
			success : function(jsonResult) {
				console.log(jsonResult);

				if(jsonResult.result == 'success'){
					//사용가능하진 불가능 한지 표현한다
					if(jsonResult.data == true){
						$("#tdMsg").css("color","blue");  
						$("#tdMsg").html( id+ "는 사용가능 합니다.");  
					}else{
						$("#tdMsg").css("color","red");  
						$("#tdMsg").html( id+ "는 사용중 입니다."); 
					}//inner if
				}else{
					  
				}
			},//success : function(jsonResult)
			error : function(XHR, status, error) {
			  
				console.error(status + " : " + error);
			}
		});//ajax

	}); //$("#btnIdCheck").on
</script>
</html>