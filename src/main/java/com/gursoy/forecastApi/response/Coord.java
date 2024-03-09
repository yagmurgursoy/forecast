
package com.gursoy.forecastApi.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lat",
    "lon"
})
public class Coord {

    @JsonProperty("lat")
    public Double lat;
    @JsonProperty("lon")
    public Double lon;

}
