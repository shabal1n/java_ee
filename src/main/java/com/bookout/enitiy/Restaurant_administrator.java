package com.bookout.enitiy;

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
}
