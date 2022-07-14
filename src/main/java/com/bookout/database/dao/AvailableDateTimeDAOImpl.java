package com.bookout.database.dao;

import com.bookout.entity.AvailableDateTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.bookout.util.Constants.connectionPool;

public class AvailableDateTimeDAOImpl implements com.bookout.database.daointerfaces.AvailableDateTimeDAO<AvailableDateTime> {
    private final Logger LOGGER = LogManager.getLogger(AvailableDateTimeDAOImpl.class);
    private final String FIND_AVAILABLE = "SELECT * FROM Available_date_time WHERE id = ?;";
    private final String INSERT_AVAILABLE = "INSERT INTO Available_date_time(restaurant_id, date_time, booked)" +
            "VALUES(?, ?, ?);";
    private final String UPDATE_AVAILABLE = "UPDATE available_date_time " +
            "SET booked = ? WHERE id = ?;";
    private final String FIND_AVAILABLE_BY_RESTAURANT = "SELECT * FROM Available_date_time WHERE restaurant_id = ?;";



    @Override
    public List<AvailableDateTime> getAvailableTimeByRestaurantId(int restaurantId) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        List<AvailableDateTime> list = new ArrayList<>();
        try {
            conn = connectionPool.getConnection();
            statement = conn.prepareStatement(FIND_AVAILABLE_BY_RESTAURANT);
            statement.setLong(1, restaurantId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                AvailableDateTime available = new AvailableDateTime();
                available.setId(resultSet.getInt("id"));
                available.setRestaurantId(resultSet.getInt("restaurant_id"));
                available.setDateTime(resultSet.getString("date_time"));
                available.setBooked(resultSet.getBoolean("booked"));
                list.add(available);
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
    @Override
    public void create(AvailableDateTime availableDateTime) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = connectionPool.getConnection();
            stmt = con.prepareStatement(INSERT_AVAILABLE);
            stmt.setLong(1, availableDateTime.getRestaurantId());
            stmt.setString(2, availableDateTime.getDateTime());
            stmt.setBoolean(3, availableDateTime.isBooked());

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
    public AvailableDateTime find(long id) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        AvailableDateTime available = null;
        try {
            conn = connectionPool.getConnection();
            statement = conn.prepareStatement(FIND_AVAILABLE);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                available = new AvailableDateTime();
                available.setId(resultSet.getInt("id"));
                available.setRestaurantId(resultSet.getInt("restaurant_id"));
                available.setDateTime(resultSet.getString("date_time"));
                available.setBooked(resultSet.getBoolean("booked"));
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
        return available;
    }

    @Override
    public void update(AvailableDateTime availableDateTime) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = connectionPool.getConnection();
            statement = conn.prepareStatement(UPDATE_AVAILABLE);
            statement.setBoolean(1, availableDateTime.isBooked());
            statement.setLong(2, availableDateTime.getId());
            statement.executeUpdate();

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
            connectionPool.returnConnection(conn);
        }
    }
}
