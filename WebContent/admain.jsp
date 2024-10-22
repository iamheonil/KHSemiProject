<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/adlayout/adheader.jsp" />

				
<%-- import aside --%>
<c:import url="/WEB-INF/views/adlayout/adaside.jsp" />				



<script type="text/javascript">
	
/* 주소록 */
$(document).ready(function(){
	$('#adminaddress').click(function(){
		$('#contents').load('/admin/address/list');
	})
})

/* 주소록 리스트 */
$(document).ready(function(){
	$(document).on("click", '.pagination a', function(){
		$('#contents').load($(this).attr("href"));
		return false;
	})
})

/* 사원관리 */
$(document).ready(function(){
	$('#deptlist').click(function(){
		$('#contents').load('/admin/userbasic/view');
	})
})
/* 삭제관리 */
$(document).ready(function(){
	$('#userdelete').click(function(){
		$('#contents').load('/admin/userdetail/delete');
	})
})

/* 커뮤니티 */
$(document).ready(function(){
	$('#board').click(function(){
		$('#contents').load('/admin/board/list');
	})
})

/* 커뮤니티 리스트 */
// $(document).ready(function(){
// 	$(document).on("click", '.btn btn-primary pull-right', function(){
// 		$('#contents').load($(this).attr("href"));
// 		return false;
// 	})
// })


// /* 조직도 */
// $(document).ready(function(){
// 	$('#').click(function(){
// 		$('#contents').load('');
// 	})
// })

/* 전자문서 */
$(document).ready(function(){
	$('#document').click(function(){
		$('#contents').load('/admin/document/list');
	})
})

/* 휴가관리 */
$(document).ready(function(){
	$('#dayoff').click(function(){
		$('#contents').load('/admin/dayoff/list');
	})
})
</script>

<style type="text/css">

#main {
	display: inline-block;
	width: 460px;
	height: 200px;
	list-style: none;
	margin: 270px auto;
	padding-top: 50px;
	background: #99BAFF;
}

#main h3 {
	color: #0A2D5D;
	font-weight: bold;
}

#main p {
	color: #fff;
	padding: 10px;
}
</style>




		
<div id="contents">
	<div id="container">
		<div id="main">
			<h3>관리자님, 어서오세요.</h3>
			<p>관리자 페이지에 오신 것을 환영합니다.</p>		
		</div>
	</div>
</div>
	
	
<%-- import footer --%>
<c:import url="/WEB-INF/views/adlayout/adfooter.jsp" />
