package com.eve.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Protagonista extends Personaje {

    private int nivel;
    private int muertes;
    private int xp;
    private String protaChico = "/com/eve/images/protaChico.png";
    private String protaChica = "/com/eve/images/protaChica.png";
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
    public void moverPersonaje(int nuevaFila, int nuevaCol, String[][] escenario) {
        GestorJuego gestor = Proveedor.getInstance().getGestorJuego();
        int[] pos = this.getPosicion();
        escenario[pos[0]][pos[1]] = "s";
        this.setPosicion(new int[] { nuevaFila, nuevaCol });
        escenario[nuevaFila][nuevaCol] = "" + this.id;
        gestor.setEvento("");

        gestor.notifyObservers();
    }

    @Override
    public void atacarPersonaje(int nuevaFila, int nuevaCol, String[][] escenario) {
        Random r = new Random();
        ArrayList<Personaje> personajes = Proveedor.getInstance().getGestorJuego().getPersonajes();
        GestorJuego gestor = Proveedor.getInstance().getGestorJuego();

        // Datos del enemigo
        int id = Integer.parseInt(escenario[nuevaFila][nuevaCol]);
        Enemigo enemigo = gestor.buscarEnemigo(id);
        int vidaEnemigo = enemigo.getPuntosvida();
        int defensaEnemigo = enemigo.getDefensa();
        int xpDa = enemigo.getXpDan();
        int vidaDa = enemigo.getVidaDan();
        int defensaDan = enemigo.getDefensaDan();

        int danioAenemigo = this.fuerza - defensaEnemigo;
        if (r.nextInt(100) < this.porcentajeCritico)
            danioAenemigo *= 2;

        if (danioAenemigo > 0) {
            vidaEnemigo -= danioAenemigo;
            enemigo.setPuntosvida(vidaEnemigo);
            gestor.notifyObservers();
        }

        if (vidaEnemigo <= 0) {
            this.puntosvida += vidaDa;
            this.xp += xpDa;
            this.defensa += defensaDan;
            this.muertes++;
            this.fuerza = this.fuerza + enemigo.getFuerzaDan();
            gestor.subirNivel();
            escenario[nuevaFila][nuevaCol] = "s";
            gestor.setEvento("Enemigo Asesinado con el ID: " + enemigo.getId() + ". Recibes " + enemigo.getVidaDan()
                    + " de vida, " + enemigo.getXpDan() + " de experiencia, " + enemigo.getFuerzaDan() + " de fuerza y "
                    + enemigo.getDefensaDan() + " de defensa.");

            for (Iterator<Personaje> iterator = personajes.iterator(); iterator.hasNext();) {
                Personaje p = iterator.next();
                if (p.getId() == enemigo.getId()) {
                    iterator.remove();
                    break;
                }
            }
            gestor.notifyObservers();
        }

    }

    @Override
    public String toString() {
        return super.toString() + " Muertes: " + this.muertes + " Nvl:  " + this.nivel + " XP: " + this.xp
                + " Tipo de jugador: " + this.tipoJugador;
    }

}
