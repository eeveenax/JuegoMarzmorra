package com.eve.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LectorEnemigos {

    private String[][] escenario;

    public LectorEnemigos() {
        this.escenario = new String[8][8];

    }

    public String[][] leerCSV(File ficheroEntrada) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(ficheroEntrada))) {
            String linea;

            if ((linea = br.readLine()) == null)
                throw new Exception("Texto vacío");

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.escenario;
    }

}