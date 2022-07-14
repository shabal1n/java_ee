package com.bookout.database.daointerfaces;

import com.bookout.entity.User;

import java.sql.SQLException;

public interface UserDAO<T> extends ObjectInterface<T> {
    User getUserByEmail(String email) throws SQLException;
    User getUserByPhone(String phone) throws SQLException;
}
