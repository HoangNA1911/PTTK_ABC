package com.example.pttk_project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class connectionSQL {




    //1330    NaBeo
    // 3306
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/HTQL_HoSo_UT?allowPublicKeyRetrieval=true&useSSL=false";
    //Aimeefmst281     Uyen Nhi
    //12345678         Nhan Le
    //123456aB         Phuong Trinh

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
