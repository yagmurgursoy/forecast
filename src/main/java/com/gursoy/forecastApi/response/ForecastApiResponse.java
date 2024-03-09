package com.gursoy.forecastApi.response;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class ForecastApiResponse {
    public Double feelsLike;
    public Double tempMax;
    public Integer humidity;


}
