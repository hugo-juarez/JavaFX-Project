module com.hugojuarez.props {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.hugojuarez.props to javafx.fxml;
    exports com.hugojuarez.props;
}