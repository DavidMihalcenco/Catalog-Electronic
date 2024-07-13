<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <title>InfraOff@UNSTPB - ModificareInfrastructura</title>

    <!-- Bootstrap core CSS -->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="/assets/css/fontawesome.css">
    <link rel="stylesheet" href="/assets/css/templatemo-woox-travel.css">
    <link rel="stylesheet" href="/assets/css/owl.css">
    <link rel="stylesheet" href="/assets/css/animate.css">
    <link rel="stylesheet" href="/assets/css/options.css">
    <link rel="stylesheet"href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>
    <!--

    TemplateMo 580 Woox Travel

    https://templatemo.com/tm-580-woox-travel

    -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formular pentru introducerea unei descrieri</title>
    <style>
        textarea {
            width: 100%;
            height: 150px;
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 5px;
            resize: vertical;
        }
    </style>
</head>

<style>
    fieldset {
        text-align: center; /* Centrare text */
    }

    .form-label {
        display: block; /* Fiecare etichetă pe un rând nou */
    }

    .form-control {
        margin: 0 auto; /* Centrare orizontală */
    }
</style>
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
<!-- ***** Header Area End ***** -->

<div class="second-page-heading">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h4>Book Prefered Deal Here</h4>
                <h2>Make Your Reservation</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt uttersi labore et dolore magna aliqua is ipsum suspendisse ultrices gravida</p>
                <div class="main-button"><a href="offers.ftlh">Discover More</a></div>
            </div>
        </div>
    </div>
</div>

<div class="reservation-form">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <form id="reservation-form" name="gs" role="search">
                    <div class="row">
                        <div class="col-lg-12">
                            <h4>Modifica <em>Oferta</em> Cu Ajutorul <em>Formularului</em> De Mai Jos</h4>
                        </div>
                        <div class="col-lg-12">
                            <fieldset>
                                <label for="Name" class="form-label">Numele Ofertei</label>
                                <input type="text" name="Name" class="Name" autocomplete="on" required>
                            </fieldset>
                        </div>
                        <div class="col-lg-12">
                            <fieldset>
                                <label for="Key_words" class="form-label">Cuvinte cheie</label>
                                <input type="text" name="Key_words" class="Key_words" autocomplete="on" required>
                            </fieldset>
                        </div>
                        <div class="col-lg-24">
                            <fieldset>
                                <label for="Description" class="form-label">Descrierea Ofertei</label>
                                <textarea type="text" name="Description" class="Description" autocomplete="on" required rows="5"></textarea>
                            </fieldset>
                        </div>
                        <div class="col-lg-24">
                            <fieldset>
                                <label for="Concept" class="form-label">Contextul si conceptul de baza al tehnologiei</label>
                                <textarea type="text" name="Concept" class="Concept" autocomplete="on" required rows="5"></textarea>
                            </fieldset>
                        </div>
                        <div class="col-lg-24">
                            <fieldset>
                                <label for="Benefits" class="form-label">Avantaje si Elemente Competitive</label>
                                <textarea type="text" name="Benefits" class="Benefits" autocomplete="on" required rows="5"></textarea>
                            </fieldset>
                        </div>
                        <div class="col-lg-24">
                            <fieldset>
                                <label for="Utilization" class="form-label">Domenii de utilizare si Oportunitati de piata</label>
                                <textarea type="text" name="Utilization" class="Utilization" autocomplete="on" required rows="5"></textarea>
                            </fieldset>
                        </div>
                        <div class="col-lg-24">
                            <fieldset>
                                <label for="Colaboration" class="form-label">Colaborari Solicitate</label>
                                <textarea type="text" name="Colaboration" class="Colaboration" autocomplete="on" required rows="5"></textarea>
                            </fieldset>
                        </div>
                        <div class="col-lg-24">
                            <fieldset>
                                <label for="Status" class="form-label">Statutul / stadiul protectiei Proprietatii Intelectuale</label>
                                <textarea type="text" name="Status" class="Status" autocomplete="on" required rows="5"></textarea>
                            </fieldset>
                        </div>
                        <div class="col-lg-6">
                            <fieldset>
                                <label for="Number" class="form-label">Numar de contact</label>
                                <input type="text" name="Number" class="Number" required>
                            </fieldset>
                        </div>
                        <div class="col-lg-6">
                            <fieldset>
                                <label for="Email" class="form-label">E-mail de contact</label>
                                <input type="text" name="Email" class="Email" required>
                            </fieldset>
                        </div>
                        <div class="col-lg-4">
                            <fieldset>
                                <label for="UploadOfferFoto" class="form-label">Fotografie Oferta</label>
                                <input class="form-control" type="file" name="Imagefile" placeholder="req" id="offerImage" required>
                            </fieldset>
                        </div>
                        <div class="col-lg-4">
                            <fieldset>
                                <select name="Status_Private" class="form-select" aria-label="Default select example" id="chooseStatus" onChange="this.form.click()">
                                    <option id = "option1" value="Privat" >Privat</option>
                                    <option id = "option2" value="Public" >Public</option>
                                </select>
                            </fieldset>
                        </div>
                        <div class="col-lg-12">
                            <fieldset>
                                <button type="button" class="main-button" id="submit-button-modify-offer">Modifica Oferta</button>
                            </fieldset>
                        </div>
                    </div>
                </form>
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
<#--<script src="/assets/js/tabs.js"></script>-->
<script src="/assets/js/popup.js"></script>
<script src="/assets/js/custom.js"></script>
<script src="/assets/js/showOptions.js"></script>
<script src="/assets/js/modifyOffer.js"></script>

<script>
    $(".option").click(function(){
        $(".option").removeClass("active");
        $(this).addClass("active");
    });
</script>

</body>

</html>
