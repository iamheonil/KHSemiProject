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
	<h4>사원 기본 관리</h4>
	<div class="container">

		<table class="table table-hover table-condensed">
			<caption>인사</caption>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>직위</th>
			</tr>

			<c:forEach items="${deptList }" var="deptno">
				<tr>
					<td>${User_basic.userid }</td>
					<td>${User_basic.username }</td>
					<td>${User_basic.userrank }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>

		<table class="table table-hover table-condensed">
			<caption>개발</caption>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>직위</th>
			</tr>
			<c:forEach items="${deptList }" var="deptno">
				<tr>
					<td>${User_basic.userid }</td>
					<td>${User_basic.username }</td>
					<td>${User_basic.userrank }</td>

				</tr>
			</c:forEach>
		</table>
		<br>
		<br>

		<table class="table table-hover table-condensed">
			<caption>회계</caption>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>직위</th>
			</tr>
			<c:forEach items="${deptList }" var="deptno">
				<tr>
					<td>${User_basic.userid }</td>
					<td>${User_basic.username }</td>
					<td>${User_basic.userrank }</td>

				</tr>
			</c:forEach>
		</table>
		<br>
		<br>

		<table class="table table-hover table-condensed">
			<caption>영업</caption>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>직위</th>
			</tr>
			<c:forEach items="${deptList }" var="deptno">
				<tr>
					<td>${User_basic.userid }</td>
					<td>${User_basic.username }</td>
					<td>${User_basic.userrank }</td>

				</tr>
			</c:forEach>
		</table>
		<br>
		<br>

		<table class="table table-hover table-condensed">
			<caption>자재</caption>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>직위</th>
			</tr>
			<c:forEach items="${deptList }" var="deptno">
				<tr>
					<td>${User_basic.userid }</td>
					<td>${User_basic.username }</td>
					<td>${User_basic.userrank }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
	</div>
</div>


<c:import url="/WEB-INF/views/adlayout/adfooter.jsp" />
