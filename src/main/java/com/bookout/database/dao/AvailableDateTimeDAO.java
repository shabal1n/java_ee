package com.bookout.database.dao;

import com.bookout.database.daointerfaces.AvailableDateTimeDAOInterface;
import com.bookout.enitiy.AvailableDateTime;
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

public class AvailableDateTimeDAO implements AvailableDateTimeDAOInterface<AvailableDateTime> {
    private static final Logger LOGGER = LogManager.getLogger(AvailableDateTimeDAO.class);


    @Override
    public List<AvailableDateTime> getByRestaurantId(int restaurantId) throws SQLException {
        Connection conn = null;
        List<AvailableDateTime> list = new ArrayList<>();
        try {
            conn = connectionPool.getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.FIND_AVAILABLE_BY_RESTAURANT);
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

            statement.close();
            connectionPool.returnConnection(conn);
        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
        return list;
    }

    @Override
    public List<AvailableDateTime> getByRestaurantIdAndDate(int restaurantId, String date) {
        return null;
    }

    @Override
    public void create(AvailableDateTime availableDateTime) throws SQLException {
        Connection con = null;
        try {
            con = connectionPool.getConnection();
            PreparedStatement stmt = con.prepareStatement(SqlQueries.INSERT_AVAILABLE);
            stmt.setLong(1, availableDateTime.getRestaurantId());
            stmt.setString(2, availableDateTime.getDateTime());
            stmt.setBoolean(3, availableDateTime.isBooked());

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
    public AvailableDateTime find(long id) throws SQLException {
        Connection conn = null;
        AvailableDateTime available = null;
        try {
            conn = connectionPool.getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.FIND_AVAILABLE);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                available = new AvailableDateTime();
                available.setId(resultSet.getInt("id"));
                available.setRestaurantId(resultSet.getInt("restaurant_id"));
                available.setDateTime(resultSet.getString("date_time"));
                available.setBooked(resultSet.getBoolean("booked"));
            }

            statement.close();
            connectionPool.returnConnection(conn);
        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
        return available;
    }

    @Override
    public List<AvailableDateTime> findAll() throws SQLException {
        return null;
    }

    @Override
    public void update(AvailableDateTime availableDateTime) throws SQLException {

    }
}
