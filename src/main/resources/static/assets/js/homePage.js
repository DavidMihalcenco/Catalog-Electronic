$(document).ready( function () {
    ViewRecentInfrastructuresFunction();
    ViewRecentOffersFunction();
    GetDetailsFunction();
});

function GetDetailsFunction(){
    $.ajax({
        url: 'http://localhost:9090/api/getDetails',
        type: 'GET',
        success: function(response) {
            const infrastructure_count = document.getElementById('infrastructure_count');
            const offer_count = document.getElementById('offer_count');
            const infrastructure_count1 = document.getElementById('infrastructure_count1');
            const offer_count1 = document.getElementById('offer_count1');
            const infrastructure_count2 = document.getElementById('infrastructure_count2');
            const offer_count2 = document.getElementById('offer_count2');
            infrastructure_count.innerHTML = `<span>Numar Infrastructuri:</span>
                          <br>${response['infrastructures_count']}`;
            offer_count.innerHTML = `<span>Numar Oferte:</span>
                          <br>${response['offers_count']}`;
            infrastructure_count1.innerHTML = `<span>Numar Infrastructuri:</span>
                          <br>${response['infrastructures_count']}`;
            offer_count1.innerHTML = `<span>Numar Oferte:</span>
                          <br>${response['offers_count']}`;
            infrastructure_count2.innerHTML = `<span>Numar Infrastructuri:</span>
                          <br>${response['infrastructures_count']}`;
            offer_count2.innerHTML = `<span>Numar Oferte:</span>
                          <br>${response['offers_count']}`;
        }
    });
}
function ViewRecentInfrastructuresFunction() {

    $.ajax({
        url: 'http://localhost:9090/api/newInfrastructures',
        type: 'GET',
        success: function(response) {
            populateRecentInfrastructures(response)
        }
    });
}

function ViewRecentOffersFunction() {

    $.ajax({
        url: 'http://localhost:9090/api/newOffers',
        type: 'GET',
        success: function(response) {
            populateRecentOffers(response)
        }
    });
}

function populateRecentInfrastructures(data){
    const container = $('#card_container_id');
    container.empty();

    data.slice(0,3).forEach((infrastructure, index) => {
        const offerHtml = `
                               <div class="col-lg-12">
                <div class="item">
                  <div class="row">
                    <div class="col-lg-4 col-sm-5">
                      <div class="image">
                        <img src="${"data:image/jpeg;base64," + infrastructure['infrastructure_image']}" alt="">
                      </div>
                    </div>
                    <div class="col-lg-8 col-sm-7">
                      <div class="right-content">
                        <h4>Infrastructura</h4>
                        <span>${infrastructure['infrastructure_name']}</span>
                        <div class="main-button">
                          <a href="http://localhost:9090/infrastructures">Toate Infrastructurile</a>
                        </div>
                        <p>${infrastructure['infrastructure_description']}</p>
                        <ul class="info">
                          <li><i class="fa fa-phone"></i> ${infrastructure['infrastructure_phone']}</li>
                          <liu><i class="fa fa-envelope"></i> ${infrastructure['infrastructure_email']}</liu>
                        </ul>
                        <div class="text-button">
                          <a href="http://localhost:9090/infrastructure/${infrastructure['infrastructure_id']}"> Mai multe detalii? <i class="fa fa-arrow-right"></i></a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>`;
        container.append(offerHtml);
    });
}

function populateRecentOffers(data){
    const container = $('#offer_container_id');
    container.empty();

    data.slice(0,3).forEach((offer, index) => {
        const description = offer['offer_description'];
        const truncatedDescription = description.length > 200 ? description.substring(0, 200) + '...' : description;
        const offerHtml = `
                               <div class="col-lg-12">
                <div class="item">
                  <div class="row">
                    <div class="col-lg-4 col-sm-5">
                      <div class="image">
                        <img src="${"data:image/jpeg;base64," + offer['offer_image']}" alt="">
                      </div>
                    </div>
                    <div class="col-lg-8 col-sm-7">
                      <div class="right-content">
                        <h4>Oferta</h4>
                        <span>${offer['offer_name']}</span>
                        <div class="main-button">
                          <a href="http://localhost:9090/offers">Toate Ofertele</a>
                        </div>
                        <p>${truncatedDescription}</p>
                        <ul class="info">
                          <li><i class="fa fa-phone"></i> ${offer['offer_phone']}</li>
                          <liu><i class="fa fa-envelope"></i> ${offer['offer_email']}</liu>
                        </ul>
                        <div class="text-button">
                          <a href="http://localhost:9090/offer/${offer['offer_id']}"> Mai multe detalii? <i class="fa fa-arrow-right"></i></a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>`;
        container.append(offerHtml);
    });
}

