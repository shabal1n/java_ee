package com.bookout.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AvailableDateTime implements Serializable {
    private final String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
    private long id;
    private long restaurantId;
    private String dateTime;
    private boolean booked;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);
        LocalDateTime date = LocalDateTime.parse(dateTime, formatter);
        return new SimpleDateFormat("H:mm").format(date);
    }
}
