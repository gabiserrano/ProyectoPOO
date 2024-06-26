package Cartas;

import Habilidades.Habilidad;

public class BlorpCardFactory implements CartaFactory {
    @Override
    public Carta createCartaNormal() {
        String owner = "Blorp";
        return new CartaNormal(owner, "Carta de Lia");
    }

    public Carta createCartaNormal(int espadas, int corazones, int escudos, int rayos, int cartasExtra){
        String owner = "Blorp";
        return new CartaNormal(owner, espadas,corazones,escudos,rayos,cartasExtra);
    }

    @Override
    public Carta createCartaEspecial() {
        String owner = "Blorp";
        return new CartaEspecial(owner);
    }

    public Carta createCartaEspecial(int espadas, int corazones, int escudos, int rayos, int cartasExtra, Habilidad habilidad){
        String owner = "Blorp";
        return new CartaEspecial(owner, espadas,corazones,escudos,rayos,cartasExtra, habilidad);
    }

    @Override
    public Carta createCartaEspecial(Habilidad habilidad) {
        String owner = "Blorp";
        return new CartaEspecial(owner, habilidad);
    }
}