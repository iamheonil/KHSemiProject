<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- jQuery 2.2.4.min -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">

.container {
	width: auto;
	height: auto;
	text-align: center;
}

.wrap {
	text-align: center;
	width: auto;
	margin: 0 auto;
	
}

</style>

<script type="text/javascript">

$(document).ready(function() {
	
	// 검색어 관련
	$("#searchBtn").click(function() {
		$('#contents').load( "/admin/address/list?search="+$("#keyword").val() );

// 		location.href="/admin/address/list?search="+$("#keyword").val()
	})
	
	// 검색창에서 enter시 검색버튼 눌려지기
	$("input[name~='keyword']").keydown(function(e) {
	if(e.keyCode == 13) {
		$("#searchBtn").click()
	}
})
});

</script>

<%-- <c:import url="/WEB-INF/views/adlayout/adheader.jsp" /> --%>
		<!-- float 해제 -->
		<div class="clearfix"></div>

<h3>주소록 목록</h3>
<hr>

<!-- float 해제 -->
<!-- <div class="clearfix"></div> -->

<%-- <c:import url="/WEB-INF/views/adlayout/adaside.jsp" />		 --%>

<div class="container">
	<div class="wrap">
	
<div class="form-inline" style="text-align: right;">

	<input class="form-control" type="text" id="keyword" name="keyword" 
		 placeholder="이름을 입력하세요"/>
	<button id="searchBtn" class="btn btn-primary">Search</button><br><br>

</div> 
		<div class="">
			<table id="check" class="table table-striped table-hover table-condensed">
				<thead>
<!-- 				<tr><th colspan="5" style="text-align: center;">주소록</th></tr> -->
				<tr class="info">
					<th class="text-center">부서</th>
					<th class="text-center">직급</th>
					<th class="text-center">이름</th>
					<th class="text-center">주소</th>
					<th class="text-center ">전화번호</th>
				</tr>
				</thead>
					<c:forEach items="${detailList }" var="detail">
				<tbody>
				<tr>
					<td>${detail.dept }</td>
					<td>${detail.userrank }</td>
					<td id="keyword">${detail.username }</td>
					<td>${detail.useraddr }</td>
					<td>${detail.userphone }</td>
				</tr>
				</tbody>
					</c:forEach>
				
			</table>
			
			
				<c:import url="/WEB-INF/views/adlayout/ad_paging.jsp" />
				
		</div>
	</div>
		<div class="clearfix"></div>
	
<%-- <c:import url="/WEB-INF/views/adlayout/adfooter.jsp" /> --%>