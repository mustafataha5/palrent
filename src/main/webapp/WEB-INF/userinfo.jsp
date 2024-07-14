<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
<link rel="stylesheet" href="style.css">
    <title>Pal-Rent</title>
</head>
<body>
    <div class="navbar">
        <div class="logo">
            <img src="palrent-logo.png" alt="Logo">
        </div>
        <div class="hamburger-menu" onclick="toggleMenu()">
            <i class="fas fa-bars"></i>
        </div>
        <ul class="nav-links">
            <li><a href="#">About us</a></li>
            <li><a href="#">Contact us</a></li>
            <li><a href="#">User</a></li>
        </ul>
        <div class="user-icon-container">
            <img src="ibrahim.jpg" alt="Image not found" onerror="this.src='img/profile.png';" class="user-icon" />
            <div class="burger-menu">
                <a href="#" id="register-btn">Register</a>
                <a href="#" id="login-btn">Log In</a>
            </div>
        </div>
    </div>
    <!-- <div class="navbar">
        <div class="logo">
            <img src="img/palrent-logo.png" alt="Logo">
        </div>
        <div class="hamburger-menu" onclick="toggleMenu()">
            <i class="fas fa-bars"></i>
        </div>
        <ul class="nav-links">
            <li><a href="#">About us</a></li>
            <li><a href="#">Contact us</a></li>
            <li><a href="#">User</a></li>
        </ul>
        <div class="user-icon-container">
            <img src="user-image" alt="Image not found" onerror="this.src='img/profile.png';" class="user-icon" />
            <div class="burger-menu">
                <a href="#" id="register-btn">Register</a>
                <a href="#" id="login-btn">Log In</a>
            </div>
        </div>
    </div> -->
    <section id="home">
        <div class="home-left">
            <img src="palrent-logo.png" alt="">
        </div>
        <div class="home-right">
            <h2 class="home-heading"> Grow Up Your Workflow Speed </h2>
            <p class="home-para">Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta quibusdam blanditiis
                quas assumenda nam error vel dolores suscipit ad, sapiente deleniti ipsum, obcaecati perspiciatis.</p>
         
        </div>
    </section>
    <!--================== Home Section Ends Here -->

    <!--================== Workflow Section Starts from Here ==================-->
    <section id="workFlow">
        <h2 class="heading"> Grow Up Your Workflow Speed. </h2>
        <p class="para">Lorem ipsum dolor sit amet consectetur adipisicing elit. A, commodi sint. <br>Ipsam molestias
            nemovel laboriosam consequatur, perferendis<br> minima soluta? Natus necessitatibus autem suscipit!</p>
        <div class="num-container">
            <div class="num-item"><span>27,882 <br>Customers</span></div>
            <div class="num-item"><span>90% <br>Action Plans</span></div>
            <div class="num-item"><span>70,592 <br>Downloads</span></div>
        </div>
    </section>
    <!--================== Workflow Section Ends Here -->


    <!--================== Goal Section Starts from Here ==================-->
    <section id="goal">
        <div class="goal-left">
            <h2>Our Goal</h2>
           
            <ul>
                <li>Enhance Property Management</li>
                <li> Provide Comprehensive Property Information</li>
                <li>Strengthen Marketing and Outreach:</li>
            </ul>
           
        </div>
        <div class="goal-right">
            <img src="https://e0.pxfuel.com/wallpapers/574/541/desktop-wallpaper-interior-mockup-vectors-stock-psd-minimal-interior.jpg" alt="">
        </div>
    </section>
    <!--================== Goal Section Ends Here -->

    <!--================== Our Team Section Starts from Here ==================-->
    <section id="our-Team">
        <h2>Our Member</h2>
        <div class="teamContainer">
            <div class="team-item">
                <img src="./ibrahim.jpg" alt="">
                <h5 class="member-name">Ibeahim Khalil</h5>
       
            </div>
            <div class="team-item">
                <img src="./ibrahim.jpg" alt="">
                <h5 class="member-name">Mohammad Tabakhna</h5>
              
            </div>
            <div class="team-item">
                <img src="./ibrahim.jpg" alt="">
                <h5 class="member-name">Mustafa Taha</h5>
             
            </div>
            <div class="team-item">
                <img src="./ibrahim.jpg" alt="">
                <h5 class="member-name">Laith Amer</h5>
              
            </div>
        </div>
    </section>
    <!--================== Our Team Section Ends Here -->

    <!--================== Footer Starts from Here ==================-->
    <footer>
        <p> &copy; 2022 - All rights reserved - geekshelp.in</p>
    </footer>
    <!--================== Footer Ends Here -->

    
</body>
</html>