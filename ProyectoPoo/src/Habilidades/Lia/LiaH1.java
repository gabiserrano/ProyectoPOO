package Habilidades.Lia;

import Cartas.Carta;
import Cartas.CartaEspecial;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class LiaH1 extends AbstractHabilidad {
    public LiaH1() {
        super("Destruir todas las cartas especiales con escudo", "Destruye todas las cartas especiales con escudo de los oponentes");
    }

    @Override
    public void usarHabilidad(Player player, List<Player> opponents) {
        for (Player opponent : opponents) {
            List<Carta> cartas = opponent.getCartasActivas();
            // Reemplaza esto con la lógica adecuada si `hasShield` no es parte de `CartaEspecial`
            cartas.removeIf(carta -> carta instanceof CartaEspecial && ((CartaEspecial) carta).hasShield());
        }
    }

    @Override
    public void usarHabilidad() {

    }
}
