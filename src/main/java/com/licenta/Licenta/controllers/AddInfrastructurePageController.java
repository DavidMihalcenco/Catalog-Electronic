package com.licenta.Licenta.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddInfrastructurePageController {
    @GetMapping("/addInfrastructure")
    public String getAddInfraPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated() &&
                !authentication.getPrincipal().equals("anonymousUser")){
            model.addAttribute("isLoggedIn","");
        }
        return "addInfrastructure";
    }
}
