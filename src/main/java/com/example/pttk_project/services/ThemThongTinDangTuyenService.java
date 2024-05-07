package com.example.pttk_project.services;

import com.example.pttk_project.dao.doanhNghiepDao;
import com.example.pttk_project.dao.hinhThucQuangCaoDao;
import com.example.pttk_project.dao.thongTinDangTuyenDao;
import com.example.pttk_project.dao.viTriUngTuyenDao;
import com.example.pttk_project.dto.HinhThucQuangCaoDto;
import com.example.pttk_project.dto.ThongTinDangTuyenDto;
import com.example.pttk_project.dto.ViTriUngTuyenDto;
import com.example.pttk_project.dto.doanhNghiepDto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class ThemThongTinDangTuyenService implements Initializable {

    private boolean registerSuccess = false;

    @FXML
    private ComboBox<String> taxCodeComboBox;

    @FXML
    private ComboBox<String> TenDNComboBox;

    @FXML
    private ComboBox<String> TenViTriComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private TextField SoLuongTextField;

    @FXML
    private TextField YeuCauTextField;

    @FXML
    private Button registerButton;

    private Map<String, String> taxCodeMap = new HashMap<>();
    private final hinhThucQuangCaoDao HTQCdao = new hinhThucQuangCaoDao();
    private final doanhNghiepDao DNDao = new doanhNghiepDao();
    private final viTriUngTuyenDao ViTriDao = new viTriUngTuyenDao();


    private final Map<String, Integer> HinhThucMap = new HashMap<>();
    private final Map<String, Integer> DoanhNghiepMap = new HashMap<>();
    private final Map<String, Integer> ViTriMap = new HashMap<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<HinhThucQuangCaoDto> hinhThucQuangCaoList = HTQCdao.getALLHinhThucQC();


        for (HinhThucQuangCaoDto dto : hinhThucQuangCaoList) {
            String ten = dto.getten();
            int maHinhThuc = dto.getma_hinh_thuc();
            taxCodeComboBox.getItems().add(ten);
            HinhThucMap.put(ten, maHinhThuc);
        }

        List<doanhNghiepDto> DNList = DNDao.getALLDN();


        for (doanhNghiepDto DN : DNList) {
            String ten = DN.getTen_cty();
            int maDN = DN.getMa_dn();
            TenDNComboBox.getItems().add(ten);
            DoanhNghiepMap.put(ten, maDN);
        }

        List<ViTriUngTuyenDto> ViTriList = ViTriDao.getALLViTri();


        for (ViTriUngTuyenDto vitri : ViTriList) {
            String ten = vitri.getten();
            int maViTri = vitri.getma_vi_tri();
            TenViTriComboBox.getItems().add(ten);
            ViTriMap.put(ten, maViTri);
        }


        registerButton.setOnAction(event -> {
            // Kiểm tra ComboBox và các TextField
            if (YeuCauTextField.getText() == null || taxCodeComboBox.getValue() == null || SoLuongTextField.getText().isEmpty()) {
                // Hiển thị thông báo lỗi
                System.out.println("Vui lòng điền đầy đủ thông tin.");
                return; // Dừng xử lý nếu có lỗi
            }

            LocalDate startDate = startDatePicker.getValue();

            LocalDate endDate = endDatePicker.getValue();



            String selectedHinhThuc = taxCodeComboBox.getValue();
            int selectedMaHinhThuc = HinhThucMap.get(selectedHinhThuc);
            String selectedTenDN = TenDNComboBox.getValue();
            int selectedMaDN = DoanhNghiepMap.get(selectedTenDN);
            String selectedTenViTri = TenViTriComboBox.getValue();
            int selectedMaViTri = ViTriMap.get(selectedTenViTri);
            int soLuong = Integer.parseInt(SoLuongTextField.getText());
            String requirement = YeuCauTextField.getText();

            ThongTinDangTuyenDto newTTDT = new ThongTinDangTuyenDto(selectedMaDN,selectedMaViTri,soLuong,startDate,selectedMaHinhThuc, requirement, endDate);

            thongTinDangTuyenDao addTTDT = new thongTinDangTuyenDao();
            registerSuccess = addTTDT.addThongTinDangTuyen(newTTDT);

            if (registerSuccess)

                showAlert("Created ");

            else showAlert( "Can not create ");
        });


    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Lỗi");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
