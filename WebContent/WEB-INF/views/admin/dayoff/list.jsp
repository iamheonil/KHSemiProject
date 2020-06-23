<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- <c:import url="/WEB-INF/views/layout/header.jsp" /> --%>

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

<style type="text/css">

	.container {
		width: 100%;
		height: auto;	
	}

</style>

<div class="container">

<h1>휴가 신청서 목록</h1>
<hr>

<table class="table table-striped table-hover table-condensed">
<tr>
	<th>휴가번호</th>
	<th>아이디</th>
	<th>작성일</th>
</tr>
<c:forEach items="${dayoffList }" var="board">
<tr>
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

</div>

<c:import url="/WEB-INF/views/layout/paging.jsp" />

<%-- <c:import url="/WEB-INF/views/layout/footer.jsp" /> --%>
