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

    public GestorJuego() {
        this.escenario = new Escenario();
        this.personajes = new ArrayList<>();
        this.enemigos = new HashMap<>();
        this.enemigos.put("nivel1", "juego\\src\\main\\resources\\com\\eve\\data\\enemigos1.csv");
        this.enemigos.put("nivel2", "juego\\src\\main\\resources\\com\\eve\\data\\enemigos2.csv");
        this.enemigos.put("nivel3", "juego\\src\\main\\resources\\com\\eve\\data\\enemigos3.csv");
        this.enemigos.put("nivel4", "juego\\src\\main\\resources\\com\\eve\\data\\enemigos4.csv");
        this.enemigos.put("nivel5", "juego\\src\\main\\resources\\com\\eve\\data\\enemigos5.csv");

        try {
            this.personajes.addAll(
                    lectorEnemigo.leerCSV(new File(enemigos.get("nivel1"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.observers = new ArrayList<>();
    }

    /**
     * Escenario
     * 
     * @return escenario
     */

    public Escenario getEscenario() {
        return this.escenario;
    }

    public void setEscenario(Escenario escenario) {
        this.escenario = escenario;
    }

    /**
     * Lista de personajes
     * 
     * @return personajes
     */

    public ArrayList<Personaje> getPersonajes() {
        return this.personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    /**
     * Mensaje para la <<consola>>
     * 
     * @return evento
     */
    public String getEvento() {
        return this.evento;
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(item -> item.onChange());
    }

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

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
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

    public void setLectorEnemigo(LectorEnemigos lectorEnemigo) {
        this.lectorEnemigo = lectorEnemigo;
    }

    /**
     * Mapa de rutas por niveles para el lector de los Enemigos
     * 
     * @return enemigos
     */
    public HashMap<String, String> getEnemigos() {
        return this.enemigos;
    }

    public void setEnemigos(HashMap<String, String> enemigos) {
        this.enemigos = enemigos;
    }

    public void reconstruirEscenario(String ficheroEscenario) {
        this.escenario.setEscenario(ficheroEscenario);

    }

}
