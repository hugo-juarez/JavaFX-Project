module com.hugojuarez.firstapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.hugojuarez.firstapp to javafx.fxml;
    exports com.hugojuarez.firstapp;
}