package com.bookout.database.daointerfaces;

import java.sql.SQLException;

public interface ObjectInterface<T> {
    void create(T t) throws SQLException;
    T find(long id) throws SQLException;
    void update(T t) throws SQLException;
}
