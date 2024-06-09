package Habilidades.Azzan;

import Habilidades.AbstractHabilidad;
import Player.Player;

public class AzzanH3 extends AbstractHabilidad {
    public AzzanH3() {
        super("Intercambio de Puntos de Vida de Azzan", "Swap your hit points with an opponent's");
    }

    @Override
    public void usarHabilidad(Player jugador) {
        System.out.println("Usando " + nombre + ": " + descripcion);


        Player oponente = obtenerOponente(jugador);


        int temp = jugador.getVida();
        jugador.setVida(oponente.getVida());
        oponente.setVida(temp);

        /** Mensaje de confirmación*/
        System.out.println("Los puntos de vida de " + jugador.getNombre() + " han sido intercambiados con los de " + oponente.getNombre());
    }

    private Player obtenerOponente(Player jugador) {
        /** Implementa la lógica para obtener un oponente aquí*/
        return null;
    }

    @Override
    public void usarHabilidad() {

    }
}
