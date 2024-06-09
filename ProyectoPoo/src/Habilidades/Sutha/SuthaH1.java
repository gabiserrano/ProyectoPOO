package Habilidades.Sutha;

import Cartas.Carta;
import Cartas.CartaEspecial;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class SuthaH1 extends AbstractHabilidad {


    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        // Iterar sobre cada oponente
        for (Player opponent : opponents) {
            // Obtener las cartas activas del oponente
            List<Carta> cartasActivas = opponent.getCartasActivas();

            // Buscar y destruir la primera carta de escudo encontrada
            for (Carta carta : cartasActivas) {
                if (carta instanceof CartaEspecial && ((CartaEspecial) carta).hasShield()) {
                    cartasActivas.remove(carta);
                    System.out.println("Has destruido la carta de escudo " + carta + " de " + opponent.getNombre());
                    return; // Salir después de destruir una carta de escudo
                }
            }
        }

        // Si no se encontró ninguna carta de escudo
        System.out.println("No se encontró ninguna carta de escudo para destruir.");
    }

    }

