package Habilidades.Delilah;

import Habilidades.AbstractHabilidad;
import Player.Player;

/**
 * La clase DelilahH2 representa una habilidad especial en el juego que permite a un jugador
 * elegir el objetivo de todas las cartas de escudo hasta su próximo turno.
 */
public class DelilahH2 extends AbstractHabilidad {

    /**
     * Constructor para la clase DelilahH2.
     * Inicializa la habilidad con el nombre "Control de Escudos de Delilah" y la descripción
     * "Until your next turn, choose the target of all shields cards".
     */
    public DelilahH2() {
        super("Control de Escudos de Delilah", "Until your next turn, choose the target of all shields cards");
    }

    /**
     * Usa la habilidad específica en un jugador, permitiéndole elegir el objetivo de todas las cartas de escudo
     * hasta su próximo turno.
     *
     * @param jugador el jugador que usará la habilidad
     */
    @Override
    public void usarHabilidad(Player jugador) {
        System.out.println(jugador.getNombre() + " está usando la habilidad: " + this.getDescripcion());

        // Delilah elige el objetivo de todas las cartas de escudo hasta su próximo turno
        jugador.setControlarObjetivoEscudos(true);
    }

    /**
     * Método sobreescrito de AbstractHabilidad, actualmente no implementado.
     */
    @Override
    public void usarHabilidad() {
        // Método no implementado
    }
}
