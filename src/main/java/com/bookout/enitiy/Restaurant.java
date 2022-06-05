package com.bookout.enitiy;

import java.io.Serializable;

public class Restaurant implements Serializable {
    private int id;
    private int category_id;
    private String name;
    private String address;
    private int capacity;
    private double rating;
    private int curr_free_space;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getCurr_free_space() {
        return curr_free_space;
    }

    public void setCurr_free_space(int curr_free_space) {
        this.curr_free_space = curr_free_space;
    }
}
