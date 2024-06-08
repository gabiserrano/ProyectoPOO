package Habilidades.Delilah;

import Habilidades.AbstractHabilidad;
import Player.Player;
import Cartas.Carta;

public class DelilahH3 extends AbstractHabilidad {
    public DelilahH3() {
        super("Destrucción de Delilah", "Shields each opponent with no cards in play then destroy all cards including yours");
    }

    @Override
    public void usarHabilidad(Player jugador) {
        System.out.println(jugador.getNombre() + " está usando la habilidad: " + this.getDescripcion());

        Tablero.Tablero tablero = jugador.getTablero();
        for (Player oponente : tablero.getJugadores()) {
            if (!oponente.equals(jugador) && oponente.getCartasActivas().isEmpty()) {
                // Lógica para escudar a cada oponente sin cartas en juego
                System.out.println(oponente.getNombre() + " es escudado por Delilah.");
                // Aquí puedes agregar la lógica para aplicar escudos a los oponentes
            }
        }

        // Destruir todas las cartas incluyendo las de Delilah
        for (Carta carta : jugador.getCartasActivas()) {
            System.out.println(jugador.getNombre() + " está destruyendo su carta: " + carta);
            jugador.getCartasActivas().remove(carta);
        }

        for (Player oponente : tablero.getJugadores()) {
            for (Carta carta : oponente.getCartasActivas()) {
                System.out.println(oponente.getNombre() + " está destruyendo su carta: " + carta);
                oponente.getCartasActivas().remove(carta);
            }
        }
    }

    @Override
    public void usarHabilidad() {
        
    }
}
