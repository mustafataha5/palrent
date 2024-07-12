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
    
    
// Function to toggle hamburger menu visibility
function toggleMenu() {
    $('.nav-links').toggleClass('show');
}
