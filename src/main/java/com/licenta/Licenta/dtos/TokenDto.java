package com.licenta.Licenta.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenDto {

    @JsonProperty(value = "access_token")
    public String accessToken;

    @JsonProperty(value = "refresh_token")
    public String refreshToken;

}
