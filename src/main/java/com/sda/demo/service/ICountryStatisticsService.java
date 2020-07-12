package com.sda.demo.service;

import com.sda.demo.model.CountryStatistics;

import java.util.Map;

public interface ICountryStatisticsService {
    CountryStatistics getByCountry(String countryCode);
   // Map<String, CountryStatistics> findAll();

    void add(CountryStatistics countryStatistics);
}
