package com.eve.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

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
                    Protagonista prota = (Protagonista) p;
                    prota.realizarAccionProta(teclaPresionada);
                } else {
                    Enemigo enemigo = (Enemigo) p;
                    enemigo.realizarAccionEnemigo();
                    if (enemigo.getPuntosvida() <= 0) {
                        this.personajes.remove(enemigo);
                    }
                }
            }
        }
        notifyObservers();
    }

}
