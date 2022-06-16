package com.bookout.util;

public class SqlQueries {
    //UserDAO queries
    public static final String INSERT_USER =
            "INSERT INTO user_info(first_name, mobile, email, password_hash, local_id, isadmin) VALUES" +
                    "(?, ?, ?, ?, ?, ?)";
    public static final String FIND_USER = "SELECT * FROM user_info WHERE id = ?";
    public static final String FIND_ALL_USERS = "SELECT * FROM user_info";
    public static final String UPDATE_USER = "UPDATE user_info " +
            "SET first_name = ?, mobile = ?, email = ?, password_hash = ?, local_id = ?, isadmin = ?" +
            "WHERE id = ?";
    public static final String DELETE_USER = "DELETE FROM user_info WHERE id = ?";
    public static final String FIND_USER_EMAIL = "SELECT * FROM user_info WHERE email = ?";
    public static final String FIND_USER_PHONE = "SELECT * FROM user_info WHERE phone = ?";
    //RestaurantsDAO queries
    public static final String INSERT_RESTAURANT = "INSERT INTO restaurant(category_id, name, image, address, capacity, rating, curr_free_space, local_id) VALUES" +
            "(?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String FIND_RESTAURANT = "SELECT * FROM restaurant WHERE id = ?";
    public static final String FIND_ALL_RESTAURANTS = "SELECT * FROM restaurant";
    public static final String UPDATE_RESTAURANT = "UPDATE restaurant " +
            "SET category_id = ?, name = ?, image = ?, address = ?, capacity = ?, rating = ?, curr_free_space = ?, local_id = ?" +
            "WHERE id = ?";
    public static final String DELETE_RESTAURANT = "DELETE FROM restaurant WHERE id = ?";
    public static final String FIND_RESTAURANTS_CATEGORY = "SELECT * FROM restaurant WHERE category_id = ?";
    public static final String FIND_RESTAURANTS_NAME = "SELECT * FROM restaurant WHERE ? LIKE '%' || name || '%';";
    //BoookingDAO queries
    public static final String INSERT_BOOKING = "INSERT INTO booking(user_id, restaurant_id, date, num_of_persons) VALUES" +
            "(?, ?, ?, ?)";
    public static final String FIND_BOOKING = "SELECT * FROM booking WHERE id = ?";
    public static final String FIND_ALL_BOOKINGS = "SELECT * FROM booking";
    public static final String UPDATE_BOOKING = "UPDATE booking " +
            "SET user_id = ?, restaurant_id = ?, date = ?, num_of_persons = ?" +
            "WHERE id = ?";

}
