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
h4 {
	color: #0A2D5D;
	font-weight: bold;
	font-size: 1.6em;
	padding: 10px;
}

.container {
	padding-left: 20px;
	float: left;
	position: relative;
	width: 900px;
}

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
	width: 900px;
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
</script>

<div class="content">
	<h4>전자문서 삭제</h4>

<div class="container" style="width:930px;">
<table class="table table-striped table-hover" style="width: 900px;"> <!-- 부트스트랩, table -->
<tr class="active">
	<th style="width: 10%;">문서번호</th>
	<th style="width: 14%;">보고일자</th>
	<th style="width: 40%;">제목</th>
	<th style="width: 8%;">부서</th>
	<th style="width: 8%;">직위</th>
	<th style="width: 10%;">보고자</th>
	<th style="width: 10%;">상태</th>
</tr>
<c:forEach items="${AllList }" var="list">
<tr class="table-content">
	<td>${list.doc_num }</td>
	<td><fmt:formatDate value="${list.doc_date }" pattern="yyyy-MM-dd"/></td>
	<td>
	<td>${list.doc_title }</td>
	<td>${list.dept }</td>
	<td>${list.userrank }</td>
	<td>${list.username }</td>
	<td>${list.doc_state }</td>
</tr>

</c:forEach>
</table>


<c:import url="/WEB-INF/views/layout/document_alllist_paging.jsp"/>
<br>

<div class="form-inline">
	<input id="someDate" name="startDate" type="date"> ~
	<input id="someDateTime" name="endDate" type="date">
	&emsp;&emsp;
	<input class="form-control" type="text" id="keyword" name="keyword" 
		 placeholder="검색어를 입력하세요"/>
	<button id="searchBtn" class="btn btn-primary">Search</button>

</div> 

</div> <!-- div.container -->


</div> <!-- contents 닫는태그 -->

