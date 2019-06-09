package fiuba.algo3.tp2.jugador;

import fiuba.algo3.tp2.herramienta.Herramienta;

import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;

public class InventarioTest {

    @Test
    public void cuandoSeCreaUnInventario_DeberiaPoderDevolverUnHachaDeMaderaConDurabilidad100YFuerza2() {
        Inventario inventario = new Inventario();

        Herramienta herramienta = inventario.getHachaDeMadera();

        BigDecimal durabilidadEsperada = BigDecimal.valueOf(100);
        BigDecimal fuerzaEsperada = BigDecimal.valueOf(2);

        assertEquals(durabilidadEsperada, herramienta.getDurabilidad());
        assertEquals(fuerzaEsperada, herramienta.getFuerza());
    }
}
