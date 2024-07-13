$(document).ready( function () {
    ViewUserOwnerInfoFunction();
    GetUserOfferInfraNumber();
    UserOwnerEmail();
});

function getIdFromUrl() {
    const url = window.location.href;
    const parts = url.split('/');
    return parts[parts.length - 1];
}

function ViewUserOwnerInfoFunction(){
    const userId = getIdFromUrl();

    $.ajax({
        url: 'http://localhost:9090/api/viewUserOwner/' + userId,
        type: 'GET',
        success: function(response) {
            const user_name = document.getElementById('user_name');
            const user_email = document.getElementById('user_email');
            const user_photo = document.getElementById('user_photo');

            user_photo.src = "data:image/jpeg;base64," + response['user_image'];
            user_name.innerHTML = response['user_name'];
            user_email.innerHTML = response['user_email'];
            populateOwnerUser(response);
        }
    });
}

function GetUserOfferInfraNumber(){
    const userId = getIdFromUrl();
    $.ajax({
        url: 'http://localhost:9090/api/userOfferInfraCount/' + userId,
        type: 'GET',
        success: function(response) {
            const nr_infra = document.getElementById('nr_infra');
            const nr_offer = document.getElementById('nr_offer');

            nr_infra.innerHTML = response['infrastructures_count'];
            nr_offer.innerHTML = response['offers_count'];
        }
    });
}

function UserOwnerEmail(){
    const userId = getIdFromUrl();
    document.getElementById('user_email').addEventListener('click', function() {
        $.ajax({
            url: 'http://localhost:9090/api/viewUserOwner/' + userId,
            type: 'GET',
            success: function(response) {
                const user_email = document.getElementById('user_email');
                user_email.location.href = window.location.href = 'mailto:' + response['user_email'];
            }
        });
    });
}

function populateOwnerUser(data){

    const container = $('#myTab');
    container.empty();

        const offerHtml = `
                 <li class="nav-item">
                            <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="profile-tab" data-toggle="tab" href="http://localhost:9090/ownerInfrastructures/${data['user_id']}" role="tab" aria-controls="profile" aria-selected="false">Infrastructuri</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="profile-tab" data-toggle="tab" href="http://localhost:9090/ownerOffers/${data['user_id']}" role="tab" aria-controls="profile" aria-selected="false">Oferte</a>
                        </li>`;

        container.append(offerHtml);
}