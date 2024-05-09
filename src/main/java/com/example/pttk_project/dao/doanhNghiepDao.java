package com.example.pttk_project.dao;

import com.example.pttk_project.dto.doanhNghiepDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class doanhNghiepDao {

    private static final String DANGKY_THONGTIN_DN_QUERY = "INSERT INTO DoanhNghiep (ten_cty, ms_thue, dia_chi, dai_dien, email) values (?, ?,?,?,?)";

    public boolean addDoanhNghiep(doanhNghiepDto newDN){
        boolean isValid = false;

        // Khởi tạo kết nối
        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(DANGKY_THONGTIN_DN_QUERY)) {

            // Thiết lập các tham số cho câu truy vấn
            preparedStatement.setString(1, newDN.getten_cty());
            preparedStatement.setString(2, newDN.getms_thue());
            preparedStatement.setString(3, newDN.getdia_chi());
            preparedStatement.setString(4, newDN.getDai_dien());
            preparedStatement.setString(5, newDN.getemail());



            // Thực hiện câu truy vấn
            int rowsAffected = preparedStatement.executeUpdate();

            // Nếu có bản ghi được thêm vào (rowsAffected > 0), tức là INSERT thành công
            if (rowsAffected > 0) {
                isValid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ SQLException nếu cần
        }

        return isValid;
    }
    private static final String CHECK_EXIST_QUERY = "Select * from doanhnghiep where ten_cty = ? or email = ?";
    public boolean checkExist(doanhNghiepDto newDN){
        boolean isValid = false;

        // Khởi tạo kết nối
        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(CHECK_EXIST_QUERY)) {

            // Thiết lập các tham số cho câu truy vấn
            preparedStatement.setString(1, newDN.getten_cty());
            preparedStatement.setString(2, newDN.getemail());

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


