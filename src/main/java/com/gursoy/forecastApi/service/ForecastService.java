package com.gursoy.forecastApi.service;

import com.gursoy.forecastApi.response.ForecastApiResponse;
import com.gursoy.forecastApi.response.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.gursoy.forecastApi.response.ForecastResponse;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class ForecastService {
    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    public ArrayList<ForecastApiResponse> getForecast(String city) {


        String url = "http://api.openweathermap.org/data/2.5/forecast?q={city name}&appid=920a16d77f4c94a75a12dca15378a95e";

        ForecastResponse forecastObject = restTemplate.getForObject(url, ForecastResponse.class, city);

        if(Objects.nonNull(forecastObject) && Objects.equals(forecastObject.cod, "200")) {
           java.util.List<List> listsFromResponse = forecastObject.list;
           return arrangeForecastResponse(listsFromResponse);
       }

       return null;

    }

    public ArrayList<ForecastApiResponse> arrangeForecastResponse(java.util.List<List> listsFromResponse){
        ForecastApiResponse forecastApiResponse = new ForecastApiResponse();
        ArrayList<ForecastApiResponse> forecastApiResponseList = new ArrayList<>();
        for (List list : listsFromResponse) {
            forecastApiResponse.setTempMax(list.main.getTempMax());
            forecastApiResponse.setHumidity(list.main.getHumidity());
            forecastApiResponse.setFeelsLike(list.main.getFeelsLike());
            forecastApiResponseList.add(forecastApiResponse);
        }

        return forecastApiResponseList;
    }
}
