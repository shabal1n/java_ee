package com.bookout.database.dao;

import com.bookout.entity.Booking;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.bookout.util.Constants.connectionPool;

public class BookingDAOImpl extends BookingDAOAbstract {
    private static final Logger LOGGER = LogManager.getLogger(BookingDAOImpl.class);

    private final String INSERT_BOOKING = "INSERT INTO booking(user_id, restaurant_id, date_id, num_of_persons) VALUES" +
            "(?, ?, ?, ?);";
    private final String FIND_BOOKING = "SELECT * FROM booking WHERE id = ?;";
    private final String FIND_BOOKINGS_BY_RESTAURANT_ID = "SELECT * FROM booking WHERE restaurant_id = ?;";



    @Override
    public void create(Booking booking) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = connectionPool.getConnection();
            stmt = con.prepareStatement(INSERT_BOOKING);
            stmt.setLong(1, booking.getUserId());
            stmt.setInt(2, booking.getRestaurantId());
            stmt.setLong(3, booking.getDateId());
            stmt.setInt(4, booking.getPersonsCount());

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
    public Booking find(long id) throws SQLException {
        Connection conn = null;
        Booking booking = null;
        PreparedStatement statement = null;
        try {
            conn = connectionPool.getConnection();
            statement = conn.prepareStatement(FIND_BOOKING);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                booking = new Booking();
                booking.setId(resultSet.getInt("id"));
                booking.setUserId(resultSet.getInt("user_id"));
                booking.setRestaurantId(resultSet.getInt("restaurant_id"));
                booking.setDateId(resultSet.getLong("date_id"));
                booking.setPersonsCount(resultSet.getInt("num_of_persons"));
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
        return booking;
    }

    @Override
    public List<Booking> getBookingsByRestaurantId(int restaurantId) throws SQLException {
        Connection conn = null;
        List<Booking> bookings = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            conn = connectionPool.getConnection();
            statement = conn.prepareStatement(FIND_BOOKINGS_BY_RESTAURANT_ID);
            statement.setLong(1, restaurantId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Booking booking = new Booking();
                booking.setId(resultSet.getInt("id"));
                booking.setUserId(resultSet.getInt("user_id"));
                booking.setRestaurantId(resultSet.getInt("restaurant_id"));
                booking.setDateId(resultSet.getLong("date_id"));
                booking.setPersonsCount(resultSet.getInt("num_of_persons"));
                bookings.add(booking);
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
        return bookings;
    }
}
