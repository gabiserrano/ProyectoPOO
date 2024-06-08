package Habilidades.Blorp;

import Habilidades.AbstractHabilidad;
import Player.Player;

public class BlorpH3 extends AbstractHabilidad {
    public BlorpH3() {
        super("Ataque Doble", "Attack twice when card is destroyed");
    }

    @Override
    public void usarHabilidad(Player jugador) {
        System.out.println("Usando " + nombre + ": " + descripcion);
        jugador.setAtaqueDoble(true);
    }

    @Override
    public void usarHabilidad() {

    }
}
