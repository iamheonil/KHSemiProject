<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

.title {
	text-align: left;
	margin-bottom: 18px;
	font-weight: bold;
}
.wrap {
	text-align: center;
	width: auto;
	margin: 0 auto;
	
}


</style>

<script type="text/javascript">

$(document).ready(function(){
	//선택 체크 삭제
	$("#btnDelete").click(function() {
		//선택된 체크박스
		var $checkboxes = $("input:checkbox[name='checkRow']:checked");
		
		// 체크된 대상들을 map으로 만들고 map을 문자열로 만들기
		var map = $checkboxes.map(function() {
			return $(this).val();
		});
		var names = map.get().join(",");
		
		// 전송 폼
		var $form = $("<form>")
		.attr("action", "/admin/board/delete")
		.attr("method", "get")
		.append(
			$("<input>")
				.attr("type", "hidden")
				.attr("name", "names")
				.attr("value", names)
		);
		$(document.body).append($form);
		$form.submit();
		
	})
	
	
})

//전체 체크/해제
function checkAll() {
	// checkbox들
	var $checkboxes=$("input:checkbox[name='checkRow']");

	// checkAll 체크상태 (true:전체선택, false:전체해제)
	var check_status = $("#checkAll").is(":checked");
	
	if( check_status ) {
		// 전체 체크박스를 checked로 바꾸기
		$checkboxes.each(function() {
			this.checked = true;	
		});
	} else {
		// 전체 체크박스를 checked 해제하기
		$checkboxes.each(function() {
			this.checked = false;	
		});
	}
}

$(document).ready(function(){
	$("#search").keydown(function(e) {
		if(e.keyCode == 13) {
			$("#btnSearch").click()
		}
	})
	
	$("#btnSearch").click(function() {
		$('#contents').load( "/admin/board/list?search="+$("#search").val() );

	})
});

</script>
	<div id="contents">

	<div class="container">

		<h2 class="title">커뮤니티</h2>
		<hr>
		<br>
		
		<table class="table table-hover table-striped">
			<thead>
				<tr class="info" style="text-align: center;">
					<th style="width: 5%; text-align: center;"><input type="checkbox" id="checkAll" onclick="checkAll();"/></th>
					<th style="width: 5a%; text-align: center;">글 번호</th>
					<th style="width: 12%; text-align: center;">카테고리</th>
					<th style="width: 30%; text-align: center;">제목</th>
					<th style="width: 13%; text-align: center;">아이디</th>
					<th style="width: 7%; text-align: center;">이름</th>
					<th style="width: 10%; text-align: center;">조회수</th>
					<th style="width: 13%; text-align: center;">작성일</th>
				</tr>
			</thead>
			
				<c:forEach items="${N_list }" var="a">
					<tr class="info">
						<td><input type="checkbox" name="checkRow" value="${a.b_num }"/></td>
						<td style="text-align: center;">${a.b_num }</td>
						<td style="text-align: center;">${a.category}</td>
						<td style="text-align: left;">${a.b_title }</td>
						<td style="text-align: center;">${a.userid }</td>
						<td style="text-align: center;">${a.username }</td>
						<td style="text-align: center;">${a.hits }</td>
						<td><fmt:formatDate value="${a.b_date }" pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>

			<c:forEach items="${list }" var="a">

				<tr class="table-content">
					<td><input type="checkbox" name="checkRow" value="${a.b_num }"/></td>
					<td style="text-align: center;">${a.b_num }</td>
					<td style="text-align: center;">${a.category }</td>
					<td style="text-align: left;">${a.b_title }</td>
					<td style="text-align: center;">${a.userid }</td>
					<td style="text-align: center;">${a.username }</td>
					<td style="text-align: center;">${a.hits }</td>
					<td><fmt:formatDate value="${a.b_date }" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</table>
		<button id="btnDelete" class="btn btn-primary pull-right">삭제</button>


		<!-- 검색 -->
		<div class="form-inline text-center">
			<input class="form-control" type="text" id="search" style="width:250px;" placeholder="검색어를 입력해주세요"/>
			<button id="btnSearch" class="btn glyphicon glyphicon-search"></button>
		<c:import url="/WEB-INF/views/adlayout/ad_B_paging.jsp" />
		</div>
		</div>
	
</div>