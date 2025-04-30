package com.eve.model;

public class Proveedor {
    private static Proveedor instance;
    private GestorJuego gestorJuego;

    private Proveedor() {
        this.gestorJuego = new GestorJuego();
    }

    /**
     * Instancia de clase del proveedor, patrón singleton
     * 
     * @return instancia del proveedor
     */

    public static Proveedor getInstance() {
        if (instance == null) {
            instance = new Proveedor();
        }
        return instance;
    }

    /**
     * Instancia del Gestor del juedo que tienen el proveedor
     * 
     * @return gestorJuego
     */
    public GestorJuego getGestorJuego() {
        return this.gestorJuego;
    }

    public void setGestorDragones(GestorJuego gestorJuego) {
        this.gestorJuego = gestorJuego;
    }
}
