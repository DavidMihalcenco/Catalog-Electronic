$(document).ready( function () {
    SomeFunction();
    ViewInfrastructureDetailsFunction();
});
function SomeFunction() {
    $('#submit-button-modify').click(function(event) {

        const infrastructureId = getIdFromUrl();
        event.preventDefault();

        var name = $('input[name="Name"]').val();
        var key_words = $('input[name="Key_words"]').val();
        var description = $('textarea[name="Description"]').val();
        var benefits = $('textarea[name="Benefits"]').val();
        var access = $('textarea[name="Access-info"]').val();
        var specification = $('textarea[name="Teh-specification"]').val();
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
        var lat = $('input[name="Lat"]').val();
        var lng = $('input[name="Lng"]').val();

        const formData = new FormData();
        formData.append("infrastructureId", infrastructureId);
        formData.append('image', image);
        formData.append('InfrastructureDto', new Blob([JSON.stringify({
            'infrastructure_name': name,
            'infrastructure_key_words': key_words,
            'infrastructure_description': description,
            'user_id' : 1,
            'infrastructure_benefits' : benefits,
            'infrastructure_email' : email,
            'infrastructure_phone' : number,
            'infrastructure_tehnical_specification' : specification,
            'infrastructure_access_info' : access,
            'private_status' : option,
            'infrastructure_lat': lat,
            'infrastructure_lon': lng,
        })], {type: 'application/json'}));

        $.ajax({
            url: 'http://localhost:9090/modifyInfra',
            type: 'PUT',
            data: formData,
            processData: false, // Important
            contentType: false, // Important
            success: function(response) {
                window.location.href = "http://localhost:9090/myInfrastructures";
            }
        });
    });
}

function ViewInfrastructureDetailsFunction() {

    const infrastructureId = getIdFromUrl();

    $.ajax({
        url: 'http://localhost:9090/api/infrastructure/' + infrastructureId,
        type: 'GET',
        success: function(response) {
            var name = document.querySelector('.Name');
            var key_words =  document.querySelector('.Key_words');
            var description = document.querySelector('.Description');
            var email = document.querySelector('.Email');
            var phone = document.querySelector('.Number');
            var benefits = document.querySelector('.Benefits');
            var access = document.querySelector('.Access-info');
            var tehnical = document.querySelector('.Teh-specification');
            var priv = document.getElementById('option1');
            var pub = document.getElementById('option2');
            const latInput = document.querySelector('.Lat');
            const lngInput = document.querySelector('.Lng');

            if (response['private_status'] === false){
                priv.selected = true;
            }else{
                pub.selected = true;
            }
            name.value = response['infrastructure_name'];
            key_words.value = response['infrastructure_key_words'];
            description.textContent = response['infrastructure_description'];
            email.value = response['infrastructure_email'];
            phone.value = response['infrastructure_phone'];
            benefits.textContent = response['infrastructure_benefits'];
            access.textContent = response['infrastructure_access_info'];
            tehnical.textContent = response['infrastructure_tehnical_specification'];
            latInput.value = response['infrastructure_lat'];
            lngInput.value = response['infrastructure_lon'];
        }
    });
}

function getIdFromUrl() {
    const url = window.location.href;
    const parts = url.split('/');
    return parts[parts.length - 1];
}
