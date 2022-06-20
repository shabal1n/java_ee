package com.bookout.database.daointerfaces;

import java.sql.SQLException;
import java.util.List;

public interface RestaurantDAOInterface<T> extends ObjectInterface<T> {
    public List<T> getRestaurantsByCategoryId(int id, int local_id) throws SQLException;
    public List<T> getRestaurantsByName(String search, int local_id) throws SQLException;

    List<T> findAllByLocal(int local_id) throws SQLException;
    T findByLocal(long id, int local_id) throws SQLException;
}
