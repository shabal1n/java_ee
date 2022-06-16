package com.bookout.database.dao;

import com.bookout.database.ConnectionPool;
import com.bookout.database.daointerfaces.RestaurantDAOInterface;
import com.bookout.enitiy.Restaurant;
import com.bookout.util.SqlQueries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO extends ConnectionPool implements RestaurantDAOInterface<Restaurant> {
    private static final Logger LOGGER = LogManager.getLogger(RestaurantDAO.class);

    @Override
    public void create(Restaurant restaurant) throws SQLException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement stmt = con.prepareStatement(SqlQueries.INSERT_RESTAURANT);
            stmt.setInt(1, restaurant.getCategoryId());
            stmt.setString(2, restaurant.getName());
            stmt.setString(3, restaurant.getImageUrl());
            stmt.setString(4, restaurant.getAddress());
            stmt.setInt(5, restaurant.getCapacity());
            stmt.setDouble(6, restaurant.getRating());
            stmt.setInt(7, restaurant.getCurrFreeSpace());
            stmt.setInt(8, restaurant.getLocalId());
            int row_counter = stmt.executeUpdate();
            if (row_counter != 1)
                throw new SQLException("Inserted " + row_counter + " rows");

            stmt.close();
            returnConnection(con);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        if (con != null) con.close();
    }

    @Override
    public Restaurant find(long id) throws SQLException {
        Connection conn = null;
        Restaurant restaurant = null;
        try {
            conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.FIND_RESTAURANT);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                restaurant = new Restaurant();
                restaurant.setId(resultSet.getInt("id"));
                restaurant.setCategoryId(resultSet.getInt("category_id"));
                restaurant.setName(resultSet.getString("name"));
                restaurant.setImageUrl(resultSet.getString("image"));
                restaurant.setAddress(resultSet.getString("address"));
                restaurant.setCapacity(resultSet.getInt("capacity"));
                restaurant.setRating(resultSet.getDouble("rating"));
                restaurant.setCurrFreeSpace(resultSet.getInt("curr_free_space"));
                restaurant.setLocalId(resultSet.getInt("local_id"));
            }
            statement.close();
            returnConnection(conn);

        } catch (Exception e) {
            LOGGER.error(e);
        }
        if (conn != null) conn.close();
        return restaurant;
    }

    @Override
    public List<Restaurant> findAll() throws SQLException {
        Connection conn = null;
        List<Restaurant> list = null;
        try {
            conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.FIND_ALL_RESTAURANTS);
            ResultSet resultSet = statement.executeQuery();
            list = new ArrayList<Restaurant>();

            while (resultSet.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(resultSet.getInt("id"));
                restaurant.setCategoryId(resultSet.getInt("category_id"));
                restaurant.setName(resultSet.getString("name"));
                restaurant.setImageUrl(resultSet.getString("image"));
                restaurant.setAddress(resultSet.getString("address"));
                restaurant.setCapacity(resultSet.getInt("capacity"));
                restaurant.setRating(resultSet.getDouble("rating"));
                restaurant.setCurrFreeSpace(resultSet.getInt("curr_free_space"));
                restaurant.setLocalId(resultSet.getInt("local_id"));

                list.add(restaurant);
            }
            statement.close();
            returnConnection(conn);

        } catch (Exception e) {
            LOGGER.error(e);
        }
        if (conn != null) conn.close();
        return list;
    }

    @Override
    public void update(Restaurant restaurant) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SqlQueries.UPDATE_RESTAURANT);
            stmt.setInt(1, restaurant.getCategoryId());
            stmt.setString(2, restaurant.getName());
            stmt.setString(3, restaurant.getImageUrl());
            stmt.setString(4, restaurant.getAddress());
            stmt.setInt(5, restaurant.getCapacity());
            stmt.setDouble(6, restaurant.getRating());
            stmt.setInt(7, restaurant.getCurrFreeSpace());
            stmt.setInt(8, restaurant.getLocalId());
            stmt.setInt(9, restaurant.getId());

            stmt.close();
            returnConnection(conn);

        } catch (Exception e) {
            LOGGER.error(e);
        }
        if (conn != null) conn.close();
    }

    @Override
    public void delete(Restaurant restaurant) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.DELETE_USER);
            statement.setLong(1, restaurant.getId());

            statement.close();
            returnConnection(conn);

        } catch (Exception e) {
            LOGGER.error(e);
        }
        if (conn != null) conn.close();
    }

    @Override
    public List<Restaurant> getRestaurantsByCategoryId(int id) throws SQLException {
        Connection conn = null;
        List<Restaurant> list = null;
        try {
            conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.FIND_RESTAURANTS_CATEGORY);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            list = new ArrayList<Restaurant>();

            while (resultSet.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(resultSet.getInt("id"));
                restaurant.setCategoryId(resultSet.getInt("category_id"));
                restaurant.setName(resultSet.getString("name"));
                restaurant.setImageUrl(resultSet.getString("image"));
                restaurant.setAddress(resultSet.getString("address"));
                restaurant.setCapacity(resultSet.getInt("capacity"));
                restaurant.setRating(resultSet.getDouble("rating"));
                restaurant.setCurrFreeSpace(resultSet.getInt("curr_free_space"));
                restaurant.setLocalId(resultSet.getInt("local_id"));

                list.add(restaurant);
            }
            statement.close();
            returnConnection(conn);

        } catch (Exception e) {
            LOGGER.error(e);
        }
        if (conn != null) conn.close();
        return list;
    }

    @Override
    public List<Restaurant> getRestaurantsByName(String search) throws SQLException {
        Connection conn = null;
        List<Restaurant> list = null;
        try {
            conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.FIND_RESTAURANTS_NAME);
            statement.setString(1, search);
            ResultSet resultSet = statement.executeQuery();
            list = new ArrayList<Restaurant>();

            while (resultSet.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(resultSet.getInt("id"));
                restaurant.setCategoryId(resultSet.getInt("category_id"));
                restaurant.setName(resultSet.getString("name"));
                restaurant.setImageUrl(resultSet.getString("image"));
                restaurant.setAddress(resultSet.getString("address"));
                restaurant.setCapacity(resultSet.getInt("capacity"));
                restaurant.setRating(resultSet.getDouble("rating"));
                restaurant.setCurrFreeSpace(resultSet.getInt("curr_free_space"));
                restaurant.setLocalId(resultSet.getInt("local_id"));

                list.add(restaurant);
            }
            statement.close();
            returnConnection(conn);

        } catch (Exception e) {
            LOGGER.error(e);
        }
        if (conn != null) conn.close();
        return list;
    }
}
