package com.example.pttk_project.dao;
import java.util.ArrayList;
import java.util.List;


import com.example.pttk_project.dto.doanhNghiepDto;
import com.example.pttk_project.dto.HinhThucQuangCao;
import com.example.pttk_project.dto.ThongTinDangTuyen;
import com.example.pttk_project.dto.ViTriUngTuyen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class thongTinDangTuyenDao {
    private int ho_so_count;
    // Method to load ThongTinDangTuyen from the database and return a list of ThongTinDangTuyen objects
    public List<ThongTinDangTuyen> getAllThongTinDangTuyen() {
        List<ThongTinDangTuyen> ThongTinDangTuyenList = new ArrayList<>();

        // Your database querying logic here
        String SELECT_QUERY =
                "SELECT tt.ma_thong_tin, ten_cty, vt.ten as tenVT, qc.ten as tenQC, ngay_het_han, count(ut.ma_ho_so)" +
                "FROM ThongTinDangTuyen tt " +
                "join DoanhNghiep dn on tt.ma_doanh_nghiep  = dn.ma_doanh_nghiep " +
                "join ViTriUngTuyen vt on vt.ma_vi_tri = tt.ma_vi_tri " +
                "join HinhThucQuangCao qc on qc.ma_hinh_thuc = tt.ma_hinh_thuc " +
                "join HoSoUngTuyen ut on ut.ma_thong_tin = tt.ma_thong_tin " +
                "group by ut.ma_thong_tin order by tt.ma_thong_tin asc;  ";

        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ThongTinDangTuyen kh = new ThongTinDangTuyen();
                doanhNghiepDto hp = new doanhNghiepDto();
                ViTriUngTuyen vt = new ViTriUngTuyen();
                HinhThucQuangCao qcc = new HinhThucQuangCao();

                String tenDN = rs.getString("ten_cty");
                hp.setten_cty(tenDN);
                kh.setDoanhNghiep(hp);

                String vitriTuyen = rs.getString("tenVT");
                vt.setten(vitriTuyen);
                kh.setViTriUngTuyen(vt);

                String hinhthucqc = rs.getString("tenQC");
                qcc.setten(hinhthucqc);
                kh.setHinhThucQuangCao(qcc);

                kh.setma_thong_tin(rs.getInt("ma_thong_tin"));
                kh.setngay_het_han(rs.getDate("ngay_het_han").toLocalDate());
                kh.setHoSoCount(rs.getInt("count(ut.ma_ho_so)"));
                ThongTinDangTuyenList.add(kh);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ThongTinDangTuyenList;
    }


    public List<ThongTinDangTuyen> getAllThongTinDangTuyenUngVien() {
        List<ThongTinDangTuyen> ThongTinDangTuyenList = new ArrayList<>();

        // Your database querying logic here
        String SELECT_QUERY =
                "SELECT tt.ma_thong_tin, ten_cty, vt.ten as tenVT, so_luong, ngay_het_han, yeu_cau,count(ut.ma_ho_so)" +
                        "FROM ThongTinDangTuyen tt " +
                        "join DoanhNghiep dn on tt.ma_doanh_nghiep  = dn.ma_doanh_nghiep " +
                        "join ViTriUngTuyen vt on vt.ma_vi_tri = tt.ma_vi_tri " +
                        "join HoSoUngTuyen ut on ut.ma_thong_tin = tt.ma_thong_tin " +
                        "where tinh_trang = 'Đã duyệt xong'" +
                        "group by ut.ma_thong_tin order by tt.ma_thong_tin asc;  ";

        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ThongTinDangTuyen kh = new ThongTinDangTuyen();
                doanhNghiepDto hp = new doanhNghiepDto();
                ViTriUngTuyen vt = new ViTriUngTuyen();
                HinhThucQuangCao qcc = new HinhThucQuangCao();

                String tenDN = rs.getString("ten_cty");
                hp.setten_cty(tenDN);
                kh.setDoanhNghiep(hp);

                String vitriTuyen = rs.getString("tenVT");
                vt.setten(vitriTuyen);
                kh.setViTriUngTuyen(vt);

                kh.setyeu_cau(rs.getString("yeu_cau"));
                kh.setso_luong(rs.getInt("so_luong"));
                kh.setma_thong_tin(rs.getInt("ma_thong_tin"));
                kh.setngay_het_han(rs.getDate("ngay_het_han").toLocalDate());
                kh.setHoSoCount(rs.getInt("count(ut.ma_ho_so)"));
                ThongTinDangTuyenList.add(kh);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ThongTinDangTuyenList;
    }


    public List<ThongTinDangTuyen> getAllThongTinDangTuyen2(String search) {
        List<ThongTinDangTuyen> ThongTinDangTuyenList = new ArrayList<>();

        // Your database querying logic here
        String SELECT_QUERY =
                "SELECT tt.ma_thong_tin, ten_cty, vt.ten as tenVT, qc.ten as tenQC, ngay_het_han, count(ut.ma_ho_so) " +
                        "FROM ThongTinDangTuyen tt " +
                        "JOIN DoanhNghiep dn ON tt.ma_doanh_nghiep = dn.ma_doanh_nghiep " +
                        "JOIN ViTriUngTuyen vt ON vt.ma_vi_tri = tt.ma_vi_tri " +
                        "JOIN HinhThucQuangCao qc ON qc.ma_hinh_thuc = tt.ma_hinh_thuc " +
                        "JOIN HoSoUngTuyen ut ON ut.ma_thong_tin = tt.ma_thong_tin " +
                        "WHERE ten_cty LIKE ? " +
                        "OR vt.ten LIKE ? " +
                        "OR qc.ten LIKE ? " +
                        "GROUP BY ut.ma_thong_tin ORDER BY tt.ma_thong_tin ASC";


        String searchKeyword = "%" + search + "%";
        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setString(1, searchKeyword);
            preparedStatement.setString(2, searchKeyword);
            preparedStatement.setString(3, searchKeyword);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ThongTinDangTuyen kh = new ThongTinDangTuyen();
                doanhNghiepDto hp = new doanhNghiepDto();
                ViTriUngTuyen vt = new ViTriUngTuyen();
                HinhThucQuangCao qcc = new HinhThucQuangCao();

                String tenDN = rs.getString("ten_cty");
                hp.setten_cty(tenDN);
                kh.setDoanhNghiep(hp);

                String vitriTuyen = rs.getString("tenVT");
                vt.setten(vitriTuyen);
                kh.setViTriUngTuyen(vt);

                String hinhthucqc = rs.getString("tenQC");
                qcc.setten(hinhthucqc);
                kh.setHinhThucQuangCao(qcc);

                kh.setma_thong_tin(rs.getInt("ma_thong_tin"));
                kh.setngay_het_han(rs.getDate("ngay_het_han").toLocalDate());
                kh.setHoSoCount(rs.getInt("count(ut.ma_ho_so)"));
                ThongTinDangTuyenList.add(kh);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ThongTinDangTuyenList;
    }
}
