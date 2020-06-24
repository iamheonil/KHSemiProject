<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
     request.getAttribute("allPlan");
%>  


<script type="text/javascript" src="<c:url value='/resources/js/fullcalendar/fullcalendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/fullcalendar/daygrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/fullcalendar/interaction.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/fullcalendar/timegrid.js'/>"></script>
<%-- <script type="text/javascript" src="<c:url value='/resources/js/fullcalendar/settings.js'/>"></script> --%>

<link rel="stylesheet" type="text/css" href="${ctx }/resources/css/fullcalendar/daygrid.css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/css/fullcalendar/fullcalendar.css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/css/fullcalendar/timegrid.css">

<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/layout/header.jsp" />

<%-- import aside.jsp --%>
<c:import url="/WEB-INF/views/layout/aside.jsp" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker3.min.css">

    <script type='text/javascript' src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>

<script type='text/javascript'>
	$(document).ready(function() {

		$("#ptime_start").datepicker({
			format: "yyyy/mm/dd",
			showOn: "button",
	        // buttonImage: "images/calendar.gif",
		    buttonImageOnly: false,
			buttonText: "Select date"
		});
		
		$("#ptime_end").datepicker({
			format: "yyyy/mm/dd",
			showOn: "button",
	        // buttonImage: "images/calendar.gif",
		    buttonImageOnly: false,
			buttonText: "Select date"
		});
		
		$("#date3").datepicker({
			onSelect:function(dateText, inst) {
				console.log(dateText);
				console.log(inst);
			}
		});
		
		console.log("달력 준비 완료");
	});
</script>

<c:forEach items="${allPlan }" var="plan">
		<tr>
			<td>${plan.plan_num }</td>
			<td>${plan.userid }</td>
			<td>${plan.plan_name }</td>
			<td><fmt:formatDate value="${plan.ptime_start }"
					pattern="yyyy-MM-dd" /></td>
			<td><fmt:formatDate value="${plan.ptime_end }"
					pattern="yyyy-MM-dd" /></td>
		</tr>
	</c:forEach>

<br>

<script type="text/javascript">

	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');
		
/* 		var eventName = ${plan.plan_name };
		var ptime_Start = ${plan.ptime_start };
		var ptime_End = ${plan.ptime_end }; */
		
		var eventName = '하잉';
		var ptime_Start = '2020-06-24';
		var ptime_End = '2020-06-30';

		var calendar = new FullCalendar.Calendar(calendarEl, {
			plugins : [ 'interaction', 'dayGrid' ],
			// defaultDate : '2019-06-12', 기본 날짜 설정을 삭제, 오늘 날짜로 기본 설정
			editable : true,
			eventLimit : true, // allow "more" link when too many events
			locale : 'ko',
			
			events : [ {
				title : '하위',
				start : '2020-06-24',
				end : '2020-06-26'
			}, {
				title : eventName,
				url : 'http://google.com/',
				start : ptime_Start,
				end : ptime_End
			} ]
		});
		
		calendar.render();
		// var testVal = ${allPlan };
	});
</script>


<div id="contents">

	<div id="calendar"></div>

	<form action="/plan/view" method="post">
		<table style="width:300px; margin: 0 auto; border-collapse: separate; border-spacing: 0px 30px;">
			<tr><td>일정명 : </td><td><input type="text" name="plan_name" id="plan_name" size="20" /></td></tr>
			<tr><td>일정 시작 날짜 : </td><td><input type="text" name="ptime_start" id="ptime_start" size="20" /></td></tr> 
			<tr><td>일정 종료 날짜 : </td><td><input type="text" name="ptime_end" id="ptime_end" size="20" /></td></tr>
		<!-- <input type="button" value="달력" onclick="$('#date3').datepicker('show');" /> -->
		</table>
		<br>
		<button class="btn btn-primary">일정 등록 하기</button>
	</form>

<br>

</div>

<%-- import footer --%>
<c:import url="/WEB-INF/views/layout/footer.jsp" />