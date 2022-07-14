package com.bookout.database.daointerfaces;

import java.sql.SQLException;
import java.util.List;

public interface RestaurantDAO<T> extends ObjectInterface<T> {
    List<T> getRestaurantsByCategoryId(int id, int localId) throws SQLException;
    List<T> findAllRestaurantsByLocalizationId(int localId) throws SQLException;
    T findRestaurantByLocalizationId(long id, int localId) throws SQLException;
}
