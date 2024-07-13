package com.licenta.Licenta.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.licenta.Licenta.dtos.DetailsDto;
import com.licenta.Licenta.dtos.TokenDto;
import com.licenta.Licenta.dtos.UserDto;
import com.licenta.Licenta.entities.Infrastructure;
import com.licenta.Licenta.entities.Offer;
import com.licenta.Licenta.entities.User;
import com.licenta.Licenta.repositories.InfrastructureRepository;
import com.licenta.Licenta.repositories.OfferRepository;
import com.licenta.Licenta.repositories.UserRepository;
import com.nimbusds.jose.util.IOUtils;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.keycloak.jose.jwk.JWK;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final InfrastructureRepository infrastructureRepository;
    private final OfferRepository offerRepository;
    public void saveUser(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent())
            return;

        userRepository.save(new User(null, email, email,null));
    }
    @SneakyThrows
    public void saveUserJWT(@JsonProperty("access_token") String str) {
        JWT jwt = JWTParser.parse(str);
        String email = (String) jwt.getJWTClaimsSet().getClaims().get("email");
        if (email != null){
            saveUser(email);
        }

        assert email != null;
        if (email.endsWith("upb.ro") && jwt.getJWTClaimsSet().getBooleanClaim("email_verified")) {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("client_id", "client-licena");
            params.add("client_secret", "aKgAUuXq76vwEZ9NDkXCLkI96nkITVjC");
            params.add("grant_type", "client_credentials");

            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, new HttpHeaders());
            ResponseEntity<TokenDto> accessTokenDto = new RestTemplate().exchange("http://localhost:8080/realms/licenta/protocol/openid-connect/token", HttpMethod.POST, entity, TokenDto.class);
            if (accessTokenDto.getBody().accessToken != null) {
                String x = "[\n" +
                        "    {\n" +
                        "        \"id\": \"690f8143-8546-401b-8e1f-d37c65d818f6\",\n" +
                        "        \"name\": \"privilegiat\",\n" +
                        "        \"description\": \"\",\n" +
                        "        \"composite\": false,\n" +
                        "        \"clientRole\": true,\n" +
                        "        \"containerId\": \"bf4e06c3-2ced-45b4-8533-c130200a6c0c\"\n" +
                        "    }\n" +
                        "]";
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.add("Authorization", "Bearer " + accessTokenDto.getBody().accessToken);
                httpHeaders.add("Content-Type", "application/json");

                HttpEntity<String> entity1 = new HttpEntity<>(x, httpHeaders);
                ResponseEntity<String> response = new RestTemplate().exchange("http://localhost:8080/admin/realms/licenta/users/"+jwt.getJWTClaimsSet().getClaim("sub")+"/role-mappings/clients/bf4e06c3-2ced-45b4-8533-c130200a6c0c", HttpMethod.POST, entity1, String.class);

            }
        }

    }

    public UserDto getUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = ((Jwt)authentication.getCredentials()).getClaim("email");
        Optional<User> optionalUser = userRepository.findByEmail(userEmail);

        return UserDto.builder()
                .user_email(optionalUser.get().getEmail())
                .user_name(optionalUser.get().getUser_name())
                .user_image(optionalUser.get().getImage())
                .user_id(optionalUser.get().getUser_id())
                .build();
    }

    public DetailsDto getUserOfferInfraCount(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = ((Jwt)authentication.getCredentials()).getClaim("email");
        Optional<User> optionalUser = userRepository.findByEmail(userEmail);
        Integer userId = optionalUser.get().getUser_id();

        List<Infrastructure> infrastructures = infrastructureRepository.findByUser_id(userId);
        List<Offer> offers = offerRepository.findByUser_id(userId);
        String infrCount = String.valueOf(infrastructures.stream().count());
        String offerCount = String.valueOf(offers.stream().count());

        return DetailsDto.builder()
                .infrastructures_count(infrCount)
                .offers_count(offerCount)
                .build();
    }

    @SneakyThrows
    public void modifyProfile(MultipartFile image){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = ((Jwt)authentication.getCredentials()).getClaim("email");
        Optional<User> optionalUser = userRepository.findByEmail(userEmail);

        optionalUser.get().setImage(image.getBytes());
        userRepository.save(optionalUser.get());
    }
}
