package fiuba.algo3.tp2.herramienta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;

import java.math.BigDecimal;

public class PicoTest {

	/**************************
	 * PRUBAS PICO DE MADERA  *
	 **************************/
	@Test
	public void cuandoSeCreaUnPicoDeMadera_DeberiaTenerDurabilidad100YFuerza2() {
		
		Herramienta picoDeMadera = HerramientaFactory.newPicoDeMadera();
		
		assertEquals(new BigDecimal(100), picoDeMadera.getDurabilidad()); 
		assertEquals(new BigDecimal(2), picoDeMadera.getFuerza());
	}
	
	@Test 
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraMadera_DeberiaDisminuirLaDurabilidadEn2()
			throws Exception{
		
		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		Material madera = new Madera();
		BigDecimal durabilidad = pico.getDurabilidad();
		
		pico.golpear(madera);
		
		assertEquals(pico.getDurabilidad(), durabilidad.subtract(new BigDecimal(2)));
	}

	@Test
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraPiedra_DeberiaDisminuirLaDurabilidadEn2()
			throws Exception{

		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		Material piedra = new Piedra();
		BigDecimal durabilidad = pico.getDurabilidad();
		
		pico.golpear(piedra);
		
		assertEquals(pico.getDurabilidad(), durabilidad.subtract(new BigDecimal(2)));
	}

	@Test
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraMetal_DeberiaDisminuirLaDurabilidadEn2()
			throws Exception{

		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		Material metal = new Metal();
		BigDecimal durabilidad = pico.getDurabilidad();

		pico.golpear(metal);
		
		assertEquals(pico.getDurabilidad(), durabilidad.subtract(new BigDecimal(2)));

	}

	@Test
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraDiamante_DeberiaDisminuirLaDurabilidadEn2()
			throws Exception{

		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		Material diamante = new Diamante();
		BigDecimal durabilidad = pico.getDurabilidad();

		pico.golpear(diamante);

		assertEquals(pico.getDurabilidad(), durabilidad.subtract(new BigDecimal(2)));

	}
	
	@Test
	public void cuandoSeGolpeaMaderaConPicoDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta picoMadera = HerramientaFactory.newPicoDeMadera();
		Material madera = new Madera();
		
		picoMadera.golpear(madera);
		
