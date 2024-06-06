package Cartas;

import Habilidades.Habilidades;

public class CartaEspecial extends CartaNormal implements Carta{
    private Habilidades habilidad;

    public CartaEspecial(int espadas, int corazones, int escudos, int rayos, int cartasExtra, Habilidades habilidad) {
        super(espadas,corazones,escudos,rayos,cartasExtra);
        this.habilidad = habilidad;
    }

    @Override
    public void jugarCarta(){

        habilidad.usarHabilidad();
    }
}