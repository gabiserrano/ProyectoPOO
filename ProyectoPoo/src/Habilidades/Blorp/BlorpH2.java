package Habilidades.Blorp;

import Cartas.Carta;
import Habilidades.AbstractHabilidad;
import Player.Player;

/**
 * La clase BlorpH2 representa una habilidad especial en el juego que permite a un jugador destruir una carta de escudo
 * y curarse la cantidad de escudos que tenía la carta destruida.
 */
public class BlorpH2 extends AbstractHabilidad {

    /**
     * Constructor para la clase BlorpH2.
     * Inicializa la habilidad con el nombre "Destrucción de Escudo" y la descripción
     * "Destroy a shield card and heal the amount of shields the card had".
     */
    public BlorpH2() {
        super("Destrucción de Escudo", "Destroy a shield card and heal the amount of shields the card had");
    }

    /**
     * Usa la habilidad específica en un jugador, destruyendo una carta de escudo y curando al jugador
     * la cantidad de escudos que tenía la carta.
     *
     * @param jugador el jugador que usará la habilidad
     */
    @Override
    public void usarHabilidad(Player jugador) {
        System.out.println("Usando " + nombre + ": " + descripcion);

        // Busca una carta de escudo en las cartas activas
        Carta cartaEscudo = jugador.getCartasActivas().stream()
                .filter(Carta::esCartaEscudo)
                .findFirst()
                .orElse(null);

        if (cartaEscudo != null) {
            jugador.destruirCartaEscudo(cartaEscudo);
            jugador.curar(cartaEscudo.getValorEscudo());  // Asumiendo que hay un método para curar al jugador basado en el valor del escudo
        } else {
            System.out.println("No hay cartas de escudo para destruir.");
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

