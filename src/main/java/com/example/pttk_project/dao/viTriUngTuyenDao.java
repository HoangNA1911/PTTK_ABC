package com.example.pttk_project.dao;


import com.example.pttk_project.dto.HinhThucQuangCaoDto;
import com.example.pttk_project.dto.ViTriUngTuyenDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class viTriUngTuyenDao {
    private static final String SELECT_VT_QUERY = "SELECT ma_vi_tri, ten FROM ViTriUngTuyen";
    public List<ViTriUngTuyenDto> getALLViTri() {

        List<ViTriUngTuyenDto> ViTriList = new ArrayList<>();

        boolean isValid = false;

        // Khởi tạo kết nối
        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_VT_QUERY)) {



            // Thực hiện câu truy vấn
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int maViTri = resultSet.getInt("ma_vi_tri");
                String ten = resultSet.getString("ten");


                // Tạo một đối tượng HinhThucQuangCao từ dữ liệu hàng hiện tại và thêm vào danh sách
                ViTriUngTuyenDto vitri = new ViTriUngTuyenDto(maViTri,ten);
                ViTriList.add(vitri);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ SQLException nếu cần
        }

        return ViTriList;
    }

}
