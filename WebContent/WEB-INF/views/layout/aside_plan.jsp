<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.menu {
	padding: 0px;
}

.sidemenu-title {
	height: 40px;
	margin-top: 30px;
	margin-bottom: 15px;
	border-bottom: 1px solid white;
}

.sidemenu-content {
	height: auto;
	margin-left: 20px;
}

.sidemenu-content>a {
	/* 	margin-left: 5px; */
	
}

.modal {
	text-align: center;
}

@media screen and (min-width: 768px) {
	.modal:before {
		display: inline-block;
		vertical-align: middle;
		content: " ";
		height: 100%;
	}
}

.modal-dialog {
	display: inline-block;
	text-align: left;
	vertical-align: middle;
}
</style>
<div id="wrap" style="width: 1680px;">

	<div id="s_left">

		<ul>
			<ul id="personal">
				<li id="photo" style="border-radius: 100px;">
					<img alt="프로필사진" src="/upload/${userphoto }
					style="width: 112px; height: 112px; border-radius: 100px;"></li>
				<li>${userdept }${userrank } ${username }</li>
				<li>사원번호 ${userid }</li>
				<li><button class="btn btn-dark"
						onclick="location.href='/user/modify/detail'"
						style="color: black;">마이페이지</button> &nbsp;
					<button class="btn btn-dark" style="color: black;"
						onclick='location.href="/user/logout";'>로그아웃</button></li>
			</ul>
			<nav id="admenu">
				<ul class="aside_nav">
					<li class="sidemenu-title"><a href="/plan/view">일정보기</a></li>

					<li class="sidemenu-content"><a data-toggle="modal"
						href="#addPlan">일정등록</a></li>
					<li class="sidemenu-content"><a data-toggle="modal"
						href="#myModal">일정수정</a></li>
					<li class="sidemenu-content"><a data-toggle="modal"
						href="#delPlan">일정삭제</a></li>
				</ul>
			</nav>

		</ul>
	</div>

	<!-- 일정 추가 Modal -->
	<div class="modal fade" id="addPlan" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h3 class="modal-title">일정 등록 폼</h3>
				</div>
				<div class="modal-body">
					<form action="/plan/insert" method="post">
						<table
							style="width: 300px; margin: 0 auto; border-collapse: separate; border-spacing: 0px 30px;">
							<tr>
								<td>일정명 :</td>
								<td><input type="text" name="plan_name" id="plan_name"
									size="20" /></td>
							</tr>
							<tr>
								<td>일정 시작 날짜 :</td>
								<td><input type="date" name="ptime_start" id="ptime_start"
									size="20" /></td>
							</tr>
							<tr>
								<td>일정 종료 날짜 :</td>
								<td><input type="date" name="ptime_end" id="ptime_end"
									size="20" /></td>
							</tr>
							<!-- <input type="button" value="달력" onclick="$('#date3').datepicker('show');" /> -->
							<tr>
								<td><button class="btn btn-primary">일정 등록 하기</button></td>
							</tr>
						</table>
						<br>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>


	<script type="text/javascript">
		$(document).ready(function() {
			// 삭제버튼 동작
			$("#btnDelete").click(function() {
				location.href = "/plan/delete?plan_num=${plan.plan_name }";
			});
		});
	</script>

	<!-- 일정 삭제 Modal -->
	<div class="modal fade" id="delPlan" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h3 class="modal-title">일정 삭제 폼</h3>
				</div>
				<div class="modal-body">
					<h4>등록되어 있는 나의 일정 목록</h4>
					<br>
					<c:forEach items="${allPlan }" var="plan">
							일정명 : ${plan.plan_name } <br>
							일정시작시간 : ${plan.ptime_start } <br>
							일정종료시간 : ${plan.ptime_end } <br>
						<button class="btn btn-danger" id="btnDelete">해당 일정 삭제</button>
						<hr>
					</c:forEach>
					<br>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>