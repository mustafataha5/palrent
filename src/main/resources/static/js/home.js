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
$('#search1').click(function() {
        // Reset card visibility
        $('.card').hide();
        $('.cards').fadeIn(2000); // Fade in the .cards container
        
        // Fade in each card one by one with a delay
        $('.card').each(function(index) {
            $(this).delay(100 * index).fadeIn(300); // Fade in each card with a delay
        });
    });
    // Previous and Next buttons for card navigation
    let currentCardIndex = 0;
    const cards = $('.card');
    const numCards = cards.length;

    $('.prev-btn').click(function() {
        if (currentCardIndex > 0) {
            currentCardIndex--;
            cards.hide().eq(currentCardIndex).show();
        }
    });

    $('.next-btn').click(function() {
        if (currentCardIndex < numCards - 1) {
            currentCardIndex++;
            cards.hide().eq(currentCardIndex).show();
        }
    });
});
