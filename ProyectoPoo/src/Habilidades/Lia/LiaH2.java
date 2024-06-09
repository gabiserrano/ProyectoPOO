package Habilidades.Lia;

import Cartas.Carta;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;
import java.util.Scanner;

public class LiaH2 extends AbstractHabilidad {

    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
// Obtener la pila de descarte del jugador actual
        List<Carta> pilaDeDescarte = player.getDescartadas();

        // Verificar que la pila de descarte no esté vacía
        if (pilaDeDescarte.isEmpty()) {
            System.out.println("La pila de descarte está vacía.");
            return;
        }

        // Mostrar las cartas en la pila de descarte al jugador
        System.out.println("Elige una carta de la pila de descarte para añadir a tu mano:");
        for (int i = 0; i < pilaDeDescarte.size(); i++) {
            System.out.println((i + 1) + ": " + pilaDeDescarte.get(i));
        }

        // Permitir al jugador elegir una carta
        Scanner scanner = new Scanner(System.in);
        int eleccion = scanner.nextInt();

        // Validar la elección del jugador
        if (eleccion < 1 || eleccion > pilaDeDescarte.size()) {
            System.out.println("Elección inválida.");
            return;
        }

        // Añadir la carta elegida a la mano del jugador
        Carta cartaElegida = pilaDeDescarte.get(eleccion - 1);
        player.getMano().add(cartaElegida);
        pilaDeDescarte.remove(cartaElegida);

        System.out.println("Has añadido " + cartaElegida + " a tu mano.");
    }
    }
