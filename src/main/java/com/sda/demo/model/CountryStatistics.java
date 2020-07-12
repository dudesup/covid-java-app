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
    private int active;
    private int deaths;
    private int recovered;


    public CountryStatistics(int active, int deaths, int recoverred){
        this.active=active;
        this.deaths=deaths;
        this.recovered=recoverred;
    }

}
