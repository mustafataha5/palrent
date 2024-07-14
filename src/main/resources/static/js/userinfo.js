function toggleMenu() {
    document.getElementById('user-menu').classList.toggle('show');
}

document.querySelector('.user-icon-container').addEventListener('click', function () {
    document.getElementById('user-menu').classList.toggle('show');
});
$(document).ready(function() {
    $('.content__title, .content__details p').css('opacity', '1');
});