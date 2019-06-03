package fiuba.algo3.tp2.jugador;

import fiuba.algo3.tp2.material.*;
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
    public void cuandoSeCreaUnInventario_DeberiaGolpearConSuHachaDeMaderaUnaMaderaYQueLaDurabilidadDelHachaBajeA98YLaDeLaMaderaA8() throws MaterialDestruidoNoSePuedeGolpearException {
        Inventario inventario = new Inventario();
        Material madera = new Madera();

        BigDecimal durabilidadDeUnHachaDeMadera = new BigDecimal(98);
        BigDecimal durabilidadDeLaMadera = new BigDecimal(8);

        inventario.golpearConHachaDeMadera(madera);

        assertEquals(inventario.getDurabilidadDelHachaDeMadera(), durabilidadDeUnHachaDeMadera);
        assertEquals(madera.getDurabilidad(), durabilidadDeLaMadera);
    }

    @Test
    public void cuandoSeCreaUnInventario_DeberiaGolpearConSuHachaDeMaderaUnaPiedraYQueLaDurabilidadDelHachaBajeA98YLaDeLaPiedraNoBaje() throws MaterialDestruidoNoSePuedeGolpearException {
        Inventario inventario = new Inventario();
        Material piedra = new Piedra();

        BigDecimal durabilidadDeUnHachaDeMadera = new BigDecimal(98);
        BigDecimal durabilidadDeLaPiedra = new BigDecimal(30);

        inventario.golpearConHachaDeMadera(piedra);

        assertEquals(inventario.getDurabilidadDelHachaDeMadera(), durabilidadDeUnHachaDeMadera);
        assertEquals(piedra.getDurabilidad(), durabilidadDeLaPiedra);
    }

    @Test
    public void cuandoSeCreaUnInventario_DeberiaGolpearConSuHachaDeMaderaUnMetalYQueLaDurabilidadDelHachaBajeA98YLaDelMetalNoBaje() throws MaterialDestruidoNoSePuedeGolpearException {
        Inventario inventario = new Inventario();
        Material metal = new Metal();

        BigDecimal durabilidadDeUnHachaDeMadera = new BigDecimal(98);
        BigDecimal durabilidadDelMetal = new BigDecimal(50);

        inventario.golpearConHachaDeMadera(metal);

        assertEquals(inventario.getDurabilidadDelHachaDeMadera(), durabilidadDeUnHachaDeMadera);
        assertEquals(metal.getDurabilidad(), durabilidadDelMetal);
    }

    @Test
    public void cuandoSeCreaUnInventario_DeberiaGolpearConSuHachaDeMaderaUnDiamanteYQueLaDurabilidadDelHachaBajeA98YLaDelDiamanteNoBaje() throws MaterialDestruidoNoSePuedeGolpearException {
        Inventario inventario = new Inventario();
        Material diamante = new Diamante();

        BigDecimal durabilidadDeUnHachaDeMadera = new BigDecimal(98);
        BigDecimal durabilidadDelDiamante = new BigDecimal(100);

        inventario.golpearConHachaDeMadera(diamante);

        assertEquals(inventario.getDurabilidadDelHachaDeMadera(), durabilidadDeUnHachaDeMadera);
        assertEquals(diamante.getDurabilidad(), durabilidadDelDiamante);
    }
}
