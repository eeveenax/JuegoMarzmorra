package com.eve.model;

/** Clase enemigo, para contruir a los enemigos */
public class Enemigo extends Personaje {

    private int percepcion;

    /**
     * Construtor de la clase enemigos
     * 
     * @param puntosvida
     * @param danio
     * @param fuerza
     * @param defensa
     * @param velocidad
     * @param percepcion
     */

    public Enemigo(int puntosvida, int danio, int fuerza, int defensa, int velocidad, int percepcion) {
        super(puntosvida, danio, fuerza, defensa, velocidad);
        this.percepcion = percepcion;
    }

    /**
     * Getter de la percepción
     * 
     * @return la percepción del enemigo, para detectar al protagonista e ir hace
     *         él/ella
     */
    public int getPercepcion() {
        return this.percepcion;
    }

    /**
     * Setter de la percepción
     * 
     * @param percepcion
     */
    public void setPercepcion(int percepcion) {
        this.percepcion = percepcion;
    }

}
