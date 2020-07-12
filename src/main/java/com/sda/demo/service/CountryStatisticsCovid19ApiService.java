package com.sda.demo.service;

import com.sda.demo.model.CountryStatistics;
import com.sda.demo.model.Covid19AApiSummaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryStatisticsCovid19ApiService implements ICountryStatisticsService{

    private final RestTemplate restTemplate;

    @Autowired
    public CountryStatisticsCovid19ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public CountryStatistics getByCountry(String countryCode) {
        Covid19AApiSummaryResponse response = restTemplate.getForObject("/summary", Covid19AApiSummaryResponse.class);

        CountryStatistics countryStatistics = response
                .getCountries()
                .stream()
                .filter(country -> country.getCountryCode().equalsIgnoreCase(countryCode))
                .findFirst()
                .map(country -> new CountryStatistics(country.getCountryCode(),
                        country.getTotalConfirmed(),
                        country.getTotalDeaths(),
                        country.getTotalRecovered()))
                .orElse(new CountryStatistics("", 0L, 0L, 0L));

        return countryStatistics;
    }

    @Override
    public void add(CountryStatistics countryStatistics) {
        throw new UnsupportedOperationException("You cannot add data to external API");
    }


    public List<CountryStatistics> findAll() {
        Covid19AApiSummaryResponse response = restTemplate.getForObject("/summary", Covid19AApiSummaryResponse.class);

        List<CountryStatistics> countryStatistics = response
                .getCountries()
                .stream()
                .map(country -> new CountryStatistics(country.getCountryCode(),
                        country.getTotalConfirmed(),
                        country.getTotalDeaths(),
                        country.getTotalRecovered()))
                .collect(Collectors.toList());

        return countryStatistics;
    }
}
