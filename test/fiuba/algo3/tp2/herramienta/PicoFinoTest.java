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
	/*
	 * TODO
	 * 
	 @Test
	public void cuandoSeCreaPicoFino_DeberiaTenerDurabilidad1000YFuerza20() {
		
		Herramienta picoFino = HerramientaFactory.newPicoDePiedra();
		
		assertEquals(picoFino.getDurabilidad(), new BigDecimal(1000));
		assertEquals(picoFino.getFuerza(), new BigDecimal(20));
	}
	 */
	
	@Test
	public void cuandoSeGolpeaMaderaConPicoFino_DeberiaReducirLaDurabilidadDelMaterialEn20() 
			throws Exception {
		
		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material madera = new Madera();
		
		picoFino.golpear(madera);
		
		assertEquals(new BigDecimal(0), madera.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaPiedraConPicoFino_DeberiaReducirLaDurabilidadDelMaterialEn20() 
			throws Exception {
		
		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material piedra = new Piedra();
		
		picoFino.golpear(piedra);
		
		assertEquals(new BigDecimal(10), piedra.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaMetalConPicoFino_DeberiaReducirLaDurabilidadDelMaterialEn20() 
			throws Exception {
		
		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material metal = new Metal();
		
		picoFino.golpear(metal);
		
		assertEquals(new BigDecimal(30), metal.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaDiamanteConPicoFino_DeberiaReducirLaDurabilidadDelMaterialEn20() 
			throws Exception {
		
		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material diamante = new Diamante();
		
		picoFino.golpear(diamante);
		
		assertEquals(new BigDecimal(80), diamante.getDurabilidad());
	}
}
