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

<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/layout/header.jsp" />
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
	width: 930px;
/* 	padding-left: 15px; */
	padding: 35px;
}
h3{
	margin-top: 10px;
	padding: 0;
}
#dolistcon{
	padding: 20px;
}
.container{
	width: 900px;
}

.form-inline{
	display: inline-block;
}
</style>

		<div id="s_left">

			<ul>
				<ul id="personal">
					<li id="photo" style="border-radius: 100px; padding-top: 5px;"><br>사진</li>
					<li>소속팀 인사1팀 사원 홍길동</li>
					<li>사원번호 1571000367</li>
					<li><button>마이페이지</button> &nbsp;
						<button>로그아웃</button></li>
				</ul>
				<li>첫번째 메뉴
					<ul>

						<li>1</li>
						<li>2</li>
						<li>3</li>

					</ul>

				</li>
				<li>두번째 메뉴
					<ul>

						<li>1</li>
						<li>2</li>
						<li>3</li>

					</ul>
				</li>
				<li>세번째 메뉴
					<ul>

						<li>1</li>
						<li>2</li>
						<li>3</li>

					</ul>
				</li>
				<li>네번째 메뉴
					<ul>

						<li>1</li>
						<li>2</li>
						<li>3</li>

					</ul>
				</li>
				<li>다섯번째 메뉴
					<ul>

						<li>1</li>
						<li>2</li>
						<li>3</li>

					</ul>
				</li>
			</ul>
		</div>
		
<div id="contents">
<div id="templist">

<h3>문서등록대장</h3><br>



<br><br>


<div class="container">
<table class="table table-striped table-hover" style="width: 850px;"> <!-- 부트스트랩, table -->
<tr class="active">
	<th style="width: 10%;">문서번호</th>
	<th style="width: 15%;">보고일자</th>
	<th style="width: 40%;">제목</th>
	<th style="width: 8%;">부서</th>
	<th style="width: 8%;">직위</th>
	<th style="width: 8%;">보고자</th>
	<th style="width: 8%;">상태</th>
</tr>
<c:forEach items="${AllList }" var="list">
<tr>
	<td>${list.doc_num }</td>
	<td><fmt:formatDate value="${list.doc_date }" pattern="yyyy-MM-dd"/></td>
	<td><a href="/document/view?doc_num=${list.doc_num }">${list.doc_title }</a></td>
	<td>${list.dept }</td>
	<td>${list.userrank }</td>
	<td>${list.username }</td>
	<td>${list.doc_state }</td>
</tr>

</c:forEach>
</table>


<c:import url="/WEB-INF/views/layout/document_templist_paging.jsp"/>
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
