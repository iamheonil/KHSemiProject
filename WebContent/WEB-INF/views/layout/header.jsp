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
}

#logo {
	padding-top: 16px;
	padding-left: 230px;
	position: absolute;
	line-height: 1.0em;
}

header>ul {
	width: 700px;
	background-color: white;
	margin: 0 auto;
}

header>ul:hover>li>ul {
	display: block !important;
}

header>ul>li {
	width: 25%;
	display: block;
	float: left;
	text-align: center;
}

header>ul>li a {
	display: block;
	line-height: 80px;
	width: 70% color: black;
}

header>ul>li a:hover {
	background-color: #9c6a6a;
	transition: 0.5s;
}

.depth02 {
	position: absolute;
	left: 0;
	top: 100%;
	width: 100%;
	background-color: white;
	display: block;
	max-height: 300px;
}

.depth02>li {
	display: block;
	margin: 0 auto;
	width: 750px;
	height: 100px;
	background-color: white;
}

.depth02>li>ul {
	width: 25%;
	float: left;
}

.depth02>li>ul>li {
	line-height: 33px;
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
	padding-left: 55px;
	position: relative;
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
		<li id="logo"><a href="/document/dolist"><img src="/logo.png"
				width="170px;"></a></li>
		<ul>
			<li class="li-white"><a href="/document/dolist">전자결재</a>
				<ul class="depth02" style="display: none;">
					<li>
						<ul>
							<li><a href="#">메뉴</a></li>
							<li><a href="#">메뉴</a></li>
							<li><a href="#">메뉴</a></li>
						</ul>
						<ul>
							<li><a href="#">여기도메뉴</a></li>
							<li><a href="#">여기도메뉴</a></li>
							<li><a href="#">여기도메뉴</a></li>
						</ul>
						<ul>
							<li><a href="#">저기도메뉴</a></li>
							<li><a href="#">저기도메뉴</a></li>
							<li><a href="#">저기도메뉴</a></li>
						</ul>
						<ul>
							<li><a href="#">주소록메뉴</a></li>
							<li><a href="#">주소록메뉴</a></li>
							<li><a href="#">주소록메뉴</a></li>
						</ul>
					</li>
				</ul></li>
			<li class="li-white"><a href="/plan/view">일정관리</a></li>
			<li class="li-white"><a href="/board/list">커뮤니티</a></li>
			<li class="li-white"><a href="#">주소록</a></li>
		</ul>
	</header>