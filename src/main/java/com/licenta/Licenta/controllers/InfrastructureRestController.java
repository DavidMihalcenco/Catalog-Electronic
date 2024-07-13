package com.licenta.Licenta.controllers;

import com.licenta.Licenta.dtos.InfrastructureDto;
import com.licenta.Licenta.dtos.InfrastructurePageDto;
import com.licenta.Licenta.dtos.ViewInfrastructureDto;
import com.licenta.Licenta.repositories.InfrastructuresImagesRepository;
import com.licenta.Licenta.services.InfrastructureService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class InfrastructureRestController {
    private final InfrastructureService infrastructureService;

    public InfrastructureRestController(InfrastructureService infrastructureService, InfrastructuresImagesRepository infrastructuresImagesRepository) {
        this.infrastructureService = infrastructureService;
    }

    @PostMapping(value = "addInfra", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void addInfraDataBase(@RequestPart("InfrastructureDto") InfrastructureDto infrastructureDto,
                                   @RequestPart("image") MultipartFile image){
        infrastructureService.save(infrastructureDto, image);
    }

    @GetMapping("/api/infrastructure/{id}")
    public InfrastructurePageDto getInfrastructureImages(@PathVariable("id") Integer id) {
        return infrastructureService.getViewInfrastructure(id);
    }

    @GetMapping("/api/allInfrastructures")
    public List<ViewInfrastructureDto> getInfrastructures(){
        return infrastructureService.getAllInfrastructures();
    }

    @GetMapping("/api/searchInfrastructures")
    public List<ViewInfrastructureDto> searchInfrastructures(@RequestParam(value = "name", required = false) String name){
        return infrastructureService.searchInfrastructures(name);
    }

    @GetMapping("/api/newInfrastructures")
    public List<ViewInfrastructureDto> getNewInfrastructures(){
        return infrastructureService.getNewInfrastructures();
    }

}
