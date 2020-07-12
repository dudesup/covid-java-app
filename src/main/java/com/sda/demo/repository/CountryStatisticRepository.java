package com.sda.demo.repository;

import com.sda.demo.model.CountryStatistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryStatisticRepository extends CrudRepository<CountryStatistics, String> {

}
