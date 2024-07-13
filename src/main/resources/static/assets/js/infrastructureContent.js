$(document).ready( function () {
    ViewInfrastructureFunction();

});

function ViewInfrastructureFunction() {

    const infrastructureId = getIdFromUrl();

    $.ajax({
        url: 'http://localhost:9090/api/infrastructure/' + infrastructureId,
        type: 'GET',
        success: function(response) {
            populateInfrastructure(response)
        }
    });
}

function getIdFromUrl() {
    const url = window.location.href;
    const parts = url.split('/');
    return parts[parts.length - 1];
}

function populateInfrastructure(data){
    const container = $('#container-infrastructure_id');
    container.empty();
    const offerHtml = `
        <div class="page-heading">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <h2>${data['infrastructure_name']}</h2>
                    </div>
                </div>
            </div>
        </div>
        <div class = "container infrastructure-container">
            <div class="row">
                <div class="col-md-6">
                    <img src="${"data:image/jpeg;base64," + data['infrastructure_image']}" alt="">
                </div>
                <div class="col-md-6 infrastructure-details">
                     <a href="http://localhost:9090/viewUserOwner/${data['user_id']}">Adaugata de : ${data['user_email']}</a><br>
                     <a> Cuvinte cheie: ${data['infrastructure_key_words']}</a>
                    <h2>Descrierea Generala a Infrastructurii</h2>
                    <p>${data['infrastructure_description']}</p>
                </div>
            </div>
            <div>
                <div class="row">
                    <div class="col-md-12 infrastructure-details">
                        <h2>Beneficiile aduse de Infrastructura</h2>
                        <p>${data['infrastructure_benefits']}</p>
                    </div>
                </div>
            </div>
            <div>
                <div class="row">
                    <div class="col-md-12 infrastructure-details">
                        <h2>Accesul la Infrastructura</h2>
                        <p>${data['infrastructure_access_info']}</p>
                    </div>
                </div>
            </div>
            <div>
                <div class="row">
                    <div class="col-md-12 infrastructure-details">
                        <h2>Specificatiile Tehnice</h2>
                        <p>${data['infrastructure_tehnical_specification']}</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="container" style = "display: flex; justify-content: center ; margin-bottom: 50px">
            <div class="contact-info">
                <div>
                    <i class="fas fa-phone-alt"></i>
                    <span id="phone-number">${data['infrastructure_phone']}</span>
                </div>
                <div>
                    <i class="fas fa-envelope"></i>
                    <span id="email-address">${data['infrastructure_email']}</span>
                </div>
            </div>
        </div>

        `;
    container.append(offerHtml);
}