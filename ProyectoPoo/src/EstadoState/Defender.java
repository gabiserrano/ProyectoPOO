package EstadoState;

public class Defender implements Estado {


    @Override
    public void ejecutarAccion(Jugador jugador) {
        System.out.println("Defendiendo");
    }
}
