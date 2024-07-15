$(document).ready(function() {
    // Initialize Pannellum viewer
    if ($('#panorama').length) {
        pannellum.viewer('panorama', {
            type: 'equirectangular',
            panorama: 'img/shot-panoramic-composition-living-room.jpg',
            autoLoad: true,
            showZoomCtrl: false,
            compass: false,
            autoRotate: -2,
        });
    }

    // Toggle navigation links visibility on hamburger menu click
    $('.hamburger-menu').click(function() {
        $('.nav-links').toggleClass('show');
    });

    // Toggle burger-menu visibility on user-icon-container click
    $('.user-icon-wrapper').click(function(event) {
        event.stopPropagation();
        $('.burger-menu').toggleClass('show');
    });

    // Hide burger-menu if clicking outside
    $(document).click(function(event) {
        if (!$(event.target).closest('.user-icon-container').length) {
            $('.burger-menu').removeClass('show');
        }
    });

    // Redirect to login page
    $('#login-btn').click(function(e) {
        e.preventDefault();
        window.location.href = "/login";
    });

    // Redirect to register page
    $('#register-btn').click(function(e) {
        e.preventDefault();
        window.location.href = "/register";
    });
});
