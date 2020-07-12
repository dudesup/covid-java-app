package com.sda.demo.task;



import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sda.demo.model.CountryStatistics;
import com.sda.demo.service.CountryStatisticsCovid19ApiService;
import com.sda.demo.service.CountryStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private final CountryStatisticsCovid19ApiService countryStatisticsCovid19ApiService;
    private final CountryStatisticsService countryStatisticsService;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    @Autowired
    public ScheduledTasks(CountryStatisticsCovid19ApiService countryStatisticsCovid19ApiService, CountryStatisticsService countryStatisticsService) {
        this.countryStatisticsCovid19ApiService = countryStatisticsCovid19ApiService;
        this.countryStatisticsService = countryStatisticsService;
    }

    @Scheduled(fixedRate = 15000)
    public void reportCurrentTime() {
        log.debug("getting data");
        List<CountryStatistics> result = countryStatisticsCovid19ApiService.findAll();
        log.debug("Saving data size: " + result.size());
        result.forEach(countryStatistics -> countryStatisticsService.add(countryStatistics));
    }
}