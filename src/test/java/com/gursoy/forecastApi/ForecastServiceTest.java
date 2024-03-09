package com.gursoy.forecastApi;

import com.gursoy.forecastApi.response.ForecastApiResponse;
import com.gursoy.forecastApi.response.ForecastResponse;
import com.gursoy.forecastApi.service.ForecastService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


@ExtendWith(MockitoExtension.class)
public class ForecastServiceTest {

    @Mock
    private RestTemplate restTemplate;



    @InjectMocks
    private ForecastService forecastService = new ForecastService();

    @Test
    public void isFirstInfoCorrect(){
        ForecastApiResponse forecastApiResponse= new ForecastApiResponse();
        forecastApiResponse.setFeelsLike(285.53);
        forecastApiResponse.setHumidity(64);
        forecastApiResponse.setTempMax(286.47);

        Mockito.when(restTemplate.getForEntity("http://api.openweathermap.org/data/2.5/forecast?q=London&appid=920a16d77f4c94a75a12dca15378a95e", ForecastResponse.class))
                .thenReturn(new ResponseEntity(forecastApiResponse, HttpStatus.OK));

        ArrayList<ForecastApiResponse> forecastResponse = forecastService.getForecast("London");

        Assertions.assertNotEquals(forecastApiResponse.getFeelsLike(),forecastResponse.get(0).getFeelsLike());


    }
}
