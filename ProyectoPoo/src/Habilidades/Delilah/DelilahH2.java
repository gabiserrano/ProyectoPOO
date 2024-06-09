package Habilidades.Delilah;

import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class DelilahH2 extends AbstractHabilidad {


    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        // Marcar que el jugador puede elegir el objetivo de todas las cartas de escudo hasta su próximo turno
        player.setControlShields(true);
        System.out.println(player.getNombre() + " puede elegir el objetivo de todas las cartas de escudo hasta su próximo turno.");
    }

}