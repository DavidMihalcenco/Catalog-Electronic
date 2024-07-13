package com.licenta.Licenta.configuration;

import com.licenta.Licenta.dtos.TokenDto;
import com.licenta.Licenta.dtos.TokenActiveStatusDto;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private boolean isValid(String access_token) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", "client-licena");
        params.add("client_secret", "aKgAUuXq76vwEZ9NDkXCLkI96nkITVjC");
        params.add("token", access_token);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, new HttpHeaders());
        ResponseEntity<TokenActiveStatusDto> response = new RestTemplate().exchange("http://localhost:8080/realms/licenta/protocol/openid-connect/token/introspect", HttpMethod.POST, entity, TokenActiveStatusDto.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            TokenActiveStatusDto tokenResponse = response.getBody();
            if (tokenResponse != null) {
                return tokenResponse.active;
            }
        }

        return false;
    }

    private void getAndSetNewAccessToken(HttpServletResponse httpServletResponse, String access_token, String refresh_token) throws HttpClientErrorException {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("client_id", "client-licena");
            params.add("client_secret", "aKgAUuXq76vwEZ9NDkXCLkI96nkITVjC");
            params.add("grant_type", "refresh_token");
            params.add("refresh_token", refresh_token);

            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, new HttpHeaders());
            ResponseEntity<TokenDto> response = null;
            response = new RestTemplate().exchange("http://localhost:8080/realms/licenta/protocol/openid-connect/token", HttpMethod.POST, entity, TokenDto.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                TokenDto tokenResponse = response.getBody();
                if (tokenResponse != null) {
                    Cookie accessTokenCookie = new Cookie("access_token", tokenResponse.accessToken);
                    accessTokenCookie.setHttpOnly(true);
                    accessTokenCookie.setPath("/");

                    Cookie refreshTokenCookie = new Cookie("refresh_token", tokenResponse.refreshToken);
                    refreshTokenCookie.setHttpOnly(true);
                    refreshTokenCookie.setPath("/");

                    httpServletResponse.addCookie(accessTokenCookie);
                    httpServletResponse.addCookie(refreshTokenCookie);
                }
            }
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(new OncePerRequestFilter() {
                    @Override
                    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                        Cookie access_token_cookie = WebUtils.getCookie(request, "access_token");
                        Cookie refresh_token_cookie = WebUtils.getCookie(request, "refresh_token");
                        if (access_token_cookie != null && !isValid(access_token_cookie.getValue()) && refresh_token_cookie != null) {
                            try{
                                getAndSetNewAccessToken(response, access_token_cookie.getValue(), refresh_token_cookie.getValue());
                            } catch (Exception e) {
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

                                response.addCookie(accessTokenCookie);
                                response.addCookie(refreshTokenCookie);
                            }
                        }
                        filterChain.doFilter(request, response);
                    }
                }, BearerTokenAuthenticationFilter.class)
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/addInfrastructure").hasRole("privilegiat")
                        .requestMatchers("/addOffer").hasRole("privilegiat")
                        .requestMatchers("/auth").permitAll()
                        .anyRequest().permitAll())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .oauth2ResourceServer(oauth2 -> oauth2
                        .bearerTokenResolver(new MyBearerTokenResolver()).jwt(jwtConfigurer -> {
                            jwtConfigurer.decoder(JwtDecoders.fromOidcIssuerLocation("http://localhost:8080/realms/licenta"));
                            jwtConfigurer.jwtAuthenticationConverter(jwt -> {
                                Map<String, Collection<String>> realmAccess1 = jwt.getClaim("resource_access");
                                Map<String, Collection<String>> stringCollectionMap = (Map<String, Collection<String>>) realmAccess1.get("client-licena");
                                if (stringCollectionMap == null) {
                                    return new JwtAuthenticationToken(jwt, Collections.emptyList());
                                }
                                Collection<String> roles = stringCollectionMap.get("roles");
                                if (roles == null) {
                                    return new JwtAuthenticationToken(jwt, Collections.emptyList());
                                }
                                var grantedAuthorities = roles.stream()
                                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                                        .toList();
                                return new JwtAuthenticationToken(jwt, grantedAuthorities);
                            });
                        }));

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "PUT", "DELETE"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/", configuration);
        return source;
    }
}
