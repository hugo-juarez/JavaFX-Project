module mavenfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.hugojuarez.mavenfx to javafx.fxml;

    exports com.hugojuarez.mavenfx;
}