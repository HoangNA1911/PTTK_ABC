package com.example.pttk_project.dao;

import com.example.pttk_project.dto.UngVienDto;
import com.example.pttk_project.dto.doanhNghiepDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class ungVienDao {
    private static final String SELECT_QUERY = "SELECT * FROM UngVien WHERE email = ? AND password = ?";
    //NameTextField.getText(),PasswordTextField.getText(),
    //                        AddressTextField.getText(),birthDayTextField.getValue(),EmailTextField.getText()
    //ten, email, ngay_sinh, dia_chi, password
    private static final String DANGKY_UV_QUERY = "INSERT INTO UngVien(ten,email, ngay_sinh, dia_chi, password) values (?,?,?,?,?); ";


    public boolean login(String email, String password) {
        boolean isValid = false;

        // Khởi tạo kết nối
        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY)) {

            // Thiết lập các tham số cho câu truy vấn
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

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
    public boolean addUngVien(UngVienDto newUV){
        boolean isValid = false;

        // Khởi tạo kết nối
        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(DANGKY_UV_QUERY)) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String ngsinh =  newUV.getngay_sinh().format(formatter);


            preparedStatement.setString(1, newUV.getten());
            preparedStatement.setString(2, newUV.getemail());
            preparedStatement.setString(3, ngsinh);
            preparedStatement.setString(4, newUV.getdia_chi());
            preparedStatement.setString(5, newUV.getpassword());



            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                isValid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isValid;
    }



}

