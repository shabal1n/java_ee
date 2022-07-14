package com.bookout.database;

import com.bookout.validation.PasswordEncryption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    private final Logger log = LogManager.getLogger(this.getClass().getName());
    private String url;
    private String user;
    private String password;
    private String driverDB;
    private final Properties properties = getProperties("db.properties");
    private final int maxConnection = Integer.parseInt(properties.getProperty("pool.maxConnection"));
    private static ConnectionPool instance = null;
    private final BlockingQueue<Connection> freeConnections = new ArrayBlockingQueue<>(maxConnection);

    protected ConnectionPool() {
        init();
    }

    private void init() {
        setDataForConnection();
        loadDrivers();
        createConnections();
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    private void setDataForConnection() {
        this.url = properties.getProperty("pool.url");
        this.password = PasswordEncryption.decrypt(properties.getProperty("pool.password"));
        this.user = properties.getProperty("pool.user");
        this.driverDB = properties.getProperty("pool.driver");
    }

    private Properties getProperties(String configurationFile) {
        Properties properties = new Properties();
        try(InputStream inputStream = ConnectionPool.class.getClassLoader().getResourceAsStream(configurationFile)) {
            properties.load(inputStream);
        } catch (IOException e) {
            log.error(e);
        }
        return properties;
    }

    private void loadDrivers() {
        try {
            Driver driver = (Driver) Class.forName(driverDB).newInstance();
        } catch (InstantiationException | ClassNotFoundException e) {
            log.warn(e);
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.warn(e);
        }
    }

    public synchronized Connection getConnection() {
        Connection connection = null;
        try {
            connection = freeConnections.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private BlockingQueue<Connection> createConnections() {
        if (freeConnections.isEmpty()) {
            while (freeConnections.size() < maxConnection) {
                try(Connection connection = DriverManager.getConnection(url, user, password)) {
                    freeConnections.put(connection);
                } catch (InterruptedException | SQLException e) {
                    log.warn(e);
                    e.printStackTrace();
                }
            }
        }
        return freeConnections;
    }

    public synchronized void returnConnection(Connection connection) {
        if ((connection != null) && (freeConnections.size() < maxConnection)) {
            try {
                freeConnections.put(connection);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}