package Habilidades.MinscAndBoo;

import Cartas.Carta;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class MinscH1 extends AbstractHabilidad {
    public MinscH1() {
        super("Robo de carta", "Robar la primera carta del mazo de cada oponente");
    }

    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        for (Player opponent : opponents) {
            List<Carta> mazoOponente = opponent.getMazo();
            if (!mazoOponente.isEmpty()) {
                Carta cartaRobada = mazoOponente.remove(0);
                player.getMano().add(cartaRobada);
                System.out.println("Has robado " + cartaRobada + " del mazo de " + opponent.getNombre());
            } else {
                System.out.println("El mazo de " + opponent.getNombre() + " está vacío.");
            }
        }
    }

    @Override
    public void usarHabilidad() {

    }
}
