<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
					<button class="btn btn-dark" style="color: black;">로그아웃</button></li>
			</ul>
			<nav id="admenu">

				<li class="ad-li"><a href="/document/dolist">&nbsp;&nbsp;전자문서</a></li>

				<li class="ad-li"><a href="/plan/view">&nbsp;&nbsp;일정관리</a></li>
		
				<li class="ad-li"><a href="/board/list">&nbsp;&nbsp;커뮤니티</a></li>

				<li class="ad-li"><a href="">&nbsp;&nbsp;주소록</a></li>
						
			</nav>
		</ul>
	</div>