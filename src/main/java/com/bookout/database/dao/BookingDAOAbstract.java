package com.bookout.database.dao;

import com.bookout.database.daointerfaces.BookingDAO;
import com.bookout.entity.Booking;

import java.sql.SQLException;

public abstract class BookingDAOAbstract implements BookingDAO<Booking> {

    public void update(Booking t) throws SQLException {}
}
