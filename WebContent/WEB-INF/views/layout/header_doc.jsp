<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
<title>:: ActiveWare</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript"
 src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$('#address').click(function(){
		console.log("클릭")
	})
})
</script>

<style type="text/css">
@import
	url(//cdn.jsdelivr.net/font-nanum/1.0/nanumbarungothic/nanumbarungothic.css);

/* 나눔바른고딕 : 한국서버 빠름*/
* {
	margin: 0px;
	padding: 0px;
	font-family: nanumbarungothic;
}

#front-wrap {
	width: 1180px;
	margin: 0px auto;
	padding: 10px 0px;
	text-align: center;
}

body, ul, li {
	margin: 0;
	padding: 0;
	list-style: none;
}

a {
	color: inherit;
	text-decoration: inherit;
}

header {
	position: relative;
	width: 100%;
	height: 80px;
	background-color: #0f4c81;
	z-index: 9999;
	text-decoration: none;
}

#logo {
	padding-top: 16px;
	padding-left: 230px;
	position: absolute;
	line-height: 1.0em;
}

header>ul {
	width: 950px;
	background-color: #0f4c81;
	margin: 0 auto;
	text-decoration: none;
	position: absolute;
}

header>ul:hover>li>ul {
	display: block !important;
}

header>ul>li {
	width: 25%;
	display: block;
	float: left;
	text-align: center;
	text-decoration: none;
}

header>ul>li a {
	display: block;
	line-height: 80px;
	width: 70% color: black;
	text-decoration: none;
}

header>ul>li a:hover {
	background-color: #9c6a6a;
	transition: 0.5s;
	text-decoration: none;
}

.depth02 {
	position: absolute;
	left: 0;
	top: 100%;
	width: 100%;
	display: block;
	max-height: 500px;
	text-decoration: none;
}

.depth02>li {
	display: block;
	position: relative;
	margin: 0 auto;
	width: 950px;
	height: 100px;
}

.depth02>li>ul {
	width: 25%;
	float: left;
}

.depth02>li>ul>li {
	line-height: 80px;
	background: white;
}

.li-white>a {
	color: white;
}

#photo {
	text-align: center;
	margin: auto;
	width: 55%;
	min-height: 110px;
	margin-top: 5px;
	border: 1px solid white;
}

div#s_left>ul>li {
	padding: 10px;
	margin-top: 25px;
	font-family: HELVETICA, NANUMGOTHIC;
	font-size: 18px;
	background: #0f4c81;
	color: white;
	border-bottom: 1px solid white;
}

a {
	/* border: 1px solid black; */
	text-decoration: none;
	color: white;
}

#footer {
	margin-top: 10px;
	clear: both;
}

#footer a:hover {
	text-decoration: underline;
}

#contents {
	/* border: 1px solid black; */
	margin-right: 250px;
	margin-top: 30px;
	float: right;
	text-align: center;
	margin-left: 7px;
	min-height: 1120px;
	position: relative;
	width: 1000px;
}

/* 사이드 메뉴 */
.ad-li {
	border-bottom: 4px solid white;
	height: 100px;
	display: flex;
	align-items: center;
}

#admenu {
	margin-top: 10px;
	border-top: 4px solid white;
}

#admenu a {
	color: white;
	width: 100%;
	font-size: 20px;
	text-decoration: none;
}

#admenu li {
	padding-left: 0px;
	position: relative;
	color: white;
	width: 100%;
	font-size: 20px;
	text-decoration: none;
}

/* ---------------------------- */

div#s_left {
	margin-left: 178px;
	margin-top: 0px;
	float: left;
	width: 240px;
	text-align: left;
	background: #0f4c81;
	min-height: 1123px;
	line-height: 2.5em;
	position: relative;
	float: left;
}

div#s_left ul {
	width: 230px;
	text-align: left;
	margin: 0 auto;
}

#s_left ul ul {
	width: 210px;
	list-style: none;
	text-align: center;
}

#s_left ul ul.aside_nav {
	width: 210px;
	list-style: none;
	text-align: left;
    margin-top: 10px;
}

#personal {
	width: 210px;
	height: 280px;
	background: #4C7DA6;
	padding-top: 15px;
	list-style: none;
	text-align: center;
	color: white;
}

.li-white {
	color: white;
}

#s_left ul li ul li {
	margin: 0px;
	padding: 0px;
	line-height: 1.9em;
	color: white;
	font-size: 16px;
}

#photo {
	text-align: center;
	margin: auto;
	width: 55%;
	min-height: 110px;
	margin-top: 5px;
	border: 1px solid white;
}

div#s_left>ul>li {
	padding: 10px;
	margin-top: 25px;
	font-family: HELVETICA, NANUMGOTHIC;
	font-size: 18px;
	background: #0f4c81;
	color: white;
	border-bottom: 1px solid white;
}

body>a {
	/* border: 1px solid black; */
	text-decoration: none;
	color: white;
}

a {
	/* border: 1px solid black; */
	text-decoration: none;
	color: dimgray;
}

#footer {
	margin-top: 10px;
	clear: both;
}

#footer a:hover {
	text-decoration: underline;
}
</style>

</head>

<body>
	<header>
		<li id="logo"><a href="/document/dolist"><img src="/logo.png" width="170px;"></a></li>
		<ul style="margin-left: 490px;">
			<li class="li-white"><a href="/document/dolist">전자결재</a>
				<ul class="depth02" style="display: none; position: relative; left: 0px;">
					<li>
						<ul>
							<li><a href="/document/dolist">처리할일</a></li>
							<li><a href="/document/write">문서기안</a></li>
							<li><a href="/document/list/waitapprove">문서결재</a></li>
							<li><a href="/document/list/draft">완료문서</a></li>
							<li><a href="/document/list/all">문서등록대장</a></li>
						</ul>
						<ul>
							<li><a href="#"></a>&nbsp;</li>
							<li><a href="#"></a>&nbsp;</li>
							<li><a href="#"></a>&nbsp;</li>
							<li><a href="#"></a>&nbsp;</li>
							<li><a href="#"></a>&nbsp;</li>
						</ul>
						<ul>
							<li><a href="/board/notice">공지사항</a></li>
							<li><a href="/board/study">스터디 모집</a></li>
							<li><a href="/board/free">사내게시판</a></li>
							<li><a href="#"></a>&nbsp;</li>
							<li><a href="#"></a>&nbsp;</li>
						</ul>
						<ul>
							<li><a href="#"></a>&nbsp;</li>
							<li><a href="#"></a>&nbsp;</li>
							<li><a href="#"></a>&nbsp;</li>
							<li><a href="#"></a>&nbsp;</li>
							<li><a href="#"></a>&nbsp;</li>
						</ul>
					</li>
				</ul></li>
			<li class="li-white"><a href="/plan/view">일정관리</a></li>
			<li class="li-white"><a href="/board/list">커뮤니티</a></li>
			<li class="li-white"><a href="#" id="address">주소록</a></li>
		</ul>
	</header>