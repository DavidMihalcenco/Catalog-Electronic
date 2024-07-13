package com.licenta.Licenta.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class UserDto {
    @JsonProperty
    public String user_name;

    @JsonProperty
    public String user_email;

    @JsonProperty
    public byte[] user_image;

    @JsonProperty
    public Integer user_id;
}
