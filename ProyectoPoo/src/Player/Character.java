package Player;

import Cartas.Carta;
import java.util.List;

public class Character {
    private String nombre;
    private List<Carta> cartas;

    public Character(String nombre, List<Carta> cartas) {
        this.nombre = nombre;
        this.cartas = cartas;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }
}
