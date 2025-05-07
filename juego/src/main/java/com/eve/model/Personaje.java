package com.eve.model;

public abstract class Personaje implements Comparable {
    protected int puntosvida;
    protected int porcentajeCritico;
    protected int fuerza;
    protected int defensa;
    protected int velocidad;
    protected String nombre;
    protected String imagen;
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
     * @param imagen            del personaje, enemigo o prota
     * @param nombredel         personaje, enemigo o prota
     * @param puntosvida        del personaje, enemigo o prota
     * @param porcentajeCritico del personaje, enemigo o prota
     * @param fuerza            del personaje, enemigo o prota
     * @param defensa           del personaje, enemigo o prota
     * @param velocidad         del personaje, enemigo o prota
     * @param id                del personaje, enemigo o prota
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

    /**
     * Método para establecer los puntos de vida del personaje
     * 
     * @param puntosvida
     */
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

    /**
     * Método para establecer el porcentaje crítico de los personajes, según este
     * porcentaje, harán más o menos daño si el resultado obtenido a partir de un
     * random cumple con la probabilidad establecida en el porcentaje critico de que
     * su fuerza aumente.
     * 
     * @param danio
     */
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

    /**
     * Método para establecer la fuerza de los personajes
     * 
     * @param fuerza
     */
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    /**
     * Defensa de los personajes, la defensa del prota
     * aumenta cuando matan a los enemigos
     * 
     * @return defensa
     */
    public int getDefensa() {
        return this.defensa;
    }

    /**
     * Método para establecer la defensa de los personajes
     * 
     * @param defensa
     */
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    /**
     * Velocidad de los personajes, según esta, los personajes se ordenan y se
     * establecen los turnos de movimiento.
     * 
     * @return velocidad
     */
    public int getVelocidad() {
        return this.velocidad;
    }

    /**
     * Método para establecer la velocidad de los personajes
     * 
     * @param velocidad
     */
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

    /**
     * Método para darle nombre a los personajes
     * 
     * @param nombre
     */
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

    /**
     * Método para darle una imagen a los personajes
     * 
     * @param imagen
     */
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

    /**
     * Método para darle posicion a los personajes
     * 
     * @param posicion
     */
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

    /**
     * Método para darle un id a los personajes
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método para mover a los personajes. Reciben la nueva posición (fila, columna)
     * y el escenario, para moverlos a esa nueva posición en el escenario
     * 
     * @param nuevaFila
     * @param nuevaCol
     * @param escenario
     */
    public void moverPersonaje(int nuevaFila, int nuevaCol, String[][] escenario) {

    }

    /**
     * Método para atacar a los personajes. Reciben la nueva posición (fila,
     * columna)
     * y el escenario, para atacar al personaje de esa nueva posición en el
     * escenario
     * 
     * @param nuevaFila
     * @param nuevaCol
     * @param escenario
     */
    public void atacarPersonaje(int nuevaFila, int nuevaCol, String[][] escenario) {

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
