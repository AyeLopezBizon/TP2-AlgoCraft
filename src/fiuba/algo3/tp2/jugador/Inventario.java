package fiuba.algo3.tp2.jugador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;

import java.math.BigDecimal;
<<<<<<< HEAD

import java.math.BigDecimal;
=======
>>>>>>> refs/remotes/origin/develop

public class Inventario {

    private Herramienta herramientaInicial;

    public Inventario() {
        this.herramientaInicial = HerramientaFactory.newHachaDeMadera();
    }

    public BigDecimal getDurabilidadDelHachaDeMadera() {
        return this.herramientaInicial.getDurabilidad();
    }

    public void golpearConHachaDeMadera(Material material) throws MaterialDestruidoNoSePuedeGolpearException {
        this.herramientaInicial.golpear(material);
    }
<<<<<<< HEAD

    public void recoger(Material material) {
    }
=======
>>>>>>> refs/remotes/origin/develop
}