package fiuba.algo3.tp2.modelo.herramienta;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.material.Diamante;
import fiuba.algo3.tp2.modelo.material.Madera;
import fiuba.algo3.tp2.modelo.material.Material;
import fiuba.algo3.tp2.modelo.material.Metal;
import fiuba.algo3.tp2.modelo.material.Piedra;

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
	public void dadaUnHachaDeMadera_CuandoSeUsaUnaVezContraMadera_DeberiaDisminuirLaDurabilidadEn2()
			throws Exception {

		Herramienta hachaDeMadera = HerramientaFactory.newHachaDeMadera();
		Material maderaCubo = new Madera();

		BigDecimal durabilidad = hachaDeMadera.getDurabilidad();

		hachaDeMadera.golpear(maderaCubo);

		assertEquals(durabilidad.subtract(new BigDecimal(2)), hachaDeMadera.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDeMadera_CuandoSeUsaUnaVezContraPiedra_DeberiaDisminuirLaDurabilidadEn2()
			throws Exception {

		Herramienta hachaDeMadera = HerramientaFactory.newHachaDeMadera();
		Material piedraCubo = new Piedra();

		BigDecimal durabilidad = hachaDeMadera.getDurabilidad();

		hachaDeMadera.golpear(piedraCubo);

		assertEquals(durabilidad.subtract(new BigDecimal(2)), hachaDeMadera.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDeMadera_CuandoSeUsaUnaVezContraMetal_DeberiaDisminuirLaDurabilidadEn2()
			throws Exception {

		Herramienta hachaDeMadera = HerramientaFactory.newHachaDeMadera();
		Material metalCubo = new Metal();

		BigDecimal durabilidad = hachaDeMadera.getDurabilidad();

		hachaDeMadera.golpear(metalCubo);

		assertEquals(durabilidad.subtract(new BigDecimal(2)), hachaDeMadera.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDeMadera_CuandoSeUsaUnaVezContraDiamante_DeberiaDisminuirLaDurabilidadEn2()
			throws Exception {

		Herramienta hachaDeMadera = HerramientaFactory.newHachaDeMadera();
		Material diamanteCubo = new Diamante();

		BigDecimal durabilidad = hachaDeMadera.getDurabilidad();

		hachaDeMadera.golpear(diamanteCubo);

		assertEquals(durabilidad.subtract(new BigDecimal(2)), hachaDeMadera.getDurabilidad());
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
}