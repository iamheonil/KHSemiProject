<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="<c:url value='/resources/js/fullcalendar/fullcalendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/fullcalendar/daygrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/fullcalendar/interaction.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/fullcalendar/timegrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/fullcalendar/httpRequest.js'/>"></script>
<%-- <script type="text/javascript" src="<c:url value='/resources/js/fullcalendar/settings.js'/>"></script> --%>

<link rel="stylesheet" type="text/css" href="${ctx }/resources/css/fullcalendar/daygrid.css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/css/fullcalendar/fullcalendar.css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/css/fullcalendar/timegrid.css">

<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/layout/header_doc.jsp" />

<%-- import aside.jsp --%>
<c:import url="/WEB-INF/views/layout/aside_plan.jsp" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker3.min.css">

    <script type='text/javascript' src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>

<script type='text/javascript'>
	/* $(document).ready(function() {

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
	}); */

	document.addEventListener('DOMContentLoaded', function() {
		
		var calendarEl = document.getElementById('calendar');
		
		var calendar = new FullCalendar.Calendar(calendarEl, {
			
			plugins : [ 'interaction', 'dayGrid' ],
			// defaultDate : '2019-06-12', 기본 날짜 설정을 삭제, 오늘 날짜로 기본 설정
			editable : true,
			eventLimit : true, // allow "more" link when too many events
			locale : 'ko',
			displayEventTime: false,
			events : [ 
				<c:forEach items="${allPlan }" var="plan">
				{
				title : '${plan.plan_name }',
				start : '${plan.ptime_start }',
				end : '${plan.ptime_end }'
				}, 
			</c:forEach>
			{
				title : '',
				// url : 'http://google.com/',
				start : '',
				end : ''
			} ], 
		});

		calendar.render();

	});
	
	$(document).ready(function() {
		$('#calendar').FullCalendar.Calendar({
	    	disableDragging: true
		});		
	});
</script>


<div id="contents">

	<div id="calendar"></div>

<br>

</div>

<%-- import footer --%>
<c:import url="/WEB-INF/views/layout/footer.jsp" />