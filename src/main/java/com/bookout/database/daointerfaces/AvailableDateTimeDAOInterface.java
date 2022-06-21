package com.bookout.database.daointerfaces;

import java.sql.SQLException;
import java.util.List;

public interface AvailableDateTimeDAOInterface<T> extends ObjectInterface<T> {
    List<T> getByRestaurantId(int restaurantId) throws SQLException;
}
