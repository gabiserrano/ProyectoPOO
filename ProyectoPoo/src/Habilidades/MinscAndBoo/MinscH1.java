package Habilidades.MinscAndBoo;

import Cartas.Carta;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class MinscH1 extends AbstractHabilidad {

    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        // Iterar sobre cada oponente
        for (Player opponent : opponents) {
            // Obtener el mazo del oponente
            List<Carta> mazoOponente = opponent.getMazo();

            // Verificar que el mazo del oponente no esté vacío
            if (!mazoOponente.isEmpty()) {
                // Tomar la primera carta del mazo del oponente
                Carta cartaRobada = mazoOponente.remove(0);

                // Añadir la carta robada a la mano del jugador
                player.getMano().add(cartaRobada);

                System.out.println("Has robado " + cartaRobada + " del mazo de " + opponent.getNombre());
            } else {
                System.out.println("El mazo de " + opponent.getNombre() + " está vacío.");
            }

    }
    }
}
