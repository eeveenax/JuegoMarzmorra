package com.eve.model;

import java.util.HashMap;

public class ProtasEstadisticas {
    private HashMap<String, HashMap<String, Integer>> estadisticas;

    public ProtasEstadisticas() {
        this.estadisticas = new HashMap<>();
        HashMap<String, Integer> estadisticasAsesino = new HashMap<>();
        estadisticasAsesino.put("puntosVida", 50);
        estadisticasAsesino.put("fuerza", 30);
        estadisticasAsesino.put("defensa", 20);
        estadisticasAsesino.put("velocidad", 80);
        estadisticasAsesino.put("porcentajeCritico", 25);
        HashMap<String, Integer> estadisticasAventurero = new HashMap<>();
        estadisticasAventurero.put("puntosVida", 70);
        estadisticasAventurero.put("fuerza", 15);
        estadisticasAventurero.put("defensa", 30);
        estadisticasAventurero.put("velocidad", 50);
        estadisticasAventurero.put("porcentajeCritico", 15);
        HashMap<String, Integer> estadisticasProtector = new HashMap<>();
        estadisticasProtector.put("puntosVida", 100);
        estadisticasProtector.put("fuerza", 10);
        estadisticasProtector.put("defensa", 40);
        estadisticasProtector.put("velocidad", 30);
        estadisticasProtector.put("porcentajeCritico", 10);
        this.estadisticas.put("asesino", estadisticasAsesino);
        this.estadisticas.put("aventurero", estadisticasAventurero);
        this.estadisticas.put("protector", estadisticasProtector);
    }

    /**
     * Mapa con las estadísticas de los protagonistas según su tipo
     * 
     * @return Mapa de estadísticas.
     */

    public HashMap<String, HashMap<String, Integer>> getEstadisticas() {
        return this.estadisticas;
    }

    /**
     * Método para establecer las estadísticas del prota
     * 
     * @param estadisticas de los protas según el rol
     */

    public void setEstadisticas(HashMap<String, HashMap<String, Integer>> estadisticas) {
        this.estadisticas = estadisticas;
    }

}
