package com.bookout.daointerfaces;

import java.util.List;

public interface ObjectInterface<T> {
    public void create(T t);
    public T find(long id);
    public List<T> findAll();
    public void update(T t);
    public void delete(T t);
}
