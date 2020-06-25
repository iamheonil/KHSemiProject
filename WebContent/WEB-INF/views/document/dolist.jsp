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
</style>


<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/layout/header_doc.jsp" />

<c:import url="/WEB-INF/views/layout/aside_doc.jsp" />

<div id="contents">
	<div id="dolistcon">
		<div id="dolist">
			<h4>처리할 일</h4>
			<ul id="dolistAppro">
				<li><a href="/document/list/waitapprove">결재대기함 : ${waitApproveCnt }건</a></li>
				<li><a href="/document/list/progress">진행문서함 : 1건</a></li>
			</ul>
		</div>
		<br>
		<br>
		<br>


		<div class="container" style="width: 1000px;">
			<h4>결재대기함</h4>
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
				<%-- <c:forEach items="${boardList }" var="board"> --%>
				<tr>
					<td>검토</td>
					<%-- 	<td><fmt:formatDate value="${board.writtendate }" pattern="yyyy-MM-dd"/></td> --%>
					<td>2020-05-23</td>
					<%-- 	<td><a href="/board/view?boardno=${doc.doc_num }">${doc.doc_title }</a></td> --%>
					<td>제목1</td>
					<td>부서1</td>
					<td>사원</td>
					<td>이름1</td>
				</tr>
				<%-- </c:forEach> --%>
			</table>


			<br>

			<h4>진행문서함</h4>
			<table class="table table-striped table-hover table-condensed" style="width:1000px;">
				<!-- 부트스트랩, table -->
				<tr class="active">
					<th style="width: 10%;">구분</th>
					<th style="width: 20%;">보고일자</th>
					<th style="width: 40%;">제목</th>
					<th style="width: 10%;">부서</th>
					<th style="width: 10%;">직위</th>
					<th style="width: 10%;">보고자</th>
				</tr>
				<%-- <c:forEach items="${boardList }" var="board"> --%>
				<tr>
					<td>검토</td>
					<%-- 	<td><fmt:formatDate value="${board.writtendate }" pattern="yyyy-MM-dd"/></td> --%>
					<td>2020-05-23</td>
					<%-- 	<td><a href="/board/view?boardno=${doc.doc_num }">${doc.doc_title }</a></td> --%>
					<td>전자문서 결재에 대한 결과 보고 입니다 아아아</td>
					<td>부서1</td>
					<td>사원</td>
					<td>이름1</td>
				</tr>
				<%-- </c:forEach> --%>
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
