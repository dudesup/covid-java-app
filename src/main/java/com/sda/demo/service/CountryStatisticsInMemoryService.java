package com.sda.demo.service;

import com.sda.demo.model.CountryStatistics;
import com.sda.demo.repository.CountryStatisticsInMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class CountryStatisticsInMemoryService implements ICountryStatisticsService{
    CountryStatisticsInMemoryRepository countryStatisticsInMemoryRepository;

    @Autowired
    public CountryStatisticsInMemoryService(CountryStatisticsInMemoryRepository countryStatisticsInMemoryRepository){
        this.countryStatisticsInMemoryRepository = countryStatisticsInMemoryRepository;
    }

    @Override
    public CountryStatistics getByCountry(String countryCode) {
        CountryStatistics countryStatistics = countryStatisticsInMemoryRepository.getCountry(countryCode);
        if (countryCode==null){
            countryStatistics = new CountryStatistics(null, 0L, 0L, 0L);
        }
        return countryStatistics;
    }

    @Override
    public void add(CountryStatistics countryStatistics) {
        throw new UnsupportedOperationException("You cannot add data to external API");
    }

    public Map<String, CountryStatistics> findAll(){
        return this.countryStatisticsInMemoryRepository.findAll();
    }

}
