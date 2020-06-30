<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- jQuery 2.2.4.min -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<%-- <c:import url="/WEB-INF/views/adlayout/adheader.jsp" /> --%>

<style type="text/css">


.container {
	width: auto;
	height: auto;
	text-align: center;
}

table, th {
	text-align: center;
}

.table {
	padding: 20px;
}

.title {
	text-align: left;
	margin-bottom: 18px;
	font-weight: bold;
}

</style>

<script type="text/javascript">
	$(document).ready(function() {


		// 선택체크 삭제
		$("#btnDelete").click(function() {
			// 선택된 체크박스
			var $checkboxes = $("input:checkbox[name='checkRow']:checked");
			

			var map = $checkboxes.map(function() {
				return $(this).val();
			});
			var names = map.get().join(",");

			
			var $form = $("<form>")
				.attr("action", "/admin/document/delete")
				.attr("method", "get")
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
	
	$(document).ready(function(){
		$("#search").keydown(function(e) {
			if(e.keyCode == 13) {
				$("#btnSearch").click()
			}
		})
		
		$("#btnSearch").click(function() {
			$('#contents').load( "/admin/document/list?search="+$("#search").val()
					+"&startDate="+$("#someDate").val()
					+"&endDate="+$("#someDateTime").val() );

		})
	});	

</script>

<div class="contents">

	<div class="container">

	<h2 class="title">전자문서</h2>
	<hr>
	<br>

<table class="table table-striped table-hover" > <!-- 부트스트랩, table -->
<tr class="info">
	<th style="width: 5%"><input type="checkbox" id="checkAll" onclick="checkAll();"/></th>
	<th style="width: 10%;">문서번호</th>
	<th style="width: 14%;">보고일자</th>
	<th style="width: 35%;">제목</th>
	<th style="width: 8%;">부서</th>
	<th style="width: 8%;">직위</th>
	<th style="width: 10%;">보고자</th>
	<th style="width: 15%;">상태</th>
</tr>

<c:forEach items="${AllList }" var="list">
<tr class="table-content">
	<td><input type="checkbox" name="checkRow" value="${list.doc_num }" /></td>
	<td>${list.doc_num }</td>
	<td><fmt:formatDate value="${list.doc_date }" pattern="yyyy-MM-dd"/></td>
	<td>${list.doc_title }</td>
	<td>${list.dept }</td>
	<td>${list.userrank }</td>
	<td>${list.username }</td>
	<td>${list.doc_state }</td>
</tr>

</c:forEach>
</table>

<button id="btnDelete" class="btn btn-primary pull-right">삭제</button>


<c:import url="/WEB-INF/views/adlayout/ad_D_paging.jsp"/>
<br>

<div class="form-inline">
	<input id="someDate" name="startDate" type="date"> ~
	<input id="someDateTime" name="endDate" type="date">
	&emsp;&emsp;
	<input class="form-control" type="text" id="search" name="keyword" 
		 placeholder="검색어를 입력하세요"/>
	<button id="btnSearch" class="btn btn-primary">Search</button>

</div> 

</div> <!-- div.container -->


</div> <!-- contents 닫는태그 -->

