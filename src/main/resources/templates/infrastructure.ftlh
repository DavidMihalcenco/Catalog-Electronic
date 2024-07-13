<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <title>InfraOff@UNSTPB - DetaliiInfrastructura</title>

    <!-- Bootstrap core CSS -->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="/assets/css/animate.css">
    <link rel="stylesheet" href="/assets/css/fontawesome.css">
    <link rel="stylesheet" href="/assets/css/templatemo-woox-travel.css">
    <link rel="stylesheet" href="/assets/css/owl.css">
    <link rel="stylesheet" href="/assets/css/infrastructure-page.css">
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

<div id="container-infrastructure_id">
</div>
<div id="map" style="width: 100%; height: 500px;"></div>
<!-- ***** Header Area End ***** -->
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
<#--  <script src="/assets/js/wow.js"></script>-->
<#--<script src="/assets/js/tabs.js"></script>-->
<script src="/assets/js/popup.js"></script>
<script src="/assets/js/custom.js"></script>
<script src="/assets/js/addInfrastructure.js"></script>
<script src="/assets/js/infrastructureContent.js"></script>
<script src="/assets/js/showOptions.js"></script>
<script src="/assets/js/infrastructuresMap.js"></script>
<script async
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBHlsyos05eADZVZRJ6Nof7A-gwOGiyQCk&loading=async&callback=initMap">
</script>
<script>
    $(".option").click(function(){
        $(".option").removeClass("active");
        $(this).addClass("active");
    });
</script>

</body>

</html>
