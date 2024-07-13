$(document).ready( function () {
    SomeFunction();
    ViewOfferDetailsFunction();
});
function SomeFunction() {
    $('#submit-button-modify-offer').click(function(event) {

        const offerId = getIdFromUrl();
        event.preventDefault();

        var name = $('input[name="Name"]').val();
        var key_words = $('input[name="Key_words"]').val();
        var description = $('textarea[name="Description"]').val();
        var benefits = $('textarea[name="Benefits"]').val();
        var concept = $('textarea[name="Concept"]').val();
        var utilization = $('textarea[name="Utilization"]').val();
        var colaboration = $('textarea[name="Colaboration"]').val();
        var status = $('textarea[name="Status"]').val();
        var number = $('input[name="Number"]').val();
        var email = $('input[name="Email"]').val();
        var image = $('input[type=file]')[0].files[0];
        var selectedOption = document.getElementById('chooseStatus').value;
        var option;
        if (selectedOption === "Privat"){
            option = false;
        }else{
            option = true;
        }

        const formData = new FormData();
        formData.append("offerId", offerId);
        formData.append('image', image);
        formData.append('OfferDto', new Blob([JSON.stringify({
            'offer_name': name,
            'offer_key_words': key_words,
            'offer_description': description,
            'user_id' : 1,
            'offer_benefits' : benefits,
            'offer_colaborations' : colaboration,
            'offer_phone' : number,
            'offer_email' : email,
            'offer_status' : status,
            'offer_utilization' : utilization,
            'offer_context' : concept,
            'private_status' : option,
        })], {type: 'application/json'}));

        $.ajax({
            url: 'http://localhost:9090/modifyOff',
            type: 'PUT',
            data: formData,
            processData: false, // Important
            contentType: false, // Important
            success: function(response) {
                window.location.href = "http://localhost:9090/myOffers";
            }
        });
    });
}

function ViewOfferDetailsFunction() {

    const offerId = getIdFromUrl();

    $.ajax({
        url: 'http://localhost:9090/api/offer/' + offerId,
        type: 'GET',
        success: function(response) {
            var name = document.querySelector('.Name');
            var key_words = document.querySelector('.Key_words');
            var description = document.querySelector('.Description');
            var email = document.querySelector('.Email');
            var phone = document.querySelector('.Number');
            var benefits = document.querySelector('.Benefits');
            var utilization = document.querySelector('.Utilization');
            var context = document.querySelector('.Concept');
            var colaborations = document.querySelector('.Colaboration');
            var status = document.querySelector('.Status');
            var priv = document.getElementById('option1');
            var pub = document.getElementById('option2');

            if (response['private_status'] === false){
                priv.selected = true;
            }else{
                pub.selected = true;
            }

            name.value = response['offer_name'];
            key_words.value = response['offer_key_words'];
            description.textContent = response['offer_description'];
            email.value = response['offer_email'];
            phone.value = response['offer_phone'];
            benefits.textContent = response['offer_benefits'];
            utilization.textContent = response['offer_utilization'];
            context.textContent = response['offer_context'];
            colaborations.textContent = response['offer_colaborations'];
            status.textContent = response['offer_status'];
        }
    });
}

function getIdFromUrl() {
    const url = window.location.href;
    const parts = url.split('/');
    return parts[parts.length - 1];
}
