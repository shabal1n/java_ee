package com.bookout.enitiy;

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
    private long date_id;
    private int numOfPersons;

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
        return date_id;
    }

    public void setDateId(long date) {
        this.date_id = date;
    }

    public int getNumOfPersons() {
        return numOfPersons;
    }

    public void setNumOfPersons(int numOfPersons) {
        this.numOfPersons = numOfPersons;
    }

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
        AvailableDateTime date = dateDAO.find(this.date_id);

        return date.getDateTime();
    }
}
