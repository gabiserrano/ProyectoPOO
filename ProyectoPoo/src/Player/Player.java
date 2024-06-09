package Player;

import Observer.Observer;
import Cartas.Carta;
import Tablero.Tablero;
import Cartas.CartaEscudo;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;

/**
 * La clase Player representa a un jugador en el juego, con varios atributos y métodos
 * para gestionar su estado, cartas y habilidades.
 */
public class Player implements Observer {
    private String nombre;
    private Character personaje;
    private int vida;
    private boolean ignorarEscudos; // Estado para ignorar escudos
    private boolean ataqueDoble; // Estado para ataque doble
    private boolean controlarObjetivoEscudos; // Estado para controlar objetivo de escudos
    private List<Carta> mazo;
    private List<Carta> mano;
    private List<Carta> jugada;
    private List<Carta> cartasActivas;
    private List<Carta> descartadas;

    /**
     * Constructor por defecto para la clase Player.
     */
    public Player() {
        this("", null);
    }

    /**
     * Constructor para la clase Player.
     * Inicializa el jugador con un nombre y un personaje.
     *
     * @param nombre el nombre del jugador
     * @param personaje el personaje asociado al jugador
     */
    public Player(String nombre, Character personaje) {
        this.nombre = nombre;
        this.personaje = personaje;
        this.vida = 100; // Vida inicial
        this.ignorarEscudos = false;
        this.ataqueDoble = false;
        this.controlarObjetivoEscudos = false;

        mazo = new ArrayList<>(personaje != null ? personaje.getCartas() : new ArrayList<>());
        mano = new ArrayList<>();
        jugada = new ArrayList<>();
        cartasActivas = new ArrayList<>();
        descartadas = new ArrayList<>();
    }

    /**
     * Método para recibir daño.
     *
     * @param cantidad la cantidad de daño recibido
     */
    public void recibirDanio(int cantidad) {
        vida -= cantidad;
        System.out.println(nombre + " ha recibido " + cantidad + " puntos de daño. Vida restante: " + vida);
        if (vida <= 0) {
            System.out.println(nombre + " ha sido derrotado.");
            // Aquí puedes añadir lógica adicional si el jugador es derrotado
        }
    }

    /**
     * Método para obtener el tablero.
     *
     * @return el tablero del juego
     */
    public Tablero getTablero() {
        return Tablero.getInstancia();
    }

    /**
     * Método para mezclar las cartas del mazo.
     */
    public void mezclarCartas() {
        shuffle(mazo);
    }

    /**
     * Método para terminar el turno del jugador.
     * Mueve las cartas jugadas a la pila de descartes y resetea los estados temporales.
     */
    public void terminarTurno() {
        for (Carta carta : jugada) {
            carta.jugarCarta();
            descartadas.add(carta);
        }
        jugada.clear(); // Limpia la lista de jugadas después de terminar el turno
        // Resetea estados temporales después del turno
        resetearEstados();
    }

    /**
     * Método para tomar una carta de una lista de cartas.
     *
     * @param cartas la lista de cartas de donde se toma una carta
     */
    public void tomarCarta(List<Carta> cartas) {
        if (!cartas.isEmpty()) {
            Carta carta = cartas.remove(cartas.size() - 1); // Obtiene la última carta de la lista
            mano.add(carta);
        }
    }

    /**
     * Implementación del método `actualizar` de la interfaz `Observer`.
     * Notifica al jugador sobre un cambio en el tablero.
     */
    @Override
    public void actualizar() {
        System.out.println(nombre + " ha sido notificado sobre un cambio en el tablero.");
    }

    // Métodos para manejar el estado de ignorar escudos
    /**
     * Verifica si el jugador puede ignorar escudos.
     *
     * @return true si puede ignorar escudos, false de lo contrario
     */
    public boolean puedeIgnorarEscudos() {
        return ignorarEscudos;
    }

    /**
     * Establece el estado de ignorar escudos del jugador.
     *
     * @param ignorarEscudos el nuevo estado de ignorar escudos
     */
    public void setIgnorarEscudos(boolean ignorarEscudos) {
        this.ignorarEscudos = ignorarEscudos;
    }

    // Métodos para manejar el estado de ataque doble
    /**
     * Verifica si el jugador tiene ataque doble.
     *
     * @return true si tiene ataque doble, false de lo contrario
     */
    public boolean tieneAtaqueDoble() {
        return ataqueDoble;
    }

