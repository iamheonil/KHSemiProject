<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- jQuery 2.2.4.min -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


<script type="text/javascript">
$(document).ready(function() {
	
	//수정버튼 동작
	$("#btnModity").click(function() {
		
		//<form> 태그 submit
		$("form").submit();
		
	});
	
	//취소버튼 동작
	$("#btnCancel").click(function() {
		history.go(-1);
	});
});
</script>

<div class="container">
<h3>사원 기본 정보 수정</h3>

<form method="post" enctype="application/x-www-form-urlencoded">

<table>
<tr>
	<td id="userid">사번</td>
	<td><input type="text" name="userid" maxlength="50" value="${userid }"></td>
</tr>

<tr>
	<td id="username">이름</td>
	<td><input type="text" name="username" maxlength="50" value="${username }"></td>
</tr>

<tr>
	<td id="userrank">부서</td>
	<td><input type="text" name="userrank" maxlength="50" value="${userrank }"></td>
</tr>

<tr>
	<td id="deptno">직위</td>
	<td><input type="text" name="deptno" maxlength="50" value="${deptno }"></td>
</tr>
</table>
</form>
</div>

<div class="text-center">	
	<button type="button" id="btnModity" class="btn btn-info">수정</button>
	<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
</div>


