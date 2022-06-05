package com.bookout.daointerfaces;

import com.bookout.enitiy.User;

public interface UserDAOInterface<T> extends ObjectInterface<T> {
    public User getByEmail(String email);
    public User getByPhone(String email);
}
