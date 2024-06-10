package Habilidades.Azzan;

import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;
import java.util.Scanner;

/**
 * La clase AzzanH3 representa una habilidad específica para un personaje llamado Azzan.
 * Esta habilidad permite al jugador intercambiar puntos de vida con un oponente seleccionado.
 */
public class AzzanH3 extends AbstractHabilidad {

    /**
     * Este método aplica la habilidad al jugador y a sus oponentes.
     *
     * @param player    El jugador que usa la habilidad.
     * @param opponents La lista de oponentes entre los cuales se puede elegir uno para intercambiar puntos de vida.
     */
    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        // Mostrar los oponentes al jugador para elegir uno
        System.out.println("Elige un oponente para intercambiar puntos de vida:");
        for (int i = 0; i < opponents.size(); i++) {
            System.out.println((i + 1) + ": " + opponents.get(i).getNombre());
        }

        // Leer la elección del jugador
        Scanner scanner = new Scanner(System.in);
        int eleccion = scanner.nextInt() - 1;

        // Validar la elección del jugador
        if (eleccion < 0 || eleccion >= opponents.size()) {
            System.out.println("Elección inválida.");
            return;
        }

        // Obtener el oponente seleccionado
        Player selectedOpponent = opponents.get(eleccion);

        // Intercambiar los puntos de vida
        int tempVida = player.getVida();
        player.setVida(selectedOpponent.getVida());
        selectedOpponent.setVida(tempVida);

        System.out.println(player.getNombre() + " ha intercambiado puntos de vida con " + selectedOpponent.getNombre());
    }
}