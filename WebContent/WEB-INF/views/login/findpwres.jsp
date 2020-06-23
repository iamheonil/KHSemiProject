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
	height: 337px;
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
	margin-top: 30px;
}

</style>

<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	// btnForm 클릭 시 메인로그인페이지로 이동
	$("#btnForm").click(function() {
		$(location).attr("href", "/");
	})
	
})

</script>

<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/layout/header_login.jsp" />	

	<div id="loginLayout">
		<div id="loginForm">
			<p class="Form-name-Layout">
				<span class="Form-name">임시비밀번호 발급완료</span>
			</p>
			<div class="notice">
				<div class="notice-icon">
					<img src="/resources/img/notice.jpeg" width="20px" height="20px">
				</div>
				<div class="notice-content">
					입력한 이메일로 임시비밀번호가 발급되었습니다.
				</div>
				<div class="notice-content">
					마이페이지에서 비밀번호를 변경해주세요.
				</div>
			</div>
			
			
			<div class="Form-content">
				<input type="button" value="로그인" id="btnForm" />
			</div>		
			
		</div>
	</div>
	
	
<%-- import footer --%>
<c:import url="/WEB-INF/views/layout/footer_login.jsp" />
	
