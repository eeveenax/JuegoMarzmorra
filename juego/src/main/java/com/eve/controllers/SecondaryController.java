package com.eve.controllers;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class SecondaryController {
    /** Se establecen las etiquetas FXML con los componentes de las vistas */
    @FXML
    AnchorPane anchorPane;
    @FXML
    GridPane gridPane;

    @FXML
    public void initialize() {

        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 20, 10, 20));

        double[] columnPercents = { 30, 30, 30, 10 }; // La suma es el 100%

        for (double percent : columnPercents) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(percent);
            col.setHgrow(Priority.ALWAYS); // Para que las columnas crezcan con el GridPane
            col.setHalignment(HPos.LEFT);
            gridPane.getColumnConstraints().add(col);
        }

    }

}