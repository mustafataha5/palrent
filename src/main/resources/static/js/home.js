$(document).ready(function () {
    pannellum.viewer('panorama', {
        "type": "equirectangular",
        "panorama": "img/shot-panoramic-composition-living-room.jpg",
        "autoLoad": true,
        "showControls": false,
    });

    $('.navbar').animate({ opacity: 1 }, 2000);

    $('.search-bar').animate({ opacity: 1 }, 1000, function() {
        $(this).addClass('show');
    });

    $('#search-btn').click(function () {
        var checkin = $('#checkin').val();
        var checkout = $('#checkout').val();
        var guests = $('#guests').val();
        var location = $('#location').val();

        alert('Searching for apartments in ' + location + ' from ' + checkin + ' to ' + checkout + ' for ' + guests + ' guests.');
    });

    $('.user-icon-container').click(function (e) {
        e.stopPropagation();
        $(this).find('.burger-menu').toggle();
    });

    $(document).click(function () {
        $('.burger-menu').hide();
    });
    setTimeout(function () {
        $('.navbar').css('opacity', '1');
        $('.search-bar').addClass('show');
    }, 500);

    $('.user-icon').click(function () {
        $('.burger-menu').toggle();
    });

    $(window).resize(function () {
        if ($(window).width() > 480) {
            $('.nav-links').css('display', 'flex');
        } else {
            $('.nav-links').css('display', 'none');
        }
    });
});
