package com.eve.model;

public class Personaje implements Comparable {

    private int puntosvida;
    private int porcentajeCritico;
    private int fuerza;
    private int defensa;
    private int velocidad;
    private String nombre;
    private String imagen;
    protected int[] posicion;
    protected int id;

    public Personaje() {
        this.puntosvida = 0;
        this.porcentajeCritico = 0;
        this.fuerza = 0;
        this.defensa = 0;
        this.velocidad = 0;
        this.nombre = "eve";
        this.posicion = new int[2];
        this.id = 0;
    }

    /**
     * Constructor parametrizado de los personajes
     * 
     * @param imagen
     * @param nombre
     * @param puntosvida
     * @param porcentajeCritico
     * @param fuerza
     * @param defensa
     * @param velocidad
     * @param id
     */
    public Personaje(String imagen, String nombre, int puntosvida, int porcentajeCritico, int fuerza, int defensa,
            int velocidad, int id) {
        this.puntosvida = puntosvida;
        this.porcentajeCritico = porcentajeCritico;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.nombre = nombre;
        this.imagen = imagen;
        this.posicion = new int[2];
        this.id = id;
    }

    /**
     * Puntos de vida de los personajes
     * 
     * @return puntosVida
     */

    public int getPuntosvida() {
        return this.puntosvida;
    }

    public void setPuntosvida(int puntosvida) {
        this.puntosvida = puntosvida;
    }

    /**
     * Porcentaje Critico de los personajes
     * 
     * @return porcentajeCritico
     */

    public int getPorcentajeCritico() {
        return this.porcentajeCritico;
    }

    public void setPorcentajeCritico(int danio) {
        this.porcentajeCritico = danio;
    }

    /**
     * Fuerza de los personajes
     * 
     * @return fuerza
     */
    public int getFuerza() {
        return this.fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    /**
     * Defensa de los personajes
     * 
     * @return defensa
     */
    public int getDefensa() {
        return this.defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    /**
     * Velocidad de los personajes
     * 
     * @return velocidad
     */
    public int getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * Nombre de los personajes
     * 
     * @return nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    public void setVelocidad(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Imagen de los personajes
     * 
     * @return imagen
     */

    public String getImagen() {
        return this.imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * 
     * Posicion de los personajes
     * 
     * @return posicion
     */
    public int[] getPosicion() {
        return this.posicion;
    }

    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }

    /**
     * Id unico de los personajes
     * 
     * @return id
     */

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Personaje)) {
            throw new IllegalArgumentException("Objeto no es de tipo Personaje");
        }
        Personaje otro = (Personaje) o;
        return Integer.compare(otro.velocidad, this.velocidad);
    }

    @Override
    public String toString() {
        return "Personaje: HP: " + this.puntosvida + " def " + this.defensa + "fr  " + this.fuerza + " img "
                + this.imagen + " name "
                + this.nombre
                + " speed " + this.velocidad + " % " + this.porcentajeCritico + " id " + this.id;
    }

}
