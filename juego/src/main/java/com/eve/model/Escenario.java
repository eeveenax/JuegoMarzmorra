package com.eve.model;

import java.io.File;

/** Clase escenario, para crear el campo e juego */

public class Escenario {

    private String[][] escenario;
    private String suelo;
    private String paredes;

    /** Constructor de la clase escenario */

    public Escenario() {

        this.escenario = new String[8][8];

    }

    public String[][] getEscenario() {
        return this.escenario;
    }

    public void setEscenario(String[][] escenario) {
        LectorEscenario lector = new LectorEscenario();
        try {
            this.escenario = lector.leerCSV(new File("juego\\src\\main\\resources\\com\\eve\\data\\escenario.csv"));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
