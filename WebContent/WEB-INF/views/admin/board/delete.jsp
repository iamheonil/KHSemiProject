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

<%-- <c:import url="/WEB-INF/views/adlayout/adheader.jsp" /> --%>


<style type="text/css">
h4 {
	color: #0A2D5D;
	font-weight: bold;
	padding : 20px;
	font-size: 1.6em;
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
</style>

<script type="text/javascript">
$(document).ready(function() {
	
	//버튼 기능, 삭제버튼 기능 구현 필요
	$("#btnDelete").click(function() {

	});

});
</script>

<%-- <c:import url="/WEB-INF/views/adlayout/adaside.jsp" /> --%>

<div class="content">
	<h4>커뮤니티 삭제</h4>
	<div class="container">
	
	<!-- 현재 관리자 휴가 리스트와 큰 차이 없음, 자신의 신청서만 보게 하는 기능 필요  -->
	<table class="table table-hover table-condensed">
		<tr class="active">
			<th>문서번호</th>
			<th>문서제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${list }" var="board">
		<tr>
			<td><input type="checkbox" name="checkRow" value="${document.doc_num }" /></td>
			<td>${document.doc_num }</td>
			<td>${document.doc_title }</td>
			<td>${document.userid }</td>
			<td><fmt:formatDate value="${document.writtendate }" pattern="yyyy-MM-dd"/></td>
		</tr>
		</c:forEach>
	</table>
	<div id="btnBox">
		<button id="btnDecline" class="btn btn-primary">삭제</button>
	</div>
	
	<c:import url="/WEB-INF/views/layout/paging.jsp" />
	
	</div>

</div>

<%-- <c:import url="/WEB-INF/views/adlayout/adfooter.jsp" /> --%>

