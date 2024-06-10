package Cartas;

import Player.Player;

public class CartaNormal implements Carta {
    private String owner;
    private int espadas;
    private int corazones;
    private int escudos;
    private int rayos;
    private int cartasExtra;

    public CartaNormal() {
    }

    public CartaNormal(String owner, String cartaDeLia){
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

    @Override
    public void atacar(Player objetivo) {
        if (espadas > 0) {
            for (int i = 0; i < espadas; i++) {
                // Lógica para realizar el ataque a los jugadores
                System.out.println(owner + " ataca con una espada.");
                objetivo.recibirDanio(1);
            }
            // Descartar la carta después de atacar
            descartar();
        }
    }

    @Override
    public void escudo(Player jugador) {
        if (escudos > 0) {
            for (int i = 0; i < escudos; i++) {
                // Lógica para proteger un punto de vida
                System.out.println(owner + " usa un escudo para proteger un punto de vida.");
                jugador.agregarEscudo();
            }
            // Descartar la carta después de usar los escudos
            descartar();
        }
    }

    @Override
    public void cartaExtra(Player jugador) {
        if (cartasExtra > 0) {
            for (int i = 0; i < cartasExtra; i++) {
                // Lógica para agarrar otra carta del mazo
                System.out.println(owner + " toma una carta extra del mazo.");
                jugador.tomarCarta(jugador.getMazo());
            }
            // Descartar la carta después de tomar cartas extra
            descartar();
        }
    }

    @Override
    public void rayo(Player jugador) {
        if (rayos > 0) {
            for (int i = 0; i < rayos; i++) {
                // Lógica para volver a jugar otra carta
                System.out.println(owner + " juega otra carta usando un rayo.");
                jugador.jugarCartaExtra();
            }
            // Descartar la carta después de usar los rayos
            descartar();
        }
    }

    @Override
    public void curar(Player jugador) {
        if (corazones > 0) {
            for (int i = 0; i < corazones; i++) {
                // Lógica para curar un punto de vida
                System.out.println(owner + " cura un punto de vida.");
                jugador.curar(1);
            }
            // Descartar la carta después de curar
            descartar();
        }
    }

    @Override
    public void jugarCarta() {
        // Lógica para jugar la carta
        System.out.println(owner + " juega una carta.");
    }

    private void descartar() {
        // Lógica para descartar la carta al cementerio
        System.out.println("La carta de " + owner + " ha sido descartada al cementerio.");
        // Aquí deberías agregar la lógica para mover la carta al cementerio
    }

    // Getters y setters

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
