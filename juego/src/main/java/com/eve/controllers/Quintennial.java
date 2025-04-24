package com.eve.controllers;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class Quintennial {
    /** Se establecen las etiquetas FXML con los componentes de las vistas */
    @FXML
    AnchorPane anchorPane1;
    @FXML
    AnchorPane anchorPane2;
    @FXML
    ScrollPane scrollPane;
    @FXML
    GridPane gridPane;
    @FXML
    Label LEA1;
    @FXML
    Label LEA2;
    @FXML
    Label LEA3;
    @FXML
    Label LEB1;
    @FXML
    Label LEB2;
    @FXML
    Label LEB3;
    @FXML
    Label LEC1;
    @FXML
    Label LEC2;
    @FXML
    Label LEC3;
    @FXML
    Label finalBoss;
    @FXML
    Image IEA1;
    @FXML
    Image IEA2;
    @FXML
    Image IEA3;
    @FXML
    Image IEB1;
    @FXML
    Image IEB2;
    @FXML
    Image IEB3;
    @FXML
    Image IEC1;
    @FXML
    Image IEC2;
    @FXML
    Image IEC3;
    @FXML
    Image IfinalBoss;

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