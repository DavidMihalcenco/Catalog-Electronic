package com.licenta.Licenta.controllers;

import com.licenta.Licenta.dtos.ViewInfrastructureDto;
import com.licenta.Licenta.services.InfrastructureService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class InfrastructuresPageController {

    @GetMapping("/infrastructures")
    public String getInfrastructuresPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated() &&
                !authentication.getPrincipal().equals("anonymousUser")){
            model.addAttribute("isLoggedIn","");
        }
        return "infrastructures";
    }


    @GetMapping("/infrastructure/{id}")
    public String getInfrastructureImages(@PathVariable("id") Integer id, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated() &&
                !authentication.getPrincipal().equals("anonymousUser")){
            model.addAttribute("isLoggedIn","");
        }
        return "infrastructure";
    }
}
