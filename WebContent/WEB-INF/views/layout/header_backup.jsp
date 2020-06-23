<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

<head>
<title>Insert title here</title>

<!-- CDN -->
<script src="https://code.jquery.com/jquery-2.2.4.min.js"
	integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="css/style.css">
<script src="js/style.js"></script>

<script type="text/javascript">


    </script>

<style type="text/css">
@import
	url(//cdn.jsdelivr.net/font-nanum/1.0/nanumbarungothic/nanumbarungothic.css)
	;
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

#nav-logo {
	width: 150px;
	height: 100%;
	text-decoration: none;
	color: white;
	margin-top: 40px;
	margin-left: 45px;
	margin-right: 45px;
}

#header a {
	text-decoration: none;
	color: white;
}

.nav-container {
	display: flex;
	flex-direction: row;
	margin: 0 0 5px 0;
	/*쓸 데 없는 공백 제거*/
	padding: 0;
	/*쓸 데 없는 공백 제거*/
	background-color: #0f4c81;
	list-style-type: none;
	/*목록 기호 제거*/
}

.nav-item {
	width: 150px;
	padding: 15px;
	cursor: pointer;
	/*마우스 커서를 pointer 모양으로 함*/
	border-left: 1px solid white;
	border-right: 1px solid white;
}

.nav-item a {
	/*nav-item 클래스 아래의 a 요소를 선택함*/
	text-align: center;
	text-decoration: none;
	/*밑줄 없앰*/
	color: white;
}

.nav-item ul>li {
	text-decoration: none;
}

.nav-item ul:hover {
	text-decoration: none;
	display: block;
}

div#s_left {
	float: left;
	width: 240px;
	text-align: left;
	background: #0f4c81;
	min-height: 1123px;
	line-height: 2.5em;
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
	background: dodgerblue;
	list-style: none;
	text-align: center;
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

#contents {
	border: 1px solid black;
	width: 931px;
	float: right;
	text-align: center;
	margin-left: 7px;
	min-height: 1120px;
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
	<div id="front-wrap">
		<div id="header">
			<ul class="nav-container">
				<li id="nav-logo"><a href="">로고</a></li>
				<li class="nav-item"><a href="">일정관리</a></li>
				<li class="nav-item"><a href="">전자문서</a>
					<ul>
						<li><a href="#">공지사항</a></li>
						<li><a href="#">자유게시판</a></li>
					</ul></li>
				<li class="nav-item"><a href="">커뮤니티</a>
					<ul>
						<li><a href="#">공지사항</a></li>
						<li><a href="#">자유게시판</a></li>
					</ul></li>
				<li class="nav-item"><a href="">주소록</a></li>
			</ul>


		</div>