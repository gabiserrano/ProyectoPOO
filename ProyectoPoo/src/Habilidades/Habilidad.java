package Habilidades;

import Player.Player;

import java.util.List;

public interface Habilidad {
    public abstract void usarHabilidad(Player player, List<Player> opponents);
}
