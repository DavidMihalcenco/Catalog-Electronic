package com.licenta.Licenta.controllers;

import com.licenta.Licenta.dtos.OfferDto;
import com.licenta.Licenta.dtos.ViewOfferDto;
import com.licenta.Licenta.services.OfferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class MyOffersRestController {
    private final OfferService offerService;

    public MyOffersRestController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/api/myOffers")
    public List<ViewOfferDto> getMyOffers(){
        return offerService.getMyOffers();
    }

    @PutMapping(value = "modifyOff", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void modifyOfferDataBase(@RequestPart("OfferDto") OfferDto offerDto,
                                    @RequestPart(value = "image", required = false) MultipartFile image,
                                    @RequestPart("offerId") String offerId){
        offerService.modify(offerDto, image, Integer.valueOf(offerId));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("deleteOffer/{id}")
    public String deleteOffer(@PathVariable("id") Integer id) {
        offerService.deleteOfferById(id);
        return "success";
    }
}
