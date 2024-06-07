package Habilidades.Azzan;

import Habilidades.AbstractHabilidad;
import Player.Player;
import Tablero.Tablero;

public abstract class AzzanH1 extends AbstractHabilidad {
    public AzzanH1(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    @Override
    public void usarHabilidad() {

        Player thisJugador = getJugador();


        Tablero tablero = thisJugador.getTablero();


        for (Player jugador : tablero.getJugadores()) {
            jugador.recibirDanio(3);
        }
    }

    // Método para obtener el jugador actual
    private Player getJugador() {

        return new Player();
    }
}
