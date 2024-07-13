package com.licenta.Licenta.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class InfrastructureDto {

    @JsonProperty
    public String infrastructure_name;
    @JsonProperty
    public String infrastructure_description;

    @JsonProperty
    public Integer user_id;

    @JsonProperty
    public String infrastructure_email;

    @JsonProperty
    public String infrastructure_phone;

    @JsonProperty
    public String infrastructure_benefits;

    @JsonProperty
    public String infrastructure_access_info;

    @JsonProperty
    public String infrastructure_tehnical_specification;

    @JsonProperty
    public String infrastructure_key_words;

    @JsonProperty
    public boolean private_status;

    @JsonProperty
    public LocalDate infrastructure_data_publication;

    @JsonProperty
    public Double infrastructure_lon;

    @JsonProperty
    public Double infrastructure_lat;
}
