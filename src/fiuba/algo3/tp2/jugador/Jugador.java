package fiuba.algo3.tp2.jugador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;

public class Jugador {

    private Herramienta herramientaActiva;
    private Inventario inventario = new Inventario();

    public Jugador() {
        this.herramientaActiva = this.inventario.getHachaDeMadera();
    }

    public void golpear(Material material) throws MaterialDestruidoNoSePuedeGolpearException {
        this.herramientaActiva.golpear(material);
    }
}