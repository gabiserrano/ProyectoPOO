package Tablero;

import Cartas.Carta;
import Player.Player;
import java.util.List;

public class Tablero {
    private static Tablero instancia; // Singleton instance

    /**Atributos del tablero*/
    private List<Player> jugadores;
    private List<Carta> cartasEnJuego;

    /** Constructor privado para evitar instanciación directa*/
    private Tablero() {
        /** Inicializa los atributos del tablero según sea necesario*/
    }

    /**Método para obtener la instancia singleton*/
    public static synchronized Tablero getInstancia() {
        if (instancia == null) {
            instancia = new Tablero();
        }
        return instancia;
    }

    /**Métodos del tablero*/
    public void agregarJugador(Player jugador) {
        jugadores.add(jugador);
    }

    public void removerJugador(Player jugador) {
        jugadores.remove(jugador);
    }

    public List<Player> getJugadores() {
        return jugadores;
    }

    public List<Carta> getCartasEnJuego() {
        return cartasEnJuego;
    }

    public void agregarCarta(Carta carta) {
        cartasEnJuego.add(carta);
    }

    public void removerCarta(Carta carta) {
        cartasEnJuego.remove(carta);
    }
}

