package com.licenta.Licenta.configuration;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

@Component
public class MyBearerTokenResolver implements BearerTokenResolver {
    @Override
    public String resolve(HttpServletRequest request) {
        Cookie cookie_access_token = WebUtils.getCookie(request, "access_token");

        if (cookie_access_token != null && cookie_access_token.getValue() != null) {
            return cookie_access_token.getValue();
        } else {
            return new DefaultBearerTokenResolver().resolve(request);
        }
    }
}


