package com.bookout.entity;

import com.bookout.database.dao.AvailableDateTimeDAOImpl;
import com.bookout.database.dao.UserDAOImpl;
import com.bookout.database.daointerfaces.AvailableDateTimeDAO;
import com.bookout.database.daointerfaces.UserDAO;

import java.io.Serializable;
import java.sql.SQLException;

public class Booking implements Serializable {
    private int id;
    private long userId;
    private int restaurantId;
    private long dateId;
    private int personsCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public long getDateId() {
        return dateId;
    }

    public void setDateId(long date) {
        this.dateId = date;
    }

    public int getPersonsCount() {
        return personsCount;
    }

    public void setPersonsCount(int personsCount) {
        this.personsCount = personsCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Booking other = (Booking) obj;

        if (this.id != other.id) {
            return false;
        }

        if (this.userId != other.getUserId()) {
            return false;
        }

        if (this.restaurantId != other.getRestaurantId()) {
            return false;
        }

        if (this.dateId != other.getDateId()) {
            return false;
        }

        if (this.personsCount != other.getPersonsCount()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 4;
        hash = 53 * hash;
        hash = (int) (53 * hash + this.id + this.userId + this.restaurantId);
        return hash;
    }


    //методы ниже используются в jsp странице
    public String getUserName() throws SQLException {
        UserDAO<User> userDAO = new UserDAOImpl();
        User user = userDAO.find(this.id);
        return user.getFirstName();
    }

    public String getUserPhone() throws SQLException {
        UserDAO<User> userDAO = new UserDAOImpl();
        User user = userDAO.find(this.id);
        return user.getMobile();
    }

    public String getDateAndTime() throws SQLException {
        AvailableDateTimeDAO<AvailableDateTime> dateDAO = new AvailableDateTimeDAOImpl();
        AvailableDateTime date = dateDAO.find(this.dateId);

        return date.getDateTime();
    }
}
