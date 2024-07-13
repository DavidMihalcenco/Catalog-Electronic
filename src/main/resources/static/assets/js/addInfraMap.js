let map;
let marker;
async function initMap() {
    // Request needed libraries.
    const { Map } = await google.maps.importLibrary("maps");
    const myLatlng = { lat: 44.439663, lng: 26.096306 };
    const map = new google.maps.Map(document.getElementById("map"), {
        zoom: 4,
        center: myLatlng,
    });

    map.addListener("click", (mapsMouseEvent) => {

        const latLng = mapsMouseEvent.latLng;
        const lat = latLng.lat();
        const lng = latLng.lng();

        ViewMapInfra(lat, lng);

        if (marker) {
            marker.setPosition(latLng);
        } else {
            marker = new google.maps.Marker({
                position: latLng,
                map: map,
            });
        }
    });
}

function ViewMapInfra(lat,lng){
    const latInput = document.querySelector('.Lat');
    const lngInput = document.querySelector('.Lng');
    latInput.value = lat;
    lngInput.value = lng;
}