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

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<!-- <link rel="stylesheet" href="css/style.css"> -->
<!-- <script src="js/style.js"></script> -->

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
	height: 60px;
	margin-top: 20px;
	margin-left: 20px;
	margin-right: 20px;
	margin-bottom: 20px;
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
	background: #356285;
	list-style: none;
	text-align: center;
}


#profile {
	text-align: center;
	margin: auto;
	width: 55%;
	min-height: 110px;
	margin-top: 5px;
	
}


#contents {
	width: 931px;
	float: right;
	text-align: center;
	margin-left: 7px;
	min-height: 1120px;
}

a {
	text-decoration: none;
	color: dimgray;
}


#footer a:hover {
	text-decoration: underline;
}

/* 사이드 메뉴 */

.ad-li {
	border-bottom: 4px solid white;
	height: 70px;
	display: flex;
	align-items: center;
}

#admenu {
	margin-top: 10px;
	border-top: 4px solid white;
}

#admenu a{
	color: white;
	width: 100%;
	font-size: 18px;
	text-decoration: none;
	
}

#admenu li {
	padding-left: 55px;
	position: relative;
	
}

/* ---------------------------- */

#admenu li:hover a{color: black;}

/* Footer */

#ft-test {
	float: left;
}

#ft-test1 {
	float: right;
}

#ft-test a img {
	width:200px;
	height: 60px;
}

/* ---------------- */

/* 관리자 정보 */
#test{
	width: 250px;
	background: #356285;
	list-style: none;
	text-align: center;
	margin-top: 10px;
}

.test2 {
	margin-top: 10px;
}

.img-test{
	border-radius: 100px;
	width: 120px;
	height: 120px;
	margin-top: 10px;
}

.admin {
	color: white;
	font-size: 15px;
}

.btn-group {
	padding-left: 140px;
	position: relative;
}

/* ---------------------- */

</style>

</head>

<body>
	<div id="front-wrap">
		<div id="header">
			<ul class="nav-container">
				<li id="nav-logo"><a href="/admin/view"><img src="/adlogo2.png" width="200px;"></a></li>
			</ul>
		</div>
		
