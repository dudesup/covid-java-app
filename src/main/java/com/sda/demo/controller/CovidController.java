package com.sda.demo.controller;

import com.sda.demo.model.CountryStatistics;
import com.sda.demo.service.CountryStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/covid/country")
public class CovidController {

    private final CountryStatisticsService countryStatisticsService;

    @Autowired
    public CovidController(CountryStatisticsService countryStatisticsService){
        this.countryStatisticsService=countryStatisticsService;
    }

    @GetMapping("/{country}")
    public CountryStatistics getInfo(@PathVariable String country){ //if we have /{country} and String country (same name), we don't need @PathVariable
        return countryStatisticsService.getByCountry(country);
//        return new CountryStatistics(10000, 100, 8790);
    }

    @GetMapping("/all")
    public Map<String, CountryStatistics> allCountries(){
        return countryStatisticsService.findAll();
    }
}
