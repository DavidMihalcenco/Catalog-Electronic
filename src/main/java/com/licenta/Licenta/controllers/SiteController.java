package com.licenta.Licenta.controllers;

import com.licenta.Licenta.entities.User;
import com.licenta.Licenta.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Objects;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class SiteController {
    private final UserRepository userRepository;

    @GetMapping("/viewUserOwner/{id}")
    public String getUserOwner(@PathVariable("id") Integer id, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = 0;

        if(authentication != null && authentication.isAuthenticated() &&
                !authentication.getPrincipal().equals("anonymousUser")){
            model.addAttribute("isLoggedIn","");
            String userEmail = ((Jwt)authentication.getCredentials()).getClaim("email");
            Optional<User> optionalUser = userRepository.findByEmail(userEmail);
            userId = optionalUser.get().getUser_id();
        }
        if(!Objects.equals(userId, id)){
            return "userOwnerPage";
        }else{
            return "userPage";
        }
    }

    @GetMapping("/ownerInfrastructures/{id}")
    public String getOwnerInfrastructures(@PathVariable("id") Integer id, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated() &&
                !authentication.getPrincipal().equals("anonymousUser")){
            model.addAttribute("isLoggedIn","");
        }
        return "ownerInfrastructures";
    }

    @GetMapping("/ownerOffers/{id}")
    public String getOwnerOffers(@PathVariable("id") Integer id, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated() &&
                !authentication.getPrincipal().equals("anonymousUser")){
            model.addAttribute("isLoggedIn","");
        }
        return "ownerOffers";
    }

    @GetMapping("/contact")
    public String getContactPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated() &&
                !authentication.getPrincipal().equals("anonymousUser")){
            model.addAttribute("isLoggedIn","");
        }
        return "contact";
    }
}
