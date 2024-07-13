package com.licenta.Licenta.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenActiveStatusDto {

    @JsonProperty(value = "active")
    public Boolean active;
}
