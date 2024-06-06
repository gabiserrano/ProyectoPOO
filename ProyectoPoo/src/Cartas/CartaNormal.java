package Cartas;

public class CartaNormal implements Carta {
    //private Player propietario;
    private int espadas;
    private int corazones;
    private int escudos;
    private int rayos;
    private int cartasExtra;

    public CartaNormal() {
    }

    public CartaNormal(int espadas, int corazones, int escudos, int rayos, int cartasExtra) {
        this.espadas = espadas;
        this.corazones = corazones;
        this.escudos = escudos;
        this.rayos = rayos;
        this.cartasExtra = cartasExtra;
    }

    @Override
    public void atacar() {

    }

    @Override
    public void escudo() {

    }

    @Override
    public void cartaExtra() {

    }

    @Override
    public void rayo() {

    }

    @Override
    public void curar() {

    }

    @Override
    public void jugarCarta() {

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