package Habilidades.Blorp;

import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class BlorpH3 extends AbstractHabilidad {

    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        // Marcar que el jugador puede atacar dos veces cuando una carta es destruida
        player.setAttackTwiceOnCardDestruction(true);
        System.out.println(player.getNombre() + " ha activado la habilidad para atacar dos veces cuando una carta es destruida durante este turno.");
    }

}