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
	              
					var mypop = $("#mypopup"); 					
					$("#search").click(function() {
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
					  
	                  $.ajax({
	                      url: "/ajax",
	                      type: "POST",
	                      contentType: "application/json",
	                      data:JSON.stringify(requestData),
						  dataType: "json",
						  beforeSend: function(xhr) {
						         xhr.setRequestHeader(csrfHeader, csrfToken);
						                      },
	                      success: function(response) {
							
								
							console.log(">>>>>"+response)
						    
	                          console.log(response[0]);
							  console.log(response.length);
							  populateModal(response);
	                      },
	                      error: function(xhr, status, error) {
	                       console.log(status +"An error occurred: " + error);
	                      }
	                  });
	              });
				  
				  // Function to populate modal with apartments data
				     function populateModal(apartments) {
				         var modalContent = $('#modal-content');
				         modalContent.empty();  // Clear existing content

				         apartments.forEach(function(apartment) {
				             var cardHtml = `
				                 <div class="modal-content">
				                     <span class="close-btn" id="close-modal">&times;</span>
				                     <img src="img_avatar.png" alt="Avatar">
				                     <div>
				                         <h4><b>${apartment[1]}</b></h4>
				                         <p>${apartment[1]}</p>
				                         <p>${apartment[2]}</p>
				                     </div>
				                     <a href="/apartment/${apartment[0]}/show">View Details</a>
				                 </div>
				             `;
				             modalContent.append(cardHtml);  // Append each card to modal
				         });
				     }

				     // Event listener to open modal and fetch data
				     $('#open-modal').on('click', function() {
				         fetchApartments();
				         $('#myModal').css('display', 'block');  // Show modal
				     });

				     // Close modal event handler
				     $('#close-modal').on('click', function() {
				         $('#myModal').css('display', 'none');  // Hide modal
				     });
				  
	          });
	  