package com.licenta.Licenta.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class OfferDto {

    @JsonProperty
    public String offer_name;
    @JsonProperty
    public String offer_description;

    @JsonProperty
    public Integer offer_id;

    @JsonProperty
    public String offer_email;

    @JsonProperty
    public String offer_phone;

    @JsonProperty
    public String offer_colaborations;

    @JsonProperty
    public String offer_status;

    @JsonProperty
    public String offer_utilization;

    @JsonProperty
    public String offer_benefits;

    @JsonProperty
    public String offer_context;

    @JsonProperty
    public String offer_key_words;

    @JsonProperty
    public boolean private_status;

    @JsonProperty
    public LocalDate offer_data_publication;
}
