import Cartas.Carta;
import Cartas.CartaNormal;
import Cartas.CartaEspecial;
import Habilidades.Azzan.AzzanH1;
import Habilidades.Azzan.AzzanH2;
import Habilidades.Azzan.AzzanH3;
import Habilidades.Blorp.BlorpH1;
import Habilidades.Blorp.BlorpH2;
import Habilidades.Blorp.BlorpH3;
import Habilidades.Delilah.DelilahH1;
import Habilidades.Delilah.DelilahH2;
import Habilidades.Delilah.DelilahH3;
import Player.Player;
import Player.Character;
import Tablero.Tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = Tablero.getInstancia();
        boolean juegoActivo = true;

        System.out.println("Bienvenido al juego de cartas!");

        // Crear jugadores
        System.out.print("Ingrese el nombre del primer jugador: ");
        String nombre1 = scanner.nextLine();
        Player jugador1 = new Player(nombre1, seleccionarPersonaje(scanner));

        System.out.print("Ingrese el nombre del segundo jugador: ");
        String nombre2 = scanner.nextLine();
        Player jugador2 = new Player(nombre2, seleccionarPersonaje(scanner));

        tablero.agregarJugador(jugador1);
        tablero.agregarJugador(jugador2);

        while (juegoActivo) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Mezclar mazo");
            System.out.println("2. Tomar carta");
            System.out.println("3. Jugar carta");
            System.out.println("4. Mostrar estado de los jugadores");
            System.out.println("5. Terminar turno");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    jugador1.mezclarCartas();
                    System.out.println("Mazo de " + jugador1.getNombre() + " mezclado.");
                    break;
                case 2:
                    jugador1.tomarCarta(jugador1.getMazo());
                    System.out.println(jugador1.getNombre() + " ha tomado una carta.");
                    break;
                case 3:
                    jugarCarta(jugador1, scanner);
                    break;
                case 4:
                    mostrarEstado(jugador1);
                    mostrarEstado(jugador2);
                    break;
                case 5:
                    jugador1.terminarTurno();
                    System.out.println("Turno de " + jugador1.getNombre() + " terminado.");
                    break;
                case 6:
                    juegoActivo = false;
                    System.out.println("Saliendo del juego...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }

    private static void mostrarEstado(Player jugador) {
        System.out.println("\nEstado de " + jugador.getNombre() + ":");
        System.out.println("Vida: " + jugador.getVida());
        System.out.println("Cartas en mano: " + jugador.getMano().size());
        System.out.println("Cartas jugadas: " + jugador.getCartasActivas().size());
        System.out.println("Cartas activas: " + jugador.getCartasActivas().size());
        System.out.println("Cartas descartadas: " + jugador.getDescartadas().size());
    }

    private static void jugarCarta(Player jugador, Scanner scanner) {
        System.out.println("Cartas en mano:");
        List<Carta> mano = jugador.getMano();
        for (int i = 0; i < mano.size(); i++) {
            System.out.println((i + 1) + ". " + mano.get(i).getClass().getSimpleName());
        }
        System.out.print("Seleccione una carta para jugar (número): ");
        int seleccion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        if (seleccion > 0 && seleccion <= mano.size()) {
            Carta carta = mano.get(seleccion - 1);
            carta.jugarCarta();
            jugador.getCartasActivas().add(carta); // Asegúrate de que este método exista o usa la lista directamente
            jugador.getMano().remove(carta);
            System.out.println("Carta jugada.");
        } else {
            System.out.println("Selección no válida.");
        }
    }

    private static Character seleccionarPersonaje(Scanner scanner) {
        System.out.println("Seleccione un personaje:");
        System.out.println("1. Azzan");
        System.out.println("2. Blorp");
        System.out.println("3. Delilah");

        System.out.print("Ingrese el número del personaje: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (seleccion) {
            case 1:
                return crearPersonajeAzzan();
            case 2:
                return crearPersonajeBlorp();
            case 3:
                return crearPersonajeDelilah();
            default:
                System.out.println("Selección no válida, se seleccionará Delilah por defecto.");
                return crearPersonajeDelilah();
        }
    }

    private static Character crearPersonajeAzzan() {
        List<Carta> cartas = new ArrayList<>();
        cartas.add(new CartaNormal(2, 0, 0, 0, 0));
        cartas.add(new CartaEspecial(0, 0, 1, 0, 0, new AzzanH1()));
        cartas.add(new CartaEspecial(0, 0, 0, 1, 0, new AzzanH2()));
        cartas.add(new CartaEspecial(0, 0, 0, 0, 1, new AzzanH3()));
        return new Character("Azzan", cartas);
    }

    private static Character crearPersonajeBlorp() {
        List<Carta> cartas = new ArrayList<>();
        cartas.add(new CartaNormal(1, 1, 0, 0, 0));
        cartas.add(new CartaEspecial(0, 1, 0, 0, 0, new BlorpH1()));
        cartas.add(new CartaEspecial(0, 0, 1, 0, 0, new BlorpH2()));
        cartas.add(new CartaEspecial(0, 0, 0, 1, 0, new BlorpH3()));
        return new Character("Blorp", cartas);
    }

    private static Character crearPersonajeDelilah() {
        List<Carta> cartas = new ArrayList<>();
        cartas.add(new CartaNormal(1, 0, 0, 0, 0));
        cartas.add(new CartaEspecial(0, 0, 1, 0, 0, new DelilahH1()));
        cartas.add(new CartaEspecial(0, 0, 0, 1, 0, new DelilahH2()));
        cartas.add(new CartaEspecial(0, 0, 0, 0, 1, new DelilahH3()));
        return new Character("Delilah", cartas);
    }
}



