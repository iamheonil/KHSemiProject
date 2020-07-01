<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- 사원 클릭 시 해당 사원만 보여줌, 검색 기능 필요할 수 있음  -->

<style type="text/css">
h4 {
	color: #0A2D5D;
	font-weight: bold;
	padding: 20px;
	font-size: 1.7em;
}

/* .container { */
/* /* 	float: right; */ */
/* 	position: relative; */
/* 	width: 900px; */
/* } */

table, th {
	text-align: center;
}

.table {
	padding: 20px;
}
.container {
	width: auto;
	height: auto;
	text-align: center;
}
.content {
/* 	margin: 0 auto; */
	min-height: 100%;
}

caption {
	color: #0A2D5D;
	font-weight: bold;
	padding: 20px;
	font-size: 1.3em;
}
.form-inline{
	display: inline-block;
}
</style>
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

			
			var $form = $("<form>")
				.attr("action", "/admin/userbasic/list")
				.attr("method", "Post")
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
		$('#contents').load("/admin/userbasic/list?search="+$("#userid").val());
	})
	
		
		// 검색창에서 enter시 검색버튼 눌려지기
		$("input[name~='userid']").keydown(function(e) {
		if(e.keyCode == 13) {
			$("#searchBtn").click()
		}
		})
	});
	
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

<%-- <c:import url="/WEB-INF/views/adlayout/adaside.jsp" /> --%>

<div class="content">
	<div class="container">
	<h4>사원 검색 결과</h4>
	<h5>사원 검색 결과입니다.</h5>
	<hr>

	<table class="table table-hover table-condensed">
		<tr class="info">
			<th><input type="checkbox" id="checkAll" onclick="checkAll();" /></th>
			<th>사번</th>
			<th>이름</th>
			<th>직급</th>
			<th>부서</th>
		</tr>
		<c:forEach items="${userbasiclist }" var="userbasic">
			<tr>
				<td><input type="checkbox" name="checkRow" value="${userbasic.userid }" /></td>
				<td>${userbasic.userid }</td>
				<td><a href="/admin/userbasic/modify?userid=${userbasic.userid }">${userbasic.username }</a>&nbsp;</td>
				<td>${userbasic.userrank }</td>
				<td>${userbasic.dept }</td>
			</tr>
		</c:forEach>
	</table>
	
	
		<div class="btnBox">
				<button type="button" id="btnDelete" class="btn btn-danger">삭제</button>
		</div>
		<hr>

<%-- 	<jsp:include page="/WEB-INF/views/layout/paging.jsp" /> --%>

	<div class="form-inline">
	<input class="form-control" type="text" id="userid" name="userid" placeholder="사번을 입력하세요"/>
	<button id="searchBtn" class="btn btn-primary">Search</button>

</div> 

</div>
	</div>
<!-- .container -->


