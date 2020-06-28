<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- jQuery 2.2.4.min -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<c:import url="/WEB-INF/views/adlayout/adheader.jsp" />


<style type="text/css">
h4 {
	text-align: center;
	color: #0A2D5D;
	font-weight: bold;
	margin: 40px 0 40px 0;
	font-size: 1.6em;
}

p {
	text-align: center;
	padding: 10px;
}

table {
	size: 0.8em;
}

.container {
	float: left;
	position: relative;
	width: 900px;
}

.contents {
	min-height: 100%;
}

.container {
	width: 900px;
}

#formSearch {
	text-align: center;
	margin: 0 0 200px 0;
}

#btnBox {
	
}
</style>

<script type="text/javascript">
	$(document).ready(function() {

		$("#btnCreate").click(function() {

		
			//<form> 태그 submit
			$("form").submit();
		});

		//취소버튼 동작
		$("#btnCancel").click(function() {
			history.go(-1);
		});

	});
</script>

<c:import url="/WEB-INF/views/adlayout/adaside.jsp" />

<div class="contents">
	<div class="container">

		<h4>새로운 사원 생성</h4>
		<hr>

		<div>

			<!-- enctype 확인 필요, 날짜 지정 방법에 대해 생각 필요 -->
			<form action="/user/modify/basic" method="post"
				enctype="application/x-www-form-urlencoded">

				<table class="table table-bordered">
					<tr>
						<td class="info">사번</td>
						<td><input type="text" name="userrank" id="userrank" style="width: 100%" /></td>
					</tr>
					<tr>
						<td class="info">이름</td>
						<td><input type="text" name="username" id="username" style="width: 100%" /></td>
					</tr>
					<tr>
						<td class="info">직급</td>
						<td><input type="text" name="userrank" id="userrank" style="width: 100%" /></td>
					</tr>
					<tr>
						<td class="info">부서</td>
						<td><input type="text" name="userid" id="userid" style="width: 100%" /></td>
					</tr>
				</table>

			</form>
		</div>

		<div class="text-center">
			<button type="button" id="btnCreate" class="btn btn-primary">생성</button>
			<button type="button" id="btnCancel" class="btn btn-primary">취소</button>
		</div>

	</div>
</div>

<c:import url="/WEB-INF/views/adlayout/adfooter.jsp" />

