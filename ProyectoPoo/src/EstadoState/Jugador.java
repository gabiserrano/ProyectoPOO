package EstadoState;

import Cartas.Carta;
import Personaje.Personaje;

import java.util.List;

public class Jugador {
    private int edad;
    private String nombre;
    private List<Carta> mazo;
    private List<Carta> mano;
    private List<Carta> cartasEnDescarte;
    private int puntosVida;
    private Personaje personaje;



    public void atacar(){

    }

    public void defender(){

    }

    public void curar(){

    }

    public void tomarCarta(){

    }

    public void usarCarta(){

    }





    /*atributo privado que representara el estado de nuestro jugador */
    private Estado estado;


    /*metodo que nos ayudara con el cambio de estado de nustro jugador */
    public void cambiarEstado(Estado estado) {
        this.estado = estado;
    }

    /*metodo que invoca el metodo ejecu actual
    * nos permitira realizar una accion especifica segun su estado */
    public void realizarAccion() {
        this.estado.ejecutarAccion(this);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(List<Carta> mazo) {
        this.mazo = mazo;
    }

    public List<Carta> getMano() {
        return mano;
    }

    public void setMano(List<Carta> mano) {
        this.mano = mano;
    }

    public List<Carta> getCartasEnDescarte() {
        return cartasEnDescarte;
    }

    public void setCartasEnDescarte(List<Carta> cartasEnDescarte) {
        this.cartasEnDescarte = cartasEnDescarte;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
