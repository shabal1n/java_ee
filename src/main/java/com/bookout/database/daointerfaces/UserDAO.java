package com.bookout.database.daointerfaces;

import com.bookout.enitiy.User;

import java.sql.SQLException;

public interface UserDAO<T> extends ObjectInterface<T> {
    User getByEmail(String email) throws SQLException;
    User getByPhone(String phone) throws SQLException;
}
