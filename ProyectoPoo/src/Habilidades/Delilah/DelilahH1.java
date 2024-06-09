package Habilidades.Delilah;

import Cartas.CartaEspecial;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;
import java.util.Scanner;

public class DelilahH1 extends AbstractHabilidad {


    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        Scanner scanner = new Scanner(System.in);

        for (Player opponent : opponents) {
            System.out.println(opponent.getNombre() + ", ¿quieres alabar la grandeza de " + player.getNombre() + " y recibir un escudo? (si/no)");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("si")) {
                // Crear una nueva carta de escudo y añadirla a las cartas activas del oponente
                CartaEspecial escudo = new CartaEspecial();
                escudo.setShield(true);
                escudo.setShieldAmount(1); // Ajusta la cantidad de escudos según las reglas del juego
                opponent.getCartasActivas().add(escudo);

                System.out.println(opponent.getNombre() + " ha recibido un escudo.");
            }
        }
    }
}