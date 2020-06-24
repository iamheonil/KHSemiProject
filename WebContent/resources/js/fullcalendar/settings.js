
document.addEventListener('DOMContentLoaded', function() {
	
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		plugins : [ 'interaction', 'dayGrid', 'timeGrid' ],
		defaultView : 'dayGridMonth',
		defaultDate : new Date(),
		header : {
			left : 'interaction',
			center : 'title',
			right : 'prev, next today'
		},
		locale: 'ko',
		dateClick: function() {
			calendar.on('dateClick', function(info) {
				  console.log('clicked on ' + info.dateStr);
				});
		  }
	});
	calendar.render();
});