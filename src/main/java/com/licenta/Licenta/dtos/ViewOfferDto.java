package com.licenta.Licenta.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class ViewOfferDto {

    @JsonProperty
    public String offer_name;

    @JsonProperty
    public String offer_phone;

    @JsonProperty
    public String offer_description;

    @JsonProperty
    public byte[] offer_image;

    @JsonProperty
    public Integer offer_id;

    @JsonProperty
    public String offer_email;

    @JsonProperty
    public boolean public_status;

    @JsonProperty
    public LocalDate offer_data_publication;
}
