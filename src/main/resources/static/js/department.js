// Script to handle user menu toggle
document.querySelector('.user-icon-wrapper').addEventListener('click', function() {
    document.querySelector('.burger-menu').classList.toggle('show');
});

// Script to handle image popup functionality
const modal = document.getElementById('image-popup');
const modalImg = document.getElementById('img01');
const closeBtn = document.querySelector('.close-btn');
const images = document.querySelectorAll('.apartment-img');
const prevBtn = document.getElementById('prevBtn');
const nextBtn = document.getElementById('nextBtn');

let currentIndex;

function showImage(index) {
    modal.style.display = 'block';
    modalImg.src = images[index].src;
    currentIndex = index;
}

images.forEach((img, index) => {
    img.addEventListener('click', function() {
        showImage(index);
    });
});

closeBtn.addEventListener('click', function() {
    modal.style.display = 'none';
});

modal.addEventListener('click', function(event) {
    if (event.target === modal) {
        modal.style.display = 'none';
    }
});

prevBtn.addEventListener('click', function() {
    currentIndex = (currentIndex > 0) ? currentIndex - 1 : images.length - 1;
    showImage(currentIndex);
});

nextBtn.addEventListener('click', function() {
    currentIndex = (currentIndex < images.length - 1) ? currentIndex + 1 : 0;
    showImage(currentIndex);
});

// jQuery document ready function
$(document).ready(function() {
    $('#reservationForm').submit(function(event) {
        event.preventDefault();
        // Perform form validation
        let checkInDate = $('#checkInDate').val();
        let checkOutDate = $('#checkOutDate').val();
        let numGuests = $('#numGuests').val();

        if (checkInDate && checkOutDate && numGuests) {
            // If validation passes, you can send data to server or show confirmation
            alert('Reservation confirmed!');
        } else {
            alert('Please fill all fields.');
        }
    });
});

// Google Maps API initialization
function initMap() {
    const map = new google.maps.Map(document.getElementById("map"), {
        center: { lat: 40.712776, lng: -74.005974 }, // Example coordinates (New York City)
        zoom: 12,
    });
    // Optionally, add markers or customize further
}

// Load Google Maps API script asynchronously
$(document).ready(function() {
    const script = document.createElement('script');
    script.src = `https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap`;
    script.defer = true;
    script.async = true;
    script.onerror = function() {
        alert("Failed to load Google Maps API!");
    };

    document.head.appendChild(script);
});
