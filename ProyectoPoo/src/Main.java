import Player.Character;
import Player.Player;
import Cartas.Carta;
import Cartas.CartaEspecial;
import Habilidades.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**Crear jugadores y asignarles personajes*/

        Player player1 = new Player("Player 1", Character.AZZAN);
        Player player2 = new Player("Player 2", Character.BLORP);

        /** Inicializar el tablero con los jugadores*/

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        Tablero tablero = new Tablero(players);

        /** Ejemplo de creación de cartas y habilidades*/

        Habilidad habilidad1 = new DelilahH1();
        Habilidad habilidad2 = new AzzanH1();
        Habilidad habilidad3 = new BlorpH1();
        Habilidad habilidad4 = new LiaH1();
        Habilidad habilidad5 = new MinscH1();
        Habilidad habilidad6 = new SuthaH1();
        Habilidad habilidad7 = new DelilahH2();
        Habilidad habilidad8 = new AzzanH2();
        Habilidad habilidad9 = new BlorpH2();
        Habilidad habilidad10 = new LiaH2();
        Habilidad habilidad11 = new MinscH2();
        Habilidad habilidad12 = new SuthaH2();

        /** Crear cartas especiales con habilidades*/

        Carta carta1 = new CartaEspecial("Player 1", 0, 0, 0, 0, 0, habilidad1);
        Carta carta2 = new CartaEspecial("Player 1", 0, 0, 0, 0, 0, habilidad2);
        Carta carta3 = new CartaEspecial("Player 1", 0, 0, 0, 0, 0, habilidad3);
        Carta carta4 = new CartaEspecial("Player 2", 0, 0, 0, 0, 0, habilidad4);
        Carta carta5 = new CartaEspecial("Player 2", 0, 0, 0, 0, 0, habilidad5);
        Carta carta6 = new CartaEspecial("Player 2", 0, 0, 0, 0, 0, habilidad6);
        Carta carta7 = new CartaEspecial("Player 1", 0, 0, 0, 0, 0, habilidad7);
        Carta carta8 = new CartaEspecial("Player 1", 0, 0, 0, 0, 0, habilidad8);
        Carta carta9 = new CartaEspecial("Player 1", 0, 0, 0, 0, 0, habilidad9);
        Carta carta10 = new CartaEspecial("Player 2", 0, 0, 0, 0, 0, habilidad10);
        Carta carta11 = new CartaEspecial("Player 2", 0, 0, 0, 0, 0, habilidad11);
        Carta carta12 = new CartaEspecial("Player 2", 0, 0, 0, 0, 0, habilidad12);

        /** Agregar las cartas a los mazos de los jugadores*/

        player1.getMazo().add(carta1);
        player1.getMazo().add(carta2);
        player1.getMazo().add(carta3);
        player2.getMazo().add(carta4);
        player2.getMazo().add(carta5);
        player2.getMazo().add(carta6);

        /** Menú principal*/

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("== MENU PRINCIPAL ==");
            System.out.println("1. Jugar carta");
            System.out.println("2. Usar habilidad");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    /** Lógica para jugar carta*/

                    System.out.println("Funcionalidad de jugar carta no implementada.");
                    break;
                case 2:
                    /** Lógica para usar habilidad*/

                    System.out.println("Funcionalidad de usar habilidad no implementada.");
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
