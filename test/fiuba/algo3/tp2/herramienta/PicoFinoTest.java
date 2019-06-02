package fiuba.algo3.tp2.herramienta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;
import fiuba.algo3.tp2.material.Diamante;

public class PicoFinoTest {
	
	@Test
	public void cuandoSeGolpeaMaderaConPicoFino_DeberiaReducirLaDurabilidadDelMaterialEn20() 
			throws Exception {
		
		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material madera = new Madera();
		
		picoFino.golpear(madera);
		
		assertEquals(new Integer(0), madera.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaPiedraConPicoFino_DeberiaReducirLaDurabilidadDelMaterialEn20() 
			throws Exception {
		
		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material piedra = new Piedra();
		
		picoFino.golpear(piedra);
		
		assertEquals(new Integer(10), piedra.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaMetalConPicoFino_DeberiaReducirLaDurabilidadDelMaterialEn20() 
			throws Exception {
		
		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material metal = new Metal();
		
		picoFino.golpear(metal);
		
		assertEquals(new Integer(30), metal.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaDiamanteConPicoFino_DeberiaReducirLaDurabilidadDelMaterialEn20() 
			throws Exception {
		
		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material diamante = new Diamante();
		
		picoFino.golpear(diamante);
		
		assertEquals(new Integer(80), diamante.getDurabilidad());
	}
}
