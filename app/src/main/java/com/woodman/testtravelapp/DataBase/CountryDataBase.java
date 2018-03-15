package com.woodman.testtravelapp.DataBase;

import com.woodman.testtravelapp.CountryName;
import com.woodman.testtravelapp.model.Country;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zver on 15.03.2018.
 */

public class CountryDataBase {
    private static List<Country> countries;

    public CountryDataBase() {
        countries = new ArrayList<Country>() {
            {
                add(new Country("Ukraine", CountryName.UKRAINE));
                add(new Country("German", CountryName.GERMAN));
                add(new Country("France", CountryName.FRANCE));
                add(new Country("United Kingdom", CountryName.UK));
                add(new Country("USA", CountryName.USA));
            }
        };
    }

    public List<Country> getAllContry() {
        return countries;
    }
}