		assertEquals(new BigDecimal(10), madera.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaPiedraConPicoDeMadera_DeberiaReducirLaDurabilidadDeLaPiedraEn2() 
			throws Exception {
		
		Herramienta picoMadera = HerramientaFactory.newPicoDeMadera();
		Material piedra = new Piedra();
		
		picoMadera.golpear(piedra);
		
		assertEquals(new BigDecimal(28), piedra.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaMetalConPicoDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta picoMadera = HerramientaFactory.newPicoDeMadera();
		Material metal = new Metal();
		
		picoMadera.golpear(metal);
		
		assertEquals(new BigDecimal(50), metal.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaDiamanteConPicoDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta picoMadera = HerramientaFactory.newPicoDeMadera();
		Material diamante = new Diamante();
		
		picoMadera.golpear(diamante);
		
		assertEquals(new BigDecimal(100), diamante.getDurabilidad());
	}
	
	
	/**************************
	 * PRUBAS PICO DE PIEDRA  *
	 **************************/
	@Test
	public void cuandoSeCreaUnPicoDePiedra_DeberiaTenerDurabilidad200YFuerza4() {
		
		Herramienta picoDePiedra = HerramientaFactory.newPicoDePiedra();
		
		assertEquals(new BigDecimal(200), picoDePiedra.getDurabilidad()); 
		assertEquals(new BigDecimal(4), picoDePiedra.getFuerza());
	}
	
	/*
	@Test
	public void dadoUnPicodePiedra_CuandoSeUsaUnaVezContraMadera_DeberiaDesminuirlaDurabilidadEn2Coma6()
	throws Exception{
		Herramienta pico = HerramientaFactory.newPicoDePiedra();
		Material madera = new Madera();

		BigDecimal durabilidad = pico.getDurabilidad();

		pico.golpear(madera);
		
		assertEquals(pico.getDurabilidad(), new BigDecimal(197.3334));

	}
	 */
	
	@Test
	public void cuandoSeGolpeaMaderaConPicoDePiedra_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta picoPiedra = HerramientaFactory.newPicoDePiedra();
		Material madera = new Madera();
		
		picoPiedra.golpear(madera);
		
		assertEquals(new BigDecimal(10), madera.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaPiedraConPicoDePiedra_DeberiaReducirLaDurabilidadDeLaPiedraEn4() 
			throws Exception {
		
		Herramienta picoPiedra = HerramientaFactory.newPicoDePiedra();
		Material piedra = new Piedra();
		
		picoPiedra.golpear(piedra);
		
		assertEquals(new BigDecimal(26), piedra.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaMetalConPicoDePiedra_DeberiaReducirLaDurabilidadDelMaterialEn4() 
			throws Exception {
		
		Herramienta picoPiedra = HerramientaFactory.newPicoDePiedra();
		Material metal = new Metal();
		
		picoPiedra.golpear(metal);
		
		assertEquals(new BigDecimal(46), metal.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaDiamanteConPicoDePiedra_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta picoPiedra = HerramientaFactory.newPicoDePiedra();
		Material diamante = new Diamante();
		
		picoPiedra.golpear(diamante);
		
		assertEquals(new BigDecimal(100), diamante.getDurabilidad());
	}
	
	
	/**************************
	 * PRUBAS PICO DE METAL   *
	 **************************/
	/*
	 * TODO
	 * 
	@Test
	public void cuandoSeCreaUnPicoDeMetal_DeberiaTenerDurabilidad400YFuerza12() {
		
		Herramienta picoDeMetal = HerramientaFactory.newPicoDeMetal();
		
		assertEquals(new BigDecimal(400), picoDeMetal.getDurabilidad()); 
		assertEquals(new BigDecimal(12), picoDeMetal.getFuerza());
	}
	 */
	
	/*
	//Pruebas Pico de metal
	@Test
	public void dadoUnPicoDeMetal_CuandoSeCrea_DeberiaTenerDurabilidad400YFuerza12() {
		Herramienta pico = HerramientaFactory.newPicoDeMetal();
		assertEquals(pico.getDurabilidad(), new BigDecimal(400));
		assertEquals(pico.getFuerza(), new BigDecimal(12));
	}
	 */
	
	@Test
	public void cuandoSeGolpeaMaderaConPicoDeMetal_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta picoMetal = HerramientaFactory.newPicoDeMetal();
		Material madera = new Madera();
		
		picoMetal.golpear(madera);
		
		assertEquals(new BigDecimal(10), madera.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaPiedraConPicoDeMetal_DeberiaReducirLaDurabilidadDeLaPiedraEn12() 
			throws Exception {
		
		Herramienta picoMetal = HerramientaFactory.newPicoDeMetal();
		Material piedra = new Piedra();
		
		picoMetal.golpear(piedra);
		
		assertEquals(new BigDecimal(18), piedra.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaMetalConPicoDeMetal_DeberiaReducirLaDurabilidadDelMaterialEn12() 
			throws Exception {
		
		Herramienta picoMetal = HerramientaFactory.newPicoDeMetal();
		Material metal = new Metal();
		
		picoMetal.golpear(metal);
		
		assertEquals(new BigDecimal(38), metal.getDurabilidad());
	}
	
	@Test
	public void cuandoSeGolpeaDiamanteConPicoDeMetal_NoSeDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Herramienta picoMetal = HerramientaFactory.newPicoDeMetal();
		Material diamante = new Diamante();
		
		picoMetal.golpear(diamante);
		
		assertEquals(new BigDecimal(100), diamante.getDurabilidad());
	}
}
