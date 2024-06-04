package Personaje;

import Habilidad.Habilidad;

public class Personaje {

    private String nombre;
    private TipoPersonaje tipoPersonaje;
    private Habilidad habilidad;

    public Personaje(String nombre, TipoPersonaje tipoPersonaje, Habilidad habilidad) {
        this.nombre = nombre;
        this.tipoPersonaje = tipoPersonaje;
        this.habilidad = habilidad;
    }



    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoPersonaje getTipoPersonaje() {
        return tipoPersonaje;
    }

    public void setTipoPersonaje(TipoPersonaje tipoPersonaje) {
        this.tipoPersonaje = tipoPersonaje;
    }
}

