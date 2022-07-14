package com.bookout.database.dao;

import com.bookout.entity.Restaurant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.bookout.util.Constants.connectionPool;


public class RestaurantDAOImpl implements com.bookout.database.daointerfaces.RestaurantDAO<Restaurant> {
    private static final Logger LOGGER = LogManager.getLogger(RestaurantDAOImpl.class);

    private final String INSERT_RESTAURANT = "INSERT INTO restaurant(local_item_id, category_id, name, image, address, capacity, rating, local_id) VALUES" +
            "(?, ?, ?, ?, ?, ?, ?, ?);";
    private final String FIND_RESTAURANT = "SELECT * FROM restaurant WHERE id = ?;";
    private final String FIND_RESTAURANT_LOCAL = "SELECT * FROM restaurant WHERE local_item_id = ? AND local_id = ?;";
    private final String FIND_ALL_RESTAURANTS_LOCAL = "SELECT * FROM restaurant WHERE local_id = ?;";
    private final String UPDATE_RESTAURANT = "UPDATE restaurant " +
            "SET category_id = ?, local_item_id = ?, name = ?, image = ?, address = ?, capacity = ?, rating = ?, local_id = ?" +
            "WHERE id = ?;";
    private final String FIND_RESTAURANTS_CATEGORY = "SELECT * FROM restaurant WHERE category_id = ? AND local_id = ?;";

    @Override
    public void create(Restaurant restaurant) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = connectionPool.getConnection();
            stmt = con.prepareStatement(INSERT_RESTAURANT);
            stmt.setInt(1, restaurant.getLocalId());
            stmt.setInt(2, restaurant.getCategoryId());
            stmt.setString(3, restaurant.getName());
            stmt.setString(4, restaurant.getImageUrl());
            stmt.setString(5, restaurant.getAddress());
            stmt.setInt(6, restaurant.getCapacity());
            stmt.setDouble(7, restaurant.getRating());
            stmt.setInt(8, restaurant.getLocalId());
            int rowCounter = stmt.executeUpdate();
            if (rowCounter != 1)
                throw new SQLException("Inserted " + rowCounter + " rows");

        } catch (Exception e) {
            if (con != null) con.close();
            LOGGER.error(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            connectionPool.returnConnection(con);
        }
    }

    @Override
    public Restaurant find(long id) throws SQLException {
        Connection conn = null;
        Restaurant restaurant = null;
        PreparedStatement statement = null;
        try {
            conn = connectionPool.getConnection();
            statement = conn.prepareStatement(FIND_RESTAURANT);
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
                restaurant.setLocalId(resultSet.getInt("local_id"));
            }

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
            connectionPool.returnConnection(conn);
        }
        return restaurant;
    }

    @Override
    public void update(Restaurant restaurant) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = connectionPool.getConnection();
            stmt = conn.prepareStatement(UPDATE_RESTAURANT);
            stmt.setInt(1, restaurant.getCategoryId());
            stmt.setInt(2, restaurant.getLocalItemId());
            stmt.setString(3, restaurant.getName());
            stmt.setString(4, restaurant.getImageUrl());
            stmt.setString(5, restaurant.getAddress());
            stmt.setInt(6, restaurant.getCapacity());
            stmt.setDouble(7, restaurant.getRating());
            stmt.setInt(8, restaurant.getLocalId());
            stmt.setInt(9, restaurant.getId());

            int rowCounter = stmt.executeUpdate();
            if (rowCounter != 1)
                throw new SQLException("Inserted " + rowCounter + " rows");

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            connectionPool.returnConnection(conn);
        }
    }

    @Override
    public List<Restaurant> getRestaurantsByCategoryId(int id, int localId) throws SQLException {
        Connection conn = null;
        List<Restaurant> list = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            conn = connectionPool.getConnection();
            statement = conn.prepareStatement(FIND_RESTAURANTS_CATEGORY);
            statement.setLong(1, id);
            statement.setInt(2, localId);
            ResultSet resultSet = statement.executeQuery();

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
                restaurant.setLocalId(resultSet.getInt("local_id"));

                list.add(restaurant);
            }

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
            connectionPool.returnConnection(conn);
        }
        return list;
    }

    public Restaurant findRestaurantByLocalizationId(long id, int localId) throws SQLException {
        Connection conn = null;
        Restaurant restaurant = null;
        PreparedStatement statement = null;
        try {
            conn = connectionPool.getConnection();
            statement = conn.prepareStatement(FIND_RESTAURANT_LOCAL);
            statement.setLong(1, id);
            statement.setInt(2, localId);
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
                restaurant.setLocalId(resultSet.getInt("local_id"));
            }

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
            connectionPool.returnConnection(conn);
        }
        return restaurant;
    }

    public List<Restaurant> findAllRestaurantsByLocalizationId(int localId) throws SQLException {
        Connection conn = null;
        List<Restaurant> list = null;
        PreparedStatement statement = null;
        try {
            conn = connectionPool.getConnection();
            statement = conn.prepareStatement(FIND_ALL_RESTAURANTS_LOCAL);
            statement.setInt(1, localId);
            ResultSet resultSet = statement.executeQuery();
            list = new ArrayList<>();

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
                restaurant.setLocalId(resultSet.getInt("local_id"));
                list.add(restaurant);
            }

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
            connectionPool.returnConnection(conn);
        }
        return list;
    }
}
