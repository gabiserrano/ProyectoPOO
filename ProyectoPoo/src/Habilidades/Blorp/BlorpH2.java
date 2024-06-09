package Habilidades.Blorp;

import Cartas.Carta;
import Cartas.CartaEspecial;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class BlorpH2 extends AbstractHabilidad {

    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        for (Player opponent : opponents) {
            List<Carta> cartasActivas = opponent.getCartasActivas();
            for (Carta carta : cartasActivas) {
                if (carta instanceof CartaEspecial && ((CartaEspecial) carta).hasShield()) {
                    int shieldAmount = ((CartaEspecial) carta).getShieldAmount();
                    cartasActivas.remove(carta);
                    player.setVida(player.getVida() + shieldAmount);
                    System.out.println(player.getNombre() + " ha destruido la carta de escudo " + carta + " de " + opponent.getNombre() + " y se ha curado " + shieldAmount + " puntos de vida.");
                    return;
                }
            }
        }
        System.out.println("No se encontró ninguna carta de escudo para destruir.");
    }

}
