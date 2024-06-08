package Player;

import Observer.Observer;
import Cartas.Carta;
import Tablero.Tablero;
import Cartas.CartaEscudo;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;

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

    public Player() {
        this("", null);
    }

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

    // Método para recibir daño
    public void recibirDanio(int cantidad) {
        vida -= cantidad;
        System.out.println(nombre + " ha recibido " + cantidad + " puntos de daño. Vida restante: " + vida);
        if (vida <= 0) {
            System.out.println(nombre + " ha sido derrotado.");
            // Aquí puedes añadir lógica adicional si el jugador es derrotado
        }
    }

    // Método para obtener el tablero
    public Tablero getTablero() {
        return Tablero.getInstancia();
    }

    // Método para mezclar cartas del mazo
    public void mezclarCartas() {
        shuffle(mazo);
    }

    // Método para terminar el turno
    public void terminarTurno() {
        for (Carta carta : jugada) {
            carta.jugarCarta();
            descartadas.add(carta);
        }
        jugada.clear(); // Limpia la lista de jugadas después de terminar el turno
        // Resetea estados temporales después del turno
        resetearEstados();
    }

    // Método para tomar una carta
    public void tomarCarta(List<Carta> cartas) {
        if (!cartas.isEmpty()) {
            Carta carta = cartas.remove(cartas.size() - 1); // Obtiene la última carta de la lista
            mano.add(carta);
        }
    }

    // Implementación del método `actualizar` de la interfaz `Observer`
    @Override
    public void actualizar() {
        System.out.println(nombre + " ha sido notificado sobre un cambio en el tablero.");
    }

    // Métodos para manejar el estado de ignorar escudos
    public boolean puedeIgnorarEscudos() {
        return ignorarEscudos;
    }

    public void setIgnorarEscudos(boolean ignorarEscudos) {
        this.ignorarEscudos = ignorarEscudos;
    }

    // Métodos para manejar el estado de ataque doble
    public boolean tieneAtaqueDoble() {
        return ataqueDoble;
    }

    public void setAtaqueDoble(boolean ataqueDoble) {
        this.ataqueDoble = ataqueDoble;
    }

    // Métodos para manejar el estado de controlar objetivo de escudos
    public boolean puedeControlarObjetivoEscudos() {
        return controlarObjetivoEscudos;
    }

    public void setControlarObjetivoEscudos(boolean controlarObjetivoEscudos) {
        this.controlarObjetivoEscudos = controlarObjetivoEscudos;
    }

    // Método para resetear estados temporales
    private void resetearEstados() {
        ignorarEscudos = false;
        ataqueDoble = false;
        controlarObjetivoEscudos = false;
    }

    // Método para destruir una carta de escudo y curar vida
    public void destruirCartaEscudo(Carta cartaEscudo) {
        if (cartaEscudo.esCartaEscudo()) {
            int cantidadEscudos = ((CartaEscudo)cartaEscudo).getEscudos();
            cartasActivas.remove(cartaEscudo);
            vida += cantidadEscudos;
            System.out.println(nombre + " ha destruido una carta de escudo y ha recuperado " + cantidadEscudos + " puntos de vida. Vida actual: " + vida);
        }
    }

    public void agregarEscudo() {
        // Lógica para agregar un escudo al jugador
        System.out.println(nombre + " ha recibido un escudo.");
    }

    // Método para jugar una carta extra
    public void jugarCartaExtra() {
        // Lógica para jugar una carta extra
        System.out.println(nombre + " juega una carta extra.");
    }

    // Método para curar una cantidad específica de puntos de vida
    public void curar(int cantidad) {
        vida += cantidad;
        System.out.println(nombre + " ha sido curado " + cantidad + " puntos de vida. Vida actual: " + vida);
    }

    // Setters y Getters

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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}








/* To Do:
- Observer - Cuando el jugador se quede sin cartas, que agarre dos cartas
- Singleton - Crear el tablero y que sea unico
-

 */