package Habilidades.Sutha;

import Cartas.Carta;
import Cartas.CartaEspecial;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class SuthaH1 extends AbstractHabilidad {
    public SuthaH1() {
        super("Destrucción de escudo", "Destruye una carta de escudo de un oponente");
    }

    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        for (Player opponent : opponents) {
            List<Carta> cartasActivas = opponent.getCartasActivas();
            for (Carta carta : cartasActivas) {
                if (carta instanceof CartaEspecial && ((CartaEspecial) carta).hasShield()) {
                    cartasActivas.remove(carta);
                    System.out.println("Has destruido la carta de escudo " + carta + " de " + opponent.getNombre());
                    return;
                }
            }
        }
        System.out.println("No se encontró ninguna carta de escudo para destruir.");
    }

    @Override
    public void usarHabilidad() {

    }
}
