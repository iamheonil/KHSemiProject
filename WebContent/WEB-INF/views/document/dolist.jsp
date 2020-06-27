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


<style type="text/css">
h4 {
	color: #0A2D5D;
	font-weight: bold;
}

#dolistAppro {
	list-style: none;
	margin: 0;
	padding-left: 20px;
	background: #6794D4;
	text-align: left;
}

#dolistAppro li {
	/* 	float: left; */
	display: inline-block;
	background: white;
	margin: 10px 20px;
	padding: 5px;
}

#dolist {
	width: 1000px;
	padding-left: 15px;
}

#dolist h4 {
	margin-top: 10px;
	padding: 0;
}

#dolistcon {
	padding: 20px;
}

.container {
	width: 900px;
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

<script type="text/javascript">
$(document).ready(function() {
	
	
	
	if(${waitApproveCnt } > 0) {
		setInterval(function() {
			$("#dolistAppro > li:nth-child(1)").css("background", "#0f4c81")
			$("#dolistAppro > li:nth-child(1) > a").css("color", "white")
			
		}, 1000);
		setInterval(function() {
			$("#dolistAppro > li:nth-child(1)").css("background", "white")
			$("#dolistAppro > li:nth-child(1) > a").css("color", "black")
		}, 2000);
	}
	if(${waitApproveCnt } > 0) {
		setInterval(function() {
			$("#dolistAppro > li:nth-child(2)").css("background", "#0f4c81")
			$("#dolistAppro > li:nth-child(2) > a").css("color", "white")
			
		}, 1000);
		setInterval(function() {
			$("#dolistAppro > li:nth-child(2)").css("background", "white")
			$("#dolistAppro > li:nth-child(2) > a").css("color", "black")
		}, 2000);
	}
	
});
</script>

<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/layout/header_doc.jsp" />

<c:import url="/WEB-INF/views/layout/aside_doc.jsp" />

<div id="contents">
	<div id="dolistcon">
		<div id="dolist">
			<h3 class="title">처리할 일</h3>
			<ul id="dolistAppro">
				<li><a href="/document/list/waitapprove" style="font-size: 16px;">결재대기함 : ${waitApproveCnt }건</a></li>
				<li><a href="/document/list/progress" style="font-size: 16px;">진행문서함 : ${progressCnt }건</a></li>
			</ul>
		</div>
		<br>
		<br>
		<br>


		<div class="container" style="width: 1000px;">
			<h3 class="title">결재대기함</h3>
			<table class="table table-striped table-hover" style="width: 1000px;">
				<!-- 부트스트랩, table -->
				<tr class="active">
					<th style="width: 10%;">구분</th>
					<th style="width: 20%;">보고일자</th>
					<th style="width: 40%;">제목</th>
					<th style="width: 10%;">부서</th>
					<th style="width: 10%;">직위</th>
					<th style="width: 10%;">보고자</th>
				</tr>
				<c:forEach items="${waitApproveDoList }" var="waitApprove">
				<tr class="table-content">
					<td>${waitApprove.report_type }</td>
					<td><fmt:formatDate value="${waitApprove.doc_date }" pattern="yyyy-MM-dd"/></td>
					<td>
					<c:if test="${waitApprove.doc_emergency eq 'Y' }">
					<a href="/document/view?doc_num=${waitApprove.doc_num }"><span>[긴급] </span>${waitApprove.doc_title }</a>
					</c:if>
					<c:if test="${waitApprove.doc_emergency != 'Y' }">
					<a href="/document/view?doc_num=${waitApprove.doc_num }">${waitApprove.doc_title }</a>
					</c:if>
					</td>
					<td>${waitApprove.dept }</td>
					<td>${waitApprove.userrank }</td>
					<td>${waitApprove.username }</td>
				</tr>
				</c:forEach>
			</table>


			<br>

			<h3 class="title">진행문서함</h3>
			<table class="table table-striped table-hover " style="width:1000px;">
				<!-- 부트스트랩, table -->
				<tr class="active">
					<th style="width: 10%;">구분</th>
					<th style="width: 20%;">보고일자</th>
					<th style="width: 40%;">제목</th>
					<th style="width: 10%;">부서</th>
					<th style="width: 10%;">직위</th>
					<th style="width: 10%;">보고자</th>
				</tr>
				<c:forEach items="${progressDoList }" var="progress">
				<tr class="table-content">
					<td>${progress.report_type }</td>
					<td><fmt:formatDate value="${progress.doc_date }" pattern="yyyy-MM-dd"/></td>
					<td>
					<c:if test="${progress.doc_emergency eq 'Y' }">
					<a href="/document/view?doc_num=${progress.doc_num }"><span>[긴급] </span>${progress.doc_title }</a>
					</c:if>
					<c:if test="${progress.doc_emergency != 'Y' }">
					<a href="/document/view?doc_num=${progress.doc_num }">${progress.doc_title }</a>
					</c:if>
					</td>
					<td>${progress.dept }</td>
					<td>${progress.userrank }</td>
					<td>${progress.username }</td>
				</tr>
				</c:forEach>
			</table>


		</div>
		<!-- div.container -->

		<br>

	</div>
	<!-- dolistcon -->


</div>
<!-- contents 닫는태그 -->


<%-- import footer --%>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
