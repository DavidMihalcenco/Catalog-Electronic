<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <title>InfraOff@UNSTPB - Oferte</title>

    <!-- Bootstrap core CSS -->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
      <link rel="stylesheet" href="assets/css/style.css">
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
                        <li><a href="/offers" class="active">Oferte</a></li>
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

  <!-- ***** Main Banner Area Start ***** -->
  <div class="about-main-content">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="content">
            <div class="blur-bg"></div>
            <h4>Explora toate ofertele</h4>
            <div class="line-dec"></div>
            <h2>Vezi toate ofertele disponibile</h2>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- ***** Main Banner Area End ***** -->

  <div class="search-form">
      <div class="container">
          <div class="row">
              <div class="col-lg-12">
                  <form id="search-form" name="gs" role="search" action="#">
                      <div class="row">
                          <div class="col-lg-2">
                              <h4>Cautare :</h4>
                          </div>
                          <div class="col-lg-8">
                              <fieldset>
                                  <input type="text" name="Name" class="Name" autocomplete="on" required>
                              </fieldset>
                          </div>
                          <div class="col-lg-2">
                              <fieldset>
                                  <button id="search-button-offer" class="border-button">Cauta</button>
                              </fieldset>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
      </div>
  </div>

  <div class="amazing-deals">
      <div class="container">
          <div class="row">
              <div id="data-container" class="row">
                  <div class="row" id = "card_container_id">
                  </div>
              </div>
              <div class="col-lg-12">
                  <ul class="page-numbers" id ="page-numbers">
                  </ul>
              </div>
          </div>
      </div>
  </div>

  <div class="call-to-action">
    <div class="container">
      <div class="row">
        <div class="col-lg-8">
          <h2>Vrei sa adaugi o oferta ?</h2>
          <h4>Atunci logheazate pe site-ul nostru</h4>
        </div>
        <div class="col-lg-4">
          <div class="border-button">
            <a href="/addOffer">Adauga Oferta</a>
          </div>
        </div>
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
<#--  <script src="/assets/js/tabs.js"></script>-->
  <script src="/assets/js/popup.js"></script>
  <script src="/assets/js/custom.js"></script>
  <script src="/assets/js/showOptions.js"></script>
  <script src="/assets/js/printOffer.js"></script>

  <script>
    $(".option").click(function(){
      $(".option").removeClass("active");
      $(this).addClass("active"); 
    });
  </script>

</body>

</html>
