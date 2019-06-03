package fiuba.algo3.tp2.herramienta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;

import java.math.BigDecimal;

public class HachaTest {
	
	/**************************
	 * PRUBAS HACHA DE MADERA *
	 **************************/
	@Test
	public void cuandoSeCreaUnHachaDeMadera_DeberiaTenerDurabilidad100YFuerza2() {
		
		Herramienta hachaDeMadera = HerramientaFactory.newHachaDeMadera();

		assertEquals(new BigDecimal(100), hachaDeMadera.getDurabilidad());
		assertEquals(new BigDecimal(2), hachaDeMadera.getFuerza());
	}
	
	@Test
	public void dadaUnHachaDeMadera_CuandoSeUsaUnaVezContraMadera_DeberiaDisminuirLaDurabilidadEn2() throws MaterialDestruidoNoSePuedeGolpearException {
		Herramienta hachaDeMadera = HerramientaFactory.newHachaDeMadera();
		Material maderaCubo = new Madera();

		BigDecimal durabilidad = hachaDeMadera.getDurabilidad();

		hachaDeMadera.golpear(maderaCubo);

		assertEquals(durabilidad.subtract(new BigDecimal(2)), hachaDeMadera.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDeMadera_CuandoSeUsaUnaVezContraPiedra_DeberiaDisminuirLaDurabilidadEn2() throws MaterialDestruidoNoSePuedeGolpearException {

		Herramienta hachaDeMadera = HerramientaFactory.newHachaDeMadera();
		Material piedraCubo = new Piedra();

		BigDecimal durabilidad = hachaDeMadera.getDurabilidad();

		hachaDeMadera.golpear(piedraCubo);

		assertEquals(durabilidad.subtract(new BigDecimal(2)), hachaDeMadera.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDeMadera_CuandoSeUsaUnaVezContraMetal_DeberiaDisminuirLaDurabilidadEn2() throws MaterialDestruidoNoSePuedeGolpearException {
		Herramienta hachaDeMadera = HerramientaFactory.newHachaDeMadera();
		Material metalCubo = new Metal();

		BigDecimal durabilidad = hachaDeMadera.getDurabilidad();

		hachaDeMadera.golpear(metalCubo);

		assertEquals(durabilidad.subtract(new BigDecimal(2)), hachaDeMadera.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDeMadera_CuandoSeUsaUnaVezContraDiamante_DeberiaDisminuirLaDurabilidadEn2() throws MaterialDestruidoNoSePuedeGolpearException {
		Herramienta hachaDeMadera = HerramientaFactory.newHachaDeMadera();
		Material diamanteCubo = new Diamante();

		BigDecimal durabilidad = hachaDeMadera.getDurabilidad();

		hachaDeMadera.golpear(diamanteCubo);

		assertEquals(durabilidad.subtract(new BigDecimal(2)), hachaDeMadera.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaMaderaConHachaDeMadera_DeberiaReducirLaDurabilidadDeLaMaderaEn2() 
			throws Exception {
		
		Herramienta hachaMadera = HerramientaFactory.newHachaDeMadera();
		Material madera = new Madera();
		
		hachaMadera.golpear(madera);
		
		assertEquals(new BigDecimal(8), madera.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaPiedraConHachaDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta hachaMadera = HerramientaFactory.newHachaDeMadera();
		Material piedra = new Piedra();
		
		hachaMadera.golpear(piedra);
		
		assertEquals(new BigDecimal(30), piedra.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaMetalConHachaDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta hachaMadera = HerramientaFactory.newHachaDeMadera();
		Material metal = new Metal();
		
		hachaMadera.golpear(metal);
		
		assertEquals(new BigDecimal(50), metal.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaDiamanteConHachaDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta hachaMadera = HerramientaFactory.newHachaDeMadera();
		Material diamante = new Diamante();
		
		hachaMadera.golpear(diamante);
		
		assertEquals(new BigDecimal(100), diamante.getDurabilidad());
	}
	
	
	/**************************
	 * PRUBAS HACHA DE PIEDRA *
	 **************************/
	@Test
	public void cuandoSeCreaUnHachaDePiedra_DeberiaTenerDurabilidad200YFuerza5() {
		
		Herramienta hacha = HerramientaFactory.newHachaDePiedra();
		
		assertEquals(hacha.getDurabilidad(),new BigDecimal(200));
		assertEquals(hacha.getFuerza(),new BigDecimal(5));
	}

	@Test
	public void dadaUnHachaDePiedra_CuandoSeUsaUnaVezContraMadera_DeberiaDisminuirLaDurabilidadEn5() 
			throws Exception {
		
		Herramienta hachaDePiedra = HerramientaFactory.newHachaDePiedra();
		Material madera = new Madera();
		BigDecimal durabilidad = hachaDePiedra.getDurabilidad();
		
		hachaDePiedra.golpear(madera);

		assertEquals(durabilidad.subtract(new BigDecimal(5)), hachaDePiedra.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDePiedra_CuandoSeUsaUnaVezContraPiedra_DeberiaDisminuirLaDurabilidadEn5() 
			throws Exception {

		Herramienta hachaDePiedra = HerramientaFactory.newHachaDePiedra();
		Material piedraCubo = new Piedra();
		BigDecimal durabilidad = hachaDePiedra.getDurabilidad();
		
		hachaDePiedra.golpear(piedraCubo);

		assertEquals(durabilidad.subtract(new BigDecimal(5)), hachaDePiedra.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDePiedra_CuandoSeUsaUnaVezContraMetal_DeberiaDisminuirLaDurabilidadEn5() 
			throws Exception {
		
		Herramienta hachaDePiedra = HerramientaFactory.newHachaDePiedra();
		Material metal = new Metal();
		BigDecimal durabilidad = hachaDePiedra.getDurabilidad();
		
		hachaDePiedra.golpear(metal);
		
		assertEquals(durabilidad.subtract(new BigDecimal(5)), hachaDePiedra.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDePiedra_CuandoSeUsaUnaVezContraDiamante_DeberiaDisminuirLaDurabilidadEn5() 
			throws Exception {
		
		Herramienta hachaDePiedra = HerramientaFactory.newHachaDePiedra();
		Material diamante = new Diamante();
		BigDecimal durabilidad = hachaDePiedra.getDurabilidad();

		hachaDePiedra.golpear(diamante);

		assertEquals(durabilidad.subtract(new BigDecimal(5)), hachaDePiedra.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaMaderaConHachaDePiedra_DeberiaReducirLaDurabilidadDeLaMaderaEn5() 
			throws Exception {
		
		Herramienta hachaPiedra = HerramientaFactory.newHachaDePiedra();
		Material madera = new Madera();
		
		hachaPiedra.golpear(madera);
		
		assertEquals(new BigDecimal(5), madera.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaPiedraConHachaDePiedra_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta hachaPiedra = HerramientaFactory.newHachaDePiedra();
		Material piedra = new Piedra();
		
		hachaPiedra.golpear(piedra);
		
		assertEquals(new BigDecimal(30), piedra.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaDiamanteConHachaDePiedra_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta hachaPiedra = HerramientaFactory.newHachaDePiedra();
		Material diamante = new Diamante();
		
		hachaPiedra.golpear(diamante);
		
		assertEquals(new BigDecimal(100), diamante.getDurabilidad());
	}
	
	
	/**************************
	 * PRUBAS HACHA DE METAL  *
	 **************************/
	@Test
	public void cuandoSeCreaUnHachaDeMetal_DeberiaTenerDurabilidad400YFuerza10() {
		
		Herramienta hacha = HerramientaFactory.newHachaDeMetal();
		
		assertEquals(new BigDecimal(400), hacha.getDurabilidad());
		assertEquals(new BigDecimal(10), hacha.getFuerza());
	}
	
	@Test
	public void dadaUnHachaDeMetal_CuandoSeUsaUnaVezContraMadera_DeberiaDisminuirLaDurabilidadEn5() 
			throws Exception {

		Herramienta hachaDeMetal = HerramientaFactory.newHachaDeMetal();
		Material madera = new Madera();
		BigDecimal durabilidad = hachaDeMetal.getDurabilidad();

		hachaDeMetal.golpear(madera);

		assertEquals(durabilidad.subtract(new BigDecimal(5)) , hachaDeMetal.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDeMetal_CuandoSeUsaUnaVezContraPiedra_DeberiaDisminuirLaDurabilidadEn5() 
			throws Exception {

		Herramienta hachaDeMetal = HerramientaFactory.newHachaDeMetal();
		Material piedra = new Piedra();
		BigDecimal durabilidad = hachaDeMetal.getDurabilidad();

		hachaDeMetal.golpear(piedra);

		assertEquals(durabilidad.subtract(new BigDecimal(5)), hachaDeMetal.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDeMetal_CuandoSeUsaUnaVezContraMetal_DeberiaDisminuirLaDurabilidadEn5() 
			throws Exception {

		Herramienta hachaDeMetal = HerramientaFactory.newHachaDeMetal();
		Material metal = new Metal();
		BigDecimal durabilidad = hachaDeMetal.getDurabilidad();

		hachaDeMetal.golpear(metal);

		assertEquals(durabilidad.subtract(new BigDecimal(5)) , hachaDeMetal.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDeMetal_CuandoSeUsaUnaVezContraDiamante_DeberiaDisminuirLaDurabilidadEn5() 
			throws Exception {

		Herramienta hachaDeMetal = HerramientaFactory.newHachaDeMetal();
		Material diamante = new Diamante();
		BigDecimal durabilidad = hachaDeMetal.getDurabilidad();

		hachaDeMetal.golpear(diamante);

		assertEquals(durabilidad.subtract(new BigDecimal(5)), hachaDeMetal.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaMaderaConHachaDeMetal_DeberiaReducirLaDurabilidadDeLaMaderaEn10() 
			throws Exception {
		
		Herramienta hachaMetal = HerramientaFactory.newHachaDeMetal();
		Material madera = new Madera();
		
		hachaMetal.golpear(madera);
		
		assertEquals(new BigDecimal(0), madera.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaPiedraConHachaDeMetal_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta hachaMetal = HerramientaFactory.newHachaDeMetal();
		Material piedra = new Piedra();
		
		hachaMetal.golpear(piedra);
		
		assertEquals(new BigDecimal(30), piedra.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaDiamanteConHachaDeMetal_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta hachaMetal = HerramientaFactory.newHachaDeMetal();
		Material diamante = new Diamante();
		
		hachaMetal.golpear(diamante);
		
		assertEquals(new BigDecimal(100), diamante.getDurabilidad());
	}
}
