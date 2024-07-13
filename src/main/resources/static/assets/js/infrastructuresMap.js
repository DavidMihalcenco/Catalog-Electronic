let map;
let marker;

async function initMap() {
    const { Map } = await google.maps.importLibrary("maps");
    const { AdvancedMarkerElement } = await google.maps.importLibrary("marker");
    const infrastructureId = getIdFromUrl();
    $.ajax({
        url: 'http://localhost:9090/api/infrastructure/' + infrastructureId,
        type: 'GET',
        success: function(response) {
            const lat = parseFloat(response['infrastructure_lat']);
            const lng = parseFloat(response['infrastructure_lon']);
            map = new Map(document.getElementById("map"), {
                center: { lat, lng },
                zoom: 8,
                mapId: "4504f8b37365c3d0",
            });

            // Imagine personalizată pentru marker
            const markerContent = document.createElement('div');
            markerContent.innerHTML = `<img src="data:image/jpeg;base64,${response['infrastructure_image']}" style="width:30px;height:30px; border-radius: 50%;">`;

            marker = new AdvancedMarkerElement({
                map,
                position: { lat, lng },
                content: markerContent
            });
        }
    });
}

function getIdFromUrl() {
    const url = window.location.href;
    const parts = url.split('/');
    return parts[parts.length - 1];
}