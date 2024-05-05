package com.example.pttk_project.dao;

import com.example.pttk_project.dto.UsersDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class nhanVienDao {

    private static final String SELECT_QUERY = "SELECT * FROM Users WHERE email = ? AND password = ?";


    public boolean login(UsersDto users) {
        boolean isValid = false;

        // Khởi tạo kết nối
        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY)) {

            // Thiết lập các tham số cho câu truy vấn
            preparedStatement.setString(1, users.getEmail());
            preparedStatement.setString(2, users.getPassword());

            // Thực hiện câu truy vấn
            ResultSet resultSet = preparedStatement.executeQuery();

            // Nếu có bản ghi trả về, tức là thông tin đăng nhập hợp lệ
            if (resultSet.next()) {
                isValid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ SQLException nếu cần
        }

        return isValid;
    }

}
