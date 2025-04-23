package com.eve.model;

import java.util.ArrayList;

public class GestorJuego {

    private Escenario escenario;
    private ArrayList<Personaje> personajes;

    public GestorJuego() {

        this.escenario = new Escenario();
        this.personajes = new ArrayList<>();

    }

    public Escenario getEscenario() {
        return this.escenario;
    }

    public void setEscenario(Escenario escenario) {
        this.escenario = escenario;
    }

    public ArrayList<Personaje> getPersonajes() {
        return this.personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

}
