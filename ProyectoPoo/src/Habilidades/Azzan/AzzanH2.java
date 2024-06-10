package Habilidades.Azzan;

import Cartas.Carta;
import Cartas.CartaEspecial;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

/**
 * La clase AzzanH2 representa una habilidad específica para un personaje llamado Azzan.
 * Esta habilidad permite al jugador tomar y usar una carta de escudo activa de un oponente.
 */
public class AzzanH2 extends AbstractHabilidad {

    /**
     * Este método aplica la habilidad al jugador y a sus oponentes.
     *
     * @param player    El jugador que usa la habilidad.
     * @param opponents La lista de oponentes a los que se les puede tomar una carta de escudo.
     */
    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        // Iterar sobre cada oponente
        for (Player opponent : opponents) {
            // Obtener las cartas activas del oponente
            List<Carta> cartasActivas = opponent.getCartasActivas();

            // Buscar la primera carta de escudo encontrada
            for (Carta carta : cartasActivas) {
                if (carta instanceof CartaEspecial && ((CartaEspecial) carta).hasShield()) {
                    // Remover la carta de escudo del oponente
                    cartasActivas.remove(carta);

                    // Añadir la carta de escudo a las cartas activas del jugador
                    player.getCartasActivas().add(carta);

                    System.out.println(player.getNombre() + " ha tomado la carta de escudo " + carta + " de " + opponent.getNombre() + " y la está usando.");

                    // Salir después de tomar y usar una carta de escudo
                    return;
                }
            }
        }

        // Si no se encontró ninguna carta de escudo
        System.out.println("No se encontró ninguna carta de escudo para tomar y usar.");
    }
}
