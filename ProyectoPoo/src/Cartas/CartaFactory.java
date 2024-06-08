package Cartas;

import Habilidades.Habilidad;

public interface CartaFactory {
    public Carta createCartaNormal();
    public Carta createCartaNormal(int espadas, int corazones, int escudos, int rayos, int cartasExtra);
    public Carta createCartaEspecial();
    public Carta createCartaEspecial(int espadas, int corazones, int escudos, int rayos, int cartasExtra, Habilidad habilidad);
    public Carta createCartaEspecial(Habilidad habilidad);
}