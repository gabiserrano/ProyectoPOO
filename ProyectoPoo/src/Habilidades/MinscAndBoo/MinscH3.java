package Habilidades.MinscAndBoo;

import Cartas.Carta;
import Cartas.CartaEspecial;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class MinscH3 extends AbstractHabilidad {
    public MinscH3() {
        super("Bono de daño", "Incrementa el daño de las cartas de escudo");
    }

    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        List<Carta> cartasActivas = player.getCartasActivas();
        for (Carta carta : cartasActivas) {
            if (carta instanceof CartaEspecial && ((CartaEspecial) carta).hasShield()) {
                ((CartaEspecial) carta).incrementarDanio(1);
                System.out.println("La carta " + carta + " ahora inflige un daño adicional de 1 este turno.");
            }
        }
    }

    @Override
    public void usarHabilidad() {

    }
}
