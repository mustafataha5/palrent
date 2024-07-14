$(document).ready(function() {
    // Initialize Pannellum viewer
    pannellum.viewer('panorama', {
        type: 'equirectangular',
        panorama: 'img/shot-panoramic.jpg',
        autoLoad: true,
        showZoomCtrl: false,
        compass: false,
        autoRotate: -2
    });

    // Select navbar and search bar elements
    const navbar = $('.navbar');
    const searchBar = $('.search-bar');

    // Hide navbar and search bar initially
    navbar.css('opacity', 0);
    searchBar.css('opacity', 0);

    // Fade in navbar and search bar after 1 second
    setTimeout(function() {
        navbar.animate({ opacity: 1 }, 500);
        searchBar.animate({ opacity: 1 }, 500);
    }, 1000);

    // Toggle nav-links visibility on hamburger-menu click
    $('.hamburger-menu').click(function() {
        $('.nav-links').toggleClass('show');
    });

    // Toggle burger-menu visibility on user-icon-wrapper click
    $('.user-icon-wrapper').click(function(event) {
        event.stopPropagation(); // Prevent the event from bubbling up to document
        $('.burger-menu').toggleClass('show');
    });

    // Hide burger-menu if clicking outside
    $(document).click(function(event) {
        if (!$(event.target).closest('.user-icon-wrapper').length) {
            $('.burger-menu').removeClass('show');
        }
    });

    // Redirect to login page
    $('#login-btn').click(function(e) {
        e.preventDefault(); // Prevent default form submission behavior
        window.location.href = "/login";
    });

    // Redirect to register page
    $('#register-btn').click(function(e) {
        e.preventDefault(); // Prevent default form submission behavior
        window.location.href = "/register";
    });
});
