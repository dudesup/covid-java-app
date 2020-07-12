package com.sda.demo.service;

import com.sda.demo.model.CountryStatistics;
import com.sda.demo.repository.CountryStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class CountryStatisticsService implements ICountryStatisticsService{

    private final CountryStatisticRepository countryStatisticRepository;

    @Autowired
    public CountryStatisticsService(CountryStatisticRepository countryStatisticRepository) {
        this.countryStatisticRepository = countryStatisticRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public CountryStatistics getByCountry(String countryCode){
        return this.countryStatisticRepository.findById(countryCode).orElse(new CountryStatistics(null, 0L,0L,0L));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(CountryStatistics countryStatistics) {
        this.countryStatisticRepository.save(countryStatistics);
    }

}
