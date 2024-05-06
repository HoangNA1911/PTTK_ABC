package com.example.pttk_project.services;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.pttk_project.dao.connectionSQL;
import com.example.pttk_project.dto.*;
import com.example.pttk_project.dto.DoanhNghiep;
import com.example.pttk_project.dto.ViTriUngTuyen;
import com.example.pttk_project.dto.HinhThucQuangCao;
import com.example.pttk_project.dao.*;

import java.util.List;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
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
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class xemCVService {
    @FXML
    private TableView<HoSoUngTuyen> HoSoUngTuyenTableView;
    @FXML
    private BorderPane bp;
    @FXML
    private TableColumn<HoSoUngTuyen, String> ma_ho_so;
    @FXML
    private TableColumn<HoSoUngTuyen, String> ten;
    @FXML
    private TableColumn<HoSoUngTuyen, String> email;
    @FXML
    private TableColumn<HoSoUngTuyen, String> trang_thai;
    @FXML
    private TableColumn<HoSoUngTuyen, String> level;

    private ObservableList<HoSoUngTuyen> HoSoUngTuyenList = FXCollections.observableArrayList();
    @FXML
    public void initialize(int num) {
        System.out.println("88");
        ma_ho_so.setCellValueFactory(cellData -> cellData.getValue().ma_ho_soproperty().asString());
        ten.setCellValueFactory(cellData -> cellData.getValue().getUngVien().tenproperty());
        email.setCellValueFactory(cellData -> cellData.getValue().getUngVien().emailproperty());
        trang_thai.setCellValueFactory(cellData -> cellData.getValue().trang_thaiproperty());
        level.setCellValueFactory(cellData -> cellData.getValue().levelproperty().asString());
        System.out.println("2");
        HoSoUngTuyenList = FXCollections.observableArrayList();
        loadHoSoUngTuyenFromDatabase();
        System.out.println("3");
    }


    public void receiveSelectedRowData(int selectedRowData) {
        // Process the received data herenhansuList.clear();
        //        loadNhansuFromDatabase();
        //        nhansuTableView.refresh();
        System.out.println("Received selected row data: " + selectedRowData);
        HoSoUngTuyenList.clear();
        loadHoSoUngTuyenFromDatabase2(selectedRowData);
        System.out.println("5");

    }


    private void loadHoSoUngTuyenFromDatabase() {
        hoSoUngTuyenDao loader = new hoSoUngTuyenDao();
        List<HoSoUngTuyen> HoSoUngTuyenList = loader.getAllHoSoUngTuyen();

        System.out.println("4");

        HoSoUngTuyenTableView.setItems(FXCollections.observableList(HoSoUngTuyenList));

    }

    public void loadHoSoUngTuyenFromDatabase2(int num) {
        hoSoUngTuyenDao loader = new hoSoUngTuyenDao();
        List<HoSoUngTuyen> HoSoUngTuyenList = loader.getAllHoSoUngTuyen2(num);

        System.out.println("6");

        HoSoUngTuyenTableView.setItems(FXCollections.observableList(HoSoUngTuyenList));

    }

}
