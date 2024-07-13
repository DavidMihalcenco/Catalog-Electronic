package com.licenta.Licenta.controllers;

import com.licenta.Licenta.dtos.TokenDto;
import com.licenta.Licenta.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class AuthRestController {

    private final UserService userService;

    public AuthRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/auth")
    public RedirectView auth(@RequestParam String code, HttpServletResponse rsp){
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", "client-licena");
        params.add("client_secret", "aKgAUuXq76vwEZ9NDkXCLkI96nkITVjC");
        params.add("grant_type", "authorization_code");
        params.add("code", code);
        params.add("redirect_uri", "http://localhost:9090/auth");
        params.add("scope", "openid");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, new HttpHeaders());
        ResponseEntity<TokenDto> accessTokenDto = new RestTemplate().exchange("http://localhost:8080/realms/licenta/protocol/openid-connect/token", HttpMethod.POST, entity, TokenDto.class);

        String accessToken = accessTokenDto.getBody().accessToken;
        String refreshToken = accessTokenDto.getBody().refreshToken;
        Cookie accessTokenCookie = new Cookie("access_token", accessToken);
        accessTokenCookie.setHttpOnly(true);
        accessTokenCookie.setPath("/");
        accessTokenCookie.setSecure(true);
        Cookie refreshTokenCookie = new Cookie("refresh_token", refreshToken);
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setSecure(true);

        rsp.addCookie(accessTokenCookie);
        rsp.addCookie(refreshTokenCookie);

        userService.saveUserJWT(accessTokenDto.getBody().accessToken);

        return new RedirectView("/");
    }

    @GetMapping("/dauth")
    public RedirectView deauth(HttpServletResponse rsp){
        Cookie accessTokenCookie = new Cookie("access_token", null);
        accessTokenCookie.setHttpOnly(true);
        accessTokenCookie.setPath("/");
        accessTokenCookie.setSecure(true);
        accessTokenCookie.setMaxAge(0);

        Cookie refreshTokenCookie = new Cookie("refresh_token", null);
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setSecure(true);
        refreshTokenCookie.setMaxAge(0);

        rsp.addCookie(accessTokenCookie);
        rsp.addCookie(refreshTokenCookie);

        return new RedirectView("/");
    }

    @GetMapping("/login")
    public RedirectView login(){
        return new RedirectView("http://localhost:8080/realms/licenta/protocol/openid-connect/auth?client_id=client-licena&response_type=code&scope=openid&redirect_uri=http://localhost:9090/auth&state=auth");
    }

    @GetMapping("/auth/logout")
    public RedirectView logout(){
        return new RedirectView("http://localhost:8080/realms/licenta/protocol/openid-connect/logout?post_logout_redirect_uri=http://localhost:9090/dauth&client_id=client-licena");
    }

}
