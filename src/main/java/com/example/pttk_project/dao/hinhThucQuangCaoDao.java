package com.example.pttk_project.dao;

import com.example.pttk_project.dto.HinhThucQuangCaoDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class hinhThucQuangCaoDao {
    private static final String SELECT_HT_QUERY = "SELECT ma_hinh_thuc, ten, gia FROM HinhThucQuangCao";
    public List<HinhThucQuangCaoDto> getALLHinhThucQC() {

        List<HinhThucQuangCaoDto> hinhThucQuangCaoList = new ArrayList<>();

        boolean isValid = false;

        // Khởi tạo kết nối
        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_HT_QUERY)) {



            // Thực hiện câu truy vấn
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int maHinhThuc = resultSet.getInt("ma_hinh_thuc");
                String ten = resultSet.getString("ten");
                int gia = resultSet.getInt("gia");


                // Tạo một đối tượng HinhThucQuangCao từ dữ liệu hàng hiện tại và thêm vào danh sách
                HinhThucQuangCaoDto hinhThucQuangCao = new HinhThucQuangCaoDto(maHinhThuc, ten, gia);
                hinhThucQuangCaoList.add(hinhThucQuangCao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ SQLException nếu cần
        }

        return hinhThucQuangCaoList;
    }

}
