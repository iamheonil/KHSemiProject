<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style type="text/css">
#loginLayout {
	width: 100%;
	background: #0f4c81;
}

#loginForm {
	margin: 0 auto;
	padding: 80px 100px;
	width: 350px;
	background: white;
	vertical-align: middle;
}

.Form-title {
	margin: 0 auto;
	margin-bottom: 3px;
	width: 345px;
	text-align: left;
	font-size: 1.3em;
	font-weight: bold;
	padding-left: 5px;
}

.Form-content {
	width: 350px;
	margin: 0 auto;
	margin-bottom: 40px;
}

.Form-content:last-child {
	width: 350px;
	margin: 0 auto;
	margin-bottom: 0px;
	text-align: center;
}

.Form-content > input, button {
	width: 100%;
	height: 45px;
	margin: 0 auto;
	font-size: 0.9em;
	padding: 10px;
	border-radius: 5px;
}

.Form-content > button {
	background: #0f4c81;
	font-size: 1.2em;
	color: white;
	cursor: pointer;
	
}

.Form-content > a {
	color: black;
	text-decoration: none;
	font-weight: bold;
}

.Form-content > a:hover {
	text-decoration: underline;
}

.Form-content > input[id="btnForm"]{
	background: #0f4c81;
	font-size: 1.2em;
	color: white;
	cursor: pointer;
	font-weight: bold;
	width: 100%;
	height: auto;
	margin: 0 auto;
	padding: 10px;
	border-radius: 5px;
}
</style>

<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#userid").focus() // 초기 포커스
	
	$("input[name~='msg']").keydown(function(e) {
		if(e.keyCode == 13) {
			$("#btnLogin").click()
		}
	})


	// 값 있으면 에러창 없애기
	$("#userid").blur(function() {
		if($(this).val() != 0) {
			$("#id_err_msg").text("");
		}
	})
	
	$("#userpw").blur(function() {
		if($(this).val() != 0) {
			$("#pw_err_msg").text("");
		}
	})


	// form submit 전 검증
	$("#joinForm").submit(function() {
	
		var cnt=0;
	
		if($("#userid").val() == "") {
			$("#id_err_msg").text("사번을 입력하세요.");
			$("#id_err_msg").css("color", "red")
			cnt++;
		}
		
		if($("#userpw").val() == "") {
			$("#pw_err_msg").text("비밀번호를 입력하세요.");
			$("#pw_err_msg").css("color", "red")
			cnt++;
		}
		
		// cnt>0 이면 submit 수행x
		if(cnt>0) {
			return false;
		} else {
			$(this).submit()
		}
	})
	
})

</script>

<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/layout/header_login.jsp" />	

	<div id="loginLayout">
		<div id="loginForm">
			
			<form action="/user/login" method="post" id="joinForm">
			
			<div class="Form-title">
				<label for="userid">사번</label>
			</div>
			<div class="Form-content">
				<input type="text" id="userid" name="userid" />
				<div id="id_err_msg"></div>
			</div>
			<div class="Form-title">
				<label for="userpw">비밀번호</label>
			</div>
			<div class="Form-content">
				<input type="password" id="userpw" name="userpw" />
				<div id="pw_err_msg"></div>
			</div>
			<div class="Form-content">
				<input type="submit" value="로그인" id="btnForm" />
			</div>
			<div class="Form-content">
				<a href="/user/findpw">비밀번호 찾기</a>&nbsp;|&nbsp;<a href="/user/joincheck">회원가입</a>
			</div>			
			
			
	
			</form>
			
		</div>
	</div>
	
	
<%-- import footer --%>
<c:import url="/WEB-INF/views/layout/footer_login.jsp" />
	
