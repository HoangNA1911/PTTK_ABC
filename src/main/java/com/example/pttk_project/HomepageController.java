package com.example.pttk_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

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
    private void pageAddPolicy(MouseEvent event) throws IOException {
        loadpage("addPolicy");
    }

    private  void loadpage(String page) throws IOException {
        Parent root =null;
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page + ".fxml")));
        bp.setCenter(root);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BorderPane.setMargin(ap, new Insets(40, 40, 40, 40));
    }

}