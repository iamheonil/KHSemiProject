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
//사원 검색
var newUsersearch = null;
$(document).ready(function() {
	
	newUsersearch = $("tbody.usersearch").clone().eq(0).html();
	
	$("#deptSearch").change(function() {
		makeUsersearch();
	})
	$("#rankSearch").change(function() {
		makeUsersearch();
	})
	$("#searchname").keyup(function() {
		makeUsersearch();
	})
})

function makeUsersearch() {
	
	$("tbody.usersearch").html( newUsersearch )
	
	if( '0' != $('#deptSearch').val()) {
		$("tbody.usersearch tr td:nth-child(2)").each(function() {
			if( $(this).text() != $('#deptSearch').val() ) {
				$(this).parent("tr").remove();
			}
		})
	}

	if( '0' != $('#rankSearch').val()) {
		$("tbody.usersearch tr td:nth-child(3)").each(function() {
			if( $(this).text() != $('#rankSearch').val() ) {
				$(this).parent("tr").remove();
			}
		})
	}

	if( null != $('#searchname').val() && '' != $('#searchname').val()) {
		$("tbody.usersearch tr td:nth-child(4)").each(function() {
			if( $(this).text().indexOf($('#searchname').val()) < 0 ) {
				$(this).parent("tr").remove();
			}
		})
	}

}

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
	
	var checkbox = $("input[name=checkbox]:checked"); // 체크
	var radiobox = $("input[name=checkbox]:checked"); // 보고 종류
	
	// 체크된 체크박스 값을 가져온다
	checkbox.each(function(i) {
		
		console.log( $(this).parent().parent().children().eq(1) )
		console.log( $(this).parent().parent().children().eq(3) )
		console.log( $(this).parent().parent().children().eq(4) )
		
		var type = $(":input:radio[name=report_type]:checked").val();
		var userid = $(this).parent().parent().children().eq(1).text();
		var dept = $(this).parent().parent().children().eq(3).text();
		var name = $(this).parent().parent().children().eq(4).text();
		
		var $tr = $("<tr>")

		var $td1 = $("<td>").html(dept + "<br>" + name)
		var $td2 = $("<td>").html(type)
		
		var $input1 = $("<input>").attr({
			type: "hidden"
			, name: "userid"
			, value: userid
		})
		
		var $input2 = $("<input>").attr({
			type: "hidden"
			, name: "type"
			, value: type
		})
		
		
		
		$tr.append( $td2 ).append( $td1 ).append($("<td>")).append($("<td>")).append($("<td>"))
			.append( $input1 ).append( $input2 )
		
		$(".link").append( $tr )
	}); // checkbox.each -- end
	
	checkbox.prop("checked", false)
	checkbox.prop("disabled", true)
	
}); // $("#selectBtn").click(function() -- end




// $(".checktest").click(function() {
$("#docform").submit(function() {
	console.log( $("tbody.link tr input[name='userid']") );
	console.log( $("tbody.link tr input[name='type']") );
	
	var users = $("tbody.link tr input[name='userid']").map(function() {
		return $(this).val();
	})
	.get()
	.join();
	
	var types = $("tbody.link tr input[name='type']").map(function() {
		return $(this).val();
	})
	.get()
	.join();
	
	
	console.log(".checktest clicked")
	
	$("<input>").attr({
		type: "hidden"
		, name: "users"
		, value: users
	}).appendTo( $("#docform") )
	
	$("<input>").attr({
		type: "hidden"
		, name: "types"
		, value: types
	}).appendTo( $("#docform") )
	
	console.log(".checktest end")
	
})

// 보고경로 삭제
$("#deleteBtn").click(function() {
	console.log("클릭됌")
	
	var checkbox = $("input[name=checkbox]:disabled");
	
	checkbox.each(function(i) {
		$(".link > tr:nth-child(2)").remove();
		$("input[type='hidden']").remove();
		checkbox.prop("checked", false)
		checkbox.prop("disabled", false)
		console.log("삭제완료")
	})
})

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
#searchname{
	width: 150px;
	height: 40px;
	display: inline-block;
