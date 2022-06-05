package com.bookout.dao;

import com.bookout.daointerfaces.UserDAOInterface;
import com.bookout.enitiy.User;

import java.util.List;

public class UserDAO<T> implements UserDAOInterface<T> {

    protected User user;

    @Override
    public void create(Object o) {

    }

    @Override
    public T find(long id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public User getByPhone(String email) {
        return null;
    }
}
