<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- 사원 클릭 시 해당 사원만 보여줌, 검색 기능 필요할 수 있음  -->

<style type="text/css">
h4 {
	color: #0A2D5D;
	font-weight: bold;
	padding: 20px;
	font-size: 1.7em;
}

/* .container { */
/* 	float: right; */
/* 	position: relative; */
/* 	width: 900px; */
/* } */

table, th {
	text-align: center;
}

.table {
	padding: 20px;
}
.container {
	width: auto;
	height: auto;
	text-align: center;
}
.content {
/* 	margin: 0 auto; */
	min-height: 100%;
}

caption {
	color: #0A2D5D;
	font-weight: bold;
	padding: 20px;
	font-size: 1.3em;
}
.form-inline{
	display: inline-block;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		
		//링크
		$(".username").click(function() {
			$('#contents').load("/admin/userbasic/modify?userid="+$(this).attr("data-userid"));
		})
		
	
		// 검색어 관련
		$("#searchBtn").click(function() {
			$('#contents').load("/admin/userbasic/list?search="+$("#userid").val());
		})
	
		
		// 검색창에서 enter시 검색버튼 눌려지기
		$("input[name~='userid']").keydown(function(e) {
		if(e.keyCode == 13) {
			$("#searchBtn").click()
		}
		})
	});
</script>

<%-- <c:import url="/WEB-INF/views/adlayout/adaside.jsp" /> --%>

<div class="content">
	<div class="container">
	<h4>사원 검색 결과</h4>
	<h5>사원 검색 결과입니다.</h5>
	<hr>

	<table class="table table-hover table-condensed">
		<tr class="info">
			<th>사번</th>
			<th>이름</th>
			<th>부서</th>
			<th>직급</th>
		</tr>
		<c:forEach items="${userbasiclist }" var="userbasic">
			<tr>
				<td>${userbasic.userid }</td>
				<td class="username" data-userid="${userbasic.userid }">${userbasic.username }</td>
				<td>${userbasic.userrank }</td>
				<td>${userbasic.dept }</td>
			</tr>
		</c:forEach>
	</table>
	
		<hr>

<%-- 	<jsp:include page="/WEB-INF/views/layout/paging.jsp" /> --%>

	<div class="form-inline">
	<input class="form-control" type="text" id="userid" name="userid" placeholder="이름을 입력하세요"/>
	<button id="searchBtn" class="btn btn-primary">Search</button>

</div> 

</div>
	</div>
<!-- .container -->


