package com.bookout.database.dao;

import com.bookout.database.daointerfaces.AdminDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.bookout.util.SqlQueries.connectionPool;

public class AdminDAOImpl implements AdminDAO {
    private static final Logger LOGGER = LogManager.getLogger(AdminDAOImpl.class);

    private final String GET_RESTAURANT_ID_BY_ADMIN_ID = "SELECT restaurant_id " +
            "FROM restaurant_administrator WHERE user_id = ?";

    @Override
    public int getRestaurantIdByAdminId(long adminId) throws Exception {
        Connection conn = null;
        int restaurantId = 0;
        try {
            conn = connectionPool.getConnection();
            PreparedStatement statement = conn.prepareStatement(GET_RESTAURANT_ID_BY_ADMIN_ID);
            statement.setLong(1, adminId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                restaurantId = resultSet.getInt("restaurant_id");
            }

            statement.close();
            connectionPool.returnConnection(conn);

        } catch (Exception e) {
            if (conn != null) conn.close();
            LOGGER.error(e);
        }
        if(restaurantId == 0) throw new Exception("Restaurant associated with admin ID not found");
        return restaurantId;
    }
}
