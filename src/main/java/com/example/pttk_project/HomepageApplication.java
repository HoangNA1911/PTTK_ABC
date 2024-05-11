package com.example.pttk_project;

import com.example.pttk_project.dao.connectionSQL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class HomepageApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomepageApplication.class.getResource("homepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 972, 604);

        stage.setTitle("ABC!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        connectionSQL jdbcDao = new connectionSQL();

        try {
            Connection conn = jdbcDao.getConnection();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        launch();

    }
}