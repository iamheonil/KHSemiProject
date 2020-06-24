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

<%-- <c:import url="/WEB-INF/views/adlayout/adheader.jsp" /> --%>

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


<script type="text/javascript">
$(document).ready(function() {
	
	//버튼 기능, 승인버튼 기능 필요
	$("#btnAccept").click(function() {

	});

	//버튼 기능, 반려버튼 기능 필요
	$("#btnDecline").click(function() {

	});
	
	//버튼 기능, 삭제버튼 기능 구현 필요
	$("#btnDelete").click(function() {

	});
	
});
</script>

<%-- <c:import url="/WEB-INF/views/adlayout/adaside.jsp" /> --%>

<div class="content">
	<h4>휴가 신청서 목록</h4>
	<div class="container">
	
		<table class="table table-hover table-condensed">
			<tr class="active">
				<th>휴가번호</th>
				<th>아이디</th>
				<th>작성일</th>
			</tr>
		<c:forEach items="${dayoffList }" var="board">
			<tr>
				<td><input type="checkbox" name="checkRow" value="${dayoff.daynum  }" /></td>
				<td>${dayoff.daynum }</td>
				<td>${dayoff.userno }</td>
				<td><fmt:formatDate value="${dayoff.writtendate }" pattern="yyyy-MM-dd"/></td>
			</tr>
		</c:forEach>
		</table>

		<div id="btnBox">
			<button id="btnAccept" class="btn btn-primary">승인</button>
			<button id="Decline" class="btn btn-primary">반려</button>
			<button id="btnDelete" class="btn btn-primary">삭제</button>
		</div>

	<c:import url="/WEB-INF/views/layout/paging.jsp" />

	</div>
	
</div>


<%-- <c:import url="/WEB-INF/views/adlayout/adfooter.jsp" /> --%>

