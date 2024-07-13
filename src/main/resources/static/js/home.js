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

    // Initialize the Slick carousel
    $('.cards').slick({
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

    // Search button click handler
    $('#search').click(function(e) {
        e.preventDefault();
        const location = $('#city').val();
        const checkin = $('#checkin').val();
        const checkout = $('#checkout').val();
        const guests = $('#guests').val();

        // Show the slider and adjust panorama-container height
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
    });

    // Next and Previous buttons for slick carousel
    $('.next-btn').click(function() {
        $('.cards').slick('slickNext');
    });

    $('.prev-btn').click(function() {
        $('.cards').slick('slickPrev');
    });
});
