package com.bookout.database.daointerfaces;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface ObjectInterface<T> {
    void create(T t) throws SQLException;
    T find(long id) throws SQLException;
    List<T> findAll() throws SQLException;
    void update(T t) throws SQLException;
}
