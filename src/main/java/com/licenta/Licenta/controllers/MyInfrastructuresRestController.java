package com.licenta.Licenta.controllers;

import com.licenta.Licenta.dtos.InfrastructureDto;
import com.licenta.Licenta.dtos.ViewInfrastructureDto;
import com.licenta.Licenta.services.InfrastructureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class MyInfrastructuresRestController {
    private final InfrastructureService infrastructureService;

    public MyInfrastructuresRestController(InfrastructureService infrastructureService) {
        this.infrastructureService = infrastructureService;
    }

    @GetMapping("/api/myInfrastructures")
    public List<ViewInfrastructureDto> getMyInfrastructures(){
        return infrastructureService.getMyInfrastructures();
    }

    @PutMapping(value = "modifyInfra", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void modifyInfraDataBase(@RequestPart("InfrastructureDto") InfrastructureDto infrastructureDto,
                                 @RequestPart(value = "image", required = false) MultipartFile image,
                                    @RequestPart("infrastructureId") String infrastructureId){
        infrastructureService.modify(infrastructureDto, image, Integer.valueOf(infrastructureId));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("deleteInfrastructure/{id}")
    public String deleteInfrastructure(@PathVariable("id") Integer id) {
        infrastructureService.deleteInfrastructureById(id);
        return "success";
    }
}
