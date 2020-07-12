package com.sda.demo.repository;

import com.sda.demo.model.CountryStatistics;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CountryRepository {
    private Map<String, CountryStatistics> statisticsMap;

    public CountryRepository(){
        this.statisticsMap=new HashMap<>();
        statisticsMap.put("pl", new CountryStatistics(10000, 10, 1));
        statisticsMap.put("de", new CountryStatistics(2124234, 1132, 4423));
    }

    public CountryStatistics getCountry(String countryCode){
        return statisticsMap.get(countryCode);
    }

    public Map<String, CountryStatistics> findAll(){
        return statisticsMap;
    }
}
