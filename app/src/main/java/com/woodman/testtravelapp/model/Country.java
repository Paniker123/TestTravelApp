package com.woodman.testtravelapp.model;

import com.woodman.testtravelapp.CountryName;

/**
 * Created by Zver on 15.03.2018.
 */

public class Country {
    private String name;
    private CountryName countryName;

    public Country() {
    }

    public Country(String name, CountryName countryName) {
        this.name = name;
        this.countryName = countryName;
    }

    public String getName() {
        return name;
    }

    public CountryName getCountryName() {
        return countryName;
    }
}
