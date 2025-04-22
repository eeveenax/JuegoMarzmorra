package com.eve.model;

public class Protagonista extends Personaje {

    private String nombre;
    private int nivel;
    private int muertes;

    public Protagonista(int puntosvida, int danio, int fuerza, int defensa, int velocidad) {
        super(puntosvida, danio, fuerza, defensa, velocidad);
        this.nombre = nombre;
        this.muertes = 0;
        this.nivel = 1;
    }

    public void matar() {

    }

}
