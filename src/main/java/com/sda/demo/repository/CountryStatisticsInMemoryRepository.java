package com.sda.demo.repository;

import com.sda.demo.model.CountryStatistics;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.Map;

@Repository
public class CountryStatisticsInMemoryRepository {
    private Map<String, CountryStatistics> statisticsMap;

    public CountryStatisticsInMemoryRepository(){
        this.statisticsMap=new HashMap<>();
        statisticsMap.put("pl", new CountryStatistics("pl", 10000L, 10L, 1L));
        statisticsMap.put("de", new CountryStatistics("de",2124234L, 1132L, 4423L));
    }

    public CountryStatistics getCountry(String countryCode){
        return statisticsMap.get(countryCode);
    }

    public Map<String, CountryStatistics> findAll(){
        return statisticsMap;
    }
}
