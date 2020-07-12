package com.sda.demo.service;

import com.sda.demo.model.CountryStatistics;
import com.sda.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class CountryStatisticsService {
    CountryRepository countryRepository;

    @Autowired
    public CountryStatisticsService(CountryRepository countryRepository){
        this.countryRepository=countryRepository;
    }

    public CountryStatistics getByCountry(String countryCode) {
        CountryStatistics countryStatistics = countryRepository.getCountry(countryCode);
        if (countryCode==null){
            countryStatistics = new CountryStatistics(0, 0, 0);
        }
        return countryStatistics;
    }

    public Map<String, CountryStatistics> findAll(){
        return this.countryRepository.findAll();
    }
}
