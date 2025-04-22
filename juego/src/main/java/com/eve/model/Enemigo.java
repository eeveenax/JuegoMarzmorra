package com.eve.model;

public class Enemigo {

private int percepcion;

public Enemigo(int puntosvida, int danio, int fuerza, int defensa, int velocidad, int percepcion) {
    super(puntosvida, danio, fuerza, defensa, velocidad);
    this.percepcion = percepcion;
}


    public int getPercepcion() {
        return this.percepcion;
    }

    public void setPercepcion(int percepcion) {
        this.percepcion = percepcion;
    }


}


