<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- jQuery 2.2.4.min -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">

.container {
	width: auto;
	height: auto;
	text-align: center;
}

.wrap {
	text-align: center;
	width: auto;
	margin: 0 auto;
	
}

.tt1 {
	float: left;
	width: 48%;
}
.tt1 table {
	width: 100%;
}

/* .tt2 { */
/* 	float: none; */
/* } */

.tt3 {
	float: right;
	width: 48%;
}
.tt3 table {
	width: 100%;
}


</style>


		<!-- float 해제 -->
		<div class="clearfix"></div>

<h3>주소록 목록</h3>
<hr>

<!-- float 해제 -->
<!-- <div class="clearfix"></div> -->

<div class="container">
	<div class="wrap">
		<div class="tt1">
			<table class="table table-striped table-hover table-condensed">
				<tr><th colspan="3" style="text-align: center;">주소록</th></tr>
				<tr>
					<th>부서</th>
					<th>직급</th>
					<th>이름</th>
				</tr>
<%-- 	<c:forEach items="${ }" var="board"> --%>
				<tr>
					<td>개발팀</td>
					<td>부장</td>
					<td>홍길동</td>
				</tr>
			<%-- 	</c:forEach> --%>
				<tr>
					<td>개발팀</td>
					<td>팀장</td>
					<td>김길동</td>
				</tr>
					<tr>
					<td>개발팀</td>
					<td>사원</td>
					<td>이길동</td>
				</tr>
					<tr>
					<td>개발팀</td>
					<td>사원</td>
					<td>심길동</td>
				</tr>
				</tr>
					<tr>
					<td>개발팀</td>
					<td>사원</td>
					<td>심길동</td>
				</tr>
			</table>
				<c:import url="/WEB-INF/views/adlayout/paging.jsp" />
				
				
		</div>
		<div class="tt3">
			<table class="table-striped table-hover table-condensed">
				<tr><th colspan="3" style="text-align: center;">주소록 상세조회</th></tr>
				<tr>
					<th>이름</th>
					<th>전화번호</th>
					<th>주소</th>
				</tr>
				<tr>
					<td>홍길동</td>
					<td>010-1234-5678</td>
					<td>경기도</td>
				</tr>
			</table>
		</div>
	</div>
		<div class="clearfix"></div>

	



</body>
</html>