package com.example.pttk_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomepageController implements Initializable {
    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;





    @FXML
    private void handleButtonAction(MouseEvent event) throws IOException {
        String username = UserSingleton.getInstance().getUsername();
        String password = UserSingleton.getInstance().getPassword();
        boolean isUngVien = UserSingleton.getInstance().getIsUngVien();
        boolean isADDUVPage = false;

        if (username == null || password == null) {
            if (event.getSource() instanceof Parent source) {
                String page = source.getId();
                if (Objects.equals(page, "addUngVien") || Objects.equals(page, "login") ){
                    isADDUVPage = true;
                }
            }
            if (!isADDUVPage) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Xin hãy đăng nhập trước!");
                alert.showAndWait();
            } else {
                if (event.getSource() instanceof Parent source) {
                    String page = source.getId();
                    loadpage(page);
                }
            }
        } else if(!isUngVien) {
            if (event.getSource() instanceof Parent source) {
                String page = source.getId();
                loadpage(page);
            }
        } else {
            for (Node node : bp.getLeft().lookupAll("Button")) {
                Button button = (Button) node;
                if (!button.getId().equals("login") && !button.getId().equals("addUngVien")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setHeaderText(null);
                    alert.setContentText("Khong đủ quyền truy cập!");
                    alert.showAndWait();
                }
            }
        }
    }

    private void loadpage(String page) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page + ".fxml")));
        bp.setCenter(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadpage("login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BorderPane.setMargin(ap, new Insets(40, 40, 40, 40));

    }
}
