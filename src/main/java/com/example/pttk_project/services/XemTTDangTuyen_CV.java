package com.example.pttk_project.services;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.pttk_project.dao.connectionSQL;
import com.example.pttk_project.dto.ThongTinDangTuyen;
import com.example.pttk_project.dto.DoanhNghiep;
import com.example.pttk_project.dto.ViTriUngTuyen;
import com.example.pttk_project.dto.HinhThucQuangCao;
import com.example.pttk_project.dao.thongTinDangTuyenDao;
import java.util.List;

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
public class XemTTDangTuyen_CV {
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
        ma_hinh_thuc.setCellValueFactory(cellData -> cellData.getValue().getHinhThucQuangCao().tenproperty());
        ngay_het_han.setCellValueFactory(cellData -> cellData.getValue().ngay_het_hanproperty().asString());
        ThongTinDangTuyenList = FXCollections.observableArrayList();
        loadThongTinDangTuyenFromDatabase();

    }
    private void loadThongTinDangTuyenFromDatabase() {
        thongTinDangTuyenDao loader = new thongTinDangTuyenDao();
        List<ThongTinDangTuyen> ThongTinDangTuyenList = loader.getAllThongTinDangTuyen();

        // Assuming ThongTinDangTuyenList is a field in your class
        // You should declare it as List<ThongTinDangTuyen> ThongTinDangTuyenList; at the class level

        ThongTinDangTuyenTableView.setItems(FXCollections.observableList(ThongTinDangTuyenList));
    }

}
