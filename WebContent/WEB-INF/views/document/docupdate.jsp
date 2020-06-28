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
// $(document).ready(function(){
// 	searchajax();
// })

// function searchajax(){
// 	$("#search").click(function(){
// 		var word = $("#search").val();
// 		if(woard!=''){
// 			$.ajax({
// 				type: 'POST',
// 				url: '/';,
// 				data: { searchword : word },
// 				dataType: 'json',
// 				success: function(result){
// 					if(result.length>0){
// 						var str = ''
// 						for(var i=0; i<result.length; i++){
// 							str += '<span>'+result[i].data + '</span><br>';
// 						}
// 						$("#results").html(str);
// 					}else {$("#results").html(""); }
// 				},
// 				error: function(e){console.log('error:' + e.status);}
// 			});
// 		}else{ $("#results").html(""); }
// 	});

// }

// jQuery.ajax({
// 	type: "post",
// 	url : "/컨트롤러",
// 	data : serDate,
// 	dataType: "json",
// 	success: function(obj){
// 		showempinfo(obj);
// 	},
// 	complete: function(xhr, status){
		
// 	},
// 	error: function(xhr, status, error){
// 		console.log(error);
// 	}
// })

// function showempinfo(obj){
// 	var div document.querySelector('#emptable');

// }
</script>
<script type="text/javascript">
// 사원검색하기
// window.onload = function() {
	
// 	//button#btnAction 태그에 click 이벤트 리스너 등록하기
// 	btnAction.onclick = function() {
// 		//console.log("btnAction clicked");
		
// 		//AJAX요청 보내기
// 		sendRequest("POST", "/ajax/test", "", callback);
// // 		callback : 요청에 대한 응답함수
		
// 	}
// }
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
		
		console.log("tdArr : " + tdArr.length)
		console.log("부서 : " + dept);
		console.log("직위 : " + dept);
		console.log("userid : " + userid);
		console.log("name : " + name);
		
	
	// 반복되게 해야하는데...
// 	for(var i=1; i<=tdArr.length; i+3) {
		$("#name").html("<input id=\"" + dept + "\" value=\""+tdArr[1]+"\" /><br><input id=\"" + userid + "\" value=\""+tdArr[2]+"\" />");
// 		console.log("실행"+i)
// 	}
	
	});
	
	$("#ex3_Result1").html(" * 체크된 Row의 모든 데이터 = "+rowData);	
	$("#ex3_Result2").html(tdArr);	
// 	$("#add").html(" * 체크된 Row의 모든 데이터 = "+rowData);	
	
	
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
// $('input:checkbox[id="chk"]').attr("Y", true);
// $('input:checkbox[id="chk"]').attr("N", false);

// var DATA;
// $('input:checkbox[id=chk]').each(function() {
//    if($(this).is(':checked')) {
//       $(this).val() = '2y';
//    } else {
//       $(this).val() = '1n';
//    }
// });

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
.guideBox select{
	float: left;
	margin-right: 10px;
	margin-bottom: 10px;
	height: 40px;
	width: 150px;
}
#userTB {overflow-y: auto; height: 100px; }
#userTB th { position: sticky; top: 0; background: white;}


</style>

<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/layout/header_doc.jsp" />

<c:import url="/WEB-INF/views/layout/aside_doc.jsp" />
		
<div id="contents">
<div id="docdetail">


<form  method="post" enctype="multipart/form-data">
<div class="container" style="width: 930px">
<div id="docbutton" align="right">
<button type="button" class="btn btn-primary" id="myBtn">문서처리</button>
<button type="submit" onclick="javascript: form.action='/document/update';"class="btn btn-primary" >임시저장</button>
<button class="btn btn-primary" onclick="javascript: history.go(-1)">닫기</button>
</div>
<h3>문서정보</h3>

<table class="table table-bordered" style="width: 900px;">
<tr>
	<input type="hidden" name="doc_num" value="${viewDocument.doc_num }" />
	<td class="active">제목＊</td>
	<td><input type="text" id="chk" name="doc_title" style="width: 620px;" value="${viewDocument.doc_title }" />
		 <c:if test="${viewDocument.doc_emergency eq 'Y'}">
		 <input type="checkbox" id="chk" name="doc_emergency" value="Y" checked="checked" /> 긴급</td>
		 </c:if>
		 <c:if test="${viewDocument.doc_emergency ne 'Y'}">
		 <input type="checkbox" id="chk" name="doc_emergency" value="Y"/> 긴급</td>
		 </c:if>
</tr>

<tr>
	<td class="active">문서요지</td>
	<td><input type="text" id="doc_substance" name="doc_substance" style="width: 680px;" value="${viewDocument.doc_substance }"/></td>
</tr>

<tr>
<td class="active">본문＊</td>
<td><textarea id="doc_content" name="doc_content"  >${viewDocument.doc_content }</textarea></td>
</tr>

<tr id="attach">
<td class="active">붙임</td>
<td>
<!-- <button id="addAttach">삭제</button> -->
<!-- <button id="deleteAttach">추가</button> -->
<input type="file" name="upfile" />
</td>
</tr>

</table>
<input type="submit" value="확인"/>
</form>

<br>



<div class="guideBox"> <!-- h3위치 조절하기!! -->
<h3 style="margin-left: 80px;">경로정보</h3><button type="button" class="btn btn-primary" id="selectpath">경로지정</button>

<div style="display:none; ">
<select id="deptSearch" class="selectpicker">
	<option selected>부서</option>
	<option value="human">인사팀</option>
	<option value="account">회계팀</option>
	<option value="develop">개발팀</option>
	<option value="sales">영업팀</option>
	<option value="resource">자재팀</option>
</select>
<select id="rankSearch" class="selectpicker">
	<option selected>직급</option>
	<option value="human">사원</option>
	<option value="account">대리</option>
	<option value="develop">과장</option>
	<option value="sales">차장</option>
	<option value="resource">팀장</option>
	<option value="resource">부사장</option>
	<option value="resource">사장</option>
</select>
<div class="tb_wrap" style="width:100%; height:200px; overflow:auto">
<table style="width: 100%; border: 0; " id="userTB" class="table table-bordered"> <!-- c:foreach로 검색 목록 모두 표시 -->

<!-- user정보조회된거 -->
<thead>
<tr>
	<th>선택</th>
	<th>부서</th>
	<th>직위(직급)</th>
	<th>성명</th>
</tr>
</thead>
<tbody style="cellspacing:0; cellpadding:0;">
<c:forEach items="${user }" var="user">
<tr>
	<td><input type="checkbox" name="checkbox"/></td>
	<td>${user.dept }</td>
	<td>${user.userrank }</td>
	<td>${user.username }</td><!-- userrank, 보고종류 -->
</tr>
</c:forEach>
</tbody>
</table>
</div>

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
	<td>${userrank }<br>${username }</td>
	<td></td>
	<td></td>
	<td></td>
</tr>
<tr id=add>
	<td id="type"></td>
	<td id="name"></td>
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
