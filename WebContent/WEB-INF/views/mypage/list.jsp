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


<jsp:include page="/WEB-INF/views/layout/header.jsp" />

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

<jsp:include page="/WEB-INF/views/layout/aside.jsp" />


<div class="content">
	<h4>휴가 신청서 목록</h4>
	<div class="container">
	
		<table class="table table-hover table-condensed">
			<tr class="active">
				<th>휴가 날짜</th>
				<th>휴가 사유</th>
				<th>작성일</th>
				<th>휴가 승인 여부</th>
			</tr>
		<c:forEach items="${dayoffList }" var="board">
			<tr>
				<td>${dayoff.daystart } ~ ${dayoff.dayend }</td>
				<td>${dayoff.dreason }</td>
				<td><fmt:formatDate value="${dayoff.writtendate }" pattern="yyyy-MM-dd"/></td>
				<td>${dayoff.dresult }</td>
			</tr>
		</c:forEach>
		</table>


	<c:import url="/WEB-INF/views/layout/paging.jsp" />

	</div>
	
</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />