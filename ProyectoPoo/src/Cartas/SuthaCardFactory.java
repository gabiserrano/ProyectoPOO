package Cartas;

import Habilidades.Habilidad;

public class SuthaCardFactory implements CartaFactory {
    @Override
    public Carta createCartaNormal() {
        String owner = "Sutha";
        return new CartaNormal(owner, "Carta de Lia");
    }

    public Carta createCartaNormal(int espadas, int corazones, int escudos, int rayos, int cartasExtra){
        String owner = "Sutha";
        return new CartaNormal(owner, espadas,corazones,escudos,rayos,cartasExtra);
    }

    @Override
    public Carta createCartaEspecial() {
        String owner = "Sutha";
        return new CartaEspecial(owner);
    }

    public Carta createCartaEspecial(int espadas, int corazones, int escudos, int rayos, int cartasExtra, Habilidad habilidad){
        String owner = "Sutha";
        return new CartaEspecial(owner, espadas,corazones,escudos,rayos,cartasExtra, habilidad);
    }

    public Carta createCartaEspecial(Habilidad habilidad) {
        String owner = "Sutha";
        return new CartaEspecial(owner, habilidad);
    }
}