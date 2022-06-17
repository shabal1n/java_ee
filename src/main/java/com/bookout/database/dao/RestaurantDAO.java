package com.bookout.database.dao;

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

import static com.bookout.util.SqlQueries.connectionPool;

public class RestaurantDAO implements RestaurantDAOInterface<Restaurant> {
    private static final Logger LOGGER = LogManager.getLogger(RestaurantDAO.class);

    @Override
    public void create(Restaurant restaurant) throws SQLException {
        Connection con = null;
        try {
            con = connectionPool.getConnection();
            PreparedStatement stmt = con.prepareStatement(SqlQueries.INSERT_RESTAURANT);
            stmt.setInt(1, restaurant.getLocalId());
            stmt.setInt(2, restaurant.getCategoryId());
            stmt.setString(3, restaurant.getName());
            stmt.setString(4, restaurant.getImageUrl());
            stmt.setString(5, restaurant.getAddress());
            stmt.setInt(6, restaurant.getCapacity());
            stmt.setDouble(7, restaurant.getRating());
            stmt.setInt(8, restaurant.getCurrFreeSpace());
            stmt.setInt(9, restaurant.getLocalId());
            int row_counter = stmt.executeUpdate();
            if (row_counter != 1)
                throw new SQLException("Inserted " + row_counter + " rows");

            stmt.close();
            connectionPool.returnConnection(con);

        } catch (Exception e) {
            if (con != null) con.close();
            LOGGER.error(e);
        }
    }

    @Override
    public Restaurant find(long id) throws SQLException {
        Connection conn = null;
        Restaurant restaurant = null;
        try {
            conn = connectionPool.getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.FIND_RESTAURANT);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                restaurant = new Restaurant();
                restaurant.setId(resultSet.getInt("id"));
                restaurant.setLocalItemId(resultSet.getInt("local_item_id"));
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
            connectionPool.returnConnection(conn);
        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
        return restaurant;
    }

    @Override
    public List<Restaurant> findAll() throws SQLException {
        Connection conn = null;
        List<Restaurant> list = null;
        try {
            conn = connectionPool.getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.FIND_ALL_RESTAURANTS);
            ResultSet resultSet = statement.executeQuery();
            list = new ArrayList<Restaurant>();

            while (resultSet.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(resultSet.getInt("id"));
                restaurant.setLocalItemId(resultSet.getInt("local_item_id"));
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
            connectionPool.returnConnection(conn);

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
        return list;
    }

    @Override
    public void update(Restaurant restaurant) throws SQLException {
        Connection conn = null;
        try {
            conn = connectionPool.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SqlQueries.UPDATE_RESTAURANT);
            stmt.setInt(1, restaurant.getCategoryId());
            stmt.setInt(2, restaurant.getLocalItemId());
            stmt.setString(3, restaurant.getName());
            stmt.setString(4, restaurant.getImageUrl());
            stmt.setString(5, restaurant.getAddress());
            stmt.setInt(6, restaurant.getCapacity());
            stmt.setDouble(7, restaurant.getRating());
            stmt.setInt(8, restaurant.getCurrFreeSpace());
            stmt.setInt(9, restaurant.getLocalId());
            stmt.setInt(10, restaurant.getId());

            stmt.close();
            connectionPool.returnConnection(conn);

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
    }

    @Override
    public List<Restaurant> getRestaurantsByCategoryId(int id) throws SQLException {
        Connection conn = null;
        List<Restaurant> list = null;
        try {
            conn = connectionPool.getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.FIND_RESTAURANTS_CATEGORY);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            list = new ArrayList<Restaurant>();

            while (resultSet.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(resultSet.getInt("id"));
                restaurant.setLocalItemId(resultSet.getInt("local_item_id"));
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
            connectionPool.returnConnection(conn);

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
        return list;
    }

    @Override
    public List<Restaurant> getRestaurantsByName(String search) throws SQLException {
        Connection conn = null;
        List<Restaurant> list = null;
        try {
            conn = connectionPool.getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.FIND_RESTAURANTS_NAME);
            statement.setString(1, search);
            ResultSet resultSet = statement.executeQuery();
            list = new ArrayList<Restaurant>();

            while (resultSet.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(resultSet.getInt("id"));
                restaurant.setLocalItemId(resultSet.getInt("local_item_id"));
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
            connectionPool.returnConnection(conn);

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
        return list;
    }
}
