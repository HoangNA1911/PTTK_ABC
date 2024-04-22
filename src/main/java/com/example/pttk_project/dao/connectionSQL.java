package com.example.pttk_project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author 1BestCsharp
 */
public class connectionSQL {


    // Replace below database url, username and password with your actual database credentials

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/HTQL_HoSo_UT?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "12345678";



    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            // Xử lý ngoại lệ ClassNotFoundException và SQLException
            e.printStackTrace();
            throw new SQLException("Could not establish connection with the database: " + e.getMessage());
        }
        return conn;
    }
}
