$(document).ready(function() {
        pannellum.viewer('panorama', {
            type: 'equirectangular',
            panorama: 'img/shot-panoramic-composition-bedroom-2.jpg',
            autoLoad: true,
            showZoomCtrl: false,
            compass: false,
            autoRotate: -2,
        });
    });

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
    $(document).ready(function() {
    // Initial hidden state
    $('.overlay-text').hide();
    $('.contact-form-container').hide();

    // Animation for overlay-text
    $('.overlay-text').slideDown(800, function() {
        $(this).fadeIn(400);
    });

    // Animation for contact-form-container
    $('.contact-form-container').delay(400).slideDown(800, function() {
        $(this).fadeIn(400);
    });

    // Hover effect for overlay-text
    $('.overlay-text').hover(function() {
        $(this).animate({
            fontSize: '3rem'
        }, 200);
    }, function() {
        $(this).animate({
            fontSize: '2.5rem'
        }, 200);
    });

    // Hover effect for contact-form-container
    $('.contact-form-container').hover(function() {
        $(this).css('background-color', '#333');
    }, function() {
        $(this).css('background-color', 'rgba(0, 0, 0, 0.7)');
    });
});