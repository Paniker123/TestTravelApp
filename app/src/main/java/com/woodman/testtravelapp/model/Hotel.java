package com.woodman.testtravelapp.model;

/**
 * Created by Zver on 15.03.2018.
 */

public class Hotel {

    private String name;
    private String place;
    private double price;

    public Hotel() {
    }

    public Hotel(String name, String place, double price) {
        this.name = name;
        this.place = place;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
