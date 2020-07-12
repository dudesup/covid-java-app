package com.sda.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {

    @JsonProperty("Country")
    private String country;
    @JsonProperty("CountryCode")
    private String countryCode;
    @JsonProperty("TotalConfirmed")
    private Long totalConfirmed;
    @JsonProperty("TotalDeaths")
    private Long totalDeaths;
    @JsonProperty("TotalRecovered")
    private Long totalRecovered;

}
