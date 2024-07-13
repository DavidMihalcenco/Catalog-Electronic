package com.licenta.Licenta.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyInfrastructuresController {
    @GetMapping({"/myInfrastructures"})
    public String myInfrastructuresPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated() &&
                !authentication.getPrincipal().equals("anonymousUser")){
            model.addAttribute("isLoggedIn","");
        }
        return "myInfrastructures";
    }

    @GetMapping({"/modifyInfrastructure/{id}"})
    public String modifyInfrastructuresPage(@PathVariable("id") Integer id, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated() &&
                !authentication.getPrincipal().equals("anonymousUser")){
            model.addAttribute("isLoggedIn","");
        }
        return "modifyInfrastructures";
    }

}
