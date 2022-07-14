package com.bookout.database.daointerfaces;


import java.sql.SQLException;
import java.util.List;

public interface BookingDAO<T> extends ObjectInterface<T> {

    List<T> getBookingsByRestaurantId(int restaurantId) throws SQLException;
}
