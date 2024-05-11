package com.example.pttk_project.dao;

import com.example.pttk_project.dto.ChinhSachDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChinhSachDao {
    // Method to load ThongTinDangTuyen from the database and return a list of ThongTinDangTuyen objects
    public List<ChinhSachDto> getAllChinhSach() {
        List<ChinhSachDto> ThongTinDangTuyenList = new ArrayList<>();

        // Your database querying logic here
        String SELECT_QUERY = "SELECT ma_chinh_sach, mo_ta FROM ChinhSach";

        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ChinhSachDto kh = new ChinhSachDto();

                kh.setma_chinh_sach(rs.getInt("ma_chinh_sach"));
                kh.setmo_ta(rs.getString("mo_ta"));

                ThongTinDangTuyenList.add(kh);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ThongTinDangTuyenList;
    }
}
