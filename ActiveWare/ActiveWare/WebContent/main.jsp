<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/layout/header.jsp" />

<div id="s_left">

	<ul>
		<ul id="personal">
			<li id="photo" style="border-radius: 100px; padding-top: 5px;"><br>사진</li>
			<li>소속팀 인사1팀 사원 홍길동</li>
			<li>사원번호 1571000367</li>
			<li><button>마이페이지</button> &nbsp;
				<button>로그아웃</button></li>
		</ul>
		<li class="li-white"><a href="#">첫번째 메뉴</a></li>
		<li class="li-white"><a href="#">두번째 메뉴</a></li>
		<li class="li-white"><a href="#">세번째 메뉴</a></li>
		<li class="li-white"><a href="#">네번째 메뉴</a></li>
		<li class="li-white"><a href="#">다섯번째 메뉴</a></li>
	</ul>
</div>

<div id="contents">

	<h3>Content 영역</h3>

</div>


<%-- import footer --%>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
