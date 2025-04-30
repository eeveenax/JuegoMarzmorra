package com.eve.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LectorEscenario {
    private String[][] escenario;

    public LectorEscenario() {
        this.escenario = new String[8][8];
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

    public String[][] leerCSV(File ficheroEntrada) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(ficheroEntrada))) {
            String linea;
            int fila = 0;
            while ((linea = br.readLine()) != null && fila < 8) {
                String[] datos = linea.split(",");
                for (int j = 0; j < 8; j++) {
                    escenario[fila][j] = datos[j];
                }
                fila++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Error al leer el archivo: " + e.getMessage());
        }
        return this.escenario;
    }

}