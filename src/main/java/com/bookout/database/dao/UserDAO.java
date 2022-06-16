package com.bookout.database.dao;

import com.bookout.database.ConnectionPool;
import com.bookout.database.daointerfaces.UserDAOInterface;
import com.bookout.enitiy.User;
import com.bookout.util.SqlQueries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends ConnectionPool implements UserDAOInterface<User> {

    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);

    public void create(User user) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.INSERT_USER);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getMobile());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPasswordHash());
            statement.setInt(5, user.getLocalId());
            statement.setBoolean(6, user.getIsAdmin());
            int row_counter = statement.executeUpdate();
            if (row_counter != 1)
                throw new SQLException("Inserted " + row_counter + " rows");

            statement.close();
            returnConnection(conn);

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
    }

    @Override
    public User find(long id) throws SQLException {
        Connection conn = null;
        User user = null;
        try {
            conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.FIND_USER);
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
                user.setIsAdmin(resultSet.getBoolean("isadmin"));
            }

            statement.close();
            returnConnection(conn);

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
        return user;
    }

    @Override
    public List<User> findAll() throws SQLException {
        Connection conn = null;
        List<User> list = null;
        try {
            conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.FIND_ALL_USERS);
            list = new ArrayList<User>();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setEmail(resultSet.getString("email"));
                user.setMobile(resultSet.getString("mobile"));
                user.setPasswordHash(resultSet.getString("password_hash"));
                user.setLocalId(resultSet.getInt("local_id"));
                user.setIsAdmin(resultSet.getBoolean("isadmin"));
                list.add(user);
            }

            statement.close();
            returnConnection(conn);

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
        return list;
    }

    @Override
    public void update(User user) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.UPDATE_USER);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getMobile());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPasswordHash());
            statement.setInt(5, user.getLocalId());
            statement.setBoolean(6, user.getIsAdmin());
            statement.setLong(7, user.getId());

            statement.close();
            returnConnection(conn);

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(User user) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.DELETE_USER);
            statement.setLong(1, user.getId());

            statement.close();
            returnConnection(conn);

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
    }

    @Override
    public User getByEmail(String email) throws SQLException {
        Connection conn = null;
        User user = null;
        try {
            conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.FIND_USER_EMAIL);
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
                user.setIsAdmin(resultSet.getBoolean("isadmin"));
            }

            statement.close();
            returnConnection(conn);

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
        return user;
    }

    @Override
    public User getByPhone(String phone) throws SQLException {
        Connection conn = null;
        User user = null;
        try {
            conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(SqlQueries.FIND_USER_PHONE);
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
                user.setIsAdmin(resultSet.getBoolean("isadmin"));
            }

            statement.close();
            returnConnection(conn);

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
        return user;
    }
}
