package Habilidades.Lia;

import Cartas.Carta;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;
import java.util.Scanner;

public class LiaH2 extends AbstractHabilidad {
    public LiaH2() {
        super("Recuperar carta del descarte", "Elige una carta de la pila de descarte para añadir a tu mano");
    }

    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        List<Carta> pilaDeDescarte = player.getDescartadas();
        if (pilaDeDescarte.isEmpty()) {
            System.out.println("La pila de descarte está vacía.");
            return;
        }

        System.out.println("Elige una carta de la pila de descarte para añadir a tu mano:");
        for (int i = 0; i < pilaDeDescarte.size(); i++) {
            System.out.println((i + 1) + ": " + pilaDeDescarte.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        int eleccion = scanner.nextInt();

        if (eleccion < 1 || eleccion > pilaDeDescarte.size()) {
            System.out.println("Elección inválida.");
            return;
        }

        Carta cartaElegida = pilaDeDescarte.get(eleccion - 1);
        player.getMano().add(cartaElegida);
        pilaDeDescarte.remove(cartaElegida);

        System.out.println("Has añadido " + cartaElegida + " a tu mano.");
    }

    @Override
    public void usarHabilidad() {

    }
}
