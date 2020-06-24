<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<%-- <c:import url="/WEB-INF/views/layout/header.jsp" /> --%>

<script type="text/javascript">
$(document).ready(function() {
	
	//버튼 기능, 삭제버튼 기능 구현 필요
	$("#btnDelete").click(function() {

	});

});
</script>

<div class="container">

<h1>커뮤니티 게시글 삭제</h1>
<hr>


<!-- 현재 관리자 휴가 리스트와 큰 차이 없음, 자신의 신청서만 보게 하는 기능 필요  -->
<table class="table table-hover table-condensed">
<tr>
	<th>글번호</th>
	<th>게시글 제목</th>
	<th>작성자</th>
	<th>작성일</th>
</tr>
<c:forEach items="${boardList }" var="board">
<tr>
	<td>${board.b_num }</td>
	<td>${board.b_title }</td>
	<td>${board.userid }</td>
	<td><fmt:formatDate value="${board.writtendate }" pattern="yyyy-MM-dd"/></td>
</tr>
</c:forEach>
</table>

</div>

<div id="btnBox">
	<button id="btnDecline" class="btn btn-primary">삭제</button>
</div>
<c:import url="/WEB-INF/views/layout/paging.jsp" />

<%-- <c:import url="/WEB-INF/views/layout/footer.jsp" /> --%>


</body>
</html>