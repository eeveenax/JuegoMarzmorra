package com.eve.controllers;

import com.eve.interfaces.Observer;
import com.eve.model.GestorJuego;
import com.eve.model.Protagonista;
import com.eve.model.Proveedor;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ConsoleController implements Observer {
    /** Se establecen las etiquetas FXML con los componentes de las vistas */
    @FXML
    AnchorPane anchorPane;
    @FXML
    Label Lmensaje;
    @FXML
    Label Lturnos;

    @FXML
    public void initialize() {
        GestorJuego gestor = Proveedor.getInstance().getGestorJuego();
        gestor.subscribe(this);
        establecerMensajeInicial();
    }

    public void establecerMensajeInicial() {
        Protagonista prota = Proveedor.getInstance().getGestorJuego().buscarProta();
        Lmensaje.setText("¡BIENVENIDO AL JUEGO " + prota.getTipoJugador().toUpperCase());
    }

    public void onChange() {
        GestorJuego gestor = Proveedor.getInstance().getGestorJuego();
        String evento = gestor.getEvento();
        String nTurno = gestor.getNTurno();
        if (evento != null && !evento.isEmpty())
            Lmensaje.setText(evento);
        else
            Lmensaje.setText(
                    "Usa las flechas o las teclas W(arriba), A(izquierda), S(abajo) y D(derecha) para moverte."
                            + "\nMúevete hacia los enemigos para quitarles vida hasta matarlos." +
                            "\nNo te choques con las paredes, porfi.");

        if (nTurno != null && !nTurno.isEmpty())
            Lturnos.setText(nTurno);
    }

}
