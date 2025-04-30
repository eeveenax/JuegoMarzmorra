package com.eve.model;

import java.io.File;

/** Clase escenario, para crear el campo e juego */

public class Escenario {
    private String[][] escenario;
    private final String suelo = "/com/eve/images/suelo.png";
    private final String pared = "/com/eve/images/pared.png";

    /** Constructor de la clase escenario */
    public Escenario() {
        this.escenario = new String[8][8];
        setEscenario("");
    }

    public String[][] getEscenario() {
        return this.escenario;
    }

    /**
     * Método para leer el csv del esceanrio y rellenar la matriz
     * 
     * @param fileName
     */
    public void setEscenario(String fileName) {
        LectorEscenario lector = new LectorEscenario();
        if (fileName.isEmpty())
            fileName = "juego\\src\\main\\resources\\com\\eve\\data\\escenario.csv";
        try {
            this.escenario = lector.leerCSV(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Ruta de la imagen de suelo
     * 
     * @return suelo
     */

    public String getSuelo() {
        return this.suelo;
    }

    /**
     * Ruta de la imagen de pared
     * 
     * @return pared
     */

    public String getPared() {
        return this.pared;
    }

}
