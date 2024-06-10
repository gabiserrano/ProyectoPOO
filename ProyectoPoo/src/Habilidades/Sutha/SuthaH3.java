package Habilidades.Sutha;

import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class SuthaH3 extends AbstractHabilidad {
    public SuthaH3() {
        super("Curación y ataque", "Cura a Sutha y ataca a cada oponente");
    }

    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        int healAmount = opponents.size();
        player.setVida(player.getVida() + healAmount);
        System.out.println(player.getNombre() + " se ha curado " + healAmount + " puntos de vida.");

        for (Player opponent : opponents) {
            int damage = 1;
            opponent.recibirDanio(damage);
            System.out.println(player.getNombre() + " ha atacado a " + opponent.getNombre() + " causando " + damage + " puntos de daño.");
        }
    }

    @Override
    public void usarHabilidad() {
        
    }
}
