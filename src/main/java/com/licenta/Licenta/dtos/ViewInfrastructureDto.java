package com.licenta.Licenta.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class ViewInfrastructureDto {

    @JsonProperty
    public String infrastructure_name;

    @JsonProperty
    public String infrastructure_description;

    @JsonProperty
    public byte[] infrastructure_image;

    @JsonProperty
    public Integer infrastructure_id;

    @JsonProperty
    public String infrastructure_phone;

    @JsonProperty
    public String infrastructure_email;

    @JsonProperty
    public boolean public_status;

    @JsonProperty
    public LocalDate infrastructure_data_publication;
}
