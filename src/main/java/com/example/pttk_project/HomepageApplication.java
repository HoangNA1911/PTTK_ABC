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
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("ABC!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        // Khởi tạo một đối tượng từ lớp connectionSQL
        connectionSQL jdbcDao = new connectionSQL();

        try {
            // Gọi phương thức getConnection từ đối tượng jdbcDao
            Connection conn = jdbcDao.getConnection();
            // Sử dụng kết nối conn ở đây (nếu cần)

            // Đóng kết nối sau khi sử dụng
            conn.close();
        } catch (SQLException e) {
            // Xử lý ngoại lệ SQLException nếu cần
            e.printStackTrace();
        }

        // Gọi launch() để khởi chạy ứng dụng JavaFX
        launch();

    }
}