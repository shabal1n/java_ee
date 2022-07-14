package com.bookout.util;

import com.bookout.database.ConnectionPool;
import com.bookout.entity.Local;


public class Constants {

    public static final Local local = new Local();
    public static final ConnectionPool connectionPool = ConnectionPool.getInstance();

}
