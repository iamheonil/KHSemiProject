<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

.sidemenu-content > a {
/* 	margin-left: 5px; */
}

</style>
<div id="wrap" style="width: 1680px;">

	<div id="s_left">

		<ul>
			<ul id="personal">
				<li id="photo" style="border-radius: 100px;">
					<img src="https://scontent-ssn1-1.xx.fbcdn.net/v/t1.0-9/22851732_1447343662030847_4635333031465798330_n.png?_nc_cat=110&_nc_sid=85a577&_nc_ohc=RNi4MIIjllEAX9U13Gc&_nc_ht=scontent-ssn1-1.xx&oh=da907adae481ccba598a9b1596fe256c&oe=5F180F0D"
					style="width: 112px; height: 112px; border-radius:100px;">
				</li>
				<li>${userdept } ${userrank } ${username }</li>
				<li>사원번호 ${userid }</li>
				<li><button class="btn btn-dark" onclick="location.href='/user/modify/detail'" style="color: black;">마이페이지</button> &nbsp;
					<button class="btn btn-dark" style="color: black;" onclick='location.href="/user/logout";'>로그아웃</button></li>
			</ul>
			<nav id="admenu">
				<ul class="aside_nav">
					<li class="sidemenu-title"><a href="/plan/view">일정보기</a></li>
					
					<li class="sidemenu-content"><a data-toggle="modal" href="#myModal">일정등록</a></li>
					<li class="sidemenu-content"><a data-toggle="modal" href="#myModal">일정수정</a></li>
					<li class="sidemenu-content"><a data-toggle="modal" href="#myModal">일정삭제</a></li>
				</ul>
			</nav>
			
		</ul>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h4 class="modal-title">일정 등록 폼</h4>
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