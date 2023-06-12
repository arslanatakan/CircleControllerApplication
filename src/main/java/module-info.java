module com.example.circlecontrollerapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.circlecontrollerapplication to javafx.fxml;
    exports com.example.circlecontrollerapplication;
}