package Habilidades.Blorp;

import Habilidades.AbstractHabilidad;
import Player.Player;

/**
 * La clase BlorpH1 representa una habilidad especial en el juego que permite a un jugador ignorar los escudos de los oponentes durante el turno actual.
 */
public class BlorpH1 extends AbstractHabilidad {

    /**
     * Constructor para la clase BlorpH1.
     * Inicializa la habilidad con el nombre "Ataque Penetrante" y la descripción "This turn, attacks ignore shields".
     */
    public BlorpH1() {
        super("Ataque Penetrante", "This turn, attacks ignore shields");
    }

    /**
     * Usa la habilidad específica en un jugador, permitiéndole ignorar los escudos durante el turno actual.
     *
     * @param jugador el jugador que usará la habilidad
     */
    @Override
    public void usarHabilidad(Player jugador) {
        System.out.println("Usando " + nombre + ": " + descripcion);
        jugador.setIgnorarEscudos(true);
    }

    /**
     * Método sobreescrito de AbstractHabilidad, actualmente no implementado.
     */
    @Override
    public void usarHabilidad() {
        // Método no implementado
    }
}
