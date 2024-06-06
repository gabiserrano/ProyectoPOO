package Player;

import Cartas.Carta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private String nombre;
    private Character personaje;
    private int vida;

    private List<Carta> mazo;
    private List<Carta> mano;
    private List<Carta> jugada;
    private List<Carta> cartasActivas;
    private List<Carta> descartadas;

    //Constructors
    public Player (){
        mazo = new ArrayList<Carta>();
        mano = new ArrayList<Carta>();
        jugada = new ArrayList<Carta>();
        cartasActivas = new ArrayList<Carta>();
        descartadas = new ArrayList<Carta>();
    }


    public Player(String nombre, Character personaje) {
        this.nombre = nombre;
        this.personaje = personaje;

        mazo = new ArrayList<Carta>(personaje.getCartas());
        mano = new ArrayList<Carta>();
        jugada = new ArrayList<Carta>();
        cartasActivas = new ArrayList<Carta>();
        descartadas = new ArrayList<Carta>();
    }

    //Metodos

    //Mezcla las cartas del mazo
    public void mezclarCartas(List<Carta> cartas){
        Collections.shuffle(cartas);
    }

    //Esta accion ejecuta todas las acciones de las cartas cuando ya se hayan acabado los rayitos
    //Recorre la lista de cartas jugadas ese turno, las ejecuta y las manda a las cartas descartadas
    public void terminarTurno(){
        for (Carta carta : jugada) {
            carta.jugarCarta();
            jugada.remove(carta);
            descartadas.add(carta);
        }
    }

    //Funcion para agarrar cartas de un mazo especificado
    public void tomarCarta(List<Carta> cartas){
        Carta carta = cartas.getLast();
        cartas.remove(carta);
        mano.add(carta);
    }

    //Setters and Getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Character personaje) {
        this.personaje = personaje;
        mazo = personaje.getCartas();
    }

    public List<Carta> getMazo() {
        return mazo;
    }

    public List<Carta> getMano() {
        return mano;
    }

    public List<Carta> getCartasActivas() {
        return cartasActivas;
    }

    public List<Carta> getDescartadas() {
        return descartadas;
    }
}



/* To Do:
- Observer - Cuando el jugador se quede sin cartas, que agarre dos cartas
- Singleton - Crear el tablero y que sea unico
- Factory Menus
- composite para las cartas
- Chain of responsability

 */
