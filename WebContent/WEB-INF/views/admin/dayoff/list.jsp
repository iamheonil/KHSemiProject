<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- jQuery 2.2.4.min -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<%-- <c:import url="/WEB-INF/views/adlayout/adheader.jsp" /> --%>

<style type="text/css">


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
	width: auto;
	height: auto;
	text-align: center;
}
.title {
	text-align: left;
	margin-bottom: 18px;
	font-weight: bold;
}
</style>


<script type="text/javascript">
$(document).ready(function() {
	
	//버튼 기능, 승인버튼 기능 필요
	$("#btnAccept").click(function() {
		// 선택된 체크박스
		var $checkboxes = $("input:checkbox[name='checkRow']:checked");
		

		var map = $checkboxes.map(function() {
			return $(this).val();
		});
		var names = map.get().join(",");

		
		var $form = $("<form>")
			.attr("action", "/admin/dayoff/accept")
			.attr("method", "Post")
			.append(
				$("<input>")
					.attr("type", "hidden")
					.attr("name", "names")
					.attr("value", names)
			);
		
		$(document.body).append($form);
		
		$form.submit();
	});

	//버튼 기능, 반려버튼 기능 필요
	$("#btnDecline").click(function() {
		// 선택된 체크박스
		var $checkboxes = $("input:checkbox[name='checkRow']:checked");
		

		var map = $checkboxes.map(function() {
			return $(this).val();
		});
		var names = map.get().join(",");

		
		var $form = $("<form>")
			.attr("action", "/admin/dayoff/decline")
			.attr("method", "Post")
			.append(
				$("<input>")
					.attr("type", "hidden")
					.attr("name", "names")
					.attr("value", names)
			);
		
		$(document.body).append($form);
		
		$form.submit();
	});
	
	// 선택체크 삭제
	$("#btnDelete").click(function() {
		// 선택된 체크박스
		var $checkboxes = $("input:checkbox[name='checkRow']:checked");
		

		var map = $checkboxes.map(function() {
			return $(this).val();
		});
		var names = map.get().join(",");

		
		var $form = $("<form>")
			.attr("action", "/admin/dayoff/listDelete")
			.attr("method", "Post")
			.append(
				$("<input>")
					.attr("type", "hidden")
					.attr("name", "names")
					.attr("value", names)
			);
		
		$(document.body).append($form);
		
		$form.submit();
	
	});
	
});
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

<%-- <c:import url="/WEB-INF/views/adlayout/adaside.jsp" /> --%>

	<div class="container">
<div class="content">
	<h2 class="title">휴가 관리</h2>
<hr>
<br>

		<table class="table table-hover table-striped">
			<tr class="info">
				<th><input type="checkbox" id="checkAll" onclick="checkAll();" /></th>
				<th>휴가번호</th>
				<th>사번</th>
				<th>휴가 시작</th>
				<th>휴가 종료</th>
				<th>휴가 사유</th>
				<th>휴가 여부</th>
			</tr>
			<c:forEach items="${list }" var="dayoff">
				<tr class="table-content">
					<td><input type="checkbox" name="checkRow" value="${dayoff.daynum  }" /></td>
					<td>${dayoff.daynum }</td>
					<td>${dayoff.userid }</td>
					<td>${dayoff.daystart }</td>
					<td>${dayoff.dayend }</td>
					<td>${dayoff.dreason }</td>
					<td>${dayoff.dresult }</td>
				</tr>
			</c:forEach>
		</table>

		<div id="btnBox">
			<button id="btnAccept" class="btn btn-primary">승인</button>
			<button id="btnDecline" class="btn btn-primary">반려</button>
			<button id="btnDelete" class="btn btn-primary">삭제</button>
		</div>

		<c:import url="/WEB-INF/views/adlayout/ad_Day_Paging.jsp" />

	</div>

</div>


<%-- <c:import url="/WEB-INF/views/adlayout/adfooter.jsp" /> --%>

