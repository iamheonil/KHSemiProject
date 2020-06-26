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


</script>

<div id="contents">
	<div class="container">

		<h2 style="text-align: left;">커뮤니티</h2>
		
		<hr>
		<table class="table table-hover table-condensed">
			<thead style="background-color: rgb(38, 114, 165);">
				<tr style="text-align: center;">
					<th style="width: 5%"><input type="checkbox" id="checkAll" onclick="checkAll();"/></th>
					<th style="width: 10a%">글 번호</th>
					<th style="width: 15%;">카테고리</th>
					<th style="width: 30%;">제목</th>
					<th style="width: 10%;">아이디</th>
					<th style="width: 7%;">이름</th>
					<th style="width: 13%;">조회수</th>
					<th style="width: 10%;">작성일</th>
				</tr>
			</thead>

			<thead style="board: 1px solid #ffc6c9; background-color: #ffe3e4; color: #ff4e59;">
				<c:forEach items="${N_list }" var="a">
					<tr class="text-left info">
						<td><input type="checkbox" name="checkRow" value="${a.b_num }"/></td>
						<td style="text-align: center;">${a.b_num }</td>
						<td>${a.category}</td>
						<td>${a.b_title }</td>
						<td>${a.userid }</td>
						<td>${a.username }</td>
						<td>${a.hits }</td>
						<td><fmt:formatDate value="${a.b_date }" pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>
			</thead>

			<c:forEach items="${list }" var="a">

				<tr class="text-left">
					<td><input type="checkbox" name="checkRow" value="${a.b_num }"/></td>
					<td style="text-align: center;">${a.b_num }</td>
					<td>${a.category }</td>
					<td>${a.b_title }</td>
					<td>${a.userid }</td>
					<td>${a.username }</td>
					<td>${a.hits }</td>
					<td><fmt:formatDate value="${a.b_date }" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</table>
		<button id="btnDelete" class="btn btn-primary pull-right">삭제</button>


		<c:import url="/WEB-INF/views/adlayout/ad_B_paging.jsp" />

		<div class="form-inline text-center">
			<input class="form-control" type="text" id="search" style="width:250px;" placeholder="검색어를 입력해주세요"/>
			<button id="btnSearch" class="btn glyphicon glyphicon-search"></button>
		</div>
	</div>
</div>