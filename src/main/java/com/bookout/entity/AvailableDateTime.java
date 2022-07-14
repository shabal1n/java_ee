package com.bookout.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

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

    public String getTime() throws ParseException {
        Date date = new SimpleDateFormat(dateTimePattern).parse(dateTime);
        return new SimpleDateFormat("H:mm").format(date);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final AvailableDateTime other = (AvailableDateTime) obj;
        if (!Objects.equals(this.dateTime, other.dateTime)) {
            return false;
        }

        if (this.restaurantId != other.restaurantId) {
            return false;
        }

        if (this.id != other.getId()) {
            return false;
        }

        if (this.booked != other.booked) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.dateTime != null ? this.dateTime.hashCode() : 0);
        hash = (int) (53 * hash + this.id);
        return hash;
    }
}
