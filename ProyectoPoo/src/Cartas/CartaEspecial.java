package Cartas;

import Habilidades.AbstractHabilidad;
import Habilidades.Habilidad;

public class CartaEspecial extends CartaNormal implements Carta{
    private Habilidad habilidad;
    private boolean shield;
    private AbstractHabilidad habilidades;
    private int danio;
    private int shieldAmount;

    public CartaEspecial(){
        super();
        this.habilidad = null;
    }

    public CartaEspecial(String owner){
        super(owner, "Carta de Lia");
    }

    public CartaEspecial(String owner, Habilidad habilidad){
        super(owner,0,0,0,0,0);
        this.habilidad = habilidad;
    }

    public CartaEspecial(String owner, int espadas, int corazones, int escudos, int rayos, int cartasExtra, Habilidad habilidad) {
        super(owner,espadas,corazones,escudos,rayos,cartasExtra);
        this.habilidad = habilidad;
    }

    public CartaEspecial(String name , boolean shield,AbstractHabilidad habilidad) {
        super(name, "Carta de Lia");
        this.shield = shield;
        this.habilidad = habilidad;
    }
    public boolean hasShield() {
        return shield;
    }


    public void incrementarDanio(int interest) {
        this.danio += interest;
    }

    public int getDanio() {
        return danio;
    }

    public int getShieldAmount() {
        return shieldAmount;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }

    public void setShieldAmount(int shieldAmount) {
        this.shieldAmount = shieldAmount;
    }


}