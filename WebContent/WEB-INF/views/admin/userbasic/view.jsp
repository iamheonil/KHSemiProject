<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<style type="text/css">
h4 {
	text-align: center;
	color: #0A2D5D;
	font-weight: bold;
	margin: 40px 0 40px 0;
	font-size: 1.6em;
}

p {
	text-align: center;
	padding: 10px;
}
.container {
	float: left;
	position: relative;
	width: 900px;
}

.contents {
  min-height: 100%;
}
.container {
	width: 900px;
}
#formSearch {
	text-align: center;
	margin: 0 0 200px 0;
}
#btnBox {

}
</style>

<script type="text/javascript">
$(document).ready(function() {
	
	//검색 버튼 기능 구현 필요
	$("#btnSearch").click(function() {
		$('#contents').load("/admin/userbasic/list?search="+$("#search").val());
		
	});
	
	//생성 버튼 누르면 이동
	$("#btnCreate").click(function() {
		$('#contents').load("/admin/userbasic/insert");
	});

});
</script>


<div class="contents">
	<div class="container">
	<h4>사원관리</h4>
	<hr>
		<p class="bg-info">사원 수정 및 삭제를 위해 사원을 검색해주세요.</p>
<!-- 		<form action="/admin/userbasic/list" method="post"> -->
		<div class="form-inline text-center" id="formSearch">
			<input class="form-control" type="text" id="search" />
			<button id="btnSearch" class="btn btn-primary">검색</button>
		</div>
<!-- 		</form> -->
	<hr>		
			<p class="bg-info">새로운 사원 생성을 원하시면 버튼을 클릭해주세요.</p>			
		<div id="btnBox">
			<button id="btnCreate" class="btn btn-primary">새로운 사원 생성</button>
		</div>	

	</div>

</div>
