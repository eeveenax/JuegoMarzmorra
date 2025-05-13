package com.eve.controllers;

import com.eve.interfaces.Observer;
import com.eve.model.GestorJuego;
import com.eve.model.Protagonista;
import com.eve.model.Proveedor;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class PlayerController implements Observer {
    /** Se establecen las etiquetas FXML con los componentes de las vistas */
    @FXML
    AnchorPane anchorPaneProta;
    @FXML
    ImageView image;
    @FXML
    GridPane gridPaneProta;
    @FXML
    Label Lnombre;
    @FXML
    Label Lnivel;
    @FXML
    Label LpuntosVida;
    @FXML
    Label Lfuerza;
    @FXML
    Label Ldefensa;
    @FXML
    Label Lmuertes;
    @FXML
    Label Lnombre2;
    @FXML
    Label Lnivel2;
    @FXML
    Label LpuntosVida2;
    @FXML
    Label Lfuerza2;
    @FXML
    Label Ldefensa2;
    @FXML
    Label Lmuertes2;
    @FXML
    Label LXP;
    @FXML
    Label LXP2;
    @FXML
    Label LPosiciones;
    @FXML
    Label LPosiciones2;

    @FXML
    public void initialize() {
        GestorJuego gestor = Proveedor.getInstance().getGestorJuego();
        gestor.subscribe(this);
        Protagonista prota = Proveedor.getInstance().getGestorJuego().buscarProta();
        rellenarDatos(prota);
    }

    public void rellenarDatos(Protagonista prota) {
        String imagenSeleccionada = prota.getImagen();
        image.setImage(new Image(getClass().getResourceAsStream(imagenSeleccionada)));
        image.setFitHeight(128);
        image.setFitWidth(128);
        Lnombre2.setText(prota.getNombre());
        Lnivel2.setText("" + prota.getNivel());
        LpuntosVida2.setText("" + prota.getPuntosvida());
        Lfuerza2.setText("" + prota.getFuerza());
        Ldefensa2.setText("" + prota.getDefensa());
        Lmuertes2.setText("" + prota.getMuertes());
        LXP2.setText("" + prota.getXp());
        LPosiciones2.setText(" Fila: " + prota.getPosicion()[0] + " Columna: " + prota.getPosicion()[1]);
    }

    @Override
    public void onChange() {
        // Actualizar los datos del protagonista cuando haya un cambio
        Protagonista prota = Proveedor.getInstance().getGestorJuego().buscarProta();
        rellenarDatos(prota);
    }
}
