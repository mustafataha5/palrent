/**
 * 
 */

$(document).ready(function (){

$("#checkin").click(function() {
	
	
		var dtToday = new Date();

		var month = dtToday.getMonth() + 1;
		var day = dtToday.getDate();
		var year = dtToday.getFullYear();
		if (month < 10)
			month = '0' + month.toString();
		if (day < 10)
			day = '0' + day.toString();

		var maxDate = year + '-' + month + '-' + day;
		$('#checkin').attr('min', maxDate);
	});
	

	$("#checkout").click(function() {
		let dtToday
		if($("#checkin").val() != ""){
			 dtToday = new Date($("#checkin").val());//new Date();}
		}
		else{
			dtToday = new Date();
		}
		var month = dtToday.getMonth() + 1;

		var day = dtToday.getDate();
		if (day == 31 && (month == 1 || month == 3 ||
			month == 5 || month == 7
			|| month == 8 || month == 10 || month == 12)) {
			day = 1;
			month = month + 1
		}
		else if (day == 30 && (month == 4  || month == 6 ||
			month == 9 || month == 11)) {
			day = 1;
			month = month + 1
		}
		else {
			
			day = day +1 ;
		}
		var year = dtToday.getFullYear();
		if (month < 10)
			month = '0' + month.toString();
		if (day < 10)
			day = '0' + day.toString();

		var maxDate = year + '-' + month + '-' + day;
		$('#checkout').attr('min', maxDate);
		$('#checkout').val(maxDate);
	});

});