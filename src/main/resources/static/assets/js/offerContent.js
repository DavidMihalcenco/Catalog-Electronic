$(document).ready( function () {
    ViewOfferFunction();

});

function ViewOfferFunction() {

    const offerId = getIdFromUrl();

    $.ajax({
        url: 'http://localhost:9090/api/offer/' + offerId,
        type: 'GET',
        success: function(response) {
            populateOffer(response)
        }
    });
}

function getIdFromUrl() {
    const url = window.location.href;
    const parts = url.split('/');
    return parts[parts.length - 1];
}

function populateOffer(data){
    const container = $('#container-infrastructure_id');
    container.empty();
    const offerHtml = `
        <div class="page-heading">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <h2>${data['offer_name']}</h2>
                    </div>
                </div>
            </div>
        </div>
        <div class = "container infrastructure-container">
            <div class="row">
                <div class="col-md-6">
                    <img src="${"data:image/jpeg;base64," + data['offer_image']}" alt="">
                </div>
                <div class="col-md-6 infrastructure-details">
                    <a href="http://localhost:9090/viewUserOwner/${data['user_id']}">Adaugata de : ${data['user_email']}</a><br>
                    <a>Cuvinte cheie: ${data['offer_key_words']}</a>
                    <h2>Descrierea Generala a Ofertei</h2>
                    <p>${data['offer_description']}</p>
                </div>
            </div>
             <div>
                <div class="row">
                    <div class="col-md-12 infrastructure-details">
                        <h2>Contextul si conceptul de baza al tehnologiei</h2>
                        <p>${data['offer_context']}</p>
                    </div>
                </div>
            </div>
            <div>
                <div class="row">
                    <div class="col-md-12 infrastructure-details">
                        <h2>Avantaje si elemente competitive</h2>
                        <p>${data['offer_benefits']}</p>
                    </div>
                </div>
            </div>
            <div>
                <div class="row">
                    <div class="col-md-12 infrastructure-details">
                        <h2>Domenii de utilizare si oportunitati de piata</h2>
                        <p>${data['offer_utilization']}</p>
                    </div>
                </div>
            </div>
            <div>
                <div class="row">
                    <div class="col-md-12 infrastructure-details">
                        <h2>Statutul / stadiul protectiei Proprietatii Intelectuale</h2>
                        <p>${data['offer_status']}</p>
                    </div>
                </div>
            </div>
            <div>
                <div class="row">
                    <div class="col-md-12 infrastructure-details">
                        <h2>Colaborari Solicitate:</h2>
                        <p>${data['offer_colaborations']}</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="container" style = "display: flex; justify-content: center ; margin-bottom: 50px">
            <div class="contact-info">
                <div>
                    <i class="fas fa-phone-alt"></i>
                    <span id="phone-number">${data['offer_phone']}</span>
                </div>
                <div>
                    <i class="fas fa-envelope"></i>
                    <span id="email-address">${data['offer_email']}</span>
                </div>
            </div>
        </div>

        `;
    container.append(offerHtml);
}