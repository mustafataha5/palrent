$(document).ready(function() {
    // Initialize Pannellum viewer
    pannellum.viewer('panorama', {
        type: 'equirectangular',
        panorama: 'img/shot-panoramic-composition-living-room.jpg',
        autoLoad: true,
        showZoomCtrl: false,
        compass: false,
        autoRotate: -2,
    });

    // Set placeholders for check-in and check-out inputs
    $('#checkin').attr('placeholder', 'Check-in');
    $('#checkout').attr('placeholder', 'Check-out');

    // Fade-in animation for navbar and search bar after delay
    const navbar = $('.navbar');
    const searchBar = $('.search-bar');
    navbar.css('opacity', 0);
    searchBar.css('opacity', 0);
    setTimeout(() => {
        navbar.animate({ opacity: 1 }, 500);
        searchBar.animate({ opacity: 1 }, 500).addClass('show');
    }, 1000);

    // Toggle nav-links visibility on hamburger-menu click
    $('.hamburger-menu').click(function() {
        $('.nav-links').toggleClass('show');
    });

    // Toggle burger-menu visibility on user-icon-container click
    $('.user-icon-container').click(function() {
        $('.burger-menu').toggleClass('show');
    });

    // Function to show login form
    function showLoginForm() {
        $('.form-popup').fadeIn();
        $('.form-box.login').fadeIn();
        $('.form-box.signup').hide();
        $('.blur-bg-overlay').show();
    }

    // Function to show signup form
    function showSignupForm() {
        $('.form-popup').fadeIn();
        $('.form-box.signup').fadeIn();
        $('.form-box.login').hide();
        $('.blur-bg-overlay').show();
    }

    // Function to hide forms and overlay
    function hideForms() {
        $('.form-popup').fadeOut();
        $('.blur-bg-overlay').fadeOut();
    }

    // Event listeners for showing forms
    $('#login-btn, #login-link').click(function(e) {
        e.preventDefault();
        showLoginForm();
    });

    $('#register-btn, #signup-link').click(function(e) {
        e.preventDefault();
        showSignupForm();
    });

    $('.close-btn, .blur-bg-overlay').click(function(e) {
        e.preventDefault();
        hideForms();
    });

    // Search button click handler
    $('#search-btn').click(function() {
        const location = $('#location').val();
        const checkin = $('#checkin').val();
        const checkout = $('#checkout').val();
        const guests = $('#guests').val();

        if (location && checkin && checkout && guests) {
            console.log(`Searching for apartments in ${location} from ${checkin} to ${checkout} for ${guests} guests.`);
            window.location.href = `/search?location=${location}&checkin=${checkin}&checkout=${checkout}&guests=${guests}`;
        } else {
            alert('Please fill in all search fields.');
        }
    });
});

// Function to toggle hamburger menu visibility
function toggleMenu() {
    $('.nav-links').toggleClass('show');
}
