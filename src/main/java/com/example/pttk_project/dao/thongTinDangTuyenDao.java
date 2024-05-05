package com.example.pttk_project.dao;

import com.example.pttk_project.dto.DoanhNghiep;
import com.example.pttk_project.dto.HinhThucQuangCao;
import com.example.pttk_project.dto.ThongTinDangTuyen;
import com.example.pttk_project.dto.ViTriUngTuyen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class thongTinDangTuyenDao {
    private void loadThongTinDangTuyenFromDatabase() {
//        DataAccessLayer dal = null;
//        Connection conn = null;
//        CallableStatement cst = null;
//        ResultSet rs = null;
        String SELECT_QUERY = "SELECT ma_thong_tin, ten_cty,vt.ten as tenVT, qc.ten as tenQC, ngay_het_han FROM ThongTinDangTuyen tt " +
                "join DoanhNghiep dn on tt.ma_doanh_nghiep  = dn.ma_doanh_nghiep " +
                "join ViTriUngTuyen vt on vt.ma_vi_tri = tt.ma_vi_tri " +
                "join HinhThucQuangCao qc on qc.ma_hinh_thuc = tt.ma_hinh_thuc";

        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY)){
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                ThongTinDangTuyen kh = new ThongTinDangTuyen();
                DoanhNghiep hp = new DoanhNghiep();
                ViTriUngTuyen vt = new ViTriUngTuyen();
                HinhThucQuangCao qcc = new HinhThucQuangCao();
                //System.out.println(kh);

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
                ThongTinDangTuyenList.add(kh);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
}
