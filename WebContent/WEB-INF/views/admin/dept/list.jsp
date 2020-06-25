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


<!-- 사원 클릭 시 해당 사원만 보여줌, 검색 기능 필요할 수 있음  -->

<style type="text/css">
h4 {
	color: #0A2D5D;
	font-weight: bold;
	padding: 20px;
	font-size: 1.7em;
}

.container {
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

caption {
	color: #0A2D5D;
	font-weight: bold;
	padding: 20px;
	font-size: 1.3em;
}
</style>

<c:import url="/WEB-INF/views/adlayout/adaside.jsp" />

<div class="content">
	<h4>사원 검색 결과</h4>
	
	<h5>사원 검색 결과입니다.</h5>
	<hr>

	<table class="table table-hover table-condensed">
		<tr class="info">
			<th style="width: 10%">사번</th>
			<th style="width: 50%">이름</th>
			<th style="width: 15%">직급</th>
			<th style="width: 10%">부서</th>
		</tr>
		<c:forEach items="${deptlist }" var="dept">
			<tr>
				<td>${user_basic.userid }</td>
				<td><a href="user/basic/modify/list?userid=${user_basic.userid }">${user_basic.username }</a></td>
				<td>${user_basic.userrank }</td>
				<td>${user_basic.dept }</td>
			</tr>
		</c:forEach>
	</table>

	<jsp:include page="/WEB-INF/views/layout/paging.jsp" />

</div>
<!-- .container -->


<c:import url="/WEB-INF/views/adlayout/adfooter.jsp" />
