package Cartas;

import java.util.Collections;
import java.util.List;

public class Mazo {
    private List<Carta> cartas;

    public Mazo(List<Carta> cartas) {
        this.cartas = cartas;
    }

    //metodo que nos ayudara a mezcalr las cartas del mazo

    public void mezclar() {
        Collections.shuffle(this.cartas);
    }

    //metodo que nos ayuda a tomar una carta del mazo
    public Carta tomar() {
        //si el mazo esta vacio devolvera null
        if (this.cartas.isEmpty()) {
            return null;
        }
        else {
            //devuelve la primera carta
            return this.cartas.remove(0);
        }
    }

    }


