<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/views/layout/header_doc.jsp" />
<c:import url="/WEB-INF/views/layout/aside_board.jsp" />

<style type="text/css">
.container {
	width: auto;
	height: auto;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	
	//글쓰기 버튼을 누르면 이동
	$("#btnSearch").click(function(){
		location.href="/board/notice?search="+$("#search").val()+"&search2="+$("#search2").val();
	});
	
	$("#search").keydown(function(e) {
		if(e.keyCode == 13) {
			$("#btnSearch").click()
		}
	})
	
// 	$(".ListAll").click(function(){
// 		$(location).attr("href", "/board/list");
// 	})
	
});
</script>
<div id="contents">
	<div class="container">
		<div>
		<h2 style="text-align: left;">커뮤니티</h2>
		<h4 style="text-align: left;">공지사항</h4>
		<hr>
		</div>
		
		<table class="table table-hover table-condensed">
			<thead style="background-color: rgb(38, 114, 165);">
				<tr style="text-align: center;">
					<th style="width: 7%">글 번호</th>
					<th style="width: 8%;">카테고리</th>
					<th style="width: 43%;">제목</th>
					<th style="width: 12%;">아이디</th>
					<th style="width: 7%;">이름</th>
					<th style="width: 6%;">조회수</th>
					<th style="width: 8%;">작성일</th>
				</tr>
			</thead>

				<c:forEach items="${N_list }" var="i">
					<tr class="text-left">
						<td style="text-align: center;">${i.b_num }</td>
						<td>${i.category}</td>
						<td><a href="/board/view?b_num=${i.b_num }">${i.b_title }</a>
						&nbsp;<span style="color:rgb(38, 114, 165);"><c:if test="${i.c_cnt ne 0}">[${i.c_cnt}]</c:if></span></td>
						<td>${i.userid }</td>
						<td>${i.username }</td>
						<td>${i.hits }</td>
						<td><fmt:formatDate value="${i.b_date }" pattern="yyyy-MM-dd HH:mm" /></td>
					</tr>
				</c:forEach>
		</table>


		<c:if test="${userrank == '차장' or userrank == '부장' or userrank == '팀장'}">
		<button type="button" class="btn pull-right glyphicon glyphicon-pencil"
			onclick="location.href='/board/insert'">&nbsp;글쓰기</button>
		</c:if>
		<c:import url="/WEB-INF/views/layout/b_Npaging.jsp" />

		<div  class="form-inline text-center" id= "">
		<select id="search2" style="width:100px;">
			<option value="1">제목</option>
			<option value="2">내용</option>
			<option value="3">이름</option>
		</select>
		<input class="form-control" type="text" id="search" style="width:250px" placeholder="검색어를 입력해주세요"/>
		<button id="btnSearch" class="btn glyphicon glyphicon-search"></button>
		</div>
				

<!-- 		<div class="form-inline text-center"> -->
<!-- 			<input class="form-control" type="text" id="search" style="width:250px;" placeholder="검색어를 입력해주세요"/> -->
<!-- 			<button id="btnSearch" class="btn glyphicon glyphicon-search"></button> -->
<!-- 		</div> -->
	</div>
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
