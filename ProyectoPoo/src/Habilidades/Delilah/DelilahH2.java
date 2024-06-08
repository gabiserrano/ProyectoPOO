package Habilidades.Delilah;

import Habilidades.AbstractHabilidad;
import Player.Player;

public class DelilahH2 extends AbstractHabilidad {
    public DelilahH2() {
        super("Control de Escudos de Delilah", "Until your next turn, choose the target of all shields cards");
    }

    @Override
    public void usarHabilidad(Player jugador) {
        System.out.println(jugador.getNombre() + " está usando la habilidad: " + this.getDescripcion());

        // Delilah elige el objetivo de todas las cartas de escudo hasta su próximo turno
        jugador.setControlarObjetivoEscudos(true);
    }

    @Override
    public void usarHabilidad() {

    }
}
