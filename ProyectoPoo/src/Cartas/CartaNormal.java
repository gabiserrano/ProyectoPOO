package Cartas;

import Player.Player;

public class CartaNormal implements Carta {
    private String owner;
    private int espadas;
    private int corazones;
    private int escudos;
    private int rayos;
    private int cartasExtra;

    public CartaNormal() { }

    public CartaNormal(String owner) {
        this.owner = owner;
    }

    public CartaNormal(String owner, int espadas, int corazones, int escudos, int rayos, int cartasExtra) {
        this.owner = owner;
        this.espadas = espadas;
        this.corazones = corazones;
        this.escudos = escudos;
        this.rayos = rayos;
        this.cartasExtra = cartasExtra;
    }

    // Nuevo constructor
    public CartaNormal(int espadas, int corazones, int escudos, int rayos, int cartasExtra) {
        this.espadas = espadas;
        this.corazones = corazones;
        this.escudos = escudos;
        this.rayos = rayos;
        this.cartasExtra = cartasExtra;
    }

    // Implementación de métodos de Carta
    @Override
    public void atacar(Player objetivo) {
        if (espadas > 0) {
            for (int i = 0; i < espadas; i++) {
                System.out.println(owner + " ataca con una espada.");
                objetivo.recibirDanio(1);
            }
            descartar();
        }
    }

    @Override
    public void escudo(Player jugador) {
        if (escudos > 0) {
            for (int i = 0; i < escudos; i++) {
                System.out.println(owner + " usa un escudo para proteger un punto de vida.");
                jugador.agregarEscudo();
            }
            descartar();
        }
    }

    @Override
    public void cartaExtra(Player jugador) {
        if (cartasExtra > 0) {
            for (int i = 0; i < cartasExtra; i++) {
                System.out.println(owner + " toma una carta extra del mazo.");
                jugador.tomarCarta(jugador.getMazo());
            }
            descartar();
        }
    }

    @Override
    public void rayo(Player jugador) {
        if (rayos > 0) {
            for (int i = 0; i < rayos; i++) {
                System.out.println(owner + " juega otra carta usando un rayo.");
                jugador.jugarCartaExtra();
            }
            descartar();
        }
    }

    @Override
    public void curar(Player jugador) {
        if (corazones > 0) {
            for (int i = 0; i < corazones; i++) {
                System.out.println(owner + " cura un punto de vida.");
                jugador.curar(1);
            }
            descartar();
        }
    }

    @Override
    public void jugarCarta() {
        System.out.println(owner + " juega una carta.");
    }

    @Override
    public boolean esCartaEscudo() {
        return false;
    }

    private void descartar() {
        System.out.println("La carta de " + owner + " ha sido descartada al cementerio.");
    }

    public int getEspadas() {
        return espadas;
    }

    public void setEspadas(int espadas) {
        this.espadas = espadas;
    }

    public int getCorazones() {
        return corazones;
    }

    public void setCorazones(int corazones) {
        this.corazones = corazones;
    }

    public int getEscudos() {
        return escudos;
    }

    public void setEscudos(int escudos) {
        this.escudos = escudos;
    }

    public int getRayos() {
        return rayos;
    }

    public void setRayos(int rayos) {
        this.rayos = rayos;
    }

    public int getCartasExtra() {
        return cartasExtra;
    }

    public void setCartasExtra(int cartasExtra) {
        this.cartasExtra = cartasExtra;
    }
}

