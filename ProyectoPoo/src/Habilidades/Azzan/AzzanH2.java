package Habilidades.Azzan;

import Cartas.Carta;
import Habilidades.AbstractHabilidad;
import Player.Player;

public class AzzanH2 extends AbstractHabilidad {
    public AzzanH2() {
        super("Fortaleza de Azzan", "Take a shield card from an opponent and use it");
    }

    @Override
    public void usarHabilidad(Player jugador) {
        System.out.println("Usando " + getNombre() + ": " + getDescripcion());


        Player oponente = obtenerOponente(jugador);


        Carta cartaEscudo = obtenerCartaEscudo(oponente);

        if (cartaEscudo != null) {
            // Usar la carta de escudo
            jugador.getMano().add(cartaEscudo);
            oponente.getCartasActivas().remove(cartaEscudo);

            // Mensaje de confirmación
            System.out.println(jugador.getNombre() + " ha tomado una carta de escudo de " + oponente.getNombre());
        } else {
            System.out.println("No se encontró una carta de escudo.");
        }
    }

    private Player obtenerOponente(Player jugador) {

        return null;
    }

    private Carta obtenerCartaEscudo(Player jugador) {
        return jugador.getCartasActivas().stream()
                .filter(Carta::esCartaEscudo)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void usarHabilidad() {

    }
}


