$(document).ready( function () {
    SomeFunction();
});
function SomeFunction() {
    $('#submit-button-offer').click(function(event1) {
        event1.preventDefault();

        var name = $('input[name="Name"]').val();
        var key_words = $('input[name="Key_words"]').val();
        var description = $('textarea[name="Description"]').val();
        var concept = $('textarea[name="Concept"]').val();
        var benefits = $('textarea[name="Benefits"]').val();
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
        formData.append('image', image);
        formData.append('OfferDto', new Blob([JSON.stringify({
            'offer_name': name,
            'offer_key_words': key_words,
            'offer_description': description,
            'user_id' : 1,
            'offer_benefits' : benefits,
            'offer_email' : email,
            'offer_phone' : number,
            'offer_status' : status,
            'offer_utilization' : utilization,
            'offer_colaborations' : colaboration,
            'offer_context' : concept,
            'private_status' : option,
            'offer_data_publication': 1,
        })], {type: 'application/json'}));

        $.ajax({
            url: 'http://localhost:9090/addOff',
            type: 'POST',
            data: formData,
            processData: false, // Important
            contentType: false, // Important
            success: function(response) {
                window.location.href = "http://localhost:9090/";
            }
        });
    });
}
