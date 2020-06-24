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
	// 선택체크 삭제
	$("#btnDelete").click(function() {
		// 선택된 체크박스
		var $checkboxes = $("input:checkbox[name='checkRow']:checked");
		

		//방법2
		// 체크된 대상들을 map으로 만들고 map을 문자열로 만들기
		var map = $checkboxes.map(function() {
			return $(this).val();
		});
		var names = map.get().join(",");
			console.log("names : " + names);
	
			console.log($checkboxes);
			console.log( "map:" + map );	// 맵
			console.log( "map->array : " + map.get() );	// 맵->배열
			console.log( "array tostring : " + map.get().join(",") ); // toString
		
	
		
		
		// 전송 폼
		var $form = $("<form>")
			.attr("action", "/document/list/delete")
			.attr("method", "post")
			.append(
				$("<input>")
					.attr("type", "hidden")
					.attr("name", "names")
					.attr("value", names)
			);
		$(document.body).append($form);
		$form.submit();
	
	});
	
	// 검색어 관련
	$("#searchBtn").click(function() {
		location.href="/document/list/temp?search="+$("#keyword").val()
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


//전체 체크/해제
function checkAll() {
	// checkbox들
	var $checkboxes=$("input:checkbox[name='checkRow']");

	// checkAll 체크상태 (true:전체선택, false:전체해제)
	var check_status = $("#checkAll").is(":checked");
	
	if( check_status ) {
		// 전체 체크박스를 checked로 바꾸기
		$checkboxes.each(function() {
			this.checked = true;	
		});
	} else {
		// 전체 체크박스를 checked 해제하기
		$checkboxes.each(function() {
			this.checked = false;	
		});
	}
}



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

<c:import url="/WEB-INF/views/layout/aside_doc.jsp"/>
		
<div id="contents">
<div id="templist">

<h3>임시저장함</h3><br>



<br><br>


<div class="container">
<table class="table table-striped table-hover" style="width: 850px;"> <!-- 부트스트랩, table -->
<tr class="active">
	<th><input type="checkbox" id="checkAll" onclick="checkAll();"/></th>
	<th style="width: 10%;">구분</th>
	<th style="width: 20%;">저장일자</th>
	<th style="width: 40%;">제목</th>
	<th style="width: 10%;">부서</th>
	<th style="width: 10%;">직위</th>
	<th style="width: 10%;">보고자</th>
</tr>
<c:forEach items="${TempList }" var="temp">
<tr>
	<td><input type="checkbox" name="checkRow" value="${temp.doc_num }"/></td>
	<td>기안</td>
	<td><fmt:formatDate value="${temp.doc_date }" pattern="yyyy-MM-dd"/></td>
	<td><a href="/document/view?doc_num=${temp.doc_num }">${temp.doc_title }</a></td>
	<td>${temp.dept }</td>
	<td>${temp.userrank }</td>
	<td>${temp.username }</td>
</tr>

</c:forEach>
</table>

<div style="text-align: left;">
	<button id="btnDelete" class="btn btn-primary">삭제</button>
</div>

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
