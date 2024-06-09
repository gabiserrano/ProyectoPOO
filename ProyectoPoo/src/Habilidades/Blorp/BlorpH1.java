package Habilidades.Blorp;

import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class BlorpH1 extends AbstractHabilidad {


    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {

        player.setIgnoreShields(true);
        System.out.println(player.getNombre() + " ha activado la habilidad para ignorar los escudos durante este turno.");
    }

}