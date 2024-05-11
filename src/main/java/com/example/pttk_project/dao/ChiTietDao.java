package com.example.pttk_project.dao;

import com.example.pttk_project.dto.ChiTietChinhSachDto;
import com.example.pttk_project.dto.doanhNghiepDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiTietDao {
    private int ho_so_count;

    // Method to load ThongTinDangTuyen from the database and return a list of ThongTinDangTuyen objects
    public List<ChiTietChinhSachDto> getAllChiTietChinhSach(int num) {
        List<ChiTietChinhSachDto> ChiTietChinhSachList = new ArrayList<>();

        // Your database querying logic here
        String SELECT_QUERY = "SELECT ngay_bat_dau, ngay_ket_thuc, ten_cty, ms_thue   " +
                "FROM Chi_tiet_Chinh_sach ut " +
                "JOIN DoanhNghiep uv ON ut.ma_doanh_nghiep  = uv.ma_doanh_nghiep  " +
                "WHERE ut.ma_chinh_sach = " + num + " ;" ;



        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ChiTietChinhSachDto kh = new ChiTietChinhSachDto();
                doanhNghiepDto hp = new doanhNghiepDto();


                String tenUV = rs.getString("ten_cty");
                hp.setten_cty(tenUV);
                kh.setDoanhNghiep(hp);

                String thue = rs.getString("ms_thue");
                hp.setms_thue(thue);
                kh.setDoanhNghiep(hp);



                kh.setngay_bd(rs.getDate("ngay_ket_thuc").toLocalDate());
                kh.setngay_kt(rs.getDate("ngay_bat_dau").toLocalDate());

                ChiTietChinhSachList.add(kh);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ChiTietChinhSachList;
    }
}
