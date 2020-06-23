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
	height: 200px;
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
	padding-bottom: 211px;
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


/* 팝업 CSS 시작 */
/* 이용약관 css 시작 */
/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 111; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 15% auto; /* 15% from the top and centered */
    padding: 20px;
    border: 1px solid #888;
    width: 50%; /* Could be more or less, depending on screen size */                          
}
/* The Close Button */
.close {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}
.close:hover,
.close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
}
/* 이용약관 CSS 끝 */

/* 개인정보처리방침 CSS 시작 */
/* The Modal (background) */
.modal2 {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 111; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
   	overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content2 {
    background-color: #fefefe;
    margin: 15% auto; /* 15% from the top and centered */
    padding: 20px;
    border: 1px solid #888;
    width: 50%; /* Could be more or less, depending on screen size */                          
}
/* The Close Button */
.close2 {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}
.close2:hover,
.close2:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
}
/* 개인정보처리방침 CSS 끝 */


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

	<%-- 이용약관 팝업 --%>
	<!-- The Modal -->
	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
			<span class="close">&times;</span>
			<h2><strong>이용약관</strong></h2><br><br>
			<p>이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관</p>
		</div>

	</div>


	<%-- 개인정보처리방침 팝업 --%>
	<div id="myModal2" class="modal2">

		<!-- Modal content -->
		<div class="modal-content2">
			<span class="close2">&times;</span>
			<h2><strong>개인정보처리방침</strong></h2><br><br>
			<div>
				<c:import url="/resources/policy/Personal_Information_Processing_Policy.jsp"></c:import>
			</div>
		</div>

	</div>



	<div id="header">
		<div class="companyLogo"><a href="/user/login"><img src="/resources/img/logo1.png" style="width: 300px;"></a></div>
	</div>