package com.licenta.Licenta.controllers;

import com.licenta.Licenta.dtos.*;
import com.licenta.Licenta.services.SiteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SiteRestController {
    private final SiteService siteService;

    public SiteRestController(SiteService siteService) {
        this.siteService = siteService;
    }

    @GetMapping("/api/getDetails")
    public DetailsDto getDetails(){
        return siteService.getDetails();
    }

    @GetMapping("/api/viewUserOwner/{id}")
    public UserDto getUserOwner(@PathVariable("id") Integer id) {
        return siteService.getViewUserOwner(id);
    }

    @GetMapping("/api/userOfferInfraCount/{id}")
    public DetailsDto getUserOwnerDetails(@PathVariable("id") Integer id) {
        return siteService.getViewUserOwnerDetails(id);
    }

    @GetMapping("/api/ownerInfrastructures/{id}")
    public List<ViewInfrastructureDto> getOwnerInfrastructures(@PathVariable("id") Integer id) {
        return siteService.getOwnerInfrastructures(id);
    }

    @GetMapping("/api/ownerOffers/{id}")
    public List<ViewOfferDto> getOwnerOffers(@PathVariable("id") Integer id) {
        return siteService.getOwnerOffers(id);
    }
}
