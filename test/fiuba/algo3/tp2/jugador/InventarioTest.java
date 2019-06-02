package fiuba.algo3.tp2.jugador;

import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;

import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;

public class InventarioTest {

    @Test
    public void cuandoSeCreaUnInventario_suHerramientaInicialEsUnHachaDeMaderaConDurabilidad100() {
        Inventario inventario = new Inventario();
        BigDecimal durabilidadDeUnHachaDeMadera = new BigDecimal(100);
        assertEquals(inventario.getDurabilidadDelHachaDeMadera(), durabilidadDeUnHachaDeMadera);
    }

    @Test
    public void cuandoSeCreaUnInventario_DeberiaPoderGolpearUnMaterialDeMaderaConSuHachaDeMaderaYQueSuDurabilidadBajeA98() throws MaterialDestruidoNoSePuedeGolpearException {
        Inventario inventario = new Inventario();
        Madera madera = new Madera();
        inventario.golpearConHachaDeMadera(madera);
        BigDecimal durabilidadDeUnHachaDeMadera = new BigDecimal(98);
        assertEquals(inventario.getDurabilidadDelHachaDeMadera(), durabilidadDeUnHachaDeMadera);
    }
}
