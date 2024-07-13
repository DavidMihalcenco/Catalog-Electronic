$(document).ready( function () {
    ViewAllOffersFunction();
    SearchOffersFunction();
});

function ViewAllOffersFunction() {
    $.ajax({
        url: 'http://localhost:9090/api/allOffers',
        type: 'GET',
        success: function(response) {
            populateOffers(response);
        }
    });
}
function SearchOffersFunction(){
    $('#search-button-offer').click(function(event) {
        const name = $('input[name="Name"]').val();
        event.preventDefault();
        $.ajax({
            url: 'http://localhost:9090/api/searchOffers',
            type: 'GET',
            data: { name: name },
            success: function(response) {
                populateOffers(response);
            }
        });
    });
}

function populateOffers(data){

    const container1 = $('#page-numbers');
    container1.empty();
    const container = $('#card_container_id');
    container.empty();
    let len = data.length - 1

    data.forEach((offer, index) => {
        const description = offer['offer_description'];
        const truncatedDescription = description.length > 200 ? description.substring(0, 200) + '...' : description;
        const offerHtml = `
                 <div class="col-lg-6 col-sm-6">
                    <div class="item">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="image" style="display: flex ; justify-content: center; align-items: center ; height: 40vh">
                                    <img src="${"data:image/jpeg;base64," + offer['offer_image']}" alt="">
                                </div>
                            </div>
                            <div class="col-lg-6 align-self-center">
                                <div class="content">
                                    <span class="info"> Prezentarea Ofertei:</span>
                                    <h6> Publicata la data de : ${offer['offer_data_publication']}</h6>
                                    <h4 class="infrastructure-description" title="${offer['offer_name']}">${offer['offer_name']}</h4>
                                    <div class="row">
                                        <div class="col-12">
                                            <i class="fa fa-mobile"></i>
                                            <span class="list">${offer['offer_phone']}</span>
                                        </div>
                                    </div>
                                    <p class="infrastructure-description" title="${offer['offer_description']}">
                                    ${truncatedDescription}
                                    </p>
                                    <div class="main-button">
                                        <a href="http://localhost:9090/offer/${offer['offer_id']}">Detalii Oferta</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>`;
        container.append(offerHtml);
        if (index === len) {
            setPagination()
        }
    });
}

function setPagination() {
    //script.js
    const cardsPerPage = 4; // Number of cards to show per page
    const dataContainer = document.getElementById('data-container');
    const pagination = document.getElementById('page-numbers');
    const cards =
        Array.from(dataContainer.getElementsByClassName('item'));

    const totalPages = Math.ceil(cards.length / cardsPerPage);

    $('#page-numbers').append(
        "<li><a id=\"prev\"><i class=\"fa fa-arrow-left\"></i></a></li>"
    )
    for (let i = 0; i < totalPages; i++) {
        $('#page-numbers').append(
            $('<li/>',{class: 'page-link',"data-page": i + 1}).append(
                $('<a/>', {
                    href: '#',
                    html: i + 1
                })
            )
        )
    }
    $('#page-numbers').append(
        "<li><a id=\"next\"><i class=\"fa fa-arrow-right\"></i></a></li>"
    )

    const prevButton = $('#prev')
    const nextButton = $('#next');
    const pageLinks = document.querySelectorAll('.page-link');


    let currentPage = 1;

    function displayPage(page) {
        const startIndex = (page - 1) * cardsPerPage;
        const endIndex = startIndex + cardsPerPage;
        cards.forEach((card, index) => {
            if (index >= startIndex && index < endIndex) {
                card.style.display = 'block';
            } else {
                card.style.display = 'none';
            }
        });
    }

    function updatePagination() {
        prevButton.disabled = currentPage === 1;
        nextButton.disabled = currentPage === totalPages;
        pageLinks.forEach((link) => {
            const page = parseInt(link.getAttribute('data-page'));
            link.classList.toggle('active', page === currentPage);
        });
    }

    prevButton.on('click', () => {
        if (currentPage > 1) {
            currentPage--;
            displayPage(currentPage);
            updatePagination();
        }
    });

    nextButton.on('click', () => {
        if (currentPage < totalPages) {
            currentPage++;
            displayPage(currentPage);
            updatePagination();
        }
    });

    pageLinks.forEach((link) => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            const page = parseInt(link.getAttribute('data-page'));
            if (page !== currentPage) {
                currentPage = page;
                displayPage(currentPage);
                updatePagination();
            }
        });
    });

    displayPage(currentPage);
    updatePagination();
}