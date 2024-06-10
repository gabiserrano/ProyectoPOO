package Cartas;

import Habilidades.Habilidad;

public class CartaEspecial extends CartaNormal implements Carta {
    private Habilidad habilidad;
    private boolean shield; // Corregir la definición del atributo shield

    public CartaEspecial(String owner, int espadas, int corazones, int escudos, int rayos, int cartasExtra, Habilidad habilidad) {
        super(owner, espadas, corazones, escudos, rayos, cartasExtra); // Llamar al constructor de la clase padre
        this.habilidad = habilidad;
    }


    @Override
    public void jugarCarta() {
        habilidad.usarHabilidad();
    }

    // Método para obtener el valor del escudo de la carta
    @Override
    public int getValorEscudo() {
        return escudos; // Puedes ajustar esto según la lógica de tu juego
    }

    // Método para verificar si la carta tiene escudo
    public boolean hasShield() {
        return shield;
    }

    // Método para incrementar el daño en la carta
    public void incrementarDanio(int incremento) {
        // Implementa esta lógica según las necesidades de tu juego
    }
}
