package com.bookout.database.daointerfaces;

import com.bookout.enitiy.Booking;

import java.sql.SQLException;
import java.util.List;

public interface BookingDAOInterface<T> extends ObjectInterface<T> {
    public T getByRestaurantIdAndDate(int restaurantId, String date);
    public List<Booking> getBookingByUserId(long id) throws SQLException;
}
