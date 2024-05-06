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
    public void initialize() {
        ma_ho_so.setCellValueFactory(cellData -> cellData.getValue().ma_ho_soproperty().asString());
        ten.setCellValueFactory(cellData -> cellData.getValue().getUngVien().tenproperty());
        email.setCellValueFactory(cellData -> cellData.getValue().getUngVien().emailproperty());
        trang_thai.setCellValueFactory(cellData -> cellData.getValue().trang_thaiproperty());
        level.setCellValueFactory(cellData -> cellData.getValue().levelproperty().asString());

        HoSoUngTuyenList = FXCollections.observableArrayList();
        loadHoSoUngTuyenFromDatabase();

    }
    private void loadPage(String page) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pttk_project/" + page + ".fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage popupStage = new Stage();

            // Set the FXML content as the scene of the stage
            Scene scene = new Scene(root);
            popupStage.setScene(scene);

            // Set modality so that it blocks events to other windows
            popupStage.initModality(Modality.APPLICATION_MODAL);

            // Show the stage
            popupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception properly
        }
    }


    private void loadHoSoUngTuyenFromDatabase() {
        hoSoUngTuyenDao loader = new hoSoUngTuyenDao();
        List<HoSoUngTuyen> HoSoUngTuyenList = loader.getAllHoSoUngTuyen();
        //System.out.println(ThongTinDangTuyenList);
        // Assuming ThongTinDangTuyenList is a field in your class
        // You should declare it as List<ThongTinDangTuyen> ThongTinDangTuyenList; at the class level

        HoSoUngTuyenTableView.setItems(FXCollections.observableList(HoSoUngTuyenList));

    }

}
