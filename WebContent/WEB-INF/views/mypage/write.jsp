<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- jQuery 2.2.4.min -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


<style type="text/css">
h4 {
	color: #0A2D5D;
	font-weight: bold;
	font-size: 1.6em;
	padding : 10px;
	
}
.container {
	padding-left: 20px;
	float: left;
	position: relative;
	width: 900px;
}

table, th {
	text-align: center;
}

.table {
 padding: 20px;
}

.content {
  min-height: 100%;
}

.container {
	width: 900px;
}


</style>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />


<script type="text/javascript">
	$(document).ready(function() {

		//작성버튼 동작
		$("#btnWrite").click(function() {

			//<form> 태그 submit
			$("form").submit();

		});

		//취소버튼 동작
		$("#btnCancel").click(function() {
			history.go(-1);
		});
	});
</script>

<jsp:include page="/WEB-INF/views/layout/aside.jsp" />

<div class="container">

	<h3>휴가 신청서 작성</h3>
	<hr>

	<div>

		<!-- enctype 확인 필요, 날짜 지정 방법에 대해 생각 필요 -->
		<form action="/board/write" method="post"
			enctype="application/x-www-form-urlencoded">

			<table class="table table-bordered">
				<tr>
					<td class="info">사번</td>
					<td>${userno }</td>
				</tr>
				<tr>
					<td class="info">이름</td>
					<td>${username }</td>
				</tr>
				<tr>
					<td class="info">휴가 시작 날짜</td>
					<td><input type="date" name="daystart" style="width: 100%" /></td>
				</tr>
				<tr>
					<td class="info">휴가 종료 날짜</td>
					<td><input type="date" name="dayend" style="width: 100%" /></td>
				</tr>
				<tr>
					<td class="info" colspan="2">휴가 사유</td>
				</tr>
				<tr>
					<td colspan="2"><textarea id="dreason" name="dreason"></textarea></td>
				</tr>
			</table>

		</form>
	</div>

	<div class="text-center">
		<button type="button" id="btnWrite" class="btn btn-primary">작성</button>
		<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
	</div>
</div>


<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
