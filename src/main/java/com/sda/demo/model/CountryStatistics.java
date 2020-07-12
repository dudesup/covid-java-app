package com.sda.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country_statistics")
public class CountryStatistics {

    @Id
    @Column(length = 2, nullable = false, unique = true)
    private String countryCode;
    private int active;
    private int deaths;
    private int recoverred;

    public CountryStatistics() {
    }

    public CountryStatistics(int active, int deaths, int recoverred){

        this.active=active;
        this.deaths=deaths;
        this.recoverred=recoverred;

    }


    public void setActive(int active) {
        this.active = active;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setRecoverred(int recoverred) {
        this.recoverred = recoverred;
    }

    public int getActive() {
        return active;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getRecoverred() {
        return recoverred;
    }

}
