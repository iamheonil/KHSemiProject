<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript">
	
	window.onload = function(){
		
		/* 주소록 */
		$(document).ready(function(){
			$('#adminaddress').click(function(){
				$('#contents').load('/admin/address');
			})
		})
		
		/* 사원관리 */
		$(document).ready(function(){
			$('#deptlist').click(function(){
				$('#contents').load('/dept/list');
			})
		})
		
		/* 조직도 */
		$(document).ready(function(){
			$('#').click(function(){
				$('#contents').load('');
			})
		})
		
		/* 전자문서 */
		$(document).ready(function(){
			$('#document').click(function(){
				$('#contents').load('/document/list/delete');
			})
		})
		
		/* 휴가관리 */
		$(document).ready(function(){
			$('#dayoff').click(function(){
				$('#contents').load('/admin/dayoff/list');
			})
		})
	}
</script>

<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/adlayout/adheader.jsp" />

				
<%-- import aside --%>
<c:import url="/WEB-INF/views/adlayout/adaside.jsp" />				


		
		<div id="contents">

			<h3>Content 영역</h3>

		</div>
	
	
<%-- import footer --%>
<c:import url="/WEB-INF/views/adlayout/adfooter.jsp" />
