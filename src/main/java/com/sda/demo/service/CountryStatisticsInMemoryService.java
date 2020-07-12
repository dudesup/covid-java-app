package com.sda.demo.service;

import com.sda.demo.model.CountryStatistics;
import com.sda.demo.repository.CountryStatisticsInMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class CountryStatisticsInMemoryService {
    CountryStatisticsInMemoryRepository countryStatisticsInMemoryRepository;

    @Autowired
    public CountryStatisticsInMemoryService(CountryStatisticsInMemoryRepository countryStatisticsInMemoryRepository){
        this.countryStatisticsInMemoryRepository = countryStatisticsInMemoryRepository;
    }

    public CountryStatistics getByCountry(String countryCode) {
        CountryStatistics countryStatistics = countryStatisticsInMemoryRepository.getCountry(countryCode);
        if (countryCode==null){
            countryStatistics = new CountryStatistics(0, 0, 0);
        }
        return countryStatistics;
    }

    public Map<String, CountryStatistics> findAll(){
        return this.countryStatisticsInMemoryRepository.findAll();
    }
}
