package com.eve.model;

public class Protagonista extends Personaje {

    private String nombre;
    private int nivel;
    private int muertes;
    private TipoJug tipo;

    public Protagonista(TipoJug tipo, String nombre, int puntosvida, int danio, int fuerza, int defensa,
            int velocidad) {
        super(puntosvida, danio, fuerza, defensa, velocidad);
        this.nombre = nombre;
        this.tipo = tipo;
        this.muertes = 0;
        this.nivel = 1;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getMuertes() {
        return this.muertes;
    }

    public void setMuertes(int muertes) {
        this.muertes = muertes;
    }

    public TipoJug getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoJug tipo) {
        this.tipo = tipo;
    }

    public void matar() {

    }

}
