package com.eve.model;

public class Personaje {

private  int puntosvida;
private int danio;
private int fuerza;
private int defensa;
private int velocidad;

public Personaje(int puntosvida, int danio, int fuerza, int defensa, int velocidad) {
    this.puntosvida = puntosvida;
    this.danio = danio;
    this.fuerza = fuerza;
    this.defensa = defensa;
    this.velocidad = velocidad; 
}

    public int getPuntosvida() {
        return this.puntosvida;
    }

    public void setPuntosvida(int puntosvida) {
        this.puntosvida = puntosvida;
    }

    public int getDanio() {
        return this.danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return this.defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }


}
