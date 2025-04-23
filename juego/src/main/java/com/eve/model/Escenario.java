package com.eve.model;

/** Clase escenario, para crear el campo e juego */

public class Escenario {

    private int[][] escenario;
    private String suelo;
    private String paredes;

    public Escenario() {

        this.escenario = new int[6][6];

    }

    public int[][] getEscenario() {
        return this.escenario;
    }

    public void setEscenario(int[][] escenario) {
        this.escenario = escenario;
    }

    public String getSuelo() {
        return this.suelo;
    }

    public void setSuelo(String suelo) {
        this.suelo = suelo;
    }

    public String getParedes() {
        return this.paredes;
    }

    public void setParedes(String paredes) {
        this.paredes = paredes;
    }

    /** Método para crear el escenario del juego, con paredes y suelos */
    public void crearEscenario() {

    }

}
