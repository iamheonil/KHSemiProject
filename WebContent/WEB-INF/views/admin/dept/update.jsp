<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%-- <c:import url="/WEB-INF/views/layout/header.jsp" /> --%>

<script type="text/javascript">
$(document).ready(function() {
	
	//수정버튼 동작
	$("#btnInsert").click(function() {
		
		//form submit 수행
		$("form").submit();
	});
	
	//취소버튼 동작
	$("#btnCancel").click(function() {
		history.go(-1);
	});
});
</script>

<div class="container">

<h3>부서 수정</h3>
<hr>

<!-- 폼 enctype확인할 것 -->
<div>
<form action="/dept/insert" method="post" enctype="application/x-www-form-urlencoded">
<table class="table table-bordered">
<tr><td class="info">새로운 부서를 입력해주세요.</td></tr>
<tr><td class="info"><input type="text" name="title" style="width:100%" value="dname" id="dname"/></td></tr>
</table>

</form>
</div>

<div class="text-center">	
	<button type="button" id="btnInsert" class="btn btn-info">수정 적용</button>
	<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
</div>
</div>

<%-- <c:import url="/WEB-INF/views/layout/footer.jsp" /> --%>

