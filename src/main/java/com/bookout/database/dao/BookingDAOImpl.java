package com.bookout.database.dao;

import com.bookout.database.daointerfaces.BookingDAO;
import com.bookout.enitiy.Booking;
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

public class BookingDAOImpl implements BookingDAO<Booking> {
    private static final Logger LOGGER = LogManager.getLogger(BookingDAOImpl.class);


    @Override
    public void create(Booking booking) throws SQLException {
        Connection con = null;
        try {
            con = connectionPool.getConnection();
            PreparedStatement stmt = con.prepareStatement(SqlQueries.INSERT_BOOKING);
            stmt.setLong(1, booking.getUserId());
            stmt.setInt(2, booking.getRestaurantId());
            stmt.setLong(3, booking.getDateId());
            stmt.setInt(4, booking.getNumOfPersons());

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
    public Booking find(long id) throws SQLException {
        Connection conn = null;
        Booking booking = null;
        try {
            conn = connectionPool.getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.FIND_BOOKING);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                booking = new Booking();
                booking.setId(resultSet.getInt("id"));
                booking.setUserId(resultSet.getInt("user_id"));
                booking.setRestaurantId(resultSet.getInt("restaurant_id"));
                booking.setDateId(resultSet.getLong("date_id"));
                booking.setNumOfPersons(resultSet.getInt("num_of_persons"));
            }

            statement.close();
            connectionPool.returnConnection(conn);

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
        return booking;
    }

    @Override
    public void update(Booking booking) throws SQLException {

    }
    @Override
    public List<Booking> getBookingsByRestaurantId(long restaurantId) throws SQLException {
        Connection conn = null;
        List<Booking> bookings = new ArrayList<>();
        try {
            conn = connectionPool.getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.FIND_BOOKINGS_BY_RESTAURANT_ID);
            statement.setLong(1, restaurantId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Booking booking = new Booking();
                booking.setId(resultSet.getInt("id"));
                booking.setUserId(resultSet.getInt("user_id"));
                booking.setRestaurantId(resultSet.getInt("restaurant_id"));
                booking.setDateId(resultSet.getLong("date_id"));
                booking.setNumOfPersons(resultSet.getInt("num_of_persons"));
                bookings.add(booking);
            }

            statement.close();
            connectionPool.returnConnection(conn);

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
        return bookings;
    }
}
