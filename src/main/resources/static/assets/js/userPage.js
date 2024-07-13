$(document).ready( function () {
    ViewUserInfoFunction();
    GetUserOfferInfraNumber();
    ChangeUserPhoto();
    UserEmail();
});

function ViewUserInfoFunction(){
    $.ajax({
        url: 'http://localhost:9090/api/myProfile',
        type: 'GET',
        success: function(response) {
            const user_name = document.getElementById('user_name');
            const user_email = document.getElementById('user_email');
            const user_photo = document.getElementById('user_photo');

            user_photo.src = "data:image/jpeg;base64," + response['user_image'];
            user_name.innerHTML = response['user_name'];
            user_email.innerHTML = response['user_email'];
        }
    });
}

function UserEmail(){
    document.getElementById('user_email').addEventListener('click', function() {
        $.ajax({
            url: 'http://localhost:9090/api/myProfile',
            type: 'GET',
            success: function(response) {
                const user_email = document.getElementById('user_email');
                user_email.location.href = window.location.href = 'mailto:' + response['user_email'];
            }
        });
    });
}

function GetUserOfferInfraNumber(){
    $.ajax({
        url: 'http://localhost:9090/api/userOfferInfraCount',
        type: 'GET',
        success: function(response) {
            const nr_infra = document.getElementById('nr_infra');
            const nr_offer = document.getElementById('nr_offer');

            nr_infra.innerHTML = response['infrastructures_count'];
            nr_offer.innerHTML = response['offers_count'];
        }
    });
}

function ChangeUserPhoto(){
    $('#submit-button-photo').click(function(event) {
        var image = $('input[type=file]')[0].files[0];

        const formData = new FormData();
        formData.append('image', image);

        $.ajax({
            url: 'http://localhost:9090/api/modifyMyProfile',
            type: 'PUT',
            data: formData,
            processData: false, // Important
            contentType: false, // Important
            success: function(response) {
                window.location.href = "http://localhost:9090/myProfile";
            }
        });
    });
}