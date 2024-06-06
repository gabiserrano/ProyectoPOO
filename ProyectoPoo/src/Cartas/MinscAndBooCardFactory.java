package Cartas;

import Habilidades.Habilidad;

public class MinscAndBooCardFactory implements CartaFactory {
    @Override
    public Carta createCartaNormal() {
        String owner = "MinscAndBoo";
        return new CartaNormal(owner);
    }

    public Carta createCartaNormal(int espadas, int corazones, int escudos, int rayos, int cartasExtra){
        String owner = "MinscAndBoo";
        return new CartaNormal(owner, espadas,corazones,escudos,rayos,cartasExtra);
    }

    @Override
    public Carta createCartaEspecial() {
        String owner = "MinscAndBoo";
        return new CartaEspecial(owner);
    }

    public Carta createCartaEspecial(int espadas, int corazones, int escudos, int rayos, int cartasExtra, Habilidad habilidad){
        String owner = "MinscAndBoo";
        return new CartaEspecial(owner, espadas,corazones,escudos,rayos,cartasExtra, habilidad);
    }

    public Carta createCartaEspecial(Habilidad habilidad) {
        String owner = "MinscAndBoo";
        return new CartaEspecial(owner, habilidad);
    }
}