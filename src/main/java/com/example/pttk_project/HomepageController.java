package com.example.pttk_project;

import com.example.pttk_project.dao.thongTinDangTuyenDao;
import com.example.pttk_project.dto.ThongTinDangTuyen;
import com.example.pttk_project.services.xemCVService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomepageController {
    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;
    @FXML
    private void pageAdvertise(MouseEvent event) throws IOException {
        bp.setCenter(ap);
    }

    @FXML
    private void pageCV(MouseEvent event) throws IOException {
        loadpage("cv");
    }
    @FXML
    private void pageLogin(MouseEvent event) throws IOException {
        loadpage("login");
    }
    @FXML
    private void pageProfile(MouseEvent event) throws IOException {
        loadpage("profile");
    }
    @FXML
    private void pageRecruitment(MouseEvent event) throws IOException {
        loadpage("recruitment");
    }
    @FXML
    private void pageAddRecruite(MouseEvent event) throws IOException {
        loadpage("addRecruite");
    }
    @FXML
    private void pageAddAdvertisement(MouseEvent event) throws IOException {
        loadpage("addAdvertisement");
    }
    @FXML
    private void pageContractExpires(MouseEvent event) throws IOException {
        loadpage("contractExpires");
    }
    @FXML
    private void pagePolicyList(MouseEvent event) throws IOException {
        loadpage("policyList");
    }

    private  void loadpage(String page) throws IOException {
        Parent root =null;
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page + ".fxml")));
        bp.setCenter(root);
    }


    @FXML
    private void pageRegisterDoanhNghiep(MouseEvent event) throws IOException {
        loadpage("register_company");
    }

    public void pageAddPolicy(MouseEvent mouseEvent) {
    }




    @FXML
    private TableView<ThongTinDangTuyen> ThongTinDangTuyenTableView;

    @FXML
    private TableColumn<ThongTinDangTuyen, String> ma_thong_tin;
    @FXML
    private TableColumn<ThongTinDangTuyen, String> ma_doanh_nghiep;
    @FXML
    private TableColumn<ThongTinDangTuyen, String> ma_vi_tri;
    @FXML
    private TableColumn<ThongTinDangTuyen, String> luong;
    @FXML
    private TableColumn<ThongTinDangTuyen, String> yeu_cau;
    @FXML
    private TableColumn<ThongTinDangTuyen, String> ngay_het_han ;
    @FXML
    private TableColumn<ThongTinDangTuyen, String> SoHoSo;
    private ObservableList<ThongTinDangTuyen> ThongTinDangTuyenList = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        ma_thong_tin.setCellValueFactory(cellData -> cellData.getValue().ma_thong_tinproperty().asString());
        ma_doanh_nghiep.setCellValueFactory(cellData -> cellData.getValue().getDoanhNghiep().ten_ctyproperty());
        ma_vi_tri.setCellValueFactory(cellData -> cellData.getValue().getViTriUngTuyen().tenproperty());
        luong.setCellValueFactory(cellData -> cellData.getValue().so_luongproperty().asString());
        yeu_cau.setCellValueFactory(cellData -> cellData.getValue().yeu_cauproperty());
        ngay_het_han.setCellValueFactory(cellData -> cellData.getValue().ngay_het_hanproperty().asString());
        SoHoSo.setCellValueFactory(cellData -> cellData.getValue().hoSoCountProperty().asString());
        System.out.println("doing...");
        ThongTinDangTuyenList = FXCollections.observableArrayList();
        loadThongTinDangTuyenFromDatabase();
//        ThongTinDangTuyenTableView.setOnMouseClicked(event -> {
//            if (event.getClickCount() == 2) { // Check for single click
//                ThongTinDangTuyen selectedThongTin = ThongTinDangTuyenTableView.getSelectionModel().getSelectedItem();
//                if (selectedThongTin != null) {
//                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pttk_project/NaBeo.fxml"));
//                    try {
//                        Parent root = loader.load();
//                        xemCVService anotherController = loader.getController();
//
//                        // Assuming ma_thong_tin is an appropriate field in selectedThongTin
//                        int num = selectedThongTin.getma_thong_tin();
//
//                        // Load the page with the data
//                        //loadPageWithRoot("NaBeo", num);
//
//                        System.out.println("Page loaded successfully");
//                    } catch (IOException e) {
//                        e.printStackTrace(); // Handle the exception properly
//                    }
//                }
//            }
//        });
    }

//    private void loadPageWithRoot(String page, int num) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pttk_project/" + page + ".fxml"));
//            Parent root = loader.load();
//
//            // Obtain the controller
//            xemCVService anotherController = loader.getController();
//
//            // Pass num data to the controller
//            anotherController.receiveSelectedRowData(num);
//
//            // Create a new stage
//            Stage popupStage = new Stage();
//
//            // Set the FXML content as the scene of the stage
//            Scene scene = new Scene(root);
//            popupStage.setScene(scene);
//
//            // Set modality so that it blocks events to other windows
//            popupStage.initModality(Modality.APPLICATION_MODAL);
//
//            // Show the stage
//            popupStage.showAndWait();
//        } catch (IOException e) {
//            e.printStackTrace(); // Handle the exception properly
//        }
//    }


    private void loadThongTinDangTuyenFromDatabase() {
        thongTinDangTuyenDao loader = new thongTinDangTuyenDao();
        List<ThongTinDangTuyen> ThongTinDangTuyenList = loader.getAllThongTinDangTuyenUngVien();

        ThongTinDangTuyenTableView.setItems(FXCollections.observableList(ThongTinDangTuyenList));

    }

}