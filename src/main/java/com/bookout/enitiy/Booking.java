package com.bookout.enitiy;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking implements Serializable {
    private int id;
    private long userId;
    private int restaurantId;
    private long date_id;
    private int numOfPersons;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public long getDateId() {
        return date_id;
    }

    public void setDateId(long date) {
        this.date_id = date;
    }

    public int getNumOfPersons() {
        return numOfPersons;
    }

    public void setNumOfPersons(int numOfPersons) {
        this.numOfPersons = numOfPersons;
    }
}
