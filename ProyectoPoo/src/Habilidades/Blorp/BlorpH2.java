package Habilidades.Blorp;

import Cartas.Carta;
import Habilidades.AbstractHabilidad;
import Player.Player;

public abstract class BlorpH2 extends AbstractHabilidad {
    public BlorpH2() {
        super("Destrucción de Escudo", "Destroy a shield card and heal the amount of shields the card had");
    }

    @Override
    public void usarHabilidad(Player jugador) {
        System.out.println("Usando " + nombre + ": " + descripcion);

        // Busca una carta de escudo en las cartas activas
        Carta cartaEscudo = jugador.getCartasActivas().stream()
                .filter(Carta::esCartaEscudo)
                .findFirst()
                .orElse(null);

        if (cartaEscudo != null) {
            jugador.destruirCartaEscudo(cartaEscudo);
        } else {
            System.out.println("No hay cartas de escudo para destruir.");
        }
    }
}
