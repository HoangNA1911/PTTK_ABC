package com.example.pttk_project.dao;
import java.util.ArrayList;
import java.util.List;


import com.example.pttk_project.dto.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class hoSoUngTuyenDao {
    private int ho_so_count;
    // Method to load ThongTinDangTuyen from the database and return a list of ThongTinDangTuyen objects
    public List<HoSoUngTuyen> getAllHoSoUngTuyen() {
        List<HoSoUngTuyen> HoSoUngTuyenList= new ArrayList<>();

        // Your database querying logic here
        String SELECT_QUERY = "SELECT ut.ma_ho_so, uv.ten, uv.email, ut.trang_thai, ut.level " +
                "FROM HoSoUngTuyen ut " +
                "JOIN UngVien uv ON ut.ma_ung_vien = uv.ma_ung_vien " +
                "WHERE ut.ma_thong_tin = 9 " +
                "ORDER BY ut.ma_ho_so ASC";


        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                HoSoUngTuyen kh = new HoSoUngTuyen();
                UngVien hp = new UngVien();


                String tenUV = rs.getString("ten");
                hp.setten(tenUV);
                kh.setUngVien(hp);

                String emailUV = rs.getString("email");
                hp.setemail(emailUV);
                kh.setUngVien(hp);

                kh.setma_ho_so(rs.getInt("ma_ho_so"));
                kh.settrang_thai(rs.getString("trang_thai"));
                kh.setlevel(rs.getInt("level"));
                HoSoUngTuyenList.add(kh);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return HoSoUngTuyenList;
    }

    public List<HoSoUngTuyen> getAllHoSoUngTuyen2(int num) {
        List<HoSoUngTuyen> HoSoUngTuyenList= new ArrayList<>();

        // Your database querying logic here
        String SELECT_QUERY = "SELECT ut.ma_ho_so, uv.ten, uv.email, ut.trang_thai, ut.level " +
                "FROM HoSoUngTuyen ut " +
                "JOIN UngVien uv ON ut.ma_ung_vien = uv.ma_ung_vien " +
                "WHERE ut.ma_thong_tin = " + num + " " +
                "ORDER BY ut.ma_ho_so ASC";

        System.out.println(SELECT_QUERY);
        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                HoSoUngTuyen kh = new HoSoUngTuyen();
                UngVien hp = new UngVien();


                String tenUV = rs.getString("ten");
                hp.setten(tenUV);
                kh.setUngVien(hp);

                String emailUV = rs.getString("email");
                hp.setemail(emailUV);
                kh.setUngVien(hp);

                kh.setma_ho_so(rs.getInt("ma_ho_so"));
                kh.settrang_thai(rs.getString("trang_thai"));
                kh.setlevel(rs.getInt("level"));
                HoSoUngTuyenList.add(kh);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return HoSoUngTuyenList;
    }
}