/* 	float: right; */
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
		
<form id="docform" method="post" enctype="multipart/form-data">
<div id="contents">
<div id="docdetail">


<div class="container" style="width: 930px">
<div id="docbutton" align="right">
<button type="button" class="btn btn-primary" id="myBtn">문서처리</button>
<button type="submit" onclick="javascript: form.action='/document/update';" class="btn btn-primary" >임시저장</button>
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

<br>



<div class="guideBox"> <!-- h3위치 조절하기!! -->
<h3 style="margin-left: 80px;">경로정보</h3><button type="button" class="btn btn-primary" id="selectpath">경로지정</button>

<div style="display:none; ">
<select id="deptSearch" class="selectpicker">
	<option value="0" selected>부서</option>
	<option>인사팀</option>
	<option>회계팀</option>
	<option>개발팀</option>
	<option>영업팀</option>
	<option>자재팀</option>
</select>
<select id="rankSearch" class="selectpicker">
	<option value="0" selected>직급</option>
	<option>사원</option>
	<option>대리</option>
	<option>과장</option>
	<option>차장</option>
	<option>팀장</option>
	<option>부사장</option>
	<option>사장</option>
</select>

<input class="form-control" type="text" id="searchname" name="searchname" 
	 placeholder="이름으로 검색하기"/>
<button type="button" id="search" class="btn btn-primary">검색</button>
<div class="tb_wrap" style="width:100%; height:200px; overflow:auto; border: 1px solid #eee;" >
<table style="width: 100%; border: 0; " id="userTB" class="table table-bordered"> <!-- c:foreach로 검색 목록 모두 표시 -->


<!-- user정보조회된거 -->
<thead>
<tr>
	<th>선택</th>
	<th>사번</th>
	<th>부서</th>
	<th>직위(직급)</th>
	<th>성명</th>
</tr>
</thead>
<tbody class="usersearch" style="cellspacing:0; cellpadding:0;">
<c:forEach items="${user }" var="user">
<tr>
	<td><input type="checkbox" name="checkbox"/></td>
	<td id="name">${user.userid }</td><!-- userrank, 보고종류 -->
	<td id="dept">${user.dept }</td>
	<td id="rank">${user.userrank }</td>
	<td id="name">${user.username }</td><!-- userrank, 보고종류 -->
</tr>
</c:forEach>
</tbody>
</table>
</div>

<input type="radio" name="report_type" value="검토" checked="checked"/> 검토
<input type="radio" name="report_type" value="결재" /> 결재

<button type="button" class="btn btn-primary" id="selectBtn">추가</button>
<button type="button" class="btn btn-danger" id="deleteBtn">전체삭제</button>
<br><br>
</div> <!-- style지정 -->
<div id="ex3_Result1"></div>
<div id="ex3_Result2"></div>

</div>

<table id="path" class="table table-bordered " style="width: 900px;"> <!-- 부트스트랩, table -->
<thead>
<tr class="active">
	<th style="width: 10%;">구분</th>
	<th style="width: 15%;">직위/성명</th>
	<th style="width: 40%;">의견/지시</th>
	<th style="width: 10%;">서명</th>
	<th style="width: 25%;">처리결과</th>
</tr>
</thead>
<tbody class="link">

<tr>
	<td>기안</td>
	<td>${userrank }<br>${username }</td>
	<td></td>
	<td></td>
	<td></td>
</tr>

</tbody>
</table>
<button type="button" class="checktest">테스트</button>

</div> <!-- div.container -->
</div> <!-- detail -->


</div> <!-- contents 닫는태그 -->




<!-- 문서처리 팝업창 -->

<!-- The Modal -->
<div id="myModal" class="modal">
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

	<input type="submit" onclick="javascript: form.action='/document/write';" value="확인">
	<button>닫기</button>
  </div>
</div>

</form>

	
<%-- import footer --%>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
