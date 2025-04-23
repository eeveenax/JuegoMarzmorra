module com.eve {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.eve to javafx.fxml;
    opens com.eve.controllers to javafx.fxml;

    exports com.eve;
}
