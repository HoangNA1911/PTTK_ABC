package com.example.pttk_project.services;

import com.example.pttk_project.dao.ungVienDao;
import com.example.pttk_project.dto.UngVienDto;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegisterUngVienService {
    private boolean registerSuccess = false;

    @FXML
    private TextField NameTextField;
    @FXML
    private TextField AddressTextField;
    @FXML
    private TextField EmailTextField;
    @FXML
    private DatePicker birthDayTextField;
    @FXML
    private TextField PasswordTextField;
    @FXML
    private CheckBox termsCheckBox;
    @FXML
    private Button registerButton;
    @FXML
    private Button cancelButton;

    @FXML
    public void initialize() {
        registerButton.setOnAction(event -> {
            if (fieldsAreFilled()) {
                UngVienDto uv = new UngVienDto
                        (-1,NameTextField.getText(),PasswordTextField.getText(),
                        AddressTextField.getText(),birthDayTextField.getValue(),EmailTextField.getText());
                registerSuccess = register(uv);
                if (!registerSuccess){
                    showAlert("Đăng ký ứng viên không thành công");
                } else {
                    showSuccess("Đăng ký ứng viên thành công");
                }
            } else {
                System.out.println("Vui lòng điền đầy đủ thông tin.");
            }
        });
    }

    private boolean fieldsAreFilled() {
        return !NameTextField.getText().isEmpty() &&
                !AddressTextField.getText().isEmpty() &&
                !EmailTextField.getText().isEmpty() &&
                birthDayTextField.getValue() != null &&
                !PasswordTextField.getText().isEmpty();
    }

    private boolean register(UngVienDto uv) {
        ungVienDao register = new ungVienDao();
      return  register.addUngVien(uv);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Lỗi");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Thành công");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
