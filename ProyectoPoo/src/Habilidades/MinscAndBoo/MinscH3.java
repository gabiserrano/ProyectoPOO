package Habilidades.MinscAndBoo;

import Cartas.Carta;
import Cartas.CartaEspecial;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class MinscH3 extends AbstractHabilidad {


    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
// Obtener las cartas activas del jugador
        List<Carta> cartasActivas = player.getCartasActivas();

        // Iterar sobre las cartas activas y aplicar el bono de daño a las cartas de escudo
        for (Carta carta : cartasActivas) {
            if (carta instanceof CartaEspecial && ((CartaEspecial) carta).hasShield()) {
                // Suponemos que hay un método para incrementar el daño en la clase CartaEspecial
                ((CartaEspecial) carta).incrementarDanio(1);
                System.out.println("La carta " + carta + " ahora inflige un daño adicional de 1 este turno.");
            }
        }

    }
}

