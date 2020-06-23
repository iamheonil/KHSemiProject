<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">

	.container {
		width: 100%;
		height: auto;	
	}

</style>


<div class="container">

<h1>주소록</h1>
<hr>

<div class="btncon">
	<div class="btn-group">
		<button type="button" class="btn pull-left">테스트</button>
	</div>
</div>

<table class="table table-striped table-hover table-condensed">
<tr>
	<th>부서</th>
	<th>사원</th>
	<th>정보</th>
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
	<button id="btnAccept" class="btn btn-primary">사번 추가</button>
	<button id="Decline" class="btn btn-primary">사원 관리</button>
	<button id="btnDelete" class="btn btn-primary">직급 관리</button>
</div>

</div>

<c:import url="/WEB-INF/views/layout/paging.jsp" />

</div>