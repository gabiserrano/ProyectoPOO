package Habilidades.Delilah;

import Habilidades.AbstractHabilidad;
import Player.Player;

/**
 * La clase DelilahH1 representa una habilidad especial en el juego que permite a cada oponente
 * decidir si quiere alabar la grandeza de Delilah, afectando los escudos.
 */
public class DelilahH1 extends AbstractHabilidad {

    /**
     * Constructor para la clase DelilahH1.
     * Inicializa la habilidad con el nombre "Grandeza de Delilah" y la descripción
     * "Each opponent can choose to praise your greatness shields".
     */
    public DelilahH1() {
        super("Grandeza de Delilah", "Each opponent can choose to praise your greatness shields");
    }

    /**
     * Usa la habilidad específica en un jugador, permitiendo a cada oponente decidir si quiere alabar
     * la grandeza de Delilah y afectar los escudos del jugador.
     *
     * @param jugador el jugador que usará la habilidad
     */
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

    /**
     * Método sobreescrito de AbstractHabilidad, actualmente no implementado.
     */
    @Override
    public void usarHabilidad() {
        // Método no implementado
    }
}

