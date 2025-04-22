package com.eve.model;

/** Clase escenario, para crear el campo e juego */

public class Escenario {

    private int[][] escenario;

    public Escenario() {

        this.escenario = new int[6][6];

    }

    public int[][] getEscenario() {
        return this.escenario;
    }

    public void setEscenario(int[][] escenario) {
        this.escenario = escenario;
    }

    /** Método para crear el escenario del juego, con paredes y suelos */
    public void crearEscenario() {

    }

}
