package Habilidades.Sutha;

import Cartas.Carta;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.ArrayList;
import java.util.List;

public class SuthaH2 extends AbstractHabilidad {
    public SuthaH2() {
        super("Renovar mano", "Descarta tu mano actual y roba tres cartas");
    }

    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        List<Player> allPlayers = new ArrayList<>(opponents);
        allPlayers.add(player);

        for (Player currentPlayer : allPlayers) {
            List<Carta> manoActual = currentPlayer.getMano();
            List<Carta> pilaDeDescarte = currentPlayer.getDescartadas();
            pilaDeDescarte.addAll(manoActual);
            manoActual.clear();

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

    @Override
    public void usarHabilidad() {

    }
}
