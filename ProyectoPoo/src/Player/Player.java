package Player;

import Cartas.Carta;
import Observer.Observer;
import Tablero.Tablero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player implements Observer {
    private String nombre;
    private Character personaje;
    private int vida;
    private int escudosActivos; // Nuevo campo para llevar la cuenta de los escudos activos
    private boolean ignoreShields; //para la habilidad de ignorar escudos
    private boolean attackTwiceOnCardDestruction; //para la habilidad de atacar 2
    private boolean controlShields;
    private List<Carta> mazo;
    private List<Carta> mano;
    private List<Carta> jugada;
    private List<Carta> cartasActivas;
    private List<Carta> descartadas;
    private Tablero tablero; // Agregamos una referencia al tablero



    // Constructores

    public Player() {
        this("", null);
    }

    public Player(String nombre, Character personaje) {
        this.nombre = nombre;
        this.personaje = personaje;
        this.vida = 100; // Vida inicial, puedes ajustar según las reglas del juego
        this.escudosActivos = 0; // Inicialmente no hay escudos activos

        mazo = new ArrayList<>(personaje != null ? personaje.getCartas() : new ArrayList<>());
        mano = new ArrayList<>();
        jugada = new ArrayList<>();
        cartasActivas = new ArrayList<>();
        descartadas = new ArrayList<>();
    }

    // Métodos

    // Método para recibir daño
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

    // Método para agregar escudos
    public void agregarEscudo() {
        escudosActivos++;
        System.out.println(nombre + " ha ganado un escudo. Escudos activos: " + escudosActivos);
    }

    // Método para curar vida
    public void curar(int cantidad) {
        vida += cantidad;
        System.out.println(nombre + " se ha curado " + cantidad + " puntos de vida. Vida actual: " + vida);
    }

    // Método para obtener el tablero
    public Tablero getTablero() {
        return tablero;
    }

    // Método para mezclar cartas del mazo
    public void mezclarCartas() {
        Collections.shuffle(this.mazo);
    }

    // Método para terminar el turno
    public void terminarTurno() {
        for (Carta carta : jugada) {
            carta.jugarCarta();
            descartadas.add(carta);
        }
        jugada.clear(); // Limpia la lista de jugadas después de terminar el turno
    }

    // Método para tomar una carta
    public void tomarCarta(List<Carta> cartas) {
        if (!cartas.isEmpty()) {
            Carta carta = cartas.remove(cartas.size() - 1); // Obtiene la última carta de la lista
            mano.add(carta);
        }
    }

    // Método para jugar una carta extra
    public void jugarCartaExtra() {
        // Aquí podrías agregar la lógica para permitir al jugador jugar otra carta
        System.out.println(nombre + " puede jugar una carta extra.");
    }

    // Implementación del método `actualizar` de la interfaz `Observer`
    @Override
    public void actualizar() {
        // Código para actualizar el estado del jugador cuando el tablero cambia
        System.out.println(nombre + " ha sido notificado sobre un cambio en el tablero.");
    }

    public void recibirDanioDirecto(int cantidad) {
        // Aplicar daño directo sin considerar escudos
        this.vida -= cantidad;
        System.out.println(nombre + " ha recibido " + cantidad + " puntos de daño directo. Vida restante: " + vida);
        if (vida <= 0) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    // Método para atacar
    public void atacar(Player oponente, int cantidad) {
        if (ignoreShields) {
            oponente.recibirDanioDirecto(cantidad);
        } else {
            oponente.recibirDanio(cantidad);
        }
    }

    // Método para destruir una carta
    public void destruirCarta(Carta carta) {
        cartasActivas.remove(carta);
        if (attackTwiceOnCardDestruction) {
            // Atacar dos veces
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