package com.woodman.testtravelapp.DataBase;

import com.woodman.testtravelapp.model.Hotel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zver on 15.03.2018.
 */

public class HotelDataBase {

    private static List<Hotel> hotels;

    public HotelDataBase() {
        hotels = new ArrayList<Hotel>() {
            {
                add(new Hotel("Jumeirah Crekside Motel", "Dubai", 800L));
                add(new Hotel("Dusit Than Dubai", "Dubai", 750L));
                add(new Hotel("City Premiere Hotel Apartments", "Dubai", 700L));
                add(new Hotel("Hotel Ternopil", "Ternopil, Ukrain", 200L));
                add(new Hotel("Hotel Lviv", "Lviv, Ukrain", 500L));
            }
        };
    }

    public List<Hotel> getAllHotels() {
        return hotels;
    }

    public void setHotel(Hotel hotel) {
        hotels.add(hotel);
    }
}
