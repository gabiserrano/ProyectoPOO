package Habilidades.Azzan;

import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class AzzanH1 extends AbstractHabilidad {

    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        // Definir la cantidad de daño
        int damage = 3;

        // Iterar sobre cada oponente y aplicar el daño
        for (Player opponent : opponents) {
            opponent.recibirDanio(damage);
            System.out.println(opponent.getNombre() + " ha recibido " + damage + " puntos de daño.");
        }

        // Aplicar el daño al jugador actual
        player.recibirDanio(damage);
        System.out.println(player.getNombre() + " ha recibido " + damage + " puntos de daño.");
    }

}
