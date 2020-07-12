package com.sda.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name="country_statistics")
public class CountryStatistics {

    @Id
    @Column(length = 2, nullable = false, unique = true)
    private String countyCode;
    private Long active;
    private Long deaths;
    private Long recovered;

    public CountryStatistics( Long active, Long deaths, Long recoverred){
        this(null, active, deaths, recoverred); //call more arguments constructor and atribute null
    }

    public CountryStatistics(String countyCode, Long active, Long deaths, Long recoverred){
        this.countyCode=countyCode;
        this.active=active;
        this.deaths=deaths;
        this.recovered=recoverred;
    }

}
