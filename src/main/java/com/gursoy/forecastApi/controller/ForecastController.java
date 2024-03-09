package com.gursoy.forecastApi.controller;

import com.gursoy.forecastApi.response.ForecastApiResponse;
import com.gursoy.forecastApi.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class ForecastController {
    @Autowired
    private ForecastService forecastService;

    @GetMapping("/forecast")
    public ArrayList<ForecastApiResponse> getProducts(@RequestParam(value = "city", required = true)String city) throws IOException {
         return forecastService.getForecast(city);

    }

}
