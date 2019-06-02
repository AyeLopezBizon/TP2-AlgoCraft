package fiuba.algo3.tp2.jugador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;

import java.math.BigDecimal;

public class Inventario {

    private Herramienta herramientaInicial;

    public void crearHachaDeMadera() {
        this.herramientaInicial = HerramientaFactory.newHachaDeMadera();
    }

    public BigDecimal getDurabilidadDelHachaDeMadera() {
        return this.herramientaInicial.getDurabilidad();
    }

    public void golpearConHachaDeMadera(Material material) throws MaterialDestruidoNoSePuedeGolpearException {
        this.herramientaInicial.golpear(material);
    }

    public void recoger(Material material) {
    }
}