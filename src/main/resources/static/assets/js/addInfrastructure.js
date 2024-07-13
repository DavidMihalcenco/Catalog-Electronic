$(document).ready( function () {
    SomeFunction();
});
function SomeFunction() {
    $('#submit-button-infra').click(function(event) {
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
            'infrastructure_data_publication': 1,
            'infrastructure_lon': lng,
            'infrastructure_lat': lat,
        })], {type: 'application/json'}));

        $.ajax({
            url: 'http://localhost:9090/addInfra',
            type: 'POST',
            data: formData,
            processData: false, // Important
            contentType: false, // Important
            success: function(response) {
                window.location.href = "http://localhost:9090/infrastructures";
            }
        });
    });
}
