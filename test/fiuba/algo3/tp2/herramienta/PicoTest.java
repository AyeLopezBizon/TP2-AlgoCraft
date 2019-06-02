package fiuba.algo3.tp2.herramienta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;

public class PicoTest {

	@Test
	public void cuandoSeGolpeaMaderaConPicoDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta picoMadera = HerramientaFactory.newPicoDeMadera();
		Material madera = new Madera();
		
		picoMadera.golpear(madera);
		
		assertEquals(new Integer(10), madera.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaMaderaConPicoDePiedra_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta picoPiedra = HerramientaFactory.newPicoDePiedra();
		Material madera = new Madera();
		
		picoPiedra.golpear(madera);
		
		assertEquals(new Integer(10), madera.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaMaderaConPicoDeMetal_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta picoMetal = HerramientaFactory.newPicoDeMetal();
		Material madera = new Madera();
		
		picoMetal.golpear(madera);
		
		assertEquals(new Integer(10), madera.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaPiedraConPicoDeMadera_DeberiaReducirLaDurabilidadDeLaPiedraEn2() 
			throws Exception {
		
		Herramienta picoMadera = HerramientaFactory.newPicoDeMadera();
		Material piedra = new Piedra();
		
		picoMadera.golpear(piedra);
		
		assertEquals(new Integer(28), piedra.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaPiedraConPicoDePiedra_DeberiaReducirLaDurabilidadDeLaPiedraEn4() 
			throws Exception {
		
		Herramienta picoPiedra = HerramientaFactory.newPicoDePiedra();
		Material piedra = new Piedra();
		
		picoPiedra.golpear(piedra);
		
		assertEquals(new Integer(26), piedra.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaPiedraConPicoDeMetal_DeberiaReducirLaDurabilidadDeLaPiedraEn12() 
			throws Exception {
		
		Herramienta picoMetal = HerramientaFactory.newPicoDeMetal();
		Material piedra = new Piedra();
		
		picoMetal.golpear(piedra);
		
		assertEquals(new Integer(18), piedra.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaMetalConPicoDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta picoMadera = HerramientaFactory.newPicoDeMadera();
		Material metal = new Metal();
		
		picoMadera.golpear(metal);
		
		assertEquals(new Integer(50), metal.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaMetalConPicoDePiedra_DeberiaReducirLaDurabilidadDelMaterialEn4() 
			throws Exception {
		
		Herramienta picoPiedra = HerramientaFactory.newPicoDePiedra();
		Material metal = new Metal();
		
		picoPiedra.golpear(metal);
		
		assertEquals(new Integer(46), metal.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaMetalConPicoDeMetal_DeberiaReducirLaDurabilidadDelMaterialEn12() 
			throws Exception {
		
		Herramienta picoMetal = HerramientaFactory.newPicoDeMetal();
		Material metal = new Metal();
		
		picoMetal.golpear(metal);
		
		assertEquals(new Integer(38), metal.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaDiamanteConPicoDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta picoMadera = HerramientaFactory.newPicoDeMadera();
		Material diamante = new Diamante();
		
		picoMadera.golpear(diamante);
		
		assertEquals(new Integer(100), diamante.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaDiamanteConPicoDePiedra_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta picoPiedra = HerramientaFactory.newPicoDePiedra();
		Material diamante = new Diamante();
		
		picoPiedra.golpear(diamante);
		
		assertEquals(new Integer(100), diamante.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaDiamanteConPicoDeMetal_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta picoMetal = HerramientaFactory.newPicoDeMetal();
		Material diamante = new Diamante();
		
		picoMetal.golpear(diamante);
		
		assertEquals(new Integer(100), diamante.getDurabilidad());
	}
}
