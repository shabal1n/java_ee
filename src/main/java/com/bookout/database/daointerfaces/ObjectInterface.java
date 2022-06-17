package com.bookout.database.daointerfaces;

import java.sql.SQLException;
import java.util.List;

public interface ObjectInterface<T> {
    public void create(T t) throws SQLException;
    public T find(long id) throws SQLException;
    public List<T> findAll() throws SQLException;
    public void update(T t) throws SQLException;
}
