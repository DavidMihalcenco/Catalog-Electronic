package com.licenta.Licenta.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class InfrastructurePageDto {

    @JsonProperty
    public String infrastructure_name;
    @JsonProperty
    public String infrastructure_description;

    @JsonProperty
    public byte[] infrastructure_image;

    @JsonProperty
    public Integer infrastructure_id;

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
    public Integer user_id;

    @JsonProperty
    public String user_email;

    @JsonProperty
    public String infrastructure_key_words;

    @JsonProperty
    public boolean private_status;

    @JsonProperty
    public Double infrastructure_lon;

    @JsonProperty
    public Double infrastructure_lat;
}
