package Habilidades.Sutha;

import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class SuthaH3 extends AbstractHabilidad {


    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        // Curar al jugador una vez por cada oponente
        int healAmount = opponents.size();
        player.setVida(player.getVida() + healAmount);
        System.out.println(player.getNombre() + " se ha curado " + healAmount + " puntos de vida.");

        // Atacar a cada oponente
        for (Player opponent : opponents) {
            int damage = 1; // Define the amount of damage to deal
            opponent.recibirDanio(damage);
            System.out.println(player.getNombre() + " ha atacado a " + opponent.getNombre() + " causando " + damage + " puntos de daño.");
        }
    }

    }


