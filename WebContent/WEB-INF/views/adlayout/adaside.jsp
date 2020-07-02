<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="s_left">

		<ul>
				
			<ul id="test">
					
				<li>
						<div class="test2">
						
							<span class="test_img">
							
								<img class="img-test" src="/admin.png"><br>
							
							</span>
							
							<span class="admin">${adminid }</span><br>
							<span class="admin">${adminid } 님 안녕하세요.</span><br>
							<div class="btn-group">
								<button class="btn btn-primary btn-xs" style="color: black;" onclick='location.href="/admin/login";'>로그아웃</button>
							</div>
						</div>
				</li>
			
			</ul>
			
				<nav id ="admenu">
					<li class="ad-li"><a href="#" id="adminaddress"><span class="glyphicon glyphicon-earphone"></span>&nbsp;&nbsp;주소록</a></li>
					
					<li class="ad-li"><a href="#" id="deptlist"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;사원관리</a></li>
					
					<li class="ad-li"><a href="#" id="userdelete"><span class="glyphicon glyphicon-trash"></span>&nbsp;&nbsp;사원삭제</a></li>
				
					<li class="ad-li"><a href="#" id="board"><span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;&nbsp;커뮤니티</a></li>
					
<!-- 					<li class="ad-li"><a href="#" id=""><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;조직도</a></li> -->
				
					<li class="ad-li"><a href="#" id="document"><span class="glyphicon glyphicon-book"></span>&nbsp;&nbsp;전자문서</a></li>
				
					<li class="ad-li"><a href="#" id="dayoff"><span class="glyphicon glyphicon-time"></span>&nbsp;&nbsp;휴가관리</a></li>
				</nav>
			</ul>
		</div>