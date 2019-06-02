package fiuba.algo3.tp2.herramienta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;

public class HachaTest {

	@Test
	public void cuandoSeGolpeaMaderaConHachaDeMadera_DeberiaReducirLaDurabilidadDeLaMaderaEn2() 
			throws Exception {
		
		Herramienta hachaMadera = HerramientaFactory.newHachaDeMadera();
		Material madera = new Madera();
		
		hachaMadera.golpear(madera);
		
		assertEquals(new Integer(8), madera.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaMaderaConHachaDePiedra_DeberiaReducirLaDurabilidadDeLaMaderaEn5() 
			throws Exception {
		
		Herramienta hachaPiedra = HerramientaFactory.newHachaDePiedra();
		Material madera = new Madera();
		
		hachaPiedra.golpear(madera);
		
		assertEquals(new Integer(5), madera.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaMaderaConHachaDeMetal_DeberiaReducirLaDurabilidadDeLaMaderaEn10() 
			throws Exception {
		
		Herramienta hachaMetal = HerramientaFactory.newHachaDeMetal();
		Material madera = new Madera();
		
		hachaMetal.golpear(madera);
		
		assertEquals(new Integer(0), madera.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaPiedraConHachaDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta hachaMadera = HerramientaFactory.newHachaDeMadera();
		Material piedra = new Piedra();
		
		hachaMadera.golpear(piedra);
		
		assertEquals(new Integer(30), piedra.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaPiedraConHachaDePiedra_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta hachaPiedra = HerramientaFactory.newHachaDePiedra();
		Material piedra = new Piedra();
		
		hachaPiedra.golpear(piedra);
		
		assertEquals(new Integer(30), piedra.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaPiedraConHachaDeMetal_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta hachaMetal = HerramientaFactory.newHachaDeMetal();
		Material piedra = new Piedra();
		
		hachaMetal.golpear(piedra);
		
		assertEquals(new Integer(30), piedra.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaMetalConHachaDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta hachaMadera = HerramientaFactory.newHachaDeMadera();
		Material metal = new Metal();
		
		hachaMadera.golpear(metal);
		
		assertEquals(new Integer(50), metal.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaDiamanteConHachaDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta hachaMadera = HerramientaFactory.newHachaDeMadera();
		Material diamante = new Diamante();
		
		hachaMadera.golpear(diamante);
		
		assertEquals(new Integer(100), diamante.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaDiamanteConHachaDePiedra_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta hachaPiedra = HerramientaFactory.newHachaDePiedra();
		Material diamante = new Diamante();
		
		hachaPiedra.golpear(diamante);
		
		assertEquals(new Integer(100), diamante.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaDiamanteConHachaDeMetal_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta hachaMetal = HerramientaFactory.newHachaDeMetal();
		Material diamante = new Diamante();
		
		hachaMetal.golpear(diamante);
		
		assertEquals(new Integer(100), diamante.getDurabilidad());
	}
}
