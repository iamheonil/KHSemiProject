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
h3{
	text-align: left;
}
span{
	color: red;
}

        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }
    
        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 60%; /* Could be more or less, depending on screen size */                          
        }
        /* The Close Button */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }
        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }

</style>

<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/layout/header_doc.jsp" />

<c:import url="/WEB-INF/views/layout/aside_doc.jsp" />
		
<div id="contents">

<div id="docdetail">

<!-- 결재대기함에 조회되는 문서일때 문서처리 버튼있음 -->

<div id="docbutton" align="right">
<input type="button" class="btn btn-primary" id="myBtn" value="문서처리">
<button class="btn btn-primary" onclick="history.back(-1)">닫기</button>
</div>

<div class="container">
<h3>문서정보</h3>
<table class="table table-bordered" style="width: 850px;">
<tr>
	<td class="active">제목＊</td>
<%-- 	<td>${viewDocument.doc_title }</td> --%>
	<td>
	<c:if test="${viewDocument.doc_emergency eq 'Y' }">
	<span>[긴급]</span>${viewDocument.doc_title }
	</c:if>
	<c:if test="${viewDocument.doc_emergency != 'Y' }">
	${viewDocument.doc_title }
	</c:if>
	</td>
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
<td>
<a href="/upload/${viewAttach.attach_rename }" download="${viewAttach.attach_originname }">${viewAttach.attach_originname }</a>
</td>
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
<c:forEach items="${viewReportComment }" var="recomm">
<tr>
	<td>${recomm.report_type }</td>
	<td>${recomm.userrank }<br>
	${recomm.username }</td><!-- userrank, 보고종류 -->
	<td>${recomm.comm_content }</td>
	<c:if test="${recomm.comm_content ne null}">
		<td>${recomm.username }</td>
	</c:if>
	<c:if test="${recomm.comm_content eq null }">
		<td></td>
	</c:if>
	<c:if test="${recomm.comm_content ne null  }">
	<td><fmt:formatDate value="${recomm.comm_date }" pattern="yyyy-MM-dd"/><br>
	<fmt:formatDate value="${recomm.comm_date }" pattern="HH:mm:ss"/></td>
	</c:if>
	<c:if test="${recomm.comm_content eq null  }">
	<td></td>
	</c:if>
</tr>
<%-- <c:forEach items="${viewComment }" var="comment"> --%>
<!-- <tr> -->
<%-- 	<td>${comment.report_type }</td> --%>
<%-- 	<td>${comment.userrank }<br> --%>
<%-- 	${comment.username }</td><!-- userrank, 보고종류 --> --%>
<%-- 	<td>${comment.comm_content }</td> --%>
<%-- 	<td>${comment.username }</td> --%>
<%-- 	<td><fmt:formatDate value="${comment.comm_date }" pattern="yyyy-MM-dd"/><br> --%>
<%-- 	<fmt:formatDate value="${comment.comm_date }" pattern="hh:MM:ss"/></td> --%>
<!-- </tr> -->

</c:forEach>
</table>
</div>

</div> <!-- div.container -->
</div> <!-- detail -->

<!-- 문서처리 팝업창 -->

<!-- The Modal -->
<form method="post">
<div id="myModal" class="modal">
  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
	<h3>문서 처리</h3>
	<table class="table table-bordered" style="width: 100%;">
<!-- 	<tr> -->
<!-- 		<td class="active">제목</td> -->
<!-- 		<td>제목1</td> -->
<!-- 	</tr> -->
	
	<tr>
		<td class="active">처리구분</td>
		<td><input type="radio" id="approve_type" name="approve_type" value="결재"/> 결재 <!-- name변경!!! -->
		<input type="radio" id="approve_type" name="approve_type" value="중단"/> 중단
		</td>
	</tr>
	
	<tr>
	<td class="active">의견/지시</td>
	<td><textarea id="approve_comment" name="approve_comment"></textarea></td>
	</tr>
	</table>                                                         
<!--     <p>Some text in the Modal..</p> -->

	<input type="submit" onclick="location.href='/document/approve/view'" value="확인">
	<button>닫기</button>
  </div>
</div>
</form>


	
	
<%-- import footer --%>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
