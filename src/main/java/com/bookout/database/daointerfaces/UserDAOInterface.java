package com.bookout.database.daointerfaces;

import com.bookout.enitiy.User;

import java.sql.SQLException;

public interface UserDAOInterface<T> extends ObjectInterface<T> {
    public User getByEmail(String email) throws SQLException;
    public User getByPhone(String phone) throws SQLException;
}
