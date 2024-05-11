package com.example.pttk_project.services;

import com.example.pttk_project.dao.ChinhSachDao;
import com.example.pttk_project.dto.ChinhSachDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
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

        ChinhSachList = FXCollections.observableArrayList();
        loadThongTinDangTuyenFromDatabase();
        ChinhSachView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Check for single click
                ChinhSachDto selectedThongTin = ChinhSachView.getSelectionModel().getSelectedItem();
                if (selectedThongTin != null) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pttk_project/chitietChinhSach.fxml"));
                    try {
                        Parent root = loader.load();
                        chitietChinhsach anotherController = loader.getController();

                        // Assuming ma_thong_tin is an appropriate field in selectedThongTin
                        int num = selectedThongTin.getma_chinh_sach();
                        String mota = selectedThongTin.getmo_ta();

                        // Load the page with the data
                        loadPageWithRoot("chitietChinhSach", num, mota);

                        System.out.println("Page loaded successfully");
                    } catch (IOException e) {
                        e.printStackTrace(); // Handle the exception properly
                    }
                }
            }
        });
    }
    private void loadPageWithRoot(String page, int num,String mota) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pttk_project/" + page + ".fxml"));
            Parent root = loader.load();

            // Obtain the controller
            chitietChinhsach anotherController = loader.getController();

            // Pass num data to the controller
            anotherController.receiveSelectedRowData(num,mota);

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
    private void loadThongTinDangTuyenFromDatabase() {
        ChinhSachDao loader = new ChinhSachDao();
        List<ChinhSachDto> ChinhSachList = loader.getAllChinhSach();
        System.out.println();
        // Assuming ThongTinDangTuyenList is a field in your class
        // You should declare it as List<ThongTinDangTuyen> ThongTinDangTuyenList; at the class level

        ChinhSachView.setItems(FXCollections.observableList(ChinhSachList));
    }

}