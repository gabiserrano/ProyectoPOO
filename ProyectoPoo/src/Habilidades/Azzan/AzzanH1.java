package Habilidades.Azzan;

import Habilidades.AbstractHabilidad;
import Player.Player;
import Tablero.Tablero;

public class AzzanH1 extends AbstractHabilidad {
    public AzzanH1() {
        super("Ataque de Azzan", "Inflicts 3 damage points to all opponents.");
    }

    @Override
    public void usarHabilidad(Player thisJugador) {
        Tablero tablero = thisJugador.getTablero();
        for (Player jugador : tablero.getJugadores()) {
            if (!jugador.equals(thisJugador)) {
                jugador.recibirDanio(3);
            }
        }
    }

    @Override
    public void usarHabilidad() {

    }
}

