<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <title>InfraOff@UNSTPB - Acasa</title>

    <!-- Bootstrap core CSS -->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="/assets/css/fontawesome.css">
    <link rel="stylesheet" href="/assets/css/templatemo-woox-travel.css">
    <link rel="stylesheet" href="/assets/css/owl.css">
    <link rel="stylesheet" href="/assets/css/animate.css">
    <link rel="stylesheet" href="/assets/css/options.css">
    <link rel="stylesheet" href="/assets/css/user-profile.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>
    <!--

    TemplateMo 580 Woox Travel

    https://templatemo.com/tm-580-woox-travel

    -->
    <style>
        /* Stil pentru a face link-ul să arate ca un text normal */
        #user_email {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
        #user_email:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>

<!-- ***** Preloader Start ***** -->
<div id="js-preloader" class="js-preloader">
    <div class="preloader-inner">
        <span class="dot"></span>
        <div class="dots">
            <span></span>
            <span></span>
            <span></span>
        </div>
    </div>
</div>
<!-- ***** Preloader End ***** -->
<!-- ***** Header Area Start ***** -->
<header class="header-area header-sticky">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <nav class="main-nav">
                    <!-- ***** Logo Start ***** -->
                    <a href="/" class="logo">
                        <img src="/assets/images/logo.png" alt="">
                    </a>
                    <!-- ***** Logo End ***** -->
                    <!-- ***** Menu Start ***** -->
                    <ul class="nav">
                        <li><a href="/" class="active">Acasa</a></li>
                        <li><a href="/offers">Oferte</a></li>
                        <li><a href="/contact">Contact</a></li>
                        <li><a href="/infrastructures">Infrastructuri</a></li>
                        <li id="addInfrastructureDropdown">
                            <a href="#" id="addInfrastructureLink">Adauga</a>
                            <ul id="addInfrastructureOptions">
                                <#if isLoggedIn??>
                                    <li><a href="/addInfrastructure">Adauga Infrastructura</a></li>
                                <#else>
                                    <li><a href="/login">Adauga Infrastructura</a></li>
                                </#if>
                                <#if isLoggedIn??>
                                    <li><a href="/addOffer">Adauga Oferta</a></li>
                                <#else>
                                    <li><a href="/login">Adauga Oferta</a></li>
                                </#if>
                            </ul>
                        </li>
                        <#if isLoggedIn??>
                            <li id="userDropdown">
                                <a href="#" id="userLink"><i class="fas fa-user"></i></a>
                                <ul id="userOptions">
                                    <li><a href="/myInfrastructures">Infrastructurile mele</a></li>
                                    <li><a href="/myOffers">Ofertele mele</a></li>
                                    <li><a href="/myProfile">Profilul meu</a></li>
                                    <li><a href="/auth/logout">Logout</a></li>
                                </ul>
                            </li>
                        <#else>
                            <li>
                                <a href="/login">Login</a>
                            </li>
                        </#if>

                    </ul>
                    <a class='menu-trigger'>
                        <span>Menu</span>
                    </a>
                    <!-- ***** Menu End ***** -->
                </nav>
            </div>
        </div>
    </div>
</header>
<!-- ***** Header Area End ***** -->

<div class="test">

</div>
<div class="container emp-profile">
    <form method="post">
        <div class="row">
            <div class="col-md-4">
                <div class="profile-img">
                    <img id = "user_photo" alt=""/>
                    <div class="file btn btn-lg btn-primary">
                        Alege Fotografia
                        <input type="file" name="file" id="userImage"/>
                    </div>
                    <div class="col-lg-12">
                        <fieldset>
                            <button type="button" class="main-button" id="submit-button-photo">Modifica Fotografia</button>
                        </fieldset>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="profile-head">
                    <h5 id = "user_name">
                    </h5>
                    <p class="proile-rating">Infrastructuri pe Site : <span id = "nr_infra"></span></p>
                    <p class="proile-rating">Oferte pe Site : <span id = "nr_offer"></span></p>
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="/myInfrastructures" role="tab" aria-controls="profile" aria-selected="false">Infrastructuri</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="/myOffers" role="tab" aria-controls="profile" aria-selected="false">Oferte</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8">
                <div class="tab-content profile-tab" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <div class="row">
                            <div class="col-md-1" style="color: black">
                                <label>Email:</label>
                            </div>
                            <div class="col-md-3" style="color: black">
                                <a id = "user_email"></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>

<div class="call-to-action">
    <div class="container">
        <div class="row">
        </div>
    </div>
</div>

<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright © <a href="#">Universitatea Nationala de Stiinta si Tehnologie</a> POLITEHNICA Bucuresti
            </div>
        </div>
    </div>
</footer>


<!-- Scripts -->
<!-- Bootstrap core JavaScript -->
<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>

<script src="/assets/js/isotope.min.js"></script>
<script src="/assets/js/owl-carousel.js"></script>
<#--<script src="/assets/js/tabs.js"></script>-->
<script src="/assets/js/popup.js"></script>
<script src="/assets/js/custom.js"></script>
<script src="/assets/js/showOptions.js"></script>
<script src="/assets/js/homePage.js"></script>
<script src="/assets/js/userPage.js"></script>

<script>
    function bannerSwitcher() {
        next = $('.sec-1-input').filter(':checked').next('.sec-1-input');
        if (next.length) next.prop('checked', true);
        else $('.sec-1-input').first().prop('checked', true);
    }

    var bannerTimer = setInterval(bannerSwitcher, 5000);

    $('nav .controls label').click(function() {
        clearInterval(bannerTimer);
        bannerTimer = setInterval(bannerSwitcher, 5000)
    });
</script>

</body>

</html>
