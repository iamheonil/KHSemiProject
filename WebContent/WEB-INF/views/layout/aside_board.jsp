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
					<img alt="프로필사진" src="/upload/${userphoto }
					style="width: 112px; height: 112px; border-radius:100px;">
				</li>
				<li>${userdept } ${userrank } ${username }</li>
				<li>사원번호 ${userid }</li>
				<li><button class="btn btn-dark" onclick="location.href='/user/modify/detail'" style="color: black;">마이페이지</button> &nbsp;
					<button class="btn btn-dark" style="color: black;" onclick='location.href="/user/logout";'>로그아웃</button></li>
			</ul>
			<nav id="admenu">
				<ul class="aside_nav">
					<li class="sidemenu-title"><a href="/document/dolist">커뮤니티</a></li>
					
					<li class="sidemenu-content"><a href="/board/notice">공지사항</a></li>
					<li class="sidemenu-content"><a href="/board/study">스터디 모집</a></li>
					<li class="sidemenu-content"><a href="/board/free">사내게시판</a></li>
				</ul>
			</nav>
			
		</ul>
	</div>