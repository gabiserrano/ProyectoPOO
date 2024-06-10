import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Cartas.Carta;
import Habilidades.Blorp.BlorpH1;
import Habilidades.Blorp.BlorpH2;
import Habilidades.Blorp.BlorpH3;
import Habilidades.Habilidad;
import Cartas.*;
import Player.*;
import Tablero.Tablero;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();
        List<Player> players = new ArrayList<>();

        while (true) {
            System.out.println("Bienvenido al juego de cartas!");
            System.out.println("1. Crear jugador");
            System.out.println("2. Seleccionar jugador");
            System.out.println("3. Realizar acción en el tablero");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  /**Consumir el salto de línea*/

            switch (opcion) {
                case 1:
                    crearJugador(scanner, players);
                    break;
                case 2:
                    seleccionarJugador(scanner, players);
                    break;
                case 3:
                    tablero.realizarAccion();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida, por favor intenta de nuevo.");
            }
        }
    }

    private static void crearJugador(Scanner scanner, List<Player> players) {
        System.out.print("Nombre del jugador: ");
        String nombre = scanner.nextLine();
        List<Carta> mano = new ArrayList<>();   /**Crear una mano vacía para el jugador*/
        Player player = new Player(nombre, mano);
        players.add(player);
        System.out.println("Jugador " + nombre + " creado.");
    }

    private static void seleccionarJugador(Scanner scanner, List<Player> players) {
        if (players.isEmpty()) {
            System.out.println("No hay jugadores creados.");
            return;
        }

        System.out.println("Selecciona un jugador:");
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i).getNombre());
        }
        int seleccion = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea

        if (seleccion < 1 || seleccion > players.size()) {
            System.out.println("Selección no válida.");
            return;
        }

        Player player = players.get(seleccion - 1);
        System.out.println("Has seleccionado a " + player.getNombre());

        mostrarHabilidades(scanner, player);
    }

    private static void mostrarHabilidades(Scanner scanner, Player player) {
        System.out.println("1. Habilidad 1");
        System.out.println("2. Habilidad 2");
        System.out.println("3. Habilidad 3");
        System.out.print("Selecciona una habilidad: ");
        int habilidad = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea

        switch (habilidad) {
            case 1:
                ejecutarHabilidad(new BlorpH1());  // Ejemplo, se debería personalizar según el jugador
                break;
            case 2:
                ejecutarHabilidad(new BlorpH2());
                break;
            case 3:
                ejecutarHabilidad(new BlorpH3());
                break;
            default:
                System.out.println("Habilidad no válida.");
        }
    }

    private static void ejecutarHabilidad(Habilidad habilidad) {
        habilidad.usarHabilidad(new Player("Jugador 1", new ArrayList<>()), new ArrayList<>());
    }
}