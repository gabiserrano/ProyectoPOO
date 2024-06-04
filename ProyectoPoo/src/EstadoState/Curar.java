package EstadoState;

public class Curar implements Estado{

    @Override
    public void ejecutarAccion(Jugador jugador) {
        System.out.println("Curando");
    }
}
