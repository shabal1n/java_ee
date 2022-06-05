package com.bookout.daointerfaces;

import java.util.List;

public interface RestaurantDAOInterface<T> extends ObjectInterface<T> {
    public List<T> getRestaurantsByCategoryId();
}
