package com.bookout.database.daointerfaces;

import java.sql.SQLException;
import java.util.List;

public interface RestaurantDAOInterface<T> extends ObjectInterface<T> {
    List<T> getRestaurantsByCategoryId(int id, int local_id) throws SQLException;

    List<T> findAllByLocal(int local_id) throws SQLException;
    T findByLocal(long id, int local_id) throws SQLException;
}
