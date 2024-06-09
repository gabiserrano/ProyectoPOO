package Habilidades.Delilah;

import Cartas.Carta;
import Cartas.CartaEspecial;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class DelilahH3 extends AbstractHabilidad {


    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        // Otorgar un escudo a cada oponente sin cartas en juego
        for (Player opponent : opponents) {
            if (opponent.getCartasActivas().isEmpty()) {
                CartaEspecial escudo = new CartaEspecial();
                escudo.setShield(true);
                escudo.setShieldAmount(1); // Ajusta la cantidad de escudos según las reglas del juego
                opponent.getCartasActivas().add(escudo);

                System.out.println(opponent.getNombre() + " ha recibido un escudo.");
            }
        }

        // Destruir todas las cartas, incluidas las del jugador actual
        destruirTodasLasCartas(player);
        for (Player opponent : opponents) {
            destruirTodasLasCartas(opponent);
        }

        System.out.println("Todas las cartas han sido destruidas.");
    }

    private void destruirTodasLasCartas(Player player) {
        List<Carta> cartasParaDestruir = player.getCartasActivas();
        cartasParaDestruir.clear();
    }

}