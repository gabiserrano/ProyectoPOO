package Cartas;

import Player.Player;

public interface Carta {
    void atacar(Player objetivo);
    void escudo(Player jugador);
    void cartaExtra(Player jugador);
    void rayo(Player jugador);
    void curar(Player jugador);
    void jugarCarta();

    // Método para verificar si la carta es de escudo
    boolean esCartaEscudo();
}
