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
				<li><button class="btn btn-dark" onclick="location.href='/user/modify/detail'">마이페이지</button> &nbsp;
					<button class="btn btn-dark">로그아웃</button></li>
			</ul>
			<nav id="admenu">
				<ul class="aside_nav">
					<li class="sidemenu-title"><a href="/document/dolist">처리할일</a></li>
					
					<li class="sidemenu-title">기안</li>
					
					<li class="sidemenu-content"><a href="/document/write">문서기안</a></li>
					<li class="sidemenu-content"><a href="/document/list/temp">임시저장함</a></li>
					
					<li class="sidemenu-title">결재</li>
					
					<li class="sidemenu-content"><a href="/document/list/waitapprove">결재대기함</a></li>
					<li class="sidemenu-content"><a href="/document/list/progress">진행문서함</a></li>
					
					<li class="sidemenu-title">완료문서</li>
					<li class="sidemenu-content"><a href="/document/list/draft">기안한문서</a></li>
					<li class="sidemenu-content"><a href="/document/list/approve">결재한문서</a></li>
					
					<li class="sidemenu-title"><a href="/document/list/all">문서등록대장</a></li>
				</ul>
			</nav>
			
		</ul>
	</div>