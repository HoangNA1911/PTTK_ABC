package com.example.pttk_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class doanhNghiepDao {

    private static final String DANGKY_THONGTIN_DN_QUERY = "INSERT INTO DoanhNghiep (ten_cty, ms_thue, dia_chi, dai_dien, email) values (?, ?,?,?)";

    public boolean addDoanhNghiep(String tenCty, int msThue, String diaChi, String daiDien, String email){
        boolean isValid = false;

        // Khởi tạo kết nối
        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(DANGKY_THONGTIN_DN_QUERY)) {

            // Thiết lập các tham số cho câu truy vấn
            preparedStatement.setString(1, tenCty);
            preparedStatement.setInt(2, msThue);
            preparedStatement.setString(3, diaChi);
            preparedStatement.setString(4, daiDien);
            preparedStatement.setString(5, email);



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


