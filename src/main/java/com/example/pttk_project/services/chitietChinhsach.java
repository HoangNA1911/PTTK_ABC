package com.example.pttk_project.services; //xemCV

import com.example.pttk_project.dto.*;
import com.example.pttk_project.dao.*;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class chitietChinhsach {
    @FXML
    private TableView<ChiTietChinhSachDto> HoSoUngTuyenTableView;
    @FXML
    private BorderPane bp;
    @FXML
    private TableColumn<ChiTietChinhSachDto, String> ten;
    @FXML
    private TableColumn<ChiTietChinhSachDto, String> thue;
    @FXML
    private TableColumn<ChiTietChinhSachDto, String> bd;
    @FXML
    private TableColumn<ChiTietChinhSachDto, String> kt;
    @FXML
    private Label place;
    @FXML
    private Label company;

    private ObservableList<ChiTietChinhSachDto> HoSoUngTuyenList = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        //System.out.println("88");
        thue.setCellValueFactory(cellData -> cellData.getValue().getDoanhNghiep().ms_thueproperty());
        ten.setCellValueFactory(cellData -> cellData.getValue().getDoanhNghiep().ten_ctyproperty());
        bd.setCellValueFactory(cellData -> cellData.getValue().ngay_bdproperty().asString());
        kt.setCellValueFactory(cellData -> cellData.getValue().ngay_ktproperty().asString());
        HoSoUngTuyenList = FXCollections.observableArrayList();
    }


    public void receiveSelectedRowData(int selectedRowData,String mota) {
        // Process the received data herenhansuList.clear();
        //        loadNhansuFromDatabase();
        //        nhansuTableView.refresh();
        HoSoUngTuyenList.clear();
        System.out.println("Received selected row data: " + selectedRowData);
        loadHoSoUngTuyenFromDatabase2(selectedRowData);
        //System.out.println("5");
        place.setText(mota);
        company.setText(Integer.toString(selectedRowData));

    }


//    private void loadHoSoUngTuyenFromDatabase() {
//        hoSoUngTuyenDao loader = new hoSoUngTuyenDao();
//        List<HoSoUngTuyen> HoSoUngTuyenList = loader.getAllHoSoUngTuyen();
//
//        //System.out.println("4");
//
//        HoSoUngTuyenTableView.setItems(FXCollections.observableList(HoSoUngTuyenList));
//
//    }

    public void loadHoSoUngTuyenFromDatabase2(int num) {
        ChiTietDao loader = new ChiTietDao();
        List<ChiTietChinhSachDto> HoSoUngTuyenList = loader.getAllChiTietChinhSach(num);

        //System.out.println("6");

        HoSoUngTuyenTableView.setItems(FXCollections.observableList(HoSoUngTuyenList));

    }

}

