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
    <link rel="stylesheet" href="/assets/css/animations.css">
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

  <!-- ***** Main Banner Area Start ***** -->
  <section id="section-1">
    <div class="content-slider">
      <input type="radio" id="banner1" class="sec-1-input" name="banner" checked>
      <input type="radio" id="banner2" class="sec-1-input" name="banner">
      <input type="radio" id="banner3" class="sec-1-input" name="banner">
      <div class="slider">
        <div id="top-banner-1" class="banner">
          <div class="banner-inner-wrapper header-text">
            <div class="main-caption">
                <svg>
                  <text x="50%" y="50%" dy=".35em" text-anchor="middle">
                    InfraOFF@UNSTBP
                  </text>
                </svg>
            </div>
            <div class="container">
              <div class="row">
                <div class="col-lg-12">
                  <div class="more-info">
                    <div class="row">
                      <div class="col-lg-3 col-sm-6 col-6">
                        <i class="fa-solid fa-gear"></i>
                        <h4 id = "infrastructure_count">
                        </h4>
                      </div>
                      <div class="col-lg-3 col-sm-6 col-6">
                        <i class="fa fa-file" ></i>
                        <h4 id = "offer_count">
                        </h4>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div id="top-banner-2" class="banner">
          <div class="banner-inner-wrapper header-text">
            <div class="main-caption">
              <h1>Descoperiti infrastructurile de pe site</h1>
              <div class="border-button"><a href="http://localhost:9090/infrastructures">Infrastructuri</a></div>
            </div>
            <div class="container">
              <div class="row">
                <div class="col-lg-12">
                  <div class="more-info">
                    <div class="row">
                      <div class="col-lg-3 col-sm-6 col-6">
                        <i class="fa-solid fa-gear"></i>
                        <h4 id = "infrastructure_count1"></h4>
                      </div>
                      <div class="col-lg-3 col-sm-6 col-6">
                        <i class="fa fa-file"></i>
                        <h4 id = "offer_count1"></h4>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div id="top-banner-3" class="banner">
          <div class="banner-inner-wrapper header-text">
            <div class="main-caption">
              <h1>Descoperiti Ofertele de pe site</h1>
              <div class="border-button"><a href="http://localhost:9090/offers">Oferte</a></div>
            </div>
            <div class="container">
              <div class="row">
                <div class="col-lg-12">
                  <div class="more-info">
                    <div class="row">
                      <div class="col-lg-3 col-sm-6 col-6">
                        <i class="fa-solid fa-gear"></i>
                        <h4 id = "infrastructure_count2"></h4>
                      </div>
                      <div class="col-lg-3 col-sm-6 col-6">
                        <i class="fa fa-file"></i>
                        <h4 id = "offer_count2"></h4>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="controls">
          <label for="banner1"><span class="progressbar"><span class="progressbar-fill"></span></span><span class="text">1</span></label>
          <label for="banner2"><span class="progressbar"><span class="progressbar-fill"></span></span><span class="text">2</span></label>
          <label for="banner3"><span class="progressbar"><span class="progressbar-fill"></span></span><span class="text">3</span></label>
        </div>
      </nav>
    </div>
  </section>
  <!-- ***** Main Banner Area End ***** -->
  
  <div class="visit-country">
    <div class="container">
      <div class="row">
        <div class="col-lg-5">
          <div class="section-heading">
            <h2>Infrastructurile adaugate recent</h2>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-8">
          <div class="items">
            <div class="row">
              <div id="data-container" class="row">
                <div class="row" id = "card_container_id">
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="visit-country">
    <div class="container">
      <div class="row">
        <div class="col-lg-5">
          <div class="section-heading">
            <h2>Oferte adaugate recent</h2>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-8">
          <div class="items">
            <div class="row">

              <div id="data-container-offer" class="row">
                <div class="row" id = "offer_container_id">
                </div>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="more-about">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 align-self-center">
          <div class="left-image">
            <img src="/assets/images/about-left-image.jpg" alt="">
          </div>
        </div>
        <div class="col-lg-6">
          <div class="section-heading">
            <h2>Descopera infrastructuri si oferte in toata lumea</h2>
            <p>EERTIS.eu cel mai mare site online unde puteti gasi infrastructuri si oferte din toata lumea.</p>
          </div>
          <div class="row">
            <div class="col-lg-6">
              <div class="info-item">
                <h4>2.856</h4>
                <span>Research Infrastructures</span>
              </div>
            </div>
            <div class="col-lg-6">
              <div class="info-item">
                <h4>7.113</h4>
                <span>Research Services</span>
              </div>
            </div>
            <div class="col-lg-12">
              <div class="info-item">
                <div class="row">
                  <div class="col-lg-6">
                    <h4>473</h4>
                    <span>Technology Services</span>
                  </div>
                  <div class="col-lg-6">
                    <h4>26.751</h4>
                    <span>Equipment</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="main-button">
            <a href="https://eertis.eu/">EERTIS.EU</a>
          </div>
        </div>
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
<#--  <script src="/assets/js/tabs.js"></script>-->
  <script src="/assets/js/popup.js"></script>
  <script src="/assets/js/custom.js"></script>
  <script src="/assets/js/showOptions.js"></script>
  <script src="/assets/js/homePage.js"></script>

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
