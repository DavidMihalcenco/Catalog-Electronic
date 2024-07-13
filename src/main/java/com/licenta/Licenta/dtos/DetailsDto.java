package com.licenta.Licenta.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class DetailsDto {
    @JsonProperty
    public String infrastructures_count;
    @JsonProperty
    public String offers_count;
}
