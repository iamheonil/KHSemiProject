<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {


	//수정버튼 동작
	$("#btnUpdate").click(function() {
		location.href="/admin/dept/update";
	});
	
	//버튼 기능, 삭제버튼 기능 구현 필요
	$("#btnDelete").click(function() {

	});

});
</script>

<div class="container">

<h1>사원목록</h1>
<hr>

<table class="table table-striped table-hover table-condensed">
<tr>
	<th>부서번호</th>
	<th>부서이름</th>
</tr>
<c:forEach items="${deptList }" var="board">
<tr>
	<td>${dept.deptno }</td>
	<td>${dept.dname }</td>
</tr>
</c:forEach>
</table>

<div id="btnBox">
	<button id="btnUpdate" class="btn btn-primary">수정</button>
	<button id="btnDecline" class="btn btn-primary">삭제</button>
</div>


</div>

<c:import url="/WEB-INF/views/layout/paging.jsp" />

<c:import url="/WEB-INF/views/layout/footer.jsp" />
