package com.eve.model;

import java.util.Random;

/** Clase enemigo, para contruir a los enemigos */
public class Enemigo extends Personaje {

    private int percepcion;
    private int xpDan;
    private int vidaDan;
    private int defensaDan;
    private int fuerzaDan;

    public Enemigo() {
        super();
    }

    /**
     * Construtor de la clase enemigos
     * 
     * @param nombre            de los enemigos
     * @param puntosvida        de los enemigos
     * @param porcentajeCritico para que hagan más daño de forma aleatoria
     * @param fuerza            con la que pegan los enemigos
     * @param defensa           o escudo de los enemigos
     * @param velocidad         de movimiento, establece el orden de peferencia de
     *                          movimiento
     * @param vidaDan           Vida que dan cuando se les mata
     * @param xpDan             Experiencia que dan cuando se les mata
     * @param percepcion        determina si el enemigo se mueve hace el prota o no
     * @param defensaDan        Defensa que da el enemigo al protagonista cuando
     *                          muere
     * @param fuerzaDanº        Fuerza que da el enemigo al protagonista cuando
     *                          muere
     */
    public Enemigo(String imagen, String nombre, int puntosvida, int porcentajeCritico, int fuerza, int defensa,
            int xpDan, int vidaDan,
            int velocidad,
            int percepcion, int defensaDan, int fuerzaDan, int id) {
        super(imagen, nombre, puntosvida, porcentajeCritico, fuerza, defensa, velocidad, id);
        this.percepcion = percepcion;
        this.vidaDan = vidaDan;
        this.xpDan = xpDan;
        this.defensaDan = defensaDan;
        this.fuerzaDan = fuerzaDan;

    }

    /**
     * Getter de la percepción. Según la percepción, si el enemigo detecta al prota,
     * este va a por él, si no se mueve de forma aleatoria.
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

    /**
     * Getter de la experiencia que le dan al prota cuando se mueve, así el prota
     * puede subir de nivel y enfrentarse a enemigos más tochos.
     * 
     * @return xpDan: experiencia que dan
     */
    public int getXpDan() {
        return this.xpDan;
    }

    public void setXpDan(int xpDan) {
        this.xpDan = xpDan;
    }

    /**
     * Vida que dan al prota al morirse, para que este tenga menos dificultades en
     * las próximas luchas
     * 
     * @return vidaDan
     */
    public int getVidaDan() {
        return this.vidaDan;
    }

    public void setVidaDan(int vidaDan) {
        this.vidaDan = vidaDan;
    }

    /**
     * Getter de la denfesa que le dan al prota cuando se muere, así el prota está
     * más protegido.
     * 
     * @return defensaDan
     */
    public int getDefensaDan() {
        return this.defensaDan;
    }

    public void setDefensaDan(int defensaDan) {
        this.defensaDan = defensaDan;
    }

    /**
     * Getter de la fuerza que le dan al prota cuando se muere, de esta forma, el
     * prota puede enfrentarse a enemigos más poderosos.
     * 
     * @return fuerzaDan
     */
    public int getFuerzaDan() {
        return this.fuerzaDan;
    }

    public void setFuerzaDan(int fuerzaDan) {
        this.fuerzaDan = fuerzaDan;
    }

    @Override
    public void moverPersonaje(int nuevaFila, int nuevaCol, String[][] escenario) {
        GestorJuego gestor = Proveedor.getInstance().getGestorJuego();
        int[] pos = this.getPosicion();
        escenario[pos[0]][pos[1]] = "s";
        this.setPosicion(new int[] { nuevaFila, nuevaCol });
        escenario[nuevaFila][nuevaCol] = "" + this.id;
        gestor.notifyObservers();
    }

    @Override
    public void atacarPersonaje(int nuevaFila, int nuevaCol, String[][] escenario) {
        Random r = new Random();
        GestorJuego gestor = Proveedor.getInstance().getGestorJuego();
        // Datos del protagonista
        Protagonista protagonista = gestor.buscarProta();
        int vidaProta = protagonista.getPuntosvida();
        int defensaProta = protagonista.getDefensa();
        int danioAPersonaje = this.fuerza - defensaProta;
        if (r.nextInt(100) < this.porcentajeCritico)
            danioAPersonaje *= 2;
        if (danioAPersonaje > 0) {
            vidaProta -= danioAPersonaje;
            protagonista.setPuntosvida(vidaProta);
            gestor.notifyObservers();
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.xpDan + " " + this.vidaDan + " " + this.percepcion;
    }

}
