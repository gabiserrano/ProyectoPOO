package Tablero;

import Observer.Observable;
import Player.Player;
import Player.Character;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Tablero extends Observable {
    private static Tablero instancia; // La única instancia del Tablero
    private List<Player> jugadores;
    private List<Character> personajes;

    // Constructor privado para evitar instanciación externa
    public Tablero() {
        jugadores = new ArrayList<>();
        personajes = new ArrayList<>();
    }

    // Método para obtener la única instancia del Tablero
    public static synchronized Tablero getInstance() {
        if (instancia == null) {
            instancia = new Tablero();
        }
        return instancia;
    }

    public List<Player> getJugadores() {
        return jugadores;
    }

    public void removerJugador() {
        if (!jugadores.isEmpty()) {
            jugadores.remove(jugadores.size() - 1);
            notifyObservers(); // Notifica a los observadores sobre el cambio
        }
    }

    public void agregarCPU() {
        Player CPU = new Player("CPU", new ArrayList<>());
        jugadores.add(CPU);
        notifyObservers(); // Notifica a los observadores sobre el cambio
    }

    public void empezarPartida() {
        for (Player p : jugadores) {
            p.mezclarCartas();
        }
        notifyObservers(); // Notifica a los observadores sobre el cambio
    }

    public Character seleccionarPersonaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione un personaje");
        int i = 0;

        for (Character personaje : personajes) {
            System.out.println((i++) + ". " + personaje.getNombre());
            System.out.println("Descripcion: " + personaje.getDescripcion());
            System.out.println("Color: " + personaje.getColor());
            System.out.println("--------------------");
        }

        int seleccion = sc.nextInt();
        return personajes.get(seleccion - 1);
    }

    public void agregarJugador() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        Character personaje = seleccionarPersonaje();

        Player jugador = new Player(nombre, personaje);
        jugadores.add(jugador);
        notifyObservers(); // Notifica a los observadores sobre el cambio
    }

    public void agregarPersonaje(Character personaje) {
        personajes.add(personaje);
    }

    public void realizarAccion() {
        // Método placeholder para realizar una acción en el tablero
        System.out.println("Acción realizada en el tablero.");
        notifyObservers(); // Notifica a los observadores sobre el cambio
    }
}

