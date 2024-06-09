package Habilidades.Blorp;

import Habilidades.AbstractHabilidad;
import Player.Player;

/**
 * La clase BlorpH3 representa una habilidad especial en el juego que permite a un jugador atacar dos veces cuando una carta es destruida.
 */
public class BlorpH3 extends AbstractHabilidad {

    /**
     * Constructor para la clase BlorpH3.
     * Inicializa la habilidad con el nombre "Ataque Doble" y la descripción "Attack twice when card is destroyed".
     */
    public BlorpH3() {
        super("Ataque Doble", "Attack twice when card is destroyed");
    }

    /**
     * Usa la habilidad específica en un jugador, permitiéndole realizar un ataque doble cuando una carta es destruida.
     *
     * @param jugador el jugador que usará la habilidad
     */
    @Override
    public void usarHabilidad(Player jugador) {
        System.out.println("Usando " + nombre + ": " + descripcion);
        jugador.setAtaqueDoble(true);
    }

    /**
     * Método sobreescrito de AbstractHabilidad, actualmente no implementado.
     */
    @Override
    public void usarHabilidad() {
        // Método no implementado
    }
}
