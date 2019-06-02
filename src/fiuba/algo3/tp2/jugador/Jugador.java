package fiuba.algo3.tp2.jugador;

import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;

<<<<<<< HEAD

=======
>>>>>>> refs/remotes/origin/develop
import java.math.BigDecimal;

public class Jugador {

    private Inventario inventario = new Inventario();

    public BigDecimal getDurabilidadDelHachaDeMadera() {
        return this.inventario.getDurabilidadDelHachaDeMadera();
    }

<<<<<<< HEAD
    public BigDecimal getDurabilidadDelHachaDeMadera() {
        return this.inventario.getDurabilidadDelHachaDeMadera();
    }

    public void golpearConHachaDeMadera(Material material) {
        try {
            this.inventario.golpearConHachaDeMadera(material);
        } catch (MaterialDestruidoNoSePuedeGolpearException e) {
            this.inventario.recoger(material);
        }
    }
=======
    public void golpearConHachaDeMadera(Material material) {
        try {
            this.inventario.golpearConHachaDeMadera(material);
        } catch (MaterialDestruidoNoSePuedeGolpearException e) {
        }
    }
>>>>>>> refs/remotes/origin/develop
}