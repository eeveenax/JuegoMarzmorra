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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class QuintennialController implements Observer {
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
                label.setText("Puntos Vida: " + enemigo.getPuntosvida() + ". Fuerza: " + enemigo.getFuerza()
                        + ". Defensa: " + enemigo.getDefensa()
                        + ". XP que da: " + enemigo.getXpDan() + ". Vida que da: " + enemigo.getVidaDan()
                        + ". Pociones: Fila " + enemigo.getPosicion()[0] + " Columna " + enemigo.getPosicion()[1]);
                ImageView image = new ImageView(new Image(getClass().getResourceAsStream(enemigo.getImagen())));
                image.setFitHeight(32);
                image.setFitWidth(32);
                gridPane.add(image, 0, i);
                gridPane.add(label, 1, i);
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
