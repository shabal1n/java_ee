package com.bookout.database.daointerfaces;

import java.sql.SQLException;
import java.util.List;

public interface RestaurantDAOInterface<T> extends ObjectInterface<T> {
    public List<T> getRestaurantsByCategoryId(int id) throws SQLException;
    public List<T> getRestaurantsByName(String search) throws SQLException;
}
