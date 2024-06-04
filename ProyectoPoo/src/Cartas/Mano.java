package Cartas;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<Carta> cartaEnMano;

    public Mano() {
        cartaEnMano= new ArrayList<>();
    }

    //este metodo agrega una carta al final de la lista
    public void agregarCarta(Carta carta){
        this.cartaEnMano.add(carta);
    }

    //este metodo quita una carta de la lista
    public void quitarCarta(Carta carta){
        this.cartaEnMano.remove(carta);
    }

}
