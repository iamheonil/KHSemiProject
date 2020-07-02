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
/* 	float: right; */
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
		
		$("#btnDelete").click(function() {

			//<form> 태그 submit
			$("form").submit();
			
		});

	})
</script>

<%-- <c:import url="/WEB-INF/views/adlayout/adaside.jsp" /> --%>

<div class="content">
	<div class="container">
	<div style="width=70%; margin-left: 310px;">
		<form action="/admin/userdetail/delete" method="post">
			<table style="width: 70%; margin-left: 35px; border-collapse: separate; border-spacing: 0px 30px; text-align: left;">
				<tr>
					<td style="width: 100%">탈퇴할 아이디 : <input type="text" id="userid" name="userid" size="35px" /></td>
				</tr>
				<tr>
					<td><button type="button" id="btnDelete" class="btn btn-primary" style="width: 73%;">회원탈퇴하기</button></td>
				</tr>
			</table>
		</form>
	</div>
		<hr>

<%-- 	<jsp:include page="/WEB-INF/views/layout/paging.jsp" /> --%>

</div> 

</div>
<!-- .container -->


