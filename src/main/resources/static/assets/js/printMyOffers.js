$(document).ready( function () {
    ViewMyOffersFunction();
});

function ViewMyOffersFunction() {
    $.ajax({
        url: 'http://localhost:9090/api/myOffers',
        type: 'GET',
        success: function(response) {
            populateMyOffers(response);
        }
    });
}

function populateMyOffers(data){

    const container = $('#my_card_container_id');
    container.empty();
    let len = data.length - 1

    data.forEach((offer, index) => {
        var statusText = '';
        if (offer['public_status'] === true) {
            statusText = 'Status: Public';
        } else {
            statusText = 'Status: Private';
        }
        const offerHtml = $('<div/>', { class: 'col-lg-6 col-sm-6', xmlns: 'http://www.w3.org/1999/html' }).append(
            $('<div/>', { class: 'item' }).append(
                $('<div/>', { class: 'row' }).append(
                    $('<div/>', { class: 'col-lg-6' }).append(
                        $('<div/>', { class: 'image' }).css({ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '50vh' }).append(
                            $('<img/>', { src: "data:image/jpeg;base64," + offer['offer_image'], alt: '' })
                        )
                    ),
                    $('<div/>', { class: 'col-lg-6 align-self-center' }).append(
                        $('<div/>', { class: 'content' }).append(
                            $('<span/>', { class: 'info', text: ' Prezentarea Ofertei:' }),
                            $('<h6/>', { text: statusText }),
                            $('<h4/>', { text: offer['offer_name'] }),
                            $('<div/>', { class: 'row' }).append(
                                $('<div/>', { class: 'col-12' }).append(
                                    $('<i/>', { class: 'fa fa-mobile' }),
                                    $('<span/>', { class: 'list', text: offer['offer_phone'] })
                                )
                            ),
                            $('<p/>', { class: 'offer-description', title: offer['offer_description'], text: offer['offer_description'] }),
                            $('<div/>', { class: 'main-button' }).append(
                                $('<a/>', { href: `http://localhost:9090/offer/${offer['offer_id']}`, text: 'Detalii Oferta' })
                            ),
                            $('<div/>', { class: 'main-button' }).append(
                                $('<a/>', { href: `http://localhost:9090/modifyOffer/${offer['offer_id']}`, text: 'Modifica Oferta' })
                            ),
                            $('<div/>', { class: 'main-button' }).append(
                                $('<a/>', { text: 'Sterge Oferta', click: function() {
                                        $.ajax({
                                            url: "http://localhost:9090/deleteOffer/"+ offer['offer_id'],
                                            type: 'DELETE',
                                            success: function(response) {
                                                window.location.href = "http://localhost:9090/myOffers";
                                            }
                                        });
                                    }
                                }).attr('role', 'button')
                            )
                        )
                    )
                )
            )
        );
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
