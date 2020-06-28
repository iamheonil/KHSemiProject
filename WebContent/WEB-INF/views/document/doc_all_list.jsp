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

<script type="text/javascript">
$(document).ready(function() {
	
	// 검색어 관련
	$("#searchBtn").click(function() {
		location.href="/document/list/all?search="+$("#keyword").val()
					+"&startDate="+$("#someDate").val()
					+"&endDate="+$("#someDateTime").val();
	})
	
	// 검색창에서 enter시 검색버튼 눌려지기
	$("input[name~='keyword']").keydown(function(e) {
	if(e.keyCode == 13) {
		$("#searchBtn").click()
	}
})
});

</script>
<style type="text/css">
h3{
	color: #0A2D5D;
	font-weight: bold;
}
.form-control{
	height: 40px;
}
#dolistAppro{
	list-style: none;
	margin: 0;
	padding-left: 20px;
	background: #6794D4;
}

#templist{
	width: 1000px;
	padding: 35px;
}
h3{
	margin-top: 10px;
	padding: 0;
}
#dolistcon{
	padding: 20px;
}

.form-inline{
	display: inline-block;
}

.active > th {
	text-align: center;
}

.table-content > td{ 
 	text-align: center; 
}
.table-content > td:nth-child(3){
	text-align: left;
}
.table-content span{
	color: red;
}

.title {
	text-align: left;
	margin-bottom: 18px;
	font-weight: bold;
}
</style>

<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/layout/header_doc.jsp" />

<c:import url="/WEB-INF/views/layout/aside_doc.jsp"/>
		
<div id="contents">
<div id="templist">

<h3 class="title">문서등록대장</h3>



<br><br>


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

<c:if test="${empty AllList }">
	<tr class="table-content">
		<td colspan="7">조회된 문서가 없습니다.</td>
	</tr>
</c:if>

<c:forEach items="${AllList }" var="list">
<tr class="table-content">
	<td>${list.doc_num }</td>
	<td><fmt:formatDate value="${list.doc_date }" pattern="yyyy-MM-dd"/></td>
	<td>
	<c:if test="${list.doc_emergency eq 'Y' }">
	<a href="/document/view?doc_num=${list.doc_num }"><span>[긴급] </span>${list.doc_title }</a>
	</c:if>
	<c:if test="${list.doc_emergency != 'Y' }">
	<a href="/document/view?doc_num=${list.doc_num }">${list.doc_title }</a>
	</c:if>
	</td>
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


</div> <!-- templist -->
</div> <!-- contents 닫는태그 -->
	
	
<%-- import footer --%>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
