package com.example.pttk_project.services;

import com.example.pttk_project.dao.doanhNghiepDao;
import com.example.pttk_project.dto.doanhNghiepDto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class RegisterDoanhNghiepService {
    private boolean registerSuccess = false;

    @FXML
    private TextField businessNameTextField;

    @FXML
    private TextField businessAddressTextField;

    @FXML
    private TextField taxCodeTextField;

    @FXML
    private TextField representativeTextField;

    @FXML
    private TextField emailDNTextField;

    @FXML
    private Button registerButton;

    @FXML
    private Button cancelButton;

    public void initialize() {
        registerButton.setOnAction(event -> {
            if (businessNameTextField.getText().isEmpty() ||
                    businessAddressTextField.getText().isEmpty() ||
                    taxCodeTextField.getText().isEmpty() ||
                    representativeTextField.getText().isEmpty() ||
                    emailDNTextField.getText().isEmpty()) {
                showAlert("Vui lòng điền đầy đủ thông tin.");
            } else {
                doanhNghiepDto newDoanhNghiep = new doanhNghiepDto(
                        // Assuming ma_doanh_nghiep is auto-generated or set later
                        businessNameTextField.getText(),
                        taxCodeTextField.getText(), // Convert the tax code to string
                        businessAddressTextField.getText(),
                        representativeTextField.getText(),
                        emailDNTextField.getText()
                );
                boolean isDNexist = false;
                doanhNghiepDao addDN = new doanhNghiepDao();
                doanhNghiepDao DNexist = new doanhNghiepDao();
                isDNexist = DNexist.checkExist(newDoanhNghiep);
                if (!isDNexist) {
                    registerSuccess = addDN.addDoanhNghiep(newDoanhNghiep);

                    if (registerSuccess)

                        showAlert("Created " + businessNameTextField.getText());

                    else showAlert("Can not create " + businessNameTextField.getText());

                }
                else showAlert("Doanh nghiệp đã tồn tại !!!");
            }

        });

        cancelButton.setOnAction(event -> {
            // Đặt lại giá trị của tất cả các trường text box thành rỗng
            businessNameTextField.setText("");
            businessAddressTextField.setText("");
            taxCodeTextField.setText("");
            representativeTextField.setText("");
            emailDNTextField.setText("");
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
