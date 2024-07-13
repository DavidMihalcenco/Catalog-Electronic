package com.licenta.Licenta.controllers;

import com.licenta.Licenta.dtos.DetailsDto;
import com.licenta.Licenta.dtos.UserDto;
import com.licenta.Licenta.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class MyProfileRestController {
    private final UserService userService;

    public MyProfileRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/myProfile")
    public UserDto getUser(){
        return userService.getUserInfo();
    }

    @GetMapping("/api/userOfferInfraCount")
    public DetailsDto getUserDetails(){
        return userService.getUserOfferInfraCount();
    }

    @PutMapping ("/api/modifyMyProfile")
    public void modifyUserProfile(@RequestPart(value = "image", required = false) MultipartFile image){
        userService.modifyProfile(image);
    }
}
