package com.example.demo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {

    private String url = "jdbc:mysql://localhost/tabele?serverTimezone=UTC";
    private Properties properties;
    private Connection connection;
    private String username = "root";
    private String password = "student";

    private static DatabaseConnectionManager singleInstance;

    private DatabaseConnectionManager() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Database creation failed");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnectionManager getInstance() throws SQLException {
        if (singleInstance == null) {
            singleInstance = new DatabaseConnectionManager();
        } else if (singleInstance.getConnection().isClosed()) {
            singleInstance = new DatabaseConnectionManager();
        }
        return singleInstance;
    }

//    public Connection getConnection() throws SQLException {
//        if (singleInstance != null) {
//            return DriverManager.getConnection(this.url, this.properties);
//        } else {
//            return getConnection();
//        }
//    }
}
