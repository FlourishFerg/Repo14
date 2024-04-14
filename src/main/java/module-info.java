module com.example.repo14 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.repo14 to javafx.fxml;
    exports com.example.repo14;
}