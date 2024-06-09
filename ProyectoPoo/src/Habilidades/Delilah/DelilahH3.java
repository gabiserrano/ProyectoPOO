package Habilidades.Delilah;

import Habilidades.AbstractHabilidad;
import Player.Player;
import Cartas.Carta;
import java.util.ArrayList;

/**
 * La clase DelilahH3 representa una habilidad especial en el juego que permite escudar a cada oponente
 * que no tenga cartas en juego y luego destruir todas las cartas, incluidas las del jugador que usa la habilidad.
 */
public class DelilahH3 extends AbstractHabilidad {

    /**
     * Constructor para la clase DelilahH3.
     * Inicializa la habilidad con el nombre "Destrucción de Delilah" y la descripción
     * "Shields each opponent with no cards in play then destroy all cards including yours".
     */
    public DelilahH3() {
        super("Destrucción de Delilah", "Shields each opponent with no cards in play then destroy all cards including yours");
    }

    /**
     * Usa la habilidad específica en un jugador, escudando a cada oponente que no tenga cartas en juego y
     * luego destruyendo todas las cartas, incluidas las del jugador que usa la habilidad.
     *
     * @param jugador el jugador que usará la habilidad
     */
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
        for (Carta carta : new ArrayList<>(jugador.getCartasActivas())) {
            System.out.println(jugador.getNombre() + " está destruyendo su carta: " + carta);
            jugador.getCartasActivas().remove(carta);
        }

        for (Player oponente : tablero.getJugadores()) {
            for (Carta carta : new ArrayList<>(oponente.getCartasActivas())) {
                System.out.println(oponente.getNombre() + " está destruyendo su carta: " + carta);
                oponente.getCartasActivas().remove(carta);
            }
        }
    }

    /**
     * Método sobreescrito de AbstractHabilidad, actualmente no implementado.
     */
    @Override
    public void usarHabilidad() {
        // Método no implementado
    }
}

