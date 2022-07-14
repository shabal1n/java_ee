package com.bookout.database.daointerfaces;

import java.sql.SQLException;
import java.util.List;

public interface AvailableDateTimeDAO<T> extends ObjectInterface<T> {
    List<T> getAvailableTimeByRestaurantId(int restaurantId) throws SQLException;
}
