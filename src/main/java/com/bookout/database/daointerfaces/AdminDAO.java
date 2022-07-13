package com.bookout.database.daointerfaces;

import com.bookout.enitiy.Restaurant;

import java.sql.SQLException;

public interface AdminDAO {
    int getRestaurantIdByAdminId(long adminId) throws Exception;
}
