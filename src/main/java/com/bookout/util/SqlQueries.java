package com.bookout.util;

import com.bookout.database.ConnectionPool;

public class SqlQueries {

    public static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    //UserDAO queries
    public static final String INSERT_USER =
            "INSERT INTO user_info(first_name, mobile, email, password_hash, local_id, isadmin) VALUES" +
                    "(?, ?, ?, ?, ?, ?);";
    public static final String FIND_USER = "SELECT * FROM user_info WHERE id = ?;";
    public static final String FIND_ALL_USERS = "SELECT * FROM user_info;";
    public static final String UPDATE_USER = "UPDATE user_info " +
            "SET first_name = ?, mobile = ?, email = ?, password_hash = ?, local_id = ?, isadmin = ?" +
            "WHERE id = ?;";
    public static final String FIND_USER_EMAIL = "SELECT * FROM user_info WHERE email = ?;";
    public static final String FIND_USER_PHONE = "SELECT * FROM user_info WHERE mobile = ?;";
    //RestaurantsDAO queries
    public static final String INSERT_RESTAURANT = "INSERT INTO restaurant(local_item_id, category_id, name, image, address, capacity, rating, curr_free_space, local_id) VALUES" +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String FIND_RESTAURANT = "SELECT * FROM restaurant WHERE id = ?;";
    public static final String FIND_RESTAURANT_LOCAL = "SELECT * FROM restaurant WHERE local_item_id = ? AND local_id = ?;";
    public static final String FIND_ALL_RESTAURANTS = "SELECT * FROM restaurant;";
    public static final String FIND_ALL_RESTAURANTS_LOCAL = "SELECT * FROM restaurant WHERE local_id = ?;";
    public static final String UPDATE_RESTAURANT = "UPDATE restaurant " +
            "SET category_id = ?, local_item_id = ?, name = ?, image = ?, address = ?, capacity = ?, rating = ?, curr_free_space = ?, local_id = ?" +
            "WHERE id = ?;";
    public static final String FIND_RESTAURANTS_CATEGORY = "SELECT * FROM restaurant WHERE category_id = ? AND local_id = ?;";
    public static final String FIND_RESTAURANTS_NAME = "SELECT * FROM restaurant WHERE ? LIKE '%' || name || '%' AND local_id = ?;";
    //BoookingDAO queries
    public static final String INSERT_BOOKING = "INSERT INTO booking(user_id, restaurant_id, date_id, num_of_persons) VALUES" +
            "(?, ?, ?, ?);";
    public static final String FIND_BOOKING = "SELECT * FROM booking WHERE id = ?;";
    public static final String FIND_ALL_BOOKINGS = "SELECT * FROM booking;";
    public static final String UPDATE_BOOKING = "UPDATE booking " +
            "SET user_id = ?, restaurant_id = ?, date_id = ?, num_of_persons = ?" +
            "WHERE id = ?;";
    //AvailableDateTime queries
    public static final String FIND_AVAILABLE = "SELECT * FROM Available_date_time WHERE id = ?;";
    public static final String FIND_ALL_AVAILABLE = "SELECT * FROM Available_date_time;";
    public static final String INSERT_AVAILABLE = "INSERT INTO Available_date_time(restaurant_id, date_time, booked)" +
            "VALUES(?, ?, ?);";
    public static final String UPDATE_AVAILABLE = "UPDATE available_date_time " +
            "SET booked = ? WHERE id = ?;";
    public static final String FIND_AVAILABLE_BY_RESTAURANT = "SELECT * FROM Available_date_time WHERE restaurant_id = ?;";
    public static final String FIND_AVAILABLE_BY_RESTAURANT_AND_DATE = "SELECT * FROM Available_date_time WHERE restaurant_id = ? AND date_time = ?;";
}
