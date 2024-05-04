package com.example.pttk_project;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.pttk_project.dao.connectionSQL;
import com.example.pttk_project.dto.ThongTinDangTuyen;
import com.example.pttk_project.dto.DoanhNghiep;
import com.example.pttk_project.dto.ViTriUngTuyen;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Recruitment {
    @FXML
    private TableView<ThongTinDangTuyen> ThongTinDangTuyenTableView;

    @FXML
    private TableColumn<ThongTinDangTuyen, String> ma_thong_tin;
    @FXML
    private TableColumn<ThongTinDangTuyen, String> ma_doanh_nghiep;
    @FXML
    private TableColumn<ThongTinDangTuyen, String> ma_vi_tri;
    @FXML
    private TableColumn<ThongTinDangTuyen, String> ma_hinh_thuc;
    @FXML
    private TableColumn<ThongTinDangTuyen, String> yeu_cau;
    @FXML
    private TableColumn<ThongTinDangTuyen, String> ngay_het_han ;
    @FXML
    private TableColumn<ThongTinDangTuyen, String> tiem_nang;
    private ObservableList<ThongTinDangTuyen> ThongTinDangTuyenList = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        ma_thong_tin.setCellValueFactory(cellData -> cellData.getValue().ma_thong_tinproperty().asString());
        ma_doanh_nghiep.setCellValueFactory(cellData -> cellData.getValue().getDoanhNghiep().ten_ctyproperty());
        ma_vi_tri.setCellValueFactory(cellData -> cellData.getValue().getViTriUngTuyen().tenproperty());
        ma_hinh_thuc.setCellValueFactory(cellData -> cellData.getValue().ma_hinh_thucproperty().asString());
        ngay_het_han.setCellValueFactory(cellData -> cellData.getValue().ngay_het_hanproperty().asString());
        ThongTinDangTuyenList = FXCollections.observableArrayList();
        loadThongTinDangTuyenFromDatabase();

    }
    private void loadThongTinDangTuyenFromDatabase() {
//        DataAccessLayer dal = null;
//        Connection conn = null;
//        CallableStatement cst = null;
//        ResultSet rs = null;
        String SELECT_QUERY = "SELECT ma_thong_tin, ten_cty,ten, ma_hinh_thuc, ngay_het_han FROM ThongTinDangTuyen tt join DoanhNghiep dn on tt.ma_doanh_nghiep  = dn.ma_doanh_nghiep join ViTriUngTuyen vt on vt.ma_vi_tri = tt.ma_vi_tri      ";

        try (Connection conn = new connectionSQL().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY)){
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                ThongTinDangTuyen kh = new ThongTinDangTuyen();
                DoanhNghiep hp = new DoanhNghiep();
                ViTriUngTuyen vt = new ViTriUngTuyen();
                //System.out.println(kh);

                String tenDN = rs.getString("ten_cty");
                hp.setten_cty(tenDN);
                kh.setDoanhNghiep(hp);

                String vitriTuyen = rs.getString("ten");
                vt.setten(vitriTuyen);
                kh.setDoanhNghiep(vt);
                kh.setma_thong_tin(rs.getInt("ma_thong_tin"));
                kh.setma_hinh_thuc(rs.getInt("ma_hinh_thuc"));
                kh.setngay_het_han(rs.getDate("ngay_het_han").toLocalDate());
                ThongTinDangTuyenList.add(kh);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        ThongTinDangTuyenTableView.setItems(ThongTinDangTuyenList);

    }
}
