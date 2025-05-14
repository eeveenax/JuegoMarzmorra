package com.eve.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/** Clase escenario, para crear el campo e juego */

public class Escenario {
    private String[][] escenario;
    private final String suelo = "/com/eve/images/suelo.png";
    private final String pared = "/com/eve/images/pared.png";
    private final String trampa = "/com/eve/images/trampa.png";
    LectorEscenario lector = new LectorEscenario();
    private int[] posT = new int[2];

    /** Constructor de la clase escenario */
    public Escenario() {
        setEscenario("");
        verPosicionTrampa();
    }

    public int[] getPosT() {
        return this.posT;
    }

    public void setPosT(int[] posT) {
        this.posT = posT;
    }

    public void verPosicionTrampa() {
        for (int i = 0; i < escenario.length; i++) {
            for (int j = 0; j < escenario[i].length; j++) {
                if (escenario[i][j].equals("t")) {
                    setPosT(new int[] { i, j });
                }
            }
        }
        System.out.println("Posicion trampa: " + getPosT()[0] + " " + getPosT()[1]);
    }

    /**
     * Método para conseguir el escenario
     * 
     * @return una matriz de Strings que representa el escenario
     */

    public String[][] getEscenario() {
        return this.escenario;
    }

    /**
     * Método para leer el csv del esceanrio y rellenar la matriz
     * 
     * @param fileName del archivo que se lee para conseguir la estructura del
     *                 escenario
     */
    public void setEscenario(String fileName) {
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

    public LectorEscenario getLector() {
        return this.lector;
    }

    public void setLector(LectorEscenario lector) {
        this.lector = lector;
    }

    public String getTrampa() {
        return this.trampa;
    }

    public void generarPosiciones() {
        GestorJuego gestorJuego = Proveedor.getInstance().getGestorJuego();
        HashSet<String> posicionesOcupadas = new HashSet<>();
        ArrayList<Personaje> personajes = gestorJuego.getPersonajes();
        Random r = new Random();
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i) instanceof Protagonista) {
                personajes.get(i).setPosicion(new int[] { 0, 0 });
                posicionesOcupadas.add("0-0");
                escenario[0][0] = "" + personajes.get(i).getId();
            }
            if (personajes.get(i) instanceof Enemigo) {
                int posX, posY;
                do {
                    posX = r.nextInt(escenario.length);
                    posY = r.nextInt(escenario[0].length);
                } while (!escenario[posX][posY].equals("s") || posicionesOcupadas.contains(posX + "-" + posY));

                personajes.get(i).setPosicion(new int[] { posX, posY });
                escenario[posX][posY] = "" + personajes.get(i).getId();
            }
        }
        gestorJuego.notifyObservers();
    }

}
