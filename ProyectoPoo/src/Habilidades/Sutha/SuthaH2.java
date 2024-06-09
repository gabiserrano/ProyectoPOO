package Habilidades.Sutha;

import Cartas.Carta;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.ArrayList;
import java.util.List;

public class SuthaH2 extends AbstractHabilidad {


    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        // Crear una lista que incluya al jugador actual y a los oponentes
        List<Player> allPlayers = new ArrayList<>(opponents);
        allPlayers.add(player);

        // Iterar sobre cada jugador
        for (Player currentPlayer : allPlayers) {
            // Descartar la mano actual
            List<Carta> manoActual = currentPlayer.getMano();
            List<Carta> pilaDeDescarte = currentPlayer.getDescartadas();
            pilaDeDescarte.addAll(manoActual);
            manoActual.clear();

            // Robar tres cartas
            List<Carta> mazo = currentPlayer.getMazo();
            for (int i = 0; i < 3; i++) {
                if (!mazo.isEmpty()) {
                    Carta cartaRobada = mazo.remove(0);
                    manoActual.add(cartaRobada);
                }
            }

            System.out.println(currentPlayer.getNombre() + " ha descartado su mano y ha robado tres cartas.");
        }
    }
}

