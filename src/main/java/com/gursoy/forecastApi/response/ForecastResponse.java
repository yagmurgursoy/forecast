
package com.gursoy.forecastApi.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cod",
    "message",
    "cnt",
    "list",
    "city"
})

public class ForecastResponse {

    @JsonProperty("cod")
    public String cod;
    @JsonProperty("message")
    public Integer message;
    @JsonProperty("cnt")
    public Integer cnt;
    @JsonProperty("list")
    public java.util.List<com.gursoy.forecastApi.response.List> list;
    @JsonProperty("city")
    public City city;

}
