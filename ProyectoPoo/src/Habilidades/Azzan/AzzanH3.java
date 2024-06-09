package Habilidades.Azzan;

import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;
import java.util.Scanner;

public class AzzanH3 extends AbstractHabilidad {


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