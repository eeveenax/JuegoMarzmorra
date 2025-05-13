package com.eve.controllers;

import java.util.ArrayList;
import com.eve.interfaces.Observer;

import com.eve.model.Enemigo;
import com.eve.model.GestorJuego;
import com.eve.model.Personaje;
import com.eve.model.Proveedor;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class EnemiesController implements Observer {
    /** Se establecen las etiquetas FXML con los componentes de las vistas */
    @FXML
    AnchorPane anchorPane1;
    @FXML
    ScrollPane scrollPane;
    @FXML
    GridPane gridPane;

    @FXML
    public void initialize() {
        GestorJuego gestor = Proveedor.getInstance().getGestorJuego();
        gestor.subscribe(this);
        contruirGrid();
        rellenarGrid(gestor);
    }

    /** Método para construir el grid con las imagenes del escenario */
    public void contruirGrid() {
        gridPane.getChildren().clear();
        gridPane.getColumnConstraints().clear();
        gridPane.setPadding(new Insets(0, 0, 0, 0));
        double[] columnPercents = { 25, 75 };
        for (double percent : columnPercents) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(percent);
            col.setHgrow(Priority.ALWAYS);
            col.setHalignment(HPos.LEFT);
            gridPane.getColumnConstraints().add(col);
        }
    }

    public void rellenarGrid(GestorJuego gestor) {
        ArrayList<Personaje> personajes = Proveedor.getInstance().getGestorJuego().getPersonajes();
        gridPane.getChildren().clear();
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i) instanceof Enemigo) {
                Enemigo enemigo = (Enemigo) personajes.get(i);
                Label label = new Label();
                label.setWrapText(true);
                label.setText("Nombre: " + enemigo.getNombre() + "\nPuntosVida: " + enemigo.getPuntosvida()
                        + "\nFuerza: " + enemigo.getFuerza()
                        + "\nDefensa: " + enemigo.getDefensa()
                        + "\nXP da: " + enemigo.getXpDan() + "\nVida da: " + enemigo.getVidaDan()
                        + "\nPociones. Fila: " + enemigo.getPosicion()[0] + "- Columna: " + enemigo.getPosicion()[1]
                        + "\n ");
                ImageView image = new ImageView(new Image(getClass().getResourceAsStream(enemigo.getImagen())));
                image.setFitHeight(48);
                image.setFitWidth(48);
                image.setPreserveRatio(true);
                gridPane.add(image, 0, i);
                gridPane.add(label, 1, i);
                GridPane.setHalignment(image, HPos.CENTER);
                GridPane.setValignment(image, VPos.CENTER);
            }
        }
    }

    @Override
    public void onChange() {
        GestorJuego gestor = Proveedor.getInstance().getGestorJuego();
        contruirGrid();
        rellenarGrid(gestor);
    }
}
