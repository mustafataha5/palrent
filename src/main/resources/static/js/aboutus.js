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
// Function to start the count-up animation
function startCountAnimation(targetElement, targetValue, duration) {
    let current = 0;
    const increment = targetValue / (duration / 10); // Incrementing value every 10ms for smooth animation
    const element = document.getElementById(targetElement);
    
    const interval = setInterval(function() {
        current += increment;
        if (current >= targetValue) {
            clearInterval(interval);
            current = targetValue;
        }
        
        // Update the content of the element with current value
        element.innerHTML = `<i class="fas fa-${getIconClass(targetElement)}"></i> ${Math.round(current)} <br> ${getLabel(targetElement)}`;
    }, 10);
}

// Function to get the label based on targetElement ID
function getLabel(targetElement) {
    switch(targetElement) {
        case 'count1': return 'Users';
        case 'count2': return 'Rental';
        case 'count3': return 'Views';
        case 'count4': return 'Apartments';
        default: return '';
    }
}

// Function to get the Font Awesome icon class based on targetElement ID
function getIconClass(targetElement) {
    switch(targetElement) {
        case 'count1': return 'users';
        case 'count2': return 'percentage';
        case 'count3': return 'eye';
        case 'count4': return 'building';
        default: return '';
    }
}

// Start the count-up animations when the page is loaded
document.addEventListener('DOMContentLoaded', function() {
    startCountAnimation('count1', 300, 2000); // 300 users in 2000ms
    startCountAnimation('count2', 90, 2000); // 90% rental in 2000ms
    startCountAnimation('count3', 1200, 2000); // 1200 views in 2000ms
    startCountAnimation('count4', 3600, 2000); // 3600 apartments in 2000ms
});
