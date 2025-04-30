package com.eve.model;

public class Protagonista extends Personaje {

    private int nivel;
    private int muertes;
    private int xp;
    private String protaChico = "/com/eve/images/chico.png";
    private String protaChica = "/com/eve/images/chica.png";
    private String tipoJugador;

    public Protagonista() {
        super();
        this.muertes = 0;
        this.nivel = 1;
        this.xp = 0;
        this.tipoJugador = "AVENTURERO";
    }

    /**
     * Contructor de la clase Protagonista
     * 
     * @param nombre            del personaje protagonista
     * @param puntosvida
     * @param porcentajeCritico
     * @param fuerza
     * @param defensa
     * @param velocidad *
     * @param puntosvida        de los enemigos
     * @param porcentajeCritico para que hagan más daño de forma aleatoria
     * @param fuerza            con la que pegan los enemigos
     * @param defensa           o escudo de los enemigos
     * @param velocidad         de movimiento, establece el orden de peferencia de
     *                          movimiento
     * @param tipoJugador       Tipo del jugador, según este se determinan sus
     *                          estadísticas.
     * @param nivel             nivel del prota, 0 al iniciarse el juego
     * @param xp                experiencia para subir de nivel
     */

    public Protagonista(String imagen, String nombre, int puntosvida, int porcentajeCritico, int fuerza, int defensa,
            int velocidad, String tipoJugador, int id) {
        super(imagen, nombre, puntosvida, porcentajeCritico, fuerza, defensa, velocidad, id);
        this.muertes = 0;
        this.nivel = 1;
        this.xp = 0;
        this.posicion = new int[] { 0, 0 };
        this.tipoJugador = tipoJugador;
    }

    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Muerte de los enemigos que matan los personajes
     * 
     * @return muertes
     */
    public int getMuertes() {
        return this.muertes;
    }

    public void setMuertes(int muertes) {
        this.muertes = muertes;
    }

    /**
     * Expericencia de los personajes
     * 
     * @return xp
     */

    public int getXp() {
        return this.xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     * Conseguir la imagen del personaje chico
     * 
     * @return protaChico
     */

    public String getProtaChico() {
        return this.protaChico;
    }

    public void setProtaChico(String protaChico) {
        this.protaChico = protaChico;
    }

    /**
     * Conseguir la imagen del personaje chica
     * 
     * @return protaChica
     */

    public String getProtaChica() {
        return this.protaChica;
    }

    public void setProtaChica(String protaChica) {
        this.protaChica = protaChica;
    }

    /**
     * Tipo de jugador del prota
     * 
     * @return tipoJugador
     */
    public String getTipoJugador() {
        return this.tipoJugador;
    }

    public void setTipoJugador(String tipoJugador) {
        this.tipoJugador = tipoJugador;
    }

    @Override
    public String toString() {
        return super.toString() + " Muertes: " + this.muertes + " Nvl:  " + this.nivel + " XP: " + this.xp
                + " Tipo de jugador: " + this.tipoJugador;
    }

}
