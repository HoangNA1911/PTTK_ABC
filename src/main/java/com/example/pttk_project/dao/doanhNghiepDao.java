package com.example.pttk_project.dao;

import com.example.pttk_project.dto.HinhThucQuangCaoDto;
import com.example.pttk_project.dto.doanhNghiepDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class doanhNghiepDao {

    private static final String DANGKY_THONGTIN_DN_QUERY = "INSERT INTO DoanhNghiep (ten_cty, ms_thue, dia_chi, dai_dien, email) values (?, ?,?,?,?)";
    private static final String SELECT_THONGTIN_DN_QUERY = "SELECT ma_doanh_nghiep, ten_cty from DoanhNghiep ";

    public boolean addDoanhNghiep(doanhNghiepDto newDN){
        boolean isValid = false;

        // Khởi tạo kết nối
        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(DANGKY_THONGTIN_DN_QUERY)) {

            // Thiết lập các tham số cho câu truy vấn
            preparedStatement.setString(1, newDN.getTen_cty());
            preparedStatement.setInt(2, newDN.getMs_thue());
            preparedStatement.setString(3, newDN.getDia_chi());
            preparedStatement.setString(4, newDN.getDai_dien());
            preparedStatement.setString(5, newDN.getEmail());



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

    public List<doanhNghiepDto> getALLDN() {

        List<doanhNghiepDto> DoanhNghiepList = new ArrayList<>();

        boolean isValid = false;

        // Khởi tạo kết nối
        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_THONGTIN_DN_QUERY)) {



            // Thực hiện câu truy vấn
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int maDN = resultSet.getInt("ma_doanh_nghiep");
                String ten = resultSet.getString("ten_cty");


                // Tạo một đối tượng HinhThucQuangCao từ dữ liệu hàng hiện tại và thêm vào danh sách
                doanhNghiepDto DoanhNghiep = new doanhNghiepDto(maDN, ten);
                DoanhNghiepList.add(DoanhNghiep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ SQLException nếu cần
        }

        return DoanhNghiepList;
    }

}


