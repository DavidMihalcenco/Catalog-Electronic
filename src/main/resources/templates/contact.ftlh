<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <title>InfraOff@UNSTPB - Contact</title>

    <!-- Bootstrap core CSS -->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="/assets/css/fontawesome.css">
    <link rel="stylesheet" href="/assets/css/templatemo-woox-travel.css">
    <link rel="stylesheet" href="/assets/css/owl.css">
    <link rel="stylesheet" href="/assets/css/animate.css">
    <link rel="stylesheet" href="/assets/css/options.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>
    <!--

    TemplateMo 580 Woox Travel

    https://templatemo.com/tm-580-woox-travel

    -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formular pentru introducerea unei descrieri</title>
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
                        <li><a href="/">Acasa</a></li>
                        <li><a href="/offers">Oferte</a></li>
                        <li><a href="/contact" class="active">Contact</a></li>
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

<div class="second-page-heading">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>Contact</h2>
                <p>Daca vreti drepturi pentru a adauga pe site-ul nostru oferte sau infrastructuri atunci ne puteti contacta</p>
            </div>
        </div>
    </div>
</div>

<div class="more-info reservation-info">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-sm-6">
                <div class="info-item">
                    <i class="fa fa-phone"></i>
                    <h4>Suna</h4>
                    <a href="#">0732 576 574</a>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6">
                <div class="info-item">
                    <i class="fa fa-envelope"></i>
                    <h4>Contact prin email</h4>
                    <a href="mailto:infraoffunstpb@gmail.com?subject=Salutare&body=Aceasta%20este%20o%20testare">infraoffunstpb@gmail.com</a>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6">
                <div class="info-item">
                    <i class="fa fa-map-marker"></i>
                    <h4>Viziteaza-ne</h4>
                    <a href="https://www.google.com/maps/place/Faculty+of+Automatic+Control+and+Computer+Science/@44.4356429,26.0473535,17.54z/data=!4m9!1m2!2m1!1sgoogle+maps!3m5!1s0x40b201ebafcdf7a3:0xeafb513bd76c5277!8m2!3d44.4357318!4d26.0477029!16s%2Fg%2F11x7vnjby?entry=ttu">Splaiul Independenței 313, București 060042</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="step-guide-container">
    <div class="step-guide-title">Ghid Pas cu Pas Adaugare Infrastructura sau Oferta</div>
    <div class="step">
        <div class="step-number">1</div>
        <div class="step-content">
            <div class="step-title">Autentificare/Inregistrare</div>
            <div class="step-description">Te autentifici cu contul tau sau iti creezi unul nou, daca ai un cont upb
                atunci vei putea automat sa adaugi pe site-ul nostru, daca nu atunci ne poti contact pentru a cere permisiuni.</div>
        </div>
    </div>
    <div class="step">
        <div class="step-number">2</div>
        <div class="step-content">
            <div class="step-title">Navigheaza la Adaugare</div>
            <div class="step-description">Acceseaza pe site Adauga, si alege optiunea care doresti, infrastructura sau oferta.</div>
        </div>
    </div>
    <div class="step">
        <div class="step-number">3</div>
        <div class="step-content">
            <div class="step-title">Adaugare</div>
            <div class="step-description">Dupa ce ai ales ce vrei sa adaugi completeaza formularul(nu uita ca poti sa modifici oricand oferta sau infrastructura) si apasa butonul Adauga.</div>
        </div>
    </div>
    <div class="step">
        <div class="step-number">4</div>
        <div class="step-content">
            <div class="step-title">Navigheaza la Infrastructurile mele sau Ofertele mele</div>
            <div class="step-description">Aici poti vedea ce infrastructura sau oferta adaugata.</div>
        </div>
    </div>
    <div class="step">
        <div class="step-number">5</div>
        <div class="step-content">
            <div class="step-title">Modificare/Stergere</div>
            <div class="step-description">Poti sterge sau modifica infrastructura, vei vedea toate datele disponibile care deja le-ai adaugat anterior.</div>
        </div>
    </div>
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

<script>
    $(".option").click(function(){
        $(".option").removeClass("active");
        $(this).addClass("active");
    });
</script>

</body>

</html>
