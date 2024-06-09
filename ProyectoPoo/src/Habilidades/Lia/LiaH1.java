package Habilidades.Lia;

import Cartas.Carta;
import Cartas.CartaEspecial;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class LiaH1 extends AbstractHabilidad {

    //Destruir todas las cartas especiales con escudo
    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        for (Player opponent : opponents) {
            List<Carta> cartas = opponent.getCartasActivas();
            cartas.removeIf(carta -> carta instanceof CartaEspecial && ((CartaEspecial) carta).hasShield());
        }
    }
}


