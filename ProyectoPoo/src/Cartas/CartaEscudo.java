package Cartas;

import Player.Player;

public class CartaEscudo implements Carta {
    private int escudos;

    public CartaEscudo(int escudos) {
        this.escudos = escudos;
    }

    @Override
    public void atacar(Player objetivo) {
        // Las cartas de escudo no atacan
    }

    @Override
    public void escudo(Player jugador) {
        /** Lógica para proteger con escudos*/
        System.out.println("Se ha usado una carta de escudo con " + escudos + " escudos.");
        jugador.agregarEscudo();
    }

    @Override
    public void cartaExtra(Player jugador) {
        /** Las cartas de escudo no proporcionan cartas extra*/
    }

    @Override
    public void rayo(Player jugador) {
        /** Las cartas de escudo no permiten jugar otra carta*/
    }

    @Override
    public void curar(Player jugador) {
        /** Las cartas de escudo no curan*/
    }

    @Override
    public void jugarCarta() {
        /** Lógica para jugar la carta*/
        System.out.println("Se ha jugado una carta de escudo.");
    }

    @Override
    public boolean esCartaEscudo() {
        return true;
    }

    public int getEscudos() {
        return escudos;
    }
}
