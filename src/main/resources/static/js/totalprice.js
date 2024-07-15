/**
 * 
 */


$(document).ready(function() {
	let numofday = $("#numofday");
	let price = $("#Price").text();
	let total = $("#total");
	if($("#checkout").val != ""){
		compute();
	}
	
	$("#checkout").change( function() {
		compute();
	});
	
	function compute(){
		let start;
				let end;
				start = $("#checkin").val();
				end = $("#checkout").val();
				if(end != "" && start != ""){
					var date1, date2;  
					         //define two date object variables with dates inside it  
					         date1 = new Date(start);  
					         date2 = new Date(end);  
					  
					         //calculate time difference  
					         var time_difference = date2.getTime() - date1.getTime();  
					  
					         //calculate days difference by dividing total milliseconds in a day  
					         var days_difference = time_difference / (1000 * 60 * 60 * 24); 
							 $("#numofday").text("Number Of Booking Day:"+days_difference);
							 $("#total").text("Total Price : $"+ days_difference*parseFloat(price));
							  
				}
				else{
					$("#numofday").text("");
					$("#total").text("");
				}
	}

});