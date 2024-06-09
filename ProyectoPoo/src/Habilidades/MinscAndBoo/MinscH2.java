package Habilidades.MinscAndBoo;

import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.ArrayList;
import java.util.List;

public class MinscH2 extends AbstractHabilidad {

    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
// Crear una lista que incluya al jugador actual y a los oponentes
        List<Player> allPlayers = new ArrayList<>(opponents);
        allPlayers.add(player);

        // Crear un array para almacenar los puntos de vida actuales
        int[] hitPoints = new int[allPlayers.size()];

        // Obtener los puntos de vida de cada jugador
        for (int i = 0; i < allPlayers.size(); i++) {
            hitPoints[i] = allPlayers.get(i).getVida();
        }

        // Transferir los puntos de vida al jugador a la derecha
        for (int i = 0; i < allPlayers.size(); i++) {
            // Calcular el índice del jugador a la derecha
            int rightIndex = (i + 1) % allPlayers.size();

            // Establecer los puntos de vida del jugador a la derecha
            allPlayers.get(rightIndex).setVida(hitPoints[i]);

            System.out.println(allPlayers.get(i).getNombre() + " ha dado sus puntos de vida (" + hitPoints[i] + ") a " + allPlayers.get(rightIndex).getNombre());
        }
    }
    }
