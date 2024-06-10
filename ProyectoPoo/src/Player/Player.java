package Player;

import Cartas.Carta;
import Observer.Observer;
import Tablero.Tablero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * La clase Player representa a un jugador en el juego.
 * Esta clase implementa la interfaz Observer para responder a los cambios en el tablero.
 */
public class Player implements Observer {
    private String nombre;
    private Character personaje;
    private int vida;
    private int escudosActivos; // Nuevo campo para llevar la cuenta de los escudos activos
    private boolean ignoreShields; // Para la habilidad de ignorar escudos
    private boolean attackTwiceOnCardDestruction; // Para la habilidad de atacar dos veces al destruir una carta
    private boolean controlShields;
    private List<Carta> mazo;
    private List<Carta> mano;
    private List<Carta> jugada;
    private List<Carta> cartasActivas;
    private List<Carta> descartadas;
    private Tablero tablero; // Referencia al tablero

    /**
     * Constructor que inicializa el jugador con un nombre y una mano de cartas.
     *
     * @param nombre El nombre del jugador.
     * @param mano   La mano inicial de cartas del jugador.
     */
    public Player(String nombre, List<Carta> mano) {
        this.nombre = nombre;
        this.mano = mano;
    }

    /**
     * Constructor que inicializa el jugador con un nombre y un personaje.
     * También establece la vida inicial y crea las listas de cartas.
     *
     * @param nombre    El nombre del jugador.
     * @param personaje El personaje del jugador.
     */
    public Player(String nombre, Character personaje) {
        this.nombre = nombre;
        this.personaje = personaje;
        this.vida = 10; // Vida inicial, ajustable según las reglas del juego
        this.escudosActivos = 0; // Inicialmente no hay escudos activos

        mazo = new ArrayList<>(personaje != null ? personaje.getCartas() : new ArrayList<>());
        mano = new ArrayList<>();
        jugada = new ArrayList<>();
        cartasActivas = new ArrayList<>();
        descartadas = new ArrayList<>();
    }

    /**
     * Método para recibir daño.
     * Si el jugador tiene escudos activos, el daño se reduce primero de los escudos.
     *
     * @param cantidad La cantidad de daño a recibir.
     */
    public void recibirDanio(int cantidad) {
        if (escudosActivos > 0) {
            escudosActivos -= cantidad;
            System.out.println(nombre + " ha bloqueado " + cantidad + " puntos de daño con un escudo. Escudos restantes: " + escudosActivos);
            if (escudosActivos < 0) {
                vida += escudosActivos; // Resta lo que quede después de los escudos
                escudosActivos = 0;
            }
        } else {
            vida -= cantidad;
        }
        System.out.println(nombre + " ha recibido " + cantidad + " puntos de daño. Vida restante: " + vida);
        if (vida <= 0) {
            System.out.println(nombre + " ha sido derrotado.");
            // Aquí puedes añadir lógica adicional si el jugador es derrotado
        }
    }

    /**
     * Método para agregar un escudo al jugador.
     */
    public void agregarEscudo() {
        escudosActivos++;
        System.out.println(nombre + " ha ganado un escudo. Escudos activos: " + escudosActivos);
    }

    /**
     * Método para curar al jugador.
     *
     * @param cantidad La cantidad de vida a curar.
     */
    public void curar(int cantidad) {
        vida += cantidad;
        System.out.println(nombre + " se ha curado " + cantidad + " puntos de vida. Vida actual: " + vida);
    }

    /**
     * Método para obtener el tablero.
     *
     * @return El tablero en el que juega el jugador.
     */
    public Tablero getTablero() {
        return tablero;
    }

    /**
     * Método para mezclar las cartas del mazo del jugador.
     */
    public void mezclarCartas() {
        Collections.shuffle(this.mazo);
    }

    /**
     * Método para terminar el turno del jugador.
     * Mueve las cartas jugadas a la pila de descartes.
     */
    public void terminarTurno() {
        for (Carta carta : jugada) {
            carta.jugarCarta();
            descartadas.add(carta);
        }
        jugada.clear(); // Limpia la lista de jugadas después de terminar el turno
    }

    /**
     * Método para tomar una carta de una lista de cartas y añadirla a la mano del jugador.
     *
     * @param cartas La lista de cartas de las que tomar una.
     */
    public void tomarCarta(List<Carta> cartas) {
        if (!cartas.isEmpty()) {
            Carta carta = cartas.remove(cartas.size() - 1); // Obtiene la última carta de la lista
            mano.add(carta);
        }
    }

    /**
     * Método para permitir al jugador jugar una carta extra.
     */
    public void jugarCartaExtra() {
        System.out.println(nombre + " puede jugar una carta extra.");
    }

    /**
     * Método de actualización implementado de la interfaz Observer.
     * Responde a los cambios en el tablero.
     */
    @Override
    public void actualizar() {
        System.out.println(nombre + " ha sido notificado sobre un cambio en el tablero.");
    }

    /**
     * Método para recibir daño directo sin considerar los escudos.
     *
     * @param cantidad La cantidad de daño directo a recibir.
     */
    public void recibirDanioDirecto(int cantidad) {
        this.vida -= cantidad;
        System.out.println(nombre + " ha recibido " + cantidad + " puntos de daño directo. Vida restante: " + vida);
        if (vida <= 0) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    /**
     * Método para atacar a un oponente.
     *
     * @param oponente El jugador oponente a atacar.
     * @param cantidad La cantidad de daño a infligir.
     */
    public void atacar(Player oponente, int cantidad) {
        if (ignoreShields) {
            oponente.recibirDanioDirecto(cantidad);
        } else {
            oponente.recibirDanio(cantidad);
        }
    }

    /**
     * Método para destruir una carta activa.
     * Si el jugador tiene la habilidad especial, ataca dos veces al destruir una carta.
     *
     * @param carta La carta a destruir.
     */
    public void destruirCarta(Carta carta) {
        cartasActivas.remove(carta);
        if (attackTwiceOnCardDestruction) {
            atacar(this, 1);
            atacar(this, 1);
            System.out.println(nombre + " ha atacado dos veces debido a la destrucción de una carta.");
        }
    }

    // Setters y Getters

    public boolean isIgnoreShields() {
        return ignoreShields;
    }

    public void setIgnoreShields(boolean ignoreShields) {
        this.ignoreShields = ignoreShields;
    }

    public boolean isAttackTwiceOnCardDestruction() {
        return attackTwiceOnCardDestruction;
    }

    public void setAttackTwiceOnCardDestruction(boolean attackTwiceOnCardDestruction) {
        this.attackTwiceOnCardDestruction = attackTwiceOnCardDestruction;
    }

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
        mazo = new ArrayList<>(personaje.getCartas());
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

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public boolean isControlShields() {
        return controlShields;
    }

    public void setControlShields(boolean controlShields) {
        this.controlShields = controlShields;
    }
}

/* To Do:
- Observer - Cuando el jugador se quede sin cartas, que agarre dos cartas
- Singleton - Crear el tablero y que sea unico
- Factory Menus
- composite para las cartas
- Chain of responsability
 */
