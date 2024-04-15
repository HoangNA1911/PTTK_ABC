module com.example.pttk_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.pttk_project to javafx.fxml;
    exports com.example.pttk_project;
    exports com.example.pttk_project.services;
    opens com.example.pttk_project.services;
}