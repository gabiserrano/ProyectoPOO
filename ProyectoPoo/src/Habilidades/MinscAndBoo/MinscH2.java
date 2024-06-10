package Habilidades.MinscAndBoo;

import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.ArrayList;
import java.util.List;

public class MinscH2 extends AbstractHabilidad {
    public MinscH2() {
        super("Intercambio de vida", "Intercambia tus puntos de vida con los de otro jugador");
    }

    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        List<Player> allPlayers = new ArrayList<>(opponents);
        allPlayers.add(player);

        int[] hitPoints = new int[allPlayers.size()];
        for (int i = 0; i < allPlayers.size(); i++) {
            hitPoints[i] = allPlayers.get(i).getVida();
        }

        for (int i = 0; i < allPlayers.size(); i++) {
            int rightIndex = (i + 1) % allPlayers.size();
            allPlayers.get(rightIndex).setVida(hitPoints[i]);
            System.out.println(allPlayers.get(i).getNombre() + " ha dado sus puntos de vida (" + hitPoints[i] + ") a " + allPlayers.get(rightIndex).getNombre());
        }
    }

    @Override
    public void usarHabilidad() {

    }
}
