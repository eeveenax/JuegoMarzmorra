package com.eve.controllers;

import com.eve.SceneID;
import com.eve.SceneManager;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

public class PrimaryController {
    /** Se establecen las etiquetas FXML con los componentes de las vistas */
    @FXML
    SplitPane splitPane;
    @FXML
    AnchorPane anchorPane1;
    @FXML
    AnchorPane anchorPane2;
    @FXML
    SplitPane splitPaneSup;
    @FXML
    SplitPane splitPaneInf;
    @FXML
    AnchorPane anchorPaneJuego;
    @FXML
    AnchorPane anchorPaneProta;
    @FXML
    AnchorPane anchorPaneMensaje;
    @FXML
    AnchorPane anchorPaneEnemigo;

    @FXML
    public void initialize() {
        SceneManager sm = SceneManager.getInstance();

        // La vista del juego
        sm.setScene(SceneID.GAME, "game");

        Scene juego = sm.getScene(SceneID.GAME);
        AnchorPane.setBottomAnchor(juego.getRoot(), 0.0);
        AnchorPane.setTopAnchor(juego.getRoot(), 0.0);
        AnchorPane.setLeftAnchor(juego.getRoot(), 0.0);
        AnchorPane.setRightAnchor(juego.getRoot(), 0.0);
        anchorPaneJuego.getChildren().setAll(juego.getRoot());

        // La vista del prota
        sm.setScene(SceneID.PLAYER, "player");

        Scene prota = sm.getScene(SceneID.PLAYER);
        AnchorPane.setBottomAnchor(prota.getRoot(), 0.0);
        AnchorPane.setTopAnchor(prota.getRoot(), 0.0);
        AnchorPane.setLeftAnchor(prota.getRoot(), 0.0);
        AnchorPane.setRightAnchor(prota.getRoot(), 0.0);
        anchorPaneProta.getChildren().setAll(prota.getRoot());

        // La vista con los mensajes
        sm.setScene(SceneID.CONSOLE, "console");

        Scene mensaje = sm.getScene(SceneID.CONSOLE);
        AnchorPane.setBottomAnchor(mensaje.getRoot(), 0.0);
        AnchorPane.setTopAnchor(mensaje.getRoot(), 0.0);
        AnchorPane.setLeftAnchor(mensaje.getRoot(), 0.0);
        AnchorPane.setRightAnchor(mensaje.getRoot(), 0.0);
        anchorPaneMensaje.getChildren().setAll(mensaje.getRoot());

        // La vista de los enemigos
        sm.setScene(SceneID.ENEMIES, "enemies");

        Scene enemigo = sm.getScene(SceneID.ENEMIES);
        AnchorPane.setBottomAnchor(enemigo.getRoot(), 0.0);
        AnchorPane.setTopAnchor(enemigo.getRoot(), 0.0);
        AnchorPane.setLeftAnchor(enemigo.getRoot(), 0.0);
        AnchorPane.setRightAnchor(enemigo.getRoot(), 0.0);
        anchorPaneEnemigo.getChildren().setAll(enemigo.getRoot());

    }

}
