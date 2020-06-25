<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CDN -->


<style type="text/css">
@import url(//cdn.jsdelivr.net/font-nanum/1.0/nanumbarungothic/nanumbarungothic.css);

/* 나눔바른고딕 : 한국서버 빠름*/

* {
    margin: 0px;
    padding: 0px;
    font-family: nanumbarungothic;
}
#header {
	margin: 0 auto;
	width: 100%;
	height: 270px;
	background: #0f4c81;
}

.companyLogo {
	width: 100%;
	color: white;
	text-align: center;
	padding-top: 100px;
	font-size: 50px;
	background: #0f4c81;
	
}

.companyLogo > a {
	text-decoration: none;
	color: white;
}

#footer-wrap {
	width: 100%;
	background: #0f4c81;
	padding-bottom: 217px;
}

#footer {
	width: 700px;
	margin: 0 auto;
	padding-top: 10px;
	background: #0f4c81;
}

#footer a {
	
	text-decoration: none;
	color: white;
}

.foot-content {
	text-decoration: none;
	color: white;
	margin-bottom: 5px;
}

#footer a:hover {
	text-decoration: underline;
}

.title {
	color: white;
    width: 200;
    margin: 0 auto;
    font-size: 25px;
    font-weight: bold;
    text-align: center;
    margin-top: 10px;
}
</style>
<script type="text/javascript">
window.onload = function() {
	
	// 이용약관에 대한 JS
	//Get the modal
	var modal = document.getElementById('myModal');

	// Get the button that opens the modal
	var btn = document.getElementById("myBtn");

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];                                          

	// When the user clicks on the button, open the modal 
	btn.onclick = function() {
	    modal.style.display = "block";
	}

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
	    modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	    }
	}
	
	// 개인정보처리방침에 대한 JS
	//Get the modal
	var modal2 = document.getElementById('myModal2');

	// Get the button that opens the modal
	var btn2 = document.getElementById("myBtn2");

	// Get the <span> element that closes the modal
	var span2 = document.getElementsByClassName("close2")[0];                                          

	// When the user clicks on the button, open the modal 
	btn2.onclick = function() {
	    modal2.style.display = "block";
	}

	// When the user clicks on <span> (x), close the modal
	span2.onclick = function() {
	    modal2.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == modal2) {
	        modal2.style.display = "none";
	    }
	}
	
}

</script>
</head>
<body>



	<div id="header">
		<div class="companyLogo"><a href="/admin/login"><img src="/resources/img/logo1.png" style="width: 300px;"></a></div>
		<div class="title">[ 관리자 ]</div>
	</div>