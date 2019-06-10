package fiuba.algo3.tp2.jugador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;

public class Inventario {

    private Herramienta hachaDeMadera = HerramientaFactory.newHachaDeMadera();
    
    public Herramienta getHachaDeMadera() {
        return this.hachaDeMadera;
    }
}