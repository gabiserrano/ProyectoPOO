package Cartas;

public class CartaNormal implements Carta {
    private int espadas;
    private int corazones;
    private int escudos;
    private int rayos;
    private int cartasExtra;

    // Constructor por defecto
    public CartaNormal() {
    }

    // Constructor con parámetros
    public CartaNormal(int espadas, int corazones, int escudos, int rayos, int cartasExtra) {
        this.espadas = espadas;
        this.corazones = corazones;
        this.escudos = escudos;
        this.rayos = rayos;
        this.cartasExtra = cartasExtra;
    }

    // Métodos de acción (deben tener la lógica implementada según el juego)
    @Override
    public void atacar() {
        // Lógica de atacar
    }

    @Override
    public void escudo() {
        // Lógica de escudo
    }

    @Override
    public void cartaExtra() {
        // Lógica de carta extra
    }

    @Override
    public void rayo() {
        // Lógica de rayo
    }

    @Override
    public void curar() {
        // Lógica de curar
    }

    @Override
    public void jugarCarta() {
        // Lógica de jugar carta
    }

    // Getters y Setters
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

    // Nuevo método para verificar si es una carta de escudo
    public boolean esCartaEscudo() {
        return escudos > 0;  // Asume que una carta con escudos > 0 es una carta de escudo
    }
}
