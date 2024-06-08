package Habilidades.Blorp;

import Habilidades.AbstractHabilidad;
import Player.Player;

public abstract class BlorpH1 extends AbstractHabilidad {
    public BlorpH1() {
        super("Ataque Penetrante", "This turn, attacks ignore shields");
    }

    @Override
    public void usarHabilidad(Player jugador) {
        System.out.println("Usando " + nombre + ": " + descripcion);
        jugador.setIgnorarEscudos(true);
    }
}
