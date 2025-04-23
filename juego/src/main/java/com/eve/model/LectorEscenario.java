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

    public String[][] leerCSV(File ficheroEntrada) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(ficheroEntrada))) {
            String linea;

            if ((linea = br.readLine()) == null)
                throw new Exception("Texto vacío");

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                for (int i = 0; i < escenario.length; i++) {
                    for (int j = 0; j < escenario[i].length; j++) {
                        escenario[i][j] = datos[j];
                    }

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.escenario;
    }

}