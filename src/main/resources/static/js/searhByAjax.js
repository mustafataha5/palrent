/*$(document).ready(function() {
		  $("#search").click(function() {
			  $.ajax({
				  url: "/ajax",
				  type: "GET",
				  success: function(response) {
					console.log(response);  
					//$("#response").text(response);
				  },
				  error: function(xhr, status, error) {
					  $("#response").text("An error occurred: " + error);
				  }
			  });
		  });
	  });*/
$(document).ready(function() {
	var csrfToken = $("meta[name='_csrf']").attr("content");
	var csrfHeader = $("meta[name='_csrf_header']").attr("content");
    $("#error_q").hide();
	$("#search1").click(function() {
		var city = $("#city").val();
		var checkin = $("#checkin").val();
		var checkout = $("#checkout").val();
		var guests = $("#guests").val();
		var requestData = {
			city: city,
			checkin: checkin,
			checkout: checkout,
			guests: guests
		};

		
		let flag = false ; 
		$("#error_q").hide();
		$("#error_q").text("")
		if (city === "" ) {
			$("#error_q").show()
			$('.panorama-container').css('height', '100vh');
			$('#slider').fadeOut();
			$("#error_q").append("Please enter select location <br>");
			flag =true ; 
		}
		if (checkin=="") {
			$("#error_q").show()
			$('.panorama-container').css('height', '100vh');
			$('#slider').fadeOut();
			$("#error_q").append("Please enter select check-in date<br>")
			flag =true ; 
		}
		if (checkout == "") {
			$("#error_q").show()
			$('.panorama-container').css('height', '100vh');
			$('#slider').fadeOut();
			$("#error_q").append("Please enter select check-in date<br>")
			flag =true ; 
		}
		if ( guests === "") {
			$("#error_q").show()
			$('.panorama-container').css('height', '100vh');
			$('#slider').fadeOut();
			$("#error_q").append("Please enter guest number")
			flag =true ; 
		}
		
		if(flag){
			return ; 
		}
		$.ajax({
			url: "/ajax",
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(requestData),
			dataType: "json",
			beforeSend: function(xhr) {
				xhr.setRequestHeader(csrfHeader, csrfToken);
			},
			success: function(response) {
				/*console.log(">>>>>"+response);
				console.log(response[0]);
				console.log(response.length);*/
				if (response.length == 0) {
					$('.panorama-container').css('height', '100vh');
					$('#slider').fadeOut();
					$("#error_q").text("There is no apartment with your input")
					return
				}
				$("#error_q").text("")


				populateModal(response);

				$('.panorama-container').css('height', '50vh');
				$('#slider').show();

				// Initialize or reinitialize slick carousel
				$('.cards').slick('unslick').slick({
					infinite: true,
					slidesToShow: 3,
					slidesToScroll: 1,
					dots: true,
					autoplay: true,
					autoplaySpeed: 3000,
					responsive: [
						{
							breakpoint: 1024,
							settings: {
								slidesToShow: 2,
								slidesToScroll: 1,
								infinite: true,
								dots: true
							}
						},
						{
							breakpoint: 600,
							settings: {
								slidesToShow: 1,
								slidesToScroll: 1
							}
						}
					]
				});
			},
			error: function(xhr, status, error) {
				console.log(status + " An error occurred: " + error);
			}
		});
	});

	// Function to populate modal with apartments data
	function populateModal(apartments) {
		var modalContent = $('#slider');
		modalContent.empty();  // Clear existing content

		apartments.forEach(function(apartment) {
			var cardHtml = `
	                  <div class="card">
	                      <img src="${apartment.images[0].url}" alt="Apartment Image">
	                      <div class="card-body">
	                          <h4>${apartment.title}</h4>
	                          <p>${apartment.city}, ${apartment.street}, ${apartment.buildingNum}</p>
	                          <a href="/apartment/${apartment.id}/show" class="btn btn-primary">View Details</a>
	                      </div>
	                  </div>
	              `;
			modalContent.append(cardHtml);  // Append each card to modal
		});
	}




});







