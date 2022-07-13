package com.bookout.database.daointerfaces;

import java.sql.SQLException;
import java.util.List;

public interface RestaurantDAO<T> extends ObjectInterface<T> {
    List<T> getRestaurantsByCategoryId(int id, int localId) throws SQLException;

    List<T> findAllByLocal(int localId) throws SQLException;
    T findByLocal(long id, int localId) throws SQLException;
}
