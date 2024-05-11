package com.example.pttk_project.services; //xemTT

import com.example.pttk_project.dto.*;
import com.example.pttk_project.dao.thongTinDangTuyenDao;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class XemTTDangTuyen_CV {
    @FXML
    private TableView<ThongTinDangTuyenDto> ThongTinDangTuyenTableView;
    @FXML
    private BorderPane bp;
    @FXML
    private TableColumn<ThongTinDangTuyenDto, String> ma_thong_tin;
    @FXML
    private TableColumn<ThongTinDangTuyenDto, String> ma_doanh_nghiep;
    @FXML
    private TableColumn<ThongTinDangTuyenDto, String> ma_vi_tri;
    @FXML
    private TableColumn<ThongTinDangTuyenDto, String> ma_hinh_thuc;
    @FXML
    private TableColumn<ThongTinDangTuyenDto, String> yeu_cau;
    @FXML
    private TableColumn<ThongTinDangTuyenDto, String> ngay_het_han ;
    @FXML
    private TableColumn<ThongTinDangTuyenDto, String> SoHoSo;
    private ObservableList<ThongTinDangTuyenDto> ThongTinDangTuyenList = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        ma_thong_tin.setCellValueFactory(cellData -> cellData.getValue().ma_thong_tinproperty().asString());
        ma_doanh_nghiep.setCellValueFactory(cellData -> cellData.getValue().getDoanhNghiep().ten_ctyproperty());
        ma_vi_tri.setCellValueFactory(cellData -> cellData.getValue().getViTriUngTuyen().tenproperty());
        ma_hinh_thuc.setCellValueFactory(cellData -> cellData.getValue().getHinhThucQuangCao().tenproperty());
        ngay_het_han.setCellValueFactory(cellData -> cellData.getValue().ngay_het_hanproperty().asString());
        SoHoSo.setCellValueFactory(cellData -> cellData.getValue().hoSoCountProperty().asString());

        ThongTinDangTuyenList = FXCollections.observableArrayList();
        loadThongTinDangTuyenFromDatabase();
        ThongTinDangTuyenTableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Check for single click
                ThongTinDangTuyenDto selectedThongTin = ThongTinDangTuyenTableView.getSelectionModel().getSelectedItem();
                if (selectedThongTin != null) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pttk_project/NaBeo.fxml"));
                    try {
                        Parent root = loader.load();
                        xemCVService anotherController = loader.getController();

                        // Assuming ma_thong_tin is an appropriate field in selectedThongTin
                        int num = selectedThongTin.getma_thong_tin();

                        // Load the page with the data
                        loadPageWithRoot("NaBeo", num);

                        System.out.println("Page loaded successfully");
                    } catch (IOException e) {
                        e.printStackTrace(); // Handle the exception properly
                    }
                }
            }
        });
    }

    private void loadPageWithRoot(String page, int num) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pttk_project/" + page + ".fxml"));
            Parent root = loader.load();

            // Obtain the controller
            xemCVService anotherController = loader.getController();

            // Pass num data to the controller
            anotherController.receiveSelectedRowData(num);

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
        thongTinDangTuyenDao loader = new thongTinDangTuyenDao();
        List<ThongTinDangTuyenDto> ThongTinDangTuyenList = loader.getAllThongTinDangTuyen();


        ThongTinDangTuyenTableView.setItems(FXCollections.observableList(ThongTinDangTuyenList));

    }

}
