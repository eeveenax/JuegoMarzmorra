package com.eve.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
     * Setter de la percepción, para establecer la percepción de los enemigos. Según
     * esta, si detectana al prota en su rango de percepcion, van a por él/ella y
     * le ataca.
     * 
     * @param percepcion del enemigo
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

    /**
     * Método para establecer la experiencia que dan los enemigos al prota al morir.
     * 
     * @param xpDan del enemigo
     */

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

    /**
     * Método para establecer la vida que dan los enemigos al prota al
     * morir.
     * 
     * @param vidaDan el enemigo al morir
     */
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

    /**
     * Método para establecer la defensa que dan los enemigos al prota al morir.
     * 
     * @param defensaDan el enemigo al morir
     */
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

    /**
     * Método para establecer la fuerza que dan los enemigos al prota al morir.
     * 
     * @param fuerzaDan el enemigo al morir
     */
    public void setFuerzaDan(int fuerzaDan) {
        this.fuerzaDan = fuerzaDan;
    }

    /**
     * Método para que el enemigo que se recibe por parámetro relalice su accion
     * (mover o atacar) correspondiente.
     * 
     * @param enemigo que debe realizar una acción
     */
    public void realizarAccionEnemigo() {
        GestorJuego gestorJuego = Proveedor.getInstance().getGestorJuego();
        String[][] escenario = gestorJuego.getEscenario().getEscenario();
        Random r = new Random();
        int[] posicionProta = gestorJuego.buscarProta().getPosicion();
        int[] posicionEnemigo = this.getPosicion();
        int percepcion = this.getPercepcion();
        int[] posAux = new int[] { posicionEnemigo[0] - posicionProta[0], posicionEnemigo[1] - posicionProta[1] };
        if (Math.abs(posAux[0]) <= percepcion && Math.abs(posAux[1]) <= percepcion) {
            String[] auxX = new String[2];
            String[] auxY = new String[2];
            LinkedList<String> direcciones = new LinkedList<>();
            /* Teclas a la inversa */
            if (posAux[1] > 0) {
                auxX = new String[] { "A", "D" };
            } else {
                auxX = new String[] { "D", "A" };
            }
            if (posAux[0] > 0) {
                auxY = new String[] { "W", "S" };
            } else {
                auxY = new String[] { "S", "W" };
            }
            if (posAux[1] == 0) {
                direcciones.add(auxY[0]);
                direcciones.add(auxX[0]);
                direcciones.add(auxY[1]);
                direcciones.add(auxX[1]);
            } else if (posAux[0] == 0) {
                direcciones.add(auxX[0]);
                direcciones.add(auxY[0]);
                direcciones.add(auxX[1]);
                direcciones.add(auxY[1]);
            } else {
                /* por teclas a la inversa */
                if (Math.abs(posAux[1]) < Math.abs(posAux[0])) {
                    direcciones.add(auxX[0]);
                    direcciones.add(auxY[0]);
                    direcciones.add(auxX[1]);
                    direcciones.add(auxY[1]);
                } else {
                    direcciones.add(auxY[0]);
                    direcciones.add(auxX[0]);
                    direcciones.add(auxY[1]);
                    direcciones.add(auxX[1]);
                }
            }
            boolean accionRealizada = false;
            while (!accionRealizada && direcciones.size() > 0) {
                String direccion = direcciones.getFirst();
                direcciones.remove(direccion);
                String accion = comprobarAccion(posicionEnemigo, direccion);
                switch (direccion) {
                    case "W":
                        switch (accion) {
                            case "mover":
                                this.moverPersonaje(posicionEnemigo[0] - 1, posicionEnemigo[1],
                                        escenario);
                                accionRealizada = true;
                                break;
                            case "atacar":
                                if (escenario[posicionEnemigo[0] - 1][posicionEnemigo[1]]
                                        .equals("" + gestorJuego.buscarProta().getId())) {
                                    this.atacarPersonaje(posicionEnemigo[0] - 1, posicionEnemigo[1],
                                            escenario);
                                    accionRealizada = true;
                                }
                                break;
                            default:
                                break;
                        }
                        break;
                    case "A":
                        switch (accion) {
                            case "mover":
                                this.moverPersonaje(posicionEnemigo[0], posicionEnemigo[1] - 1,
                                        escenario);
                                accionRealizada = true;
                                break;
                            case "atacar":

                                if (escenario[posicionEnemigo[0]][posicionEnemigo[1] - 1]
                                        .equals("" + gestorJuego.buscarProta().getId())) {
                                    this.atacarPersonaje(posicionEnemigo[0], posicionEnemigo[1] - 1,
                                            escenario);
                                    accionRealizada = true;
                                }
                                break;
                            default:
                                break;
                        }
                        break;
                    case "S":
                        switch (accion) {
                            case "mover":
                                this.moverPersonaje(posicionEnemigo[0] + 1, posicionEnemigo[1],
                                        escenario);
                                accionRealizada = true;
                                break;
                            case "atacar":
                                if (escenario[posicionEnemigo[0] + 1][posicionEnemigo[1]]
                                        .equals("" + gestorJuego.buscarProta().getId())) {
                                    this.atacarPersonaje(posicionEnemigo[0] + 1, posicionEnemigo[1],
                                            escenario);
                                    accionRealizada = true;
                                }
                                break;
                            default:
                                break;
                        }
                        break;
                    case "D":
                        switch (accion) {
                            case "mover":
                                this.moverPersonaje(posicionEnemigo[0], posicionEnemigo[1] + 1,
                                        escenario);
                                accionRealizada = true;
                                break;
                            case "atacar":
                                if (escenario[posicionEnemigo[0]][posicionEnemigo[1] + 1]
                                        .equals("" + gestorJuego.buscarProta().getId())) {
                                    this.atacarPersonaje(posicionEnemigo[0], posicionEnemigo[1] + 1,
                                            escenario);
                                    accionRealizada = true;
                                }
                                break;

                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
        } else {
            ArrayList<String> direcciones = new ArrayList<>(Arrays.asList("A", "W", "S", "D"));
            boolean movido = false;
            while (!movido && direcciones.size() > 0) {
                String direccion = direcciones.get(r.nextInt(direcciones.size()));
                direcciones.remove(direccion);
                if (comprobarAccion(posicionEnemigo, direccion).equals("mover")) {
                    movido = true;
                    switch (direccion) {
                        case "W":
                            this.moverPersonaje(posicionEnemigo[0] - 1, posicionEnemigo[1],
                                    escenario);
                            break;
                        case "A":
                            this.moverPersonaje(posicionEnemigo[0], posicionEnemigo[1] - 1,
                                    escenario);
                            break;
                        case "S":
                            this.moverPersonaje(posicionEnemigo[0] + 1, posicionEnemigo[1],
                                    escenario);
                            break;
                        case "D":
                            this.moverPersonaje(posicionEnemigo[0], posicionEnemigo[1] + 1,
                                    escenario);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
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
