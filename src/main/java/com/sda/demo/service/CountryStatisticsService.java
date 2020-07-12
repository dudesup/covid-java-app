package com.sda.demo.service;

import com.sda.demo.model.CountryStatistics;
import com.sda.demo.repository.CountryStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryStatisticsService {

    private final CountryStatisticRepository countryStatisticRepository;

    @Autowired
    public CountryStatisticsService(CountryStatisticRepository countryStatisticRepository) {
        this.countryStatisticRepository = countryStatisticRepository;
    }

    public CountryStatistics getByCountryCode(String countryCode){
        return this.countryStatisticRepository.findById(countryCode).orElse(new CountryStatistics(0,0,0));
    }

}
