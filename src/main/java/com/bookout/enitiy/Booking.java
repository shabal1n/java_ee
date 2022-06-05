package com.bookout.enitiy;

import java.io.Serializable;

public class Booking implements Serializable {
    private int id;
    private int user_id;
    private int restaurant_id;
    private String date;
    private int num_of_persons;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNum_of_persons() {
        return num_of_persons;
    }

    public void setNum_of_persons(int num_of_persons) {
        this.num_of_persons = num_of_persons;
    }
}
