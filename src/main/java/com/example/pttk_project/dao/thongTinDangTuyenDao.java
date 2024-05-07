package com.example.pttk_project.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import com.example.pttk_project.dto.HinhThucQuangCaoDto;
import com.example.pttk_project.dto.ThongTinDangTuyenDto;
import com.example.pttk_project.dto.ViTriUngTuyenDto;
import com.example.pttk_project.dto.doanhNghiepDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class thongTinDangTuyenDao {

    private static final String THEM_THONGTIN_DANGTUYEN_QUERY = "INSERT INTO ThongTinDangTuyen (ma_doanh_nghiep, ma_vi_tri, so_luong, ngay_bat_dau, ma_hinh_thuc, yeu_cau, ngay_het_han) values (?,?,?,?, ?, ?, ?);\n";


    // Method to load ThongTinDangTuyen from the database and return a list of ThongTinDangTuyen objects
    public List<ThongTinDangTuyenDto> getAllThongTinDangTuyen() {
        List<ThongTinDangTuyenDto> ThongTinDangTuyenList = new ArrayList<>();

        // Your database querying logic here
        String SELECT_QUERY = "SELECT tt.ma_thong_tin, ten_cty, vt.ten as tenVT, qc.ten as tenQC, ngay_het_han FROM ThongTinDangTuyen tt " +
                "join DoanhNghiep dn on tt.ma_doanh_nghiep  = dn.ma_doanh_nghiep " +
                "join ViTriUngTuyen vt on vt.ma_vi_tri = tt.ma_vi_tri " +
                "join HinhThucQuangCao qc on qc.ma_hinh_thuc = tt.ma_hinh_thuc " +
                "join HoSoUngTuyen ut on ut.ma_thong_tin = tt.ma_thong_tin " +
                "group by ut.ma_thong_tin order by tt.ma_thong_tin asc;  ";

        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ThongTinDangTuyenDto kh = new ThongTinDangTuyenDto();
                doanhNghiepDto hp = new doanhNghiepDto();
                ViTriUngTuyenDto vt = new ViTriUngTuyenDto();
                HinhThucQuangCaoDto qcc = new HinhThucQuangCaoDto();

                String tenDN = rs.getString("ten_cty");
                hp.setTen_cty(tenDN);
                kh.setDoanhNghiep(hp);

                String vitriTuyen = rs.getString("tenVT");
                vt.setten(vitriTuyen);
                kh.setViTriUngTuyenDto(vt);

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

        return ThongTinDangTuyenList;
    }


    public boolean addThongTinDangTuyen(ThongTinDangTuyenDto newDT){
        boolean isValid = false;

        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(THEM_THONGTIN_DANGTUYEN_QUERY)) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            String start =  newDT.getngay_bat_dau().format(formatter);
            String end =  newDT.getngay_het_han().format(formatter);


            preparedStatement.setInt(1, newDT.getma_doanh_nghiep());
            preparedStatement.setInt(2, newDT.getma_vi_tri());
            preparedStatement.setInt(3, newDT.getso_luong());
            preparedStatement.setString(4,start);
            preparedStatement.setInt(5, newDT.getma_hinh_thuc());
            preparedStatement.setString(6, newDT.getyeu_cau());
            preparedStatement.setString(7, end);





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
}
