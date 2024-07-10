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

    // Show navbar and search bar after delay
    const navbar = $('.navbar');
    const searchBar = $('.search-bar');
    setTimeout(() => {
        navbar.css('opacity', 1);
        searchBar.css('opacity', 1);
        searchBar.addClass('show');
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
        $('.form-popup').css('display', 'block');
        $('.form-box.login').css('display', 'block');
        $('.form-box.signup').css('display', 'none');
        $('.blur-bg-overlay').css('display', 'block');
    }

    // Function to show signup form
    function showSignupForm() {
        $('.form-popup').css('display', 'block');
        $('.form-box.signup').css('display', 'block');
        $('.form-box.login').css('display', 'none');
        $('.blur-bg-overlay').css('display', 'block');
    }

    // Function to hide forms and overlay
    function hideForms() {
        $('.form-popup').css('display', 'none');
        $('.blur-bg-overlay').css('display', 'none');
    }

    // Event listeners for showing forms
    $('#login-btn').click(function(e) {
        e.preventDefault();
        showLoginForm();
    });

    $('#register-btn').click(function(e) {
        e.preventDefault();
        showSignupForm();
    });

    $('#signup-link').click(function(e) {
        e.preventDefault();
        showSignupForm();
    });

    $('#login-link').click(function(e) {
        e.preventDefault();
        showLoginForm();
    });

    $('.close-btn').click(function(e) {
        e.preventDefault();
        hideForms();
    });

    $('.blur-bg-overlay').click(hideForms);

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
