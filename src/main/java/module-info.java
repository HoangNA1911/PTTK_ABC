module com.example.pttk_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.pttk_project to javafx.fxml;
    exports com.example.pttk_project;
}