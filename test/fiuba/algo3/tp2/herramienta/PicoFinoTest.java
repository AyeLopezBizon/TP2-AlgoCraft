package fiuba.algo3.tp2.herramienta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;
import fiuba.algo3.tp2.material.Diamante;

import java.math.BigDecimal;

public class PicoFinoTest {
	
	/**************************
	 *    PRUBAS PICO FINO    *
	 **************************/

	@Test
	public void cuandoSeCreaPicoFino_DeberiaTenerDurabilidad1000YFuerza20() {
		
		Herramienta picoFino = HerramientaFactory.newPicoFino();
		
		assertEquals(picoFino.getDurabilidad(), new BigDecimal(1000));
		assertEquals(picoFino.getFuerza(), new BigDecimal(20));
	}
}
