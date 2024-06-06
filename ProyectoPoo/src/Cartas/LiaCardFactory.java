package Cartas;

import Habilidades.Habilidad;

public class LiaCardFactory implements CartaFactory {
    @Override
    public Carta createCartaNormal() {
        String owner = "Lia";
        return new CartaNormal(owner);
    }

    public Carta createCartaNormal(int espadas, int corazones, int escudos, int rayos, int cartasExtra){
        String owner = "Lia";
        return new CartaNormal(owner, espadas,corazones,escudos,rayos,cartasExtra);
    }

    @Override
    public Carta createCartaEspecial() {
        String owner = "Lia";
        return new CartaEspecial(owner);
    }

    public Carta createCartaEspecial(int espadas, int corazones, int escudos, int rayos, int cartasExtra, Habilidad habilidad){
        String owner = "Lia";
        return new CartaEspecial(owner, espadas,corazones,escudos,rayos,cartasExtra, habilidad);
    }
}