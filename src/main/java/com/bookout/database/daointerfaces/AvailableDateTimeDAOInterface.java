package com.bookout.database.daointerfaces;

import java.util.List;

public interface AvailableDateTimeDAOInterface<T> extends ObjectInterface<T> {
    public List<T> getByRestaurantId(int restaurantId);
    public List<T> getByRestaurantIdAndDate(int restaurantId, String date);
}
