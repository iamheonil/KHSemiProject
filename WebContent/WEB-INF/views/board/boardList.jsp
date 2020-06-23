<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<c:import url="/WEB-INF/views/layout/aside.jsp" />
<style type="text/css">
.container {
	width: auto;
	height: auto;
}
</style>
<div id="contents">
	<div class="container">

		<h2>사내 게시판</h2>

		<table class="table table-hover table-condensed">
			<thead style="background-color: rgb(38, 114, 165)";>
				<tr>
					<th style="width: 7%">글 번호</th>
					<th style="width: 8%;">카테고리</th>
					<th style="width: 43%;">제목</th>
					<th style="width: 12%;">아이디</th>
					<th style="width: 7%;">이름</th>
					<th style="width: 6%;">조회수</th>
					<th style="width: 8%;">작성일</th>
				</tr>
			</thead>

			<thead>
				<c:forEach items="${N_list }" var="i">
					<tr class="text-left info">
						<td>${i.b_num }</td>
						<td>${i.category }</td>
						<td><a href="/board/view?b_num=${i.b_num }">${i.b_title }</a></td>
						<td>${i.userid }</td>
						<td>${i.username }</td>
						<td>${i.hits }</td>
						<td><fmt:formatDate value="${i.b_date }" pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>
			</thead>

			<c:forEach items="${list }" var="i">

				<tr class="text-left">
					<td>${i.b_num }</td>
					<td>${i.category }</td>
					<td><a href="/board/view?b_num=${i.b_num }">${i.b_title }</a></td>
					<td>${i.userid }</td>
					<td>${i.username }</td>
					<td>${i.hits }</td>
					<td><fmt:formatDate value="${i.b_date }" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</table>
		<button type="button" class="pull-left"
			onclick="location.href='/board/insert'">글 등록</button>




		<c:import url="/WEB-INF/views/layout/paging.jsp" />
	</div>
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />