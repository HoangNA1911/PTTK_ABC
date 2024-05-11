package com.example.pttk_project.services;

import java.sql.SQLException;

import com.example.pttk_project.UserSingleton;
import com.example.pttk_project.dao.connectionSQL;
import com.example.pttk_project.dao.nhanVienDao;
import com.example.pttk_project.dao.ungVienDao;
import com.example.pttk_project.dto.UsersDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Window;

public class LoginService {
    private boolean loginSuccess = false;

    private boolean isApplicant = false;


    @FXML
    private TextField emailIdField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;
    @FXML
    private ToggleButton roleToggleButton; // Add ToggleButton field

    @FXML
    private void toggleRole() {
        if (roleToggleButton.isSelected()) {
            roleToggleButton.setStyle("-fx-background-color: red;");
            isApplicant = true;
        } else {
            roleToggleButton.setStyle("-fx-background-color: white;");
        }
    }

    @FXML
    public void register(ActionEvent event) throws SQLException {

        Window owner = submitButton.getScene().getWindow();



        if (emailIdField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your email id");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            return;
        }

        String emailId = emailIdField.getText();
        String password = passwordField.getText();

        UsersDto loginUser = new UsersDto(emailId,password);



       if (isApplicant){
           ungVienDao loginUV = new ungVienDao();
           loginSuccess = loginUV.login(emailId,password);
       } else {
           nhanVienDao loginNV = new nhanVienDao();
           loginSuccess = loginNV.login(loginUser);
       }

        if (loginSuccess){
            UserSingleton.getInstance().setUsername(emailId);
            UserSingleton.getInstance().setPassword(password);
            UserSingleton.getInstance().setUngVien(isApplicant);
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Login Successful!",
                    "Welcome " + emailIdField.getText());
        }

        else showAlert(Alert.AlertType.CONFIRMATION, owner, "Login Unsuccessful",
                "Email or password is invalid");
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}