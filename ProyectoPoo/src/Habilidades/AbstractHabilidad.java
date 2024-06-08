package Habilidades;

import Player.Player;

public abstract class AbstractHabilidad implements Habilidad {
    protected String nombre;
    protected String descripcion;

    // Constructor
    public AbstractHabilidad(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Método abstracto para usar la habilidad
    public abstract void usarHabilidad(Player jugador);

    // Getters para nombre y descripción
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

