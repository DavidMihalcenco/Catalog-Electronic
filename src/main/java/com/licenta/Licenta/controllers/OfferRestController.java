package com.licenta.Licenta.controllers;

import com.licenta.Licenta.dtos.OfferDto;
import com.licenta.Licenta.dtos.OfferPageDto;
import com.licenta.Licenta.dtos.ViewInfrastructureDto;
import com.licenta.Licenta.dtos.ViewOfferDto;
import com.licenta.Licenta.services.OfferService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class OfferRestController {
    private final OfferService offerService;

    public OfferRestController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping(value = "addOff", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void addInfraDataBase(@RequestPart("OfferDto") OfferDto offerDto,
                                 @RequestPart("image") MultipartFile image){
        offerService.saveOffer(offerDto, image);
    }

    @GetMapping("/api/offer/{id}")
    public OfferPageDto getOfferImages(@PathVariable("id") Integer id) {
        return offerService.getViewOffer(id);
    }

    @GetMapping("/api/allOffers")
    public List<ViewOfferDto> getOffers(){
        return offerService.getAllOffers();
    }

    @GetMapping("/api/searchOffers")
    public List<ViewOfferDto> searchOffers(@RequestParam("name") String name){
        return offerService.searchOffers(name);
    }

    @GetMapping("/api/newOffers")
    public List<ViewOfferDto> getNewOffers(){
        return offerService.getNewOffers();
    }
}
