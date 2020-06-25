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

// 팝업창 띄우기
window.onload = function(){
	var modal = document.getElementById('myModal');
	
	// Get the button that opens the modal
	var btn = document.getElementById("myBtn");
	
	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];                                          
	
	// When the user clicks on the button, open the modal 
	btn.onclick = function() {
	    modal.style.display = "block";
	}
	
	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
	    modal.style.display = "none";
	}
	
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	    }
	}
	
}

</script>

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

<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/layout/header_doc.jsp" />

<c:import url="/WEB-INF/views/layout/aside_doc.jsp" />
		
<div id="contents">

<div id="docdetail">

<!-- 결재대기함에 조회되는 문서일때 문서처리 버튼있음 -->

<div id="docbutton" align="right">
<button class="btn btn-primary" onclick="history.back(-1)">닫기</button>
</div>

<div class="container">
<h3>문서정보</h3>

<table class="table table-bordered" style="width: 850px;">
<tr>
	<td class="active">제목＊</td>
	<td>${viewDocument.doc_title }</td>
</tr>

<tr>
	<td class="active">문서요지</td>
	<td>${viewDocument.doc_substance }</td>
</tr>

<tr>
<td class="active">본문＊</td>
<td>${viewDocument.doc_content }</td>
</tr>

<tr id="attach">
<td class="active">붙임</td>
<td>${viewAttach.attach_originname }</td>
</tr>

</table>

<br>


<h3>보고경로</h3>
<table id="path" class="table table-bordered " style="width: 850px;"> <!-- 부트스트랩, table -->
<tr class="active">
	<th style="width: 10%;">구분</th>
	<th style="width: 15%;">직위/성명</th>
	<th style="width: 40%;">의견/지시</th>
	<th style="width: 10%;">서명</th>
	<th style="width: 25%;">처리결과</th>
</tr>
<%-- <c:if  --%>
<c:forEach items="${viewComment }" var="comment">
<tr>
	<td>${comment.report_type }</td>
	<td>${comment.userrank }<br>
	${comment.username }</td><!-- userrank, 보고종류 -->
	<td>${comment.comm_content }</td>
	<td>${comment.username }</td>
	<td><fmt:formatDate value="${comment.comm_date }" pattern="yyyy-MM-dd"/><br>
	<fmt:formatDate value="${comment.comm_date }" pattern="hh:MM:ss"/></td>
</tr>

</c:forEach>
</table>
</div>

</div> <!-- div.container -->
</div> <!-- detail -->




	
	
<%-- import footer --%>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
