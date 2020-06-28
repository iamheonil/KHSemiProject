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

<script type="text/javascript" src="/resources/js/document/httpRequest.js"></script>


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


// ajax
// var request = new XMLHttpRequest();
// function searchFunction(){
// // 	request.open("post", "/UserListServlet?userid="+document.getElementById("userid").valeu());
// 	//onreadystatechange => 서버와의 통신이 끝났을 때 호출되는 이벤
// 	request.onreadystatechange = function(){
// 		var table = document.getElementById("ajaxTable");
// 		table.innerHTML = "";
		
// 		//readyState => 현재 통신상태(4=통신완료)/status=>HTTP와의 통신결과(200=통신성공) 
// 		if(request.readyState == 4 && request.status == 200){
// 			//responseText=>서버에서 통신한 자료를 담고 있다
// 			//eval =>서버에서 받은 자료를 JSON오브젝트로 변환해준다

// 			var object = eval('(' + request.responseText + ')'); 
// 			var result = object.result;

// 			for(var i = 0; i < result.length; i++){
// 				var row = table.insertRow(0);
				
// 				for(var j = 0; j < result[i].length; j++){
// 					var cell = row.insertCell(j);
// 					cell.innerHTML = result[i][j].value;
// 				}
// 			}
// 		}
// 	}
// 	request.send();
// }
// window.onload = function(){
// 	searchFunction();
// }
// window.onload = function() {

	
	
function send(){
	var s = searchname.value;
	
	var params = "searchname="+s;
	console.log(params)
	// - - - URL 구성 - - -
	var url = "/document/write/search"; ///UserSearchController
	// - - - - - - - - - - -
	
	// - - - AJAX 요청 전송 - - -
	sendRequest("POST", url, params, callback);
	// - - - - - - - - - - - - - -
	}

//AJAX 요청 처리 콜백함수
function callback() {
	if( httpRequest.readyState == 4 ) { //XHR DONE.
		if( httpRequest.status == 200 ) { //HTTP 200, OK.
			console.log("정상적인 응답")
			
			//정상응답 처리 함수
			searchFunction();
			
		} else {
			console.log("AJAX 요청/응답 에러")
		}
	}
}


// }
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



//이름으로 사원 검색하기
$(document).ready(function(){
	
	$("#searchname").keydown(function(e) {
		if(e.keyCode == 13) {
			searchclick();
		}
	})
	$("#search").click(function(){
		searchclick();
	})
	
// 	$("#deptSearch").change(function(){
// 		var dept = $("#deptSearch option:selected").text();
// 		$("#user-table > tbody > tr").hide();
// 		var temp1 = $("#userTB> tbody > tr > td#dept:nth-child(n):contains('" + dept + "')");
		
// 		$(temp1).parent().show();
// 	})
// 	$("#rankSearch").change(function(){
// 		var dept = $("#rankSearch option:selected").val();
// 		var temp1 = $("#userTB> tbody > tr > td#rank:nth-child(n):contains('" + rank + "')");
		
// 		$(temp1).parent().show();
		
// 	})
	
function searchclick(){
		var k = $("#searchname").val();
		var dept = $("#deptSearch option:selected").text();
		
		$("#userTB > tbody > tr").hide();
		
		var temp = $("#userTB> tbody > tr > td#name:nth-child(n):contains('" + k + "')");
		var temp1 = $("#userTB> tbody > tr > td#dept:nth-child(n):contains('" + dept + "')");
		
		
		$(temp).parent().show();
		$(temp1).parent().show();
		
	}
	
	
})
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
#search{
/* 	display: inline-block; */
/* 	float: right; */
}
#searchname{
	width: 150px;
	height: 40px;
	display: inline-block;
/* 	float: right; */
}
#tb_wrap{
	
}
#userTB {overflow-y: auto; height: 100px;}
#userTB th { position: sticky; top: 0; background: white;}

 #container {width: 960px; margin: 0 auto;}
        #container #input-form {text-align: center;}
        #user-table {margin: 0 auto; text-align: center;}
        #input-form {margin-top: 10px; margin-bottom: 10px;}

        #user-table {border-collapse: collapse;}
        #user-table > thead > tr { background-color: #333; color:#fff; }
        #user-table > thead > tr > th { padding: 8px; width: 150px; }
        #user-table > tbody > tr > td { border-bottom: 1px solid gray; padding:8px; }
</style>

<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/layout/header_doc.jsp" />

<c:import url="/WEB-INF/views/layout/aside_doc.jsp" />
		
<div id="contents">
<div id="docdetail">


<div class="container" style="width: 930px">
<div id="docbutton" align="right">
</div>
<h3>문서정보</h3>

<form action="/document/write" method="post" enctype="multipart/form-data">
<input type="button" class="btn btn-primary" id="myBtn" value="문서처리">
<input type="button" class="btn btn-primary" value="임시저장" 
onclick="location.href='/document/writetemp'">
<input type="button" value="닫기" class="btn btn-primary">
<table class="table table-bordered" style="width: 900px;">
<tr>
	<td class="active">제목＊</td>
	<td><input type="text" id="doc_title" name="doc_title" style="width: 620px;"/>
		 &nbsp;<input type="checkbox" id="doc_emergency" name="doc_emergency" value="Y"/> 긴급</td>
</tr>

<tr>
	<td class="active">문서요지</td>
	<td><input type="text" id="doc_substance" name="doc_substance" style="width: 680px;"/></td>
</tr>

<tr>
<td class="active">본문＊</td>
<td><textarea id="doc_content" name="doc_content"></textarea></td>
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
<h3 style="margin-left: 80px;">경로정보</h3><button class="btn btn-primary" id="selectpath">경로지정</button>

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
<input class="form-control" type="text" id="searchname" name="searchname" 
	 placeholder="이름으로 검색하기"/>
<button id="search" class="btn btn-primary">검색</button>
<div class="tb_wrap" style="width:100%; height:200px; overflow:auto; border: 1px solid #eee;" >
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
	<td id="dept">${user.dept }</td>
	<td id="rank">${user.userrank }</td>
	<td id="name">${user.username }</td><!-- userrank, 보고종류 -->
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





<div class="form-group row pull-right">
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
</div> <!-- form-group div -->

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
