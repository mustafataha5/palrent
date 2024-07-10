document.addEventListener('DOMContentLoaded', function () {
    pannellum.viewer('panorama', {
        type: 'equirectangular',
        panorama: 'img/shot-panoramic-composition-living-room.jpg',
        autoLoad: true,
        showZoomCtrl: false,
        compass: false,
        autoRotate: -2,
    });

    const navbar = document.querySelector('.navbar');
    const searchBar = document.querySelector('.search-bar');

    setTimeout(() => {
        navbar.style.opacity = 1;
        searchBar.style.opacity = 1;
        searchBar.classList.add('show');
    }, 1000);

    document.querySelector('.hamburger-menu').addEventListener('click', function () {
        const navLinks = document.querySelector('.nav-links');
        navLinks.classList.toggle('show');
    });

    document.querySelector('.user-icon-container').addEventListener('click', function () {
        const burgerMenu = document.querySelector('.burger-menu');
        burgerMenu.classList.toggle('show');
    });


    function showLoginForm() {
        document.querySelector('.form-popup').style.display = 'block';
        document.querySelector('.form-box.login').style.display = 'block';
        document.querySelector('.form-box.signup').style.display = 'none';
        document.querySelector('.blur-bg-overlay').style.display = 'block';
    }


    function showSignupForm() {
        document.querySelector('.form-popup').style.display = 'block';
        document.querySelector('.form-box.signup').style.display = 'block';
        document.querySelector('.form-box.login').style.display = 'none';
        document.querySelector('.blur-bg-overlay').style.display = 'block';
    }


    function hideForms() {
        document.querySelector('.form-popup').style.display = 'none';
        document.querySelector('.blur-bg-overlay').style.display = 'none';
    }

 
    document.getElementById('login-btn').addEventListener('click', (e) => {
        e.preventDefault();
        showLoginForm();
    });

    document.getElementById('register-btn').addEventListener('click', (e) => {
        e.preventDefault();
        showSignupForm();
    });

  
    document.getElementById('signup-link').addEventListener('click', (e) => {
        e.preventDefault();
        showSignupForm();
    });

    document.getElementById('login-link').addEventListener('click', (e) => {
        e.preventDefault();
        showLoginForm();
    });

    
    document.querySelectorAll('.close-btn').forEach(btn => {
        btn.addEventListener('click', (e) => {
            e.preventDefault();
            hideForms();
        });
    });


    document.querySelector('.blur-bg-overlay').addEventListener('click', hideForms);


    document.getElementById('search-btn').addEventListener('click', () => {
        const location = document.getElementById('location').value;
        const checkin = document.getElementById('checkin').value;
        const checkout = document.getElementById('checkout').value;
        const guests = document.getElementById('guests').value;

        if (location && checkin && checkout && guests) {
            console.log(`Searching for apartments in ${location} from ${checkin} to ${checkout} for ${guests} guests.`);
          
            window.location.href = `/search?location=${location}&checkin=${checkin}&checkout=${checkout}&guests=${guests}`;
        } else {
            alert('Please fill in all search fields.');
        }
    });
});
