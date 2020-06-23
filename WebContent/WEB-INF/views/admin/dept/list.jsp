<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- <c:import url="/WEB-INF/views/layout/header.jsp" /> --%>

<script type="text/javascript">
$(document).ready(function() {


	//버튼 기능, 수정버튼 기능 필요
	$("#btnUpdate").click(function() {
	
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

<h1>사원목록</h1>
<hr>

<table class="table table-striped table-hover table-condensed">
<tr>
	<th>사번</th>
	<th>이름</th>
	<th>부서</th>
	<th>직위</th>
</tr>
<c:forEach items="${deptList }" var="board">
<tr>
	<td>${dept.userid }</td>
	<td>${dept.username }</td>
	<td>${dept.userrank }</td>
	<td>${dept.deptno }</td>
</tr>
</c:forEach>
</table>

</div>

<c:import url="/WEB-INF/views/layout/paging.jsp" />

<%-- <c:import url="/WEB-INF/views/layout/footer.jsp" /> --%>
