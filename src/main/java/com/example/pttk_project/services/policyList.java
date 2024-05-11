package com.example.pttk_project.services;

import com.example.pttk_project.dao.ChinhSachDao;
import com.example.pttk_project.dto.ChinhSachDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class policyList {
    @FXML
    private TableView<ChinhSachDto> ChinhSachView;

    @FXML
    private TableColumn<ChinhSachDto, String> ma_chinh_sach;
    @FXML
    private TableColumn<ChinhSachDto, String> mo_ta;
    private ObservableList<ChinhSachDto> ChinhSachList = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        ma_chinh_sach.setCellValueFactory(cellData -> cellData.getValue().ma_chinh_sachproperty().asString());
        mo_ta.setCellValueFactory(cellData -> cellData.getValue().mo_taproperty());
        loadThongTinDangTuyenFromDatabase();

    }
    private void loadThongTinDangTuyenFromDatabase() {
        ChinhSachDao loader = new ChinhSachDao();
        List<ChinhSachDto> ChinhSachList = loader.getAllChinhSach();
        System.out.println();
        // Assuming ThongTinDangTuyenList is a field in your class
        // You should declare it as List<ThongTinDangTuyen> ThongTinDangTuyenList; at the class level

        ChinhSachView.setItems(FXCollections.observableList(ChinhSachList));
    }

}