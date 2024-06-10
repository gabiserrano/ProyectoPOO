package Habilidades.Azzan;

import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

/**
 * La clase AzzanH1 representa una habilidad específica para un personaje llamado Azzan.
 * Esta habilidad causa daño tanto al jugador que la usa como a todos los oponentes.
 */
public class AzzanH1 extends AbstractHabilidad {

    /**
     * Este método aplica la habilidad al jugador y a sus oponentes.
     *
     * @param player    El jugador que usa la habilidad.
     * @param opponents La lista de oponentes que recibirán daño.
     */
    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        // Definir la cantidad de daño que se aplicará
        int damage = 3;

        // Iterar sobre cada oponente y aplicar el daño correspondiente
        for (Player opponent : opponents) {
            opponent.recibirDanio(damage);
            System.out.println(opponent.getNombre() + " ha recibido " + damage + " puntos de daño.");
        }

        // Aplicar el daño al jugador que usa la habilidad
        player.recibirDanio(damage);
        System.out.println(player.getNombre() + " ha recibido " + damage + " puntos de daño.");
    }
}