    /**
     * Establece el estado de ataque doble del jugador.
     *
     * @param ataqueDoble el nuevo estado de ataque doble
     */
    public void setAtaqueDoble(boolean ataqueDoble) {
        this.ataqueDoble = ataqueDoble;
    }

    // Métodos para manejar el estado de controlar objetivo de escudos
    /**
     * Verifica si el jugador puede controlar el objetivo de los escudos.
     *
     * @return true si puede controlar el objetivo de los escudos, false de lo contrario
     */
    public boolean puedeControlarObjetivoEscudos() {
        return controlarObjetivoEscudos;
    }

    /**
     * Establece el estado de controlar objetivo de escudos del jugador.
     *
     * @param controlarObjetivoEscudos el nuevo estado de controlar objetivo de escudos
     */
    public void setControlarObjetivoEscudos(boolean controlarObjetivoEscudos) {
        this.controlarObjetivoEscudos = controlarObjetivoEscudos;
    }

    // Método para resetear estados temporales
    /**
     * Resetea los estados temporales del jugador al final del turno.
     */
    private void resetearEstados() {
        ignorarEscudos = false;
        ataqueDoble = false;
        controlarObjetivoEscudos = false;
    }

    /**
     * Método para destruir una carta de escudo y curar la vida del jugador en base a los puntos de escudo.
     *
     * @param cartaEscudo la carta de escudo a destruir
     */
    public void destruirCartaEscudo(Carta cartaEscudo) {
        if (cartaEscudo.esCartaEscudo()) {
            int cantidadEscudos = ((CartaEscudo)cartaEscudo).getEscudos();
            cartasActivas.remove(cartaEscudo);
            vida += cantidadEscudos;
            System.out.println(nombre + " ha destruido una carta de escudo y ha recuperado " + cantidadEscudos + " puntos de vida. Vida actual: " + vida);
        }
    }

    /**
     * Método para agregar un escudo al jugador.
     */
    public void agregarEscudo() {
        // Lógica para agregar un escudo al jugador
        System.out.println(nombre + " ha recibido un escudo.");
    }

    /**
     * Método para jugar una carta extra.
     */
    public void jugarCartaExtra() {
        // Lógica para jugar una carta extra
        System.out.println(nombre + " juega una carta extra.");
    }

    /**
     * Método para curar una cantidad específica de puntos de vida.
     *
     * @param cantidad la cantidad de vida a curar
     */
    public void curar(int cantidad) {
        vida += cantidad;
        System.out.println(nombre + " ha sido curado " + cantidad + " puntos de vida. Vida actual: " + vida);
    }

    // Setters y Getters

    /**
     * Obtiene el nombre del jugador.
     *
     * @return el nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del jugador.
     *
     * @param nombre el nuevo nombre del jugador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el personaje del jugador.
     *
     * @return el personaje del jugador
     */
    public Character getPersonaje() {
        return personaje;
    }

    /**
     * Establece el personaje del jugador y actualiza el mazo con las cartas del personaje.
     *
     * @param personaje el nuevo personaje del jugador
     */
    public void setPersonaje(Character personaje) {
        this.personaje = personaje;
        mazo = new ArrayList<>(personaje.getCartas());
    }

    /**
     * Obtiene el mazo del jugador.
     *
     * @return el mazo del jugador
     */
    public List<Carta> getMazo() {
        return mazo;
    }

    /**
     * Obtiene la mano del jugador.
     *
     * @return la mano del jugador
     */
    public List<Carta> getMano() {
        return mano;
    }

    /**
     * Obtiene las cartas activas del jugador.
     *
     * @return las cartas activas del jugador
     */
    public List<Carta> getCartasActivas() {
        return cartasActivas;
    }

    /**
     * Obtiene las cartas descartadas del jugador.
     *
     * @return las cartas descartadas del jugador
     */
    public List<Carta> getDescartadas() {
        return descartadas;
    }

    /**
     * Obtiene la vida del jugador.
     *
     * @return la vida del jugador
     */
    public int getVida() {
        return vida;
    }

    /**
     * Establece la vida del jugador.
     *
     * @param vida la nueva cantidad de vida del jugador
     */
    public void setVida(int vida) {
        this.vida = vida;
    }
}
