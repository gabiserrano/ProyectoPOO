package Cartas;

import Habilidades.Habilidad;

public class AzzanCardFactory implements CartaFactory {
    @Override
    public Carta createCartaNormal() {
        String owner = "Azzan";
        return new CartaNormal(owner);
    }

    public Carta createCartaNormal(int espadas, int corazones, int escudos, int rayos, int cartasExtra){
        String owner = "Azzan";
        return new CartaNormal(owner, espadas,corazones,escudos,rayos,cartasExtra);
    }

    @Override
    public Carta createCartaEspecial() {
        return new CartaEspecial();
    }

    public Carta createCartaEspecial(int espadas, int corazones, int escudos, int rayos, int cartasExtra, Habilidad habilidad){
        String owner = "Azzan";
        return new CartaEspecial(owner, espadas,corazones,escudos,rayos,cartasExtra,habilidad);
    }

    @Override
    public Carta createCartaEspecial(Habilidad habilidad) {
        String owner = "Azzan";
        return new CartaEspecial(owner, habilidad);
    }
}
