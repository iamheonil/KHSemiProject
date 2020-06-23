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

<style type="text/css">

#docdetail{
	width: 904px;
/* 	padding-left: 15px; */
	padding: 20px;
}
#docdetail h3{
	margin-top: 10px;
	padding: 0;
	color: #0A2D5D;
	font-weight: bold;
	display: inline-block; /* 버튼을 옆에 두기위해 */
}
td:first-child{
	font-weight: bold;
	width: 200px;
}
.container{
	width: 900px;
}
input[type=checkbox] {
	transform : scale(1.5);
}
textarea{
	width: 620px;
	height: 200px;
}
#path td{
	text-align: center;
	vertical-align: middle;
}
#path th{
	text-align: center;
	vertical-align: middle;
}
#selectpath{
	margin: 10px;
	float: right;
	margin-right: 20px;
}
#attach button{
	float: right;
	margin-right: 10px;
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

<div id="docdetail">

<div id="docbutton" align="right">
<button class="btn btn-primary" id="myBtn">문서처리</button>
<button class="btn btn-primary">닫기</button>
</div>

<div class="container">
<h3>문서정보</h3>

<form action="#" method="post">
<table class="table table-bordered" style="width: 850px;">
<tr>
	<td class="active">제목＊</td>
	<td><input type="text" id="doc_title" name="doc_title" style="width: 560px;"/>
		 &nbsp;<input type="checkbox"/> 긴급</td>
</tr>

<tr>
	<td class="active">문서요지</td>
	<td><input type="text" id="doc_title" name="doc_title" style="width: 620px;"/></td>
</tr>

<tr>
<td class="active">본문＊</td>
<td><textarea></textarea></td>
</tr>

<tr id="attach">
<td class="active">붙임</td>
<td>첨부파일
<button id="addAttach">삭제</button>
<button id="deleteAttach">추가</button>
</td>
</tr>

</table>

</form>

<br>



<div class="guideBox">

<div style="display:none">
<table class="table table-bordered"> <!-- c:foreach로 검색 목록 모두 표시 -->
<tr>
	<td>선택</td>
	<td>부서</td>
	<td>직위(직급)</td>
	<td>성명</td>
</tr>
<tr>
	<td><input type="checkbox" name="checkbox"/></td>
	<td>개발팀</td>
	<td>사원</td>
	<td>김길동</td>
</tr>
<tr>
	<td><input type="checkbox" name="checkbox"/></td>
	<td>개발팀</td>
	<td>팀장</td>
	<td>박길동</td>
</tr>
<tr>
	<td><input type="checkbox" name="checkbox"/></td>
	<td>개발팀</td>
	<td>부장</td>
	<td>최길동</td>
</tr>
</table>
<button type="button" id="selectBtn">추가</button>
<br><br>
</div> <!-- style지정 -->
<div id="ex3_Result1"></div>
<div id="ex3_Result2"></div>

</div>

<table id="path" class="table table-bordered " style="width: 850px;"> <!-- 부트스트랩, table -->
<tr class="active">
	<th style="width: 10%;">구분</th>
	<th style="width: 15%;">직위/성명</th>
	<th style="width: 40%;">의견/지시</th>
	<th style="width: 10%;">서명</th>
	<th style="width: 25%;">처리결과</th>
</tr>
<%-- <c:forEach items="${boardList }" var="board"> --%>
<tr>
	<td>기안</td>
	<td>사원<br>김길동</td>
<%-- 	<td><a href="/board/view?boardno=${doc.doc_num }">${doc.doc_title }</a></td> --%>
	<td>의견1</td>
	<td>이름1</td>
<%-- 	<td><fmt:formatDate value="${board.writtendate }" pattern="yyyy-MM-dd"/></td> --%>
	<td>2020-05-23<br>13:40:30</td>
</tr>
<tr>
	<td id="add"></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
</tr>
<%-- </c:forEach> --%>
</table>


</div> <!-- div.container -->
</div> <!-- detail -->



</div>
	
	
<%-- import footer --%>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
