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
	padding: 80px 60px;
	width: 430px;
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
	margin-bottom: 0px;
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
	font-weight: bold;
}

.Form-content > a {
	text-decoration: none;
	font-weight: bold;
}

.Form-content > a:hover {
	text-decoration: underline;
}

.Form-name-Layout {
	border-bottom: 5px solid #add3f0;
	margin-bottom: 25px;
}

.Form-name {
	font-size: 1.9em;
	font-weight: bold;
	border-bottom: 5px solid #0f4c81;
}

.notice {
	font-size: 1.1em;
	font-weight: bold;
	height: auto;
	margin-bottom: 50px;
}

.notice-icon {
	display: inline-block;
}

.notice-content {
	display: inline-block;
	vertical-align: top;
}

.notice-content:nth-child(3) {
	display: inline-block;
	margin-left: 26px;
	vertical-align: middle;
}

.agree-checkbox {
	width: 350px;
	margin: 0 auto;
	margin-bottom: 40px;
	font-size: 1.1em;
	font-weight: bold;
	
}

.agree-checkbox > input[type=checkbox] {
	width: 20px;
	height: 20px;
	
}

.agree-checkbox > label {
	cursor: pointer;
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
	
	// 이메일 정규식
	var mailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	// 값 있으면 에러창 없애기
	$("#userid").blur(function() {
		if($(this).val() != 0) {
			$("#id_err_msg").text("");
		}
	})
	
	$("#useremail").blur(function() {
		if(mailReg.test($(this).val())) {
			$("#email_err_msg").text("");
		} else {
			$("#email_err_msg").text("이메일형식에 맞는 값을 입력하세요.");
			$("#email_err_msg").css("color", "red")
		}
	})
	
	$("#agree").blur(function() {
		if($("#agree").is(":checked") == true) {
			$("#check_err_msg").text("")
		} else {
			$("#check_err_msg").text("약관에 동의해주세요.")
			$("#check_err_msg").css({"font-size":"16px", "font-weight":"normal", "color":"red"})
		}
	})
	
	// form submit 전 검증
	$("#checkForm").submit(function() {
	
		var cnt=0;

	
		if($("#userid").val() == "") {
			$("#id_err_msg").text("사번을 입력하세요.");
			$("#id_err_msg").css("color", "red")
			cnt++;
		}
		
		if($("#useremail").val() == "") {
			$("#email_err_msg").text("이메일을 입력하세요.");
			$("#email_err_msg").css("color", "red")
			cnt++;
		}
		
		if($("#agree").is(":checked") != true) {
			$("#check_err_msg").text("약관에 동의해주세요.");
			$("#check_err_msg").css({"font-size":"16px", "font-weight":"normal", "color":"red"})
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
			<p class="Form-name-Layout">
				<span class="Form-name">비밀번호 찾기</span>
			</p>
			<div class="notice">
				<div class="notice-icon">
					<img src="/resources/img/notice.jpeg" width="20px" height="20px">
				</div>
				<div class="notice-content">
					입력한 이메일로 임시비밀번호가 발급됩니다.
				</div>
			</div>
			
			
			<form action="/send" method="post" id="checkForm">
			
			<div class="Form-title">
				<label for="userid">사번</label>
			</div>
			<div class="Form-content">
				<input type="text" id="userid" name="userid" />
				<div id="id_err_msg"></div>
			</div>
			<div class="Form-title">
				<label for="useremail">이메일</label>
			</div>
			<div class="Form-content">
				<input type="text" id="useremail" name="useremail" />
				<div id="email_err_msg"></div>
			</div>
			<div class="agree-checkbox">
				<input type="checkbox" name="agree" id="agree" style="width: 18px; height: 18px;" /> <label for="agree">개인정보수집 동의</label>
				<div id="check_err_msg" class="err_msg"></div>
			</div>
			<div class="Form-content">
				<input type="submit" value="임시비밀번호 발급받기" id="btnForm" />
			</div>		
			
			
	
			</form>
			
		</div>
	</div>
	
	
<%-- import footer --%>
<c:import url="/WEB-INF/views/layout/footer_login.jsp" />
	
