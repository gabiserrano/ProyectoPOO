package Habilidades.Delilah;

import Habilidades.AbstractHabilidad;
import Player.Player;

public class DelilahH1 extends AbstractHabilidad {
    public DelilahH1() {
        super("Grandeza de Delilah", "Each opponent can choose to praise your greatness shields");
    }

    @Override
    public void usarHabilidad(Player jugador) {
        System.out.println(jugador.getNombre() + " está usando la habilidad: " + this.getDescripcion());

        // Obtener todos los oponentes
        Tablero.Tablero tablero = jugador.getTablero();
        for (Player oponente : tablero.getJugadores()) {
            if (!oponente.equals(jugador)) {
                // Lógica para que cada oponente decida si quiere "alabar" los escudos de Delilah
                System.out.println(oponente.getNombre() + " puede decidir si alabar o no los escudos de Delilah.");
                // Aquí puedes agregar la lógica para que los oponentes tomen su decisión
            }
        }
    }

    @Override
    public void usarHabilidad() {

    }
}
