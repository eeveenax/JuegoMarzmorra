package com.eve.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

import com.eve.interfaces.Observer;

public class GestorJuego {
    Escenario escenario;
    ArrayList<Personaje> personajes;
    ArrayList<Observer> observers;
    LectorEnemigos lectorEnemigo = new LectorEnemigos();
    HashMap<String, String> enemigos;
    String evento = "";
    String nTurno = "";

    public GestorJuego() {
        this.escenario = new Escenario();
        this.personajes = new ArrayList<>();
        this.enemigos = new HashMap<>();
        this.enemigos.put("nivel1", "juego\\src\\main\\resources\\com\\eve\\data\\enemigos1.csv");
        this.enemigos.put("nivel2", "juego\\src\\main\\resources\\com\\eve\\data\\enemigos2.csv");
        this.enemigos.put("nivel3", "juego\\src\\main\\resources\\com\\eve\\data\\enemigos3.csv");
        this.enemigos.put("nivel4", "juego\\src\\main\\resources\\com\\eve\\data\\enemigos4.csv");
        this.enemigos.put("nivel5", "juego\\src\\main\\resources\\com\\eve\\data\\enemigos5.csv");
        this.observers = new ArrayList<>();
        agregarEnemigos("nivel1");
    }

    public void agregarEnemigos(String nivel) {
        try {
            this.personajes.addAll(
                    lectorEnemigo.leerCSV(new File(enemigos.get(nivel))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Escenario del juego
     * 
     * @return escenario
     */

    public Escenario getEscenario() {
        return this.escenario;
    }

    /**
     * Método para establecer el escenario del juego
     * 
     * @param escenario para establecer el escenario del juego
     */
    public void setEscenario(Escenario escenario) {
        this.escenario = escenario;
    }

    /**
     * Método para conseguir la lista de personajes del juego
     * 
     * @return personajes
     */

    public ArrayList<Personaje> getPersonajes() {
        return this.personajes;
    }

    /**
     * Método para establecer la lista de personajes del juego.
     * 
     * @param personajes lista de personajes
     * 
     */

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    /**
     * Método para estabelcer el mensaje en consola, viendo así los turnos de los
     * personajes y las estadísticas de un enemigo asesinado, si se mata a un
     * enemigo.
     * 
     * @param evento mensaje que aparecerán en la vista consola
     */
    public void setEvento(String evento) {
        this.evento = evento;
    }

    /**
     * Método para conseguir el mensaje para la vista y controlador <i>consola</i>,
     * para saber si se mata a
     * un
     * enemigo, a cual y los turnos de los personajes
     * 
     * @return evento
     */
    public String getEvento() {
        return this.evento;
    }

    /**
     * Método para obtener y exponer el mensaje de los turnos
     * 
     * @return nTurno
     */
    public String getNTurno() {
        return this.nTurno;
    }

    /**
     * Método para establecer el mensaje de turnos de los personajes.
     * 
     * @param nTurno mensaje sobre los turnos
     */
    public void setNTurno(String nTurno) {
        this.nTurno = nTurno;
    }

    /**
     * Método para buscar de forma más sencilla al prota, ya que solo hay uno.
     * 
     * @return protagonista
     */
    public Protagonista buscarProta() {
        Protagonista prota = null;
        boolean encontrado = false;
        for (int i = 0; i < this.personajes.size() && !encontrado; i++) {
            if (personajes.get(i) instanceof Protagonista) {
                prota = (Protagonista) personajes.get(i);
                encontrado = true;
            }
        }
        return prota;
    }

    /**
     * Método para buscar de forma más sencilla a un enemigo, para obtener sus datos
     * cuando el prota le ataca.
     * 
     * @param id del enemigo que se busca
     * @return enemigo por ID buscado
     */
    public Enemigo buscarEnemigo(int id) {
        for (Personaje p : personajes) {
            if (p.getId() == id && p instanceof Enemigo) {
                return (Enemigo) p;
            }
        }
        return null;
    }

    /**
     * Lista de observadores, controladores a la escucha de eventos
     * 
     * @return observers
     */
    public ArrayList<Observer> getObservers() {
        return this.observers;
    }

    /**
     * Método para establecer los observadores del juego
     * 
     * @param observers lista de los observadores del juego.
     */
    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    /**
     * Método para suscribir a los observadores a la lista de observadores, así
     * cuando haya un cambio estarán a ala escucha y se reflejará el cambio
     * 
     * @param observer que se suscribe
     */
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    /**
     * Método para desuscribir a los observadores a la lista de observadores, así
     * dejarán de estar a la escuchca de los cambios.
     * 
     * @param observer que se desuscribe
     */
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(item -> item.onChange());
    }

    /**
     * Lector de enemigos, para iniciar el juego con el grid cargado con los
     * enemigos
     * 
     * @return lectorEnemigo
     */

    public LectorEnemigos getLectorEnemigo() {
        return this.lectorEnemigo;
    }

    /**
     * Método para establecer el lector de enemigos.
     * 
     * @param lectorEnemigo para leer el fichero de los enemigos
     */

    public void setLectorEnemigo(LectorEnemigos lectorEnemigo) {
        this.lectorEnemigo = lectorEnemigo;
    }

    /**
     * Método para consegir el mapa de rutas por niveles para el lector de los
     * Enemigos
     * 
     * @return enemigos
     */
    public HashMap<String, String> getEnemigos() {
        return this.enemigos;
    }

    /**
     * Método para establecer el mapa de rutas por niveles para el lector de los
     * 
     * @param enemigos mapa de los enemigos (nivel del prota, ruta al fichero de los
     *                 enemigos a leer)
     */
    public void setEnemigos(HashMap<String, String> enemigos) {
        this.enemigos = enemigos;
    }

    /**
     * Método para establcer los turnos. La teclaPresionada se guarda para que el
     * prota en su turno sepa hacia donde moverse.
     * 
     * @param teclaPresionada dirección de movimiento del prota
     */
    public void turno(String teclaPresionada) {
        String turnos = "";
        for (Personaje p : this.personajes) {
            turnos += p.getNombre() + " ";
        }
        setNTurno("Orden de turnos: " + turnos);
        ArrayList<Personaje> copiaPersonajes = new ArrayList<>(this.personajes);
        for (Personaje p : copiaPersonajes) {
            if (this.personajes.contains(p)) {
                if (p instanceof Protagonista) {
                    realizarAccionProta(teclaPresionada);
                } else {
                    Enemigo enemigo = (Enemigo) p;
                    realizarAccionEnemigo(enemigo);
                }
            }
        }
        notifyObservers();
    }

    /**
     * Método para que el enemigo que se recibe por parámetro relalice su accion
     * (mover o atacar) correspondiente.
     * 
     * @param enemigo que debe realizar una acción
     */
    public void realizarAccionEnemigo(Enemigo enemigo) {
        Random r = new Random();
        int[] posicionProta = buscarProta().getPosicion();
        int[] posicionEnemigo = enemigo.getPosicion();
        int percepcion = enemigo.getPercepcion();
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
                                enemigo.moverPersonaje(posicionEnemigo[0] - 1, posicionEnemigo[1],
                                        escenario.getEscenario());
                                accionRealizada = true;
                                break;
                            case "atacar":
                                if (escenario.getEscenario()[posicionEnemigo[0] - 1][posicionEnemigo[1]]
                                        .equals("" + buscarProta().getId())) {
                                    enemigo.atacarPersonaje(posicionEnemigo[0] - 1, posicionEnemigo[1],
                                            escenario.getEscenario());
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
                                enemigo.moverPersonaje(posicionEnemigo[0], posicionEnemigo[1] - 1,
                                        escenario.getEscenario());
                                accionRealizada = true;
                                break;
                            case "atacar":

                                if (escenario.getEscenario()[posicionEnemigo[0]][posicionEnemigo[1] - 1]
                                        .equals("" + buscarProta().getId())) {
                                    enemigo.atacarPersonaje(posicionEnemigo[0], posicionEnemigo[1] - 1,
                                            escenario.getEscenario());
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
                                enemigo.moverPersonaje(posicionEnemigo[0] + 1, posicionEnemigo[1],
                                        escenario.getEscenario());
                                accionRealizada = true;
                                break;
                            case "atacar":
                                if (escenario.getEscenario()[posicionEnemigo[0] + 1][posicionEnemigo[1]]
                                        .equals("" + buscarProta().getId())) {
                                    enemigo.atacarPersonaje(posicionEnemigo[0] + 1, posicionEnemigo[1],
                                            escenario.getEscenario());
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
                                enemigo.moverPersonaje(posicionEnemigo[0], posicionEnemigo[1] + 1,
                                        escenario.getEscenario());
                                accionRealizada = true;
                                break;
                            case "atacar":
                                if (escenario.getEscenario()[posicionEnemigo[0]][posicionEnemigo[1] + 1]
                                        .equals("" + buscarProta().getId())) {
                                    enemigo.atacarPersonaje(posicionEnemigo[0], posicionEnemigo[1] + 1,
                                            escenario.getEscenario());
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
                            enemigo.moverPersonaje(posicionEnemigo[0] - 1, posicionEnemigo[1],
                                    escenario.getEscenario());
                            break;
                        case "A":
                            enemigo.moverPersonaje(posicionEnemigo[0], posicionEnemigo[1] - 1,
                                    escenario.getEscenario());
                            break;
                        case "S":
                            enemigo.moverPersonaje(posicionEnemigo[0] + 1, posicionEnemigo[1],
                                    escenario.getEscenario());
                            break;
                        case "D":
                            enemigo.moverPersonaje(posicionEnemigo[0], posicionEnemigo[1] + 1,
                                    escenario.getEscenario());
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    /**
     * Método para que el prota realice su acción (mover o atacar) correspondiente
     * en base a la tecla presionada.
     * Con esta tecla se decide si el prota se mueve (porque la casilla nueva es un
     * suelo vacío) o
     * ataca.
     * 
     * @param teclaPresionada dirección que debe tomar el prota.
     */

    public void realizarAccionProta(String teclaPresionada) {
        Protagonista prota = buscarProta();
        String[][] escenario = this.escenario.getEscenario();
        // Escucha de teclado
        int[] posicion = prota.getPosicion();
        String accion = comprobarAccion(prota.getPosicion(), teclaPresionada);
        switch (teclaPresionada) {
            case "W":
                switch (accion) {
                    case "mover":
                        prota.moverPersonaje(posicion[0] - 1, posicion[1], escenario);
                        break;
                    case "atacar":
                        prota.atacarPersonaje(posicion[0] - 1, posicion[1], escenario);
                        break;
                    default:
                        break;
                }
                break;
            case "A":
                switch (accion) {
                    case "mover":
                        prota.moverPersonaje(posicion[0], posicion[1] - 1, escenario);
                        break;
                    case "atacar":
                        prota.atacarPersonaje(posicion[0], posicion[1] - 1, escenario);
                        break;
                    default:
                        break;
                }
                break;
            case "S":
                switch (accion) {
                    case "mover":
                        prota.moverPersonaje(posicion[0] + 1, posicion[1], escenario);
                        break;
                    case "atacar":
                        prota.atacarPersonaje(posicion[0] + 1, posicion[1], escenario);
                        break;
                    default:
                        break;
                }
                break;
            case "D":
                switch (accion) {
                    case "mover":
                        prota.moverPersonaje(posicion[0], posicion[1] + 1, escenario);
                        break;
                    case "atacar":
                        prota.atacarPersonaje(posicion[0], posicion[1] + 1, escenario);
                        break;

                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    /**
     * Método para comprobar si la acción (mover o atacar) se puede llevar a cabo.
     * En el caso de los enemigos, si pueden moverse o atacar, ya sea a partir de la
     * percecpión (se mueve hacia el prota) o de forma aleatoria.
     * En el caso del prota, si en base a la tecla presionada se pueden mover o no,
     * así como atacar o no (según si hay un enemigo en la "nueva posición").
     * 
     * @param posiciones en las que esta el protagonista
     * @param movimiento dirección a la que moverse
     * @return la acción a realizar.
     *         Este método es reutilizable en ambos personajes (enemigos y prota).
     */
    public String comprobarAccion(int[] posiciones, String movimiento) {
        String[][] escenario = this.escenario.getEscenario();
        String accion = "";
        switch (movimiento) {
            case "W":
                if (posiciones[0] - 1 >= 0) {
                    if (escenario[posiciones[0] - 1][posiciones[1]].equals("s"))
                        return "mover";
                    else if (!escenario[posiciones[0] - 1][posiciones[1]].equals("p"))
                        return "atacar";
                    else
                        return "nada";
                }
                break;
            case "A":
                if (posiciones[1] - 1 >= 0) {
                    if (escenario[posiciones[0]][posiciones[1] - 1].equals("s"))
                        return "mover";
                    else if (!escenario[posiciones[0]][posiciones[1] - 1].equals("p"))
                        return "atacar";
                    else
                        return "nada";
                }
                break;
            case "S":
                if (posiciones[0] + 1 < escenario.length) {
                    if (escenario[posiciones[0] + 1][posiciones[1]].equals("s"))
                        return "mover";
                    else if (!escenario[posiciones[0] + 1][posiciones[1]].equals("p"))
                        return "atacar";
                    else
                        return "nada";
                }
                break;
            case "D":
                if (posiciones[1] + 1 < escenario[0].length) {
                    if (escenario[posiciones[0]][posiciones[1] + 1].equals("s"))
                        return "mover";
                    else if (!escenario[posiciones[0]][posiciones[1] + 1].equals("p"))
                        return "atacar";
                    else
                        return "nada";
                }
                break;
            default:
                break;
        }
        return accion;
    }

    public void subirNivel() {
        Protagonista prota = buscarProta();
        int xp = prota.getXp();
        int nivelActual = prota.getNivel();
        int nuevoNivel = calcularNivelPorXP(xp);
        boolean nivelCambio = false;

        if (nuevoNivel > nivelActual) {
            prota.setNivel(nuevoNivel);
            notifyObservers();
            nivelCambio = true;
        }
        if (nivelCambio) {
            String nivelS = "";
            switch (nuevoNivel) {
                case 2:
                    nivelS = getEnemigos().get("nivel2");
                    break;
                case 3:
                    nivelS = getEnemigos().get("nivel3");
                    break;
                case 4:
                    nivelS = getEnemigos().get("nivel4");
                    break;
                case 5:
                    nivelS = getEnemigos().get("nivel5");
                    break;
            }
            nuevosEnemigos(nivelS);
        }

    }

    /**
     * Método para cambiar a los enemigos cuando el prota sube de nivel
     * Si tuvieramos más escenarios, habría que pasarle la ruta del escenario para
     * que se lea en setEscenario
     *
     * @param nivel del prota
     * 
     */
    public void nuevosEnemigos(String nivel) {
        Protagonista protagonista = buscarProta();
        ArrayList<Personaje> personajesNuevos = new ArrayList<>();
        protagonista.setPosicion(new int[] { 0, 0 });
        try {
            personajesNuevos.add(protagonista);
            personajesNuevos.addAll(this.lectorEnemigo.leerCSV(new File(nivel)));
            personajesNuevos.sort(null);
            this.personajes = personajesNuevos;
            getEscenario().setEscenario("");
            getEscenario().generarPosiciones();
            notifyObservers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para saber si el prota tiene suficiente experiecnia para subir o no
     * de nivel.
     * 
     * @param xp del prota
     * @return el número del nivel de que corresponde en base a su experiencia
     */
    public int calcularNivelPorXP(int xp) {
        if (xp >= 4000)
            return 5;
        if (xp >= 2600 && xp < 4000)
            return 4;
        if (xp >= 1200 && xp < 2600)
            return 3;
        if (xp >= 500 && xp < 1200)
            return 2;
        return 1;
    }

}
