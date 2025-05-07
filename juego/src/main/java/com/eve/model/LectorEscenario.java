package com.eve.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class LectorEscenario {
    private String[][] escenario;
    int numFilas = 0;
    int numColumnas = 0;

    public LectorEscenario() {
    }

    /**
     * Método para la lectura del fichero csv de los escenarios
     * Se crea la variable fila para establecer que fila de la matriz ha de
     * rellenarse con los datos del array DATOS.
     * 
     * @param ficheroEntrada ruta del fichero de entrada a leer
     * @return la matriz completada con los elementos que deben usarse: p para pared
     *         y s para suelo
     * @throws Exception
     */

    public String[][] leerCSV(File ficheroEntrada) throws IOException {
        LinkedList<String[]> filas = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ficheroEntrada))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.trim().split(",");
                filas.add(datos);
            }
        }
        if (filas.isEmpty()) {
            throw new IOException("El archivo CSV está vacío.");
        }
        numFilas = filas.size();
        numColumnas = filas.get(0).length;
        this.escenario = new String[numFilas][numColumnas];

        for (int i = 0; i < numFilas; i++) {
            if (filas.get(i).length != numColumnas) {
                throw new IOException("El archivo CSV tiene filas con distinto número de columnas.");
            } else {
                for (int j = 0; j < numColumnas; j++) {
                    this.escenario[i][j] = filas.get(i)[j];
                }
            }
        }
        setNumColumnas(numColumnas);
        setNumFilas(numFilas);

        return this.escenario;
    }

    /**
     * Método para devolver el escenario creado y a partir de este, establecer el
     * escenario del juego
     * 
     * @return escenario
     */
    public String[][] getEscenario() {
        return this.escenario;
    }

    /**
     * Método para establecer el escenario, que se rellenará con los datos del
     * lector y se usará para crear el escenario del juego
     * 
     * @param escenario del juego.
     */

    public void setEscenario(String[][] escenario) {
        this.escenario = escenario;
    }

    /**
     * Número de filas del escenario
     * 
     * @return entero del número de filas del escenario
     */

    public int getNumFilas() {
        return this.numFilas;
    }

    /**
     * Método para establecer el número de filas del escenario
     * 
     * @param numFilas del escenario.
     */
    public void setNumFilas(int numFilas) {
        this.numFilas = numFilas;
    }

    /**
     * Número de columnas del escenario
     * 
     * @return entero del número de columnas del escenario
     */
    public int getNumColumnas() {
        return this.numColumnas;
    }

    /**
     * Método para establecer el número de columnas del escenario
     * 
     * @param numColumnas del escenario.
     */
    public void setNumColumnas(int numColumnas) {
        this.numColumnas = numColumnas;
    }

}