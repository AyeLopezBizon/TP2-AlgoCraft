package fiuba.algo3.tp2.jugador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;

public class Inventario {

    private Herramienta herramientaInicial;

    public void crearHachaDeMadera() {
        this.herramientaInicial = HerramientaFactory.newHachaDeMadera();
    }

    public float getDurabilidadDelHachaDeMadera() {
        return this.herramientaInicial.getDurabilidad();
    }
}