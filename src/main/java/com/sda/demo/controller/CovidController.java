package com.sda.demo.controller;

import com.sda.demo.model.CountryStatistics;
import com.sda.demo.service.ICountryStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/covid/country")
public class CovidController {

    private final ICountryStatisticsService iCountryStatisticsService;

    @Autowired
    public CovidController(@Qualifier("countryStatisticsInMemoryService") ICountryStatisticsService iCountryStatisticsService) {
        this.iCountryStatisticsService = iCountryStatisticsService;
    }

    @GetMapping("/{country}")
    public CountryStatistics getInfo(@PathVariable String country){ //if we have /{country} and String country (same name), we don't need @PathVariable
        return iCountryStatisticsService.getByCountry(country);
    }

    @GetMapping("/all")
    public Map<String, CountryStatistics> allCountries(){
        return null;
    }

    @PostMapping("/{country}")
    public void addCountry(@PathVariable String country, @RequestBody CountryStatistics countryStatistics){
        this.iCountryStatisticsService.add(countryStatistics);
    }


}
