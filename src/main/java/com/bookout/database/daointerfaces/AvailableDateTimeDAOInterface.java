package com.bookout.database.daointerfaces;

import java.sql.SQLException;
import java.util.List;

public interface AvailableDateTimeDAOInterface<T> extends ObjectInterface<T> {
    public List<T> getByRestaurantId(int restaurantId) throws SQLException;
    public List<T> getByRestaurantIdAndDate(int restaurantId, String date);
}
