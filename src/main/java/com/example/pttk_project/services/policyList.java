package com.example.pttk_project.services;

import com.example.pttk_project.dao.ChinhSachDao;
import com.example.pttk_project.dto.ChinhSach;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class policyList {
    @FXML
    private TableView<ChinhSach> ChinhSachView;

    @FXML
    private TableColumn<ChinhSach, String> ma_chinh_sach;
    @FXML
    private TableColumn<ChinhSach, String> mo_ta;
    private ObservableList<ChinhSach> ChinhSachList = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        ma_chinh_sach.setCellValueFactory(cellData -> cellData.getValue().ma_chinh_sachproperty().asString());
        mo_ta.setCellValueFactory(cellData -> cellData.getValue().mo_taproperty());
        loadThongTinDangTuyenFromDatabase();

    }
    private void loadThongTinDangTuyenFromDatabase() {
        ChinhSachDao loader = new ChinhSachDao();
        List<ChinhSach> ChinhSachList = loader.getAllChinhSach();
        System.out.println();
        // Assuming ThongTinDangTuyenList is a field in your class
        // You should declare it as List<ThongTinDangTuyen> ThongTinDangTuyenList; at the class level

        ChinhSachView.setItems(FXCollections.observableList(ChinhSachList));
    }

}
