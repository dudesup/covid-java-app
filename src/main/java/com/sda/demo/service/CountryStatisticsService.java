package com.sda.demo.service;

import com.sda.demo.model.CountryStatistics;
import com.sda.demo.repository.CountryStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CountryStatisticsService implements ICountryStatisticsService{

    private final CountryStatisticRepository countryStatisticRepository;

    @Autowired
    public CountryStatisticsService(CountryStatisticRepository countryStatisticRepository) {
        this.countryStatisticRepository = countryStatisticRepository;
    }

    @Override
    public CountryStatistics getByCountry(String countryCode){
        return this.countryStatisticRepository.findById(countryCode).orElse(new CountryStatistics(null, 0L,0L,0L));
    }

    @Override
    public void add(CountryStatistics countryStatistics) {
        this.countryStatisticRepository.save(countryStatistics);
    }

}
