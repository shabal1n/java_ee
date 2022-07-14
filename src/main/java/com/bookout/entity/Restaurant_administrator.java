package com.bookout.entity;

import java.io.Serializable;

public class Restaurant_administrator implements Serializable {
    private int userId;
    private int restaurantId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Restaurant_administrator other = (Restaurant_administrator) obj;
        if (this.userId != other.getUserId()) {
            return false;
        }

        if (this.restaurantId != other.getRestaurantId()) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash;
        hash = (int) (53 * hash + this.userId + this.restaurantId);
        return hash;
    }
}
