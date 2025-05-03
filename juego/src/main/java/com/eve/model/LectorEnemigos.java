package com.eve.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LectorEnemigos {

    private ArrayList<Personaje> enemigos;
    private HashMap<String, String> imagenes;

    public LectorEnemigos() {

        this.enemigos = new ArrayList<>();
        this.imagenes = new HashMap<>();
        this.imagenes.put("imagenEA1", "/com/eve/images/enemigoA1.png");
        this.imagenes.put("imagenEA2", "/com/eve/images/enemigoA2.png");
        this.imagenes.put("imagenEA3", "/com/eve/images/enemigoA3.png");
        this.imagenes.put("imagenEB1", "/com/eve/images/enemigoB1.png");
        this.imagenes.put("imagenEB2", "/com/eve/images/enemigoB2.png");
        this.imagenes.put("imagenEB3", "/com/eve/images/enemigoB3.png");
        this.imagenes.put("imagenEC1", "/com/eve/images/enemigoC1.png");
        this.imagenes.put("imagenEC2", "/com/eve/images/enemigoC2.png");
        this.imagenes.put("imagenEC3", "/com/eve/images/enemigoC3.png");
        this.imagenes.put("imagenMainBoss", "/com/eve/images/mainBoss.png");
    }

    /**
     * Método para leer el csv que se le pasa por parámetro
     * 
     * @param ficheroEntrada
     * @return una lista de los enemigos con sus datos
     * @throws Exception
     */

    public ArrayList<Personaje> leerCSV(File ficheroEntrada) throws Exception {
        this.enemigos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(ficheroEntrada))) {
            String linea;
            if ((linea = br.readLine()) == null)
                throw new Exception("Texto vacío");
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String rutaImagen = imagenes.get(datos[0]);
                this.enemigos.add(new Enemigo(rutaImagen, datos[1], Integer.parseInt(datos[2]),
                        Integer.parseInt(datos[3]), Integer.parseInt(datos[4]),
                        Integer.parseInt(datos[5]), Integer.parseInt(datos[6]), Integer.parseInt(datos[7]),
                        Integer.parseInt(datos[8]), Integer.parseInt(datos[9]), Integer.parseInt(datos[10]),
                        Integer.parseInt(datos[11]), Integer.parseInt(datos[12])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.enemigos;
    }
}