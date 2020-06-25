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

$(document).on("click",".guideBox > button", function(){
	if($(this).next().css("display")=="none"){
		$(this).next().show();
		$(this).children("table").text("[닫기]");
	}else{
		$(this).next().hide();
		$(this).children("table").text("[열기]");
	}
});
$(document).ready(function(){

$("#selectBtn").click(function(){
	var rowData = new Array();
	var tdArr = new Array();
	var checkbox = $("input[name=checkbox]:checked");
	
	// 체크된 체크박스 값을 가져온다
	checkbox.each(function(i) {

		// checkbox.parent() : checkbox의 부모는 <td>이다.
		// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
		var tr = checkbox.parent().parent().eq(i);
		var td = tr.children();
		
		// 체크된 row의 모든 값을 배열에 담는다.
		rowData.push(tr.text());
		
		// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
		var dept = td.eq(1).text();
		var userid = td.eq(2).text();
		var name = td.eq(3).text();
		
		
		
		// 가져온 값을 배열에 담는다.
		tdArr.push(dept);
		tdArr.push(userid);
		tdArr.push(name);
		
		console.log("부서 : " + dept);
		console.log("직위 : " + dept);
		console.log("userid : " + userid);
		console.log("name : " + name);
		//console.log("email : " + email);
	});
	
	$("#ex3_Result1").html(" * 체크된 Row의 모든 데이터 = "+rowData);	
	$("#ex3_Result2").html(tdArr);	
	$("#add").html(" * 체크된 Row의 모든 데이터 = "+rowData);	
	$("#add").html(tdArr);	
});
});


</script>

<script type="text/javascript">
//Get the modal
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
<style type="text/css">

#docdetail{
	width: 1000px;
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

input[type=checkbox] {
	transform : scale(1.5);
}
textarea{
	width: 680px;
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
	margin: 10px 0px;
	float: right;
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


<div class="container" style="width: 930px">
<div id="docbutton" align="right">
<button class="btn btn-primary" id="myBtn">문서처리</button>
<button class="btn btn-primary" onclick="location.href='/document/list/temp'">임시저장</button>
<button class="btn btn-primary">닫기</button>
</div>
<h3>문서정보</h3>

<form action="#" method="post">
<table class="table table-bordered" style="width: 900px;">
<tr>
	<td class="active">제목＊</td>
	<td><input type="text" id="doc_title" name="doc_title" style="width: 620px;"/>
		 &nbsp;<input type="checkbox"/> 긴급</td>
</tr>

<tr>
	<td class="active">문서요지</td>
	<td><input type="text" id="doc_title" name="doc_title" style="width: 680px;"/></td>
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
<h3>경로정보</h3><button class="btn btn-primary" id="selectpath">경로지정</button>

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

<table id="path" class="table table-bordered " style="width: 900px;"> <!-- 부트스트랩, table -->
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


</div> <!-- contents 닫는태그 -->




<!-- 문서처리 팝업창 -->

<!-- The Modal -->
<div id="myModal" class="modal">
<form action="">
  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
	<h3>문서 처리</h3>
	<table class="table table-bordered" style="width: 100%;">
	<tr>
		<td class="active" id="doc_title">제목</td>
		<td>제목1</td>
	</tr>
	
	<tr>
		<td class="active">처리구분</td>
		<td><input type="radio" id="doc_type" name="doc_title"/>결재</td>
	</tr>
	
	<tr>
	<td class="active">의견/지시</td>
	<td><textarea id="doc_comment"></textarea></td>
	</tr>
	</table>                                                         
<!--     <p>Some text in the Modal..</p> -->

	<button>확인</button>
	<button>닫기</button>
  </div>
</form>
</div>

	
	
<%-- import footer --%>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
