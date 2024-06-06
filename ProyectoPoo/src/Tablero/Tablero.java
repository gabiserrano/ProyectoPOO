package Tablero;

import Cartas.Carta;
import Player.Player;
import Player.Character;
import java.util.List;
import java.util.Scanner;

public class Tablero {
    private List<Player> jugadores;
    private List<Character> personajes;

    public void removerJugador() {
        jugadores.remove(jugadores.size()-1);
    }

    public void agregarCPU() {
        Player CPU = new Player();
    }

    public void empezarPartida(){
        for (Player p : jugadores) {
            p.mezclarCartas(p.getMazo());

        }

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

    public void agregarJugador(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        Character personaje = seleccionarPersonaje();

        Player jugador = new Player(nombre, personaje);
        jugadores.addFirst(jugador);
    }
}
