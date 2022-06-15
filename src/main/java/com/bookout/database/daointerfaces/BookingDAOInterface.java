package com.bookout.database.daointerfaces;

public interface BookingDAOInterface<T> extends ObjectInterface<T> {
    public T getByRestaurantIdAndDate(int restaurantId, String date);
}
