package com.bookout.database.dao;

import com.bookout.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.bookout.util.Constants.connectionPool;

public class UserDAOImpl implements com.bookout.database.daointerfaces.UserDAO<User> {

    private static final Logger LOGGER = LogManager.getLogger(UserDAOImpl.class);

    private final String INSERT_USER =
            "INSERT INTO user_info(first_name, mobile, email, password_hash, local_id, is_admin) VALUES" +
                    "(?, ?, ?, ?, ?, ?);";
    private final String FIND_USER = "SELECT * FROM user_info WHERE id = ?;";
    private final String UPDATE_USER = "UPDATE user_info " +
            "SET first_name = ?, mobile = ?, email = ?, password_hash = ?, local_id = ?, is_admin = ?" +
            "WHERE id = ?;";
    private final String FIND_USER_EMAIL = "SELECT * FROM user_info WHERE email = ?;";
    private final String FIND_USER_PHONE = "SELECT * FROM user_info WHERE mobile = ?;";

    public void create(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = connectionPool.getConnection();
            statement = conn.prepareStatement(INSERT_USER);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getMobile());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPasswordHash());
            statement.setInt(5, user.getLocalId());
            statement.setBoolean(6, user.isAdmin());
            int rowCounter = statement.executeUpdate();
            if (rowCounter != 1)
                throw new SQLException("Inserted " + rowCounter + " rows");

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

    @Override
    public User find(long id) throws SQLException {
        Connection conn = null;
        User user = null;
        PreparedStatement statement = null;
        try {
            conn = connectionPool.getConnection();
            statement = conn.prepareStatement(FIND_USER);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setEmail(resultSet.getString("email"));
                user.setMobile(resultSet.getString("mobile"));
                user.setPasswordHash(resultSet.getString("password_hash"));
                user.setLocalId(resultSet.getInt("local_id"));
                user.setAdmin(resultSet.getBoolean("is_admin"));
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
        return user;
    }

    @Override
    public void update(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = connectionPool.getConnection();
            statement = conn.prepareStatement(UPDATE_USER);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getMobile());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPasswordHash());
            statement.setInt(5, user.getLocalId());
            statement.setBoolean(6, user.isAdmin());
            statement.setLong(7, user.getId());
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

    @Override
    public User getUserByEmail(String email) throws SQLException {
        Connection conn = null;
        User user = null;
        PreparedStatement statement = null;
        try {
            conn = connectionPool.getConnection();
            statement = conn.prepareStatement(FIND_USER_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setEmail(resultSet.getString("email"));
                user.setMobile(resultSet.getString("mobile"));
                user.setPasswordHash(resultSet.getString("password_hash"));
                user.setLocalId(resultSet.getInt("local_id"));
                user.setAdmin(resultSet.getBoolean("is_admin"));
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
        return user;
    }

    @Override
    public User getUserByPhone(String phone) throws SQLException {
        Connection conn = null;
        User user = null;
        PreparedStatement statement = null;
        try {
            conn = connectionPool.getConnection();
            statement = conn.prepareStatement(FIND_USER_PHONE);
            statement.setString(1, phone);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setEmail(resultSet.getString("email"));
                user.setMobile(resultSet.getString("mobile"));
                user.setPasswordHash(resultSet.getString("password_hash"));
                user.setLocalId(resultSet.getInt("local_id"));
                user.setAdmin(resultSet.getBoolean("is_admin"));
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
        return user;
    }
}
