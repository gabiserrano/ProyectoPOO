package Cartas;

import Habilidades.Habilidad;

public class CartaEspecial extends CartaNormal implements Carta{
    private Habilidad habilidad;

    public CartaEspecial(){
        super();
        this.habilidad = null;
    }

    public CartaEspecial(String owner){
        super(owner);
    }

    public CartaEspecial(Habilidad habilidad){
        super(0,0,0,0,0);
        this.habilidad = habilidad;
    }

    public CartaEspecial(int espadas, int corazones, int escudos, int rayos, int cartasExtra, Habilidad habilidad) {
        super(espadas,corazones,escudos,rayos,cartasExtra);
        this.habilidad = habilidad;
    }

    @Override
    public void jugarCarta(){
        habilidad.usarHabilidad();
    }
}
