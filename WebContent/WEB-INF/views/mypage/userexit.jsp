<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/layout/header_doc.jsp" />

<%-- import aside.jsp --%>
<c:import url="/WEB-INF/views/layout/aside_mypage.jsp" />

<style type="text/css">
#loginForm {
	padding: 80px 60px;
	width: 430px;
	background: white;
	vertical-align: middle;
	margin-left: 100px;
}

.Form-title {
	margin: 0 auto;
	margin-bottom: 3px;
	width: 345px;
	text-align: left;
	font-size: 1.3em;
	font-weight: bold;
	padding-left: 5px;
	clear: both;
}

.Form-content {
	width: 350px;
	margin: 0 auto;
	margin-bottom: 40px;
}

.Form-content:last-child {
	margin-bottom: 0px;
}

.Form-content > input, button, select, option {
	width: 100%;
	height: 45px;
	margin: 0 auto;
	font-size: 0.9em;
	padding: 10px;
	border-radius: 5px;
}

.Form-content > select, option, .content-birth > select, option {
	border-radius: 5px;
	border: 2px solid black;
	height: 45px;
	font-size: 1.0em;
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

.Form-content > input[name="useraddrDetail"] {
	margin-top: 10px;
}

.Form-name-Layout {
	font-size: 30px;
	font-weight: bold;
	text-align: left;
	margin-bottom: 100px;
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


#addrBtn {
	width: auto;
    height: 30px;
    vertical-align: bottom;
    line-height: 1px;
    font-size: 0.7em;
    margin-left: 25px;
    cursor: pointer;
    border-radius: 5px;
    background: white;
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

#userphoto {
	width: 204px;
	height: 204px;
	border: 2px solid black;
	display: inline-block;
}

.Form-content > input[name="uphoto"] {
	width: 75px;
    height: auto;
    padding: 0px;
    margin-left: 5px;
    vertical-align: bottom;
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

.content-birth {
	width: 105px;
}

.content-birth:nth-child(2), .content-birth:nth-child(3) {
	margin-left: 17px;
}

.err_msg {
 	text-align: left;
}
</style>

<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<div id="contents">

		<p class="Form-name-Layout">회원탈퇴</p>

		<form action="/user/delete" method="POST">
			<table style="width:40%; margin-left:35px; border-collapse: separate; border-spacing: 0px 30px; text-align: left;">
				<tr>
					<td>탈퇴할 아이디 : <input type="text" id="userid" name="userid" value="${userid }" size="35px" readonly></td>
				</tr>

				<tr>
					<td>비밀번호 : <input type="password" id="pw" name="pw" size="39px"></td>
				</tr>

				<tr>
					<td>비밀번호 확인 : <input type="password" id="pwchk" name="pwchk" size="35px"></td>
				</tr>
				
				<tr>
					<td><button class="btn btn-danger">회원탈퇴하기</button></td>
				</tr>
			</table>
		</form>

</div>

<%-- import footer --%>
<c:import url="/WEB-INF/views/layout/footer.jsp" />