package com.licenta.Licenta.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class OfferPageDto {

    @JsonProperty
    public String offer_name;

    @JsonProperty
    public String offer_description;

    @JsonProperty
    public String offer_context;

    @JsonProperty
    public String offer_benefits;

    @JsonProperty
    public String offer_utilization;

    @JsonProperty
    public String offer_colaborations;

    @JsonProperty
    public String offer_status;

    @JsonProperty
    public String offer_phone;

    @JsonProperty
    public String offer_email;

    @JsonProperty
    public byte[] offer_image;

    @JsonProperty
    public Integer user_id;

    @JsonProperty
    public String user_email;

    @JsonProperty
    public String offer_key_words;

    @JsonProperty
    public boolean private_status;
}