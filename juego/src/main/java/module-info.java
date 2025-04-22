module com.eve {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.eve to javafx.fxml;
    exports com.eve;
}
