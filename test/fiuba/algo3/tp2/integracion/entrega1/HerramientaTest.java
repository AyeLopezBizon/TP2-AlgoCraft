package fiuba.algo3.tp2.integracion.entrega1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;

public class HerramientaTest {
	
	@Test
	public void cuandoSeCreaUnHachaDeMadera_DeberiaTenerDurabilidad100YFuerza2() {
		
		Herramienta hachaDeMadera = HerramientaFactory.newHachaDeMadera();

		assertEquals(new BigDecimal(100), hachaDeMadera.getDurabilidad());
		assertEquals(new BigDecimal(2), hachaDeMadera.getFuerza());
	}
	
	@Test
	public void cuandoSeCreaUnPicoDeMadera_DeberiaTenerDurabilidad100YFuerza2() {
		
		Herramienta picoDeMadera = HerramientaFactory.newPicoDeMadera();
		
		assertEquals(new BigDecimal(100), picoDeMadera.getDurabilidad()); 
		assertEquals(new BigDecimal(2), picoDeMadera.getFuerza());
	}
	
	@Test
	public void cuandoSeCreaUnHachaDeMetal_DeberiaTenerDurabilidad400YFuerza10() {
		
		Herramienta hacha = HerramientaFactory.newHachaDeMetal();
		
		assertEquals(new BigDecimal(400), hacha.getDurabilidad());
		assertEquals(new BigDecimal(10), hacha.getFuerza());
	}
	 
	@Test
	public void cuandoSeCreaUnPicoDeMetal_DeberiaTenerDurabilidad400YFuerza12() {
		
		Herramienta pico = HerramientaFactory.newPicoDeMetal();
		
		assertEquals(new BigDecimal(400), pico.getDurabilidad());
		assertEquals(new BigDecimal(12), pico.getFuerza());
	}
	
	@Test
	public void cuandoSeCreaUnPicoFino_DeberiaTenerDurabilidad1000YFuerza20() {
		
		Herramienta picoFino = HerramientaFactory.newPicoFino();
		
		assertEquals(new BigDecimal(1000), picoFino.getDurabilidad());
		assertEquals(new BigDecimal(20), picoFino.getFuerza());
	}

	@Test
	public void cuandoSeUsaHachaDeMaderaContraMateriales_DeberiaReducirLaDurabilidadDelHachaDeAcuerdoASuMaterial() throws Exception {

		Herramienta hachaDeMadera = HerramientaFactory.newHachaDeMadera();
		Material madera = new Madera();
		Material piedra = new Piedra();
		Material metal = new Metal();
		Material diamante = new Diamante();

		BigDecimal decrementoDurabilidad = hachaDeMadera.getFuerza();
		BigDecimal durabilidadAntesDeGolpe = hachaDeMadera.getDurabilidad();

		hachaDeMadera.golpear(madera);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), hachaDeMadera.getDurabilidad());

		durabilidadAntesDeGolpe = hachaDeMadera.getDurabilidad();

		hachaDeMadera.golpear(piedra);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), hachaDeMadera.getDurabilidad());

		durabilidadAntesDeGolpe = hachaDeMadera.getDurabilidad();

		hachaDeMadera.golpear(metal);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), hachaDeMadera.getDurabilidad());

		durabilidadAntesDeGolpe = hachaDeMadera.getDurabilidad();

		hachaDeMadera.golpear(diamante);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), hachaDeMadera.getDurabilidad());
	}

	@Test
	public void cuandoSeUsaHachaDePiedraContraMateriales_DeberiaReducirLaDurabilidadDelHachaDeAcuerdoASuMaterial() throws Exception {

		Herramienta hachaDePiedra = HerramientaFactory.newHachaDePiedra();
		Material madera = new Madera();
		Material piedra = new Piedra();
		Material metal = new Metal();
		Material diamante = new Diamante();

		BigDecimal decrementoDurabilidad = hachaDePiedra.getFuerza();
		BigDecimal durabilidadAntesDeGolpe = hachaDePiedra.getDurabilidad();

		hachaDePiedra.golpear(madera);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), hachaDePiedra.getDurabilidad());

		durabilidadAntesDeGolpe = hachaDePiedra.getDurabilidad();

		hachaDePiedra.golpear(piedra);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), hachaDePiedra.getDurabilidad());

		durabilidadAntesDeGolpe = hachaDePiedra.getDurabilidad();

		hachaDePiedra.golpear(metal);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), hachaDePiedra.getDurabilidad());

		durabilidadAntesDeGolpe = hachaDePiedra.getDurabilidad();

		hachaDePiedra.golpear(diamante);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), hachaDePiedra.getDurabilidad());
	}

	@Test
	public void cuandoSeUsaHachaDeMetalContraMateriales_DeberiaReducirLaDurabilidadDelHachaDeAcuerdoASuMaterial() throws Exception {

		Herramienta hachaDeMetal = HerramientaFactory.newHachaDeMetal();
		Material madera = new Madera();
		Material piedra = new Piedra();
		Material metal = new Metal();
		Material diamante = new Diamante();

		BigDecimal decrementoDurabilidad = hachaDeMetal.getFuerza().divide(new BigDecimal(2));
		BigDecimal durabilidadAntesDeGolpe = hachaDeMetal.getDurabilidad();

		hachaDeMetal.golpear(madera);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), hachaDeMetal.getDurabilidad());

		durabilidadAntesDeGolpe = hachaDeMetal.getDurabilidad();

		hachaDeMetal.golpear(piedra);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), hachaDeMetal.getDurabilidad());

		durabilidadAntesDeGolpe = hachaDeMetal.getDurabilidad();

		hachaDeMetal.golpear(metal);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), hachaDeMetal.getDurabilidad());

		durabilidadAntesDeGolpe = hachaDeMetal.getDurabilidad();

		hachaDeMetal.golpear(diamante);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), hachaDeMetal.getDurabilidad());
	}

	@Test
	public void cuandoSeUsaPicoDeMaderaContraMateriales_DeberiaReducirLaDurabilidadDelPicoDeAcuerdoASuMaterial() throws Exception {

		Herramienta picoDeMadera = HerramientaFactory.newPicoDeMadera();
		Material madera = new Madera();
		Material piedra = new Piedra();
		Material metal = new Metal();
		Material diamante = new Diamante();

		BigDecimal decrementoDurabilidad = picoDeMadera.getFuerza();
		BigDecimal durabilidadAntesDeGolpe = picoDeMadera.getDurabilidad();

		picoDeMadera.golpear(madera);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), picoDeMadera.getDurabilidad());

		durabilidadAntesDeGolpe = picoDeMadera.getDurabilidad();

		picoDeMadera.golpear(piedra);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), picoDeMadera.getDurabilidad());

		durabilidadAntesDeGolpe = picoDeMadera.getDurabilidad();

		picoDeMadera.golpear(metal);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), picoDeMadera.getDurabilidad());

		durabilidadAntesDeGolpe = picoDeMadera.getDurabilidad();

		picoDeMadera.golpear(diamante);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), picoDeMadera.getDurabilidad());
	}

	@Test
	public void cuandoSeUsaPicoDePiedraContraMateriales_DeberiaReducirLaDurabilidadDelPicoDeAcuerdoASuMaterial() throws Exception {

		Herramienta picoDePiedra = HerramientaFactory.newPicoDePiedra();
		Material madera = new Madera();
		Material piedra = new Piedra();
		Material metal = new Metal();
		Material diamante = new Diamante();

		BigDecimal decrementoDurabilidad = picoDePiedra.getFuerza().divide(new BigDecimal(1.5), 2, RoundingMode.HALF_UP);
		BigDecimal durabilidadAntesDeGolpe = picoDePiedra.getDurabilidad();

		picoDePiedra.golpear(madera);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), picoDePiedra.getDurabilidad());

		durabilidadAntesDeGolpe = picoDePiedra.getDurabilidad();

		picoDePiedra.golpear(piedra);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), picoDePiedra.getDurabilidad());

		durabilidadAntesDeGolpe = picoDePiedra.getDurabilidad();

		picoDePiedra.golpear(metal);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), picoDePiedra.getDurabilidad());

		durabilidadAntesDeGolpe = picoDePiedra.getDurabilidad();

		picoDePiedra.golpear(diamante);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), picoDePiedra.getDurabilidad());
	}

	@Test
	public void cuandoSeUsaPicoDeMetalContraMateriales_DeberiaReducirLaDurabilidadDelPicoDeAcuerdoASuMaterial() throws Exception {

		Herramienta picoDeMetal = HerramientaFactory.newPicoDeMetal();
		Material madera = new Madera();
		Material piedra = new Piedra();
		Material metal = new Metal();
		Material diamante = new Diamante();

		BigDecimal decrementoDurabilidad = picoDeMetal.getFuerza();
		BigDecimal durabilidadAntesDeGolpe;

		// Golpeamos 2 veces cada material
		for(int i = 0; i < 2; i++) {

			durabilidadAntesDeGolpe = picoDeMetal.getDurabilidad();

			picoDeMetal.golpear(madera);
			assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), picoDeMetal.getDurabilidad());

			durabilidadAntesDeGolpe = picoDeMetal.getDurabilidad();

			picoDeMetal.golpear(piedra);
			assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), picoDeMetal.getDurabilidad());

			durabilidadAntesDeGolpe = picoDeMetal.getDurabilidad();

			picoDeMetal.golpear(metal);
			assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), picoDeMetal.getDurabilidad());

			durabilidadAntesDeGolpe = picoDeMetal.getDurabilidad();

			picoDeMetal.golpear(diamante);
			assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), picoDeMetal.getDurabilidad());
		}

		// Ahora 2 veces mas y en la ultima la durabilidad tiene que ser 0
		durabilidadAntesDeGolpe = picoDeMetal.getDurabilidad();

		picoDeMetal.golpear(madera);
		assertEquals(durabilidadAntesDeGolpe.subtract(decrementoDurabilidad), picoDeMetal.getDurabilidad());

		picoDeMetal.golpear(madera);
		assertEquals(new BigDecimal(0), picoDeMetal.getDurabilidad());
	}
	
	@Test
	public void cuandoSeUsaPicoFinoContraDiamante_DeberiaReducirSuDurabilidad() 
			throws Exception {
		
		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material diamante = new Diamante();
		
		BigDecimal durabilidadAntesDeGolpe = picoFino.getDurabilidad();
		picoFino.golpear(diamante);
		assertEquals(durabilidadAntesDeGolpe
						.subtract(durabilidadAntesDeGolpe.multiply(new BigDecimal("0.1")))
						.compareTo(picoFino.getDurabilidad()), 0);
		
		durabilidadAntesDeGolpe = picoFino.getDurabilidad();
		picoFino.golpear(diamante);
		assertEquals(durabilidadAntesDeGolpe
				.subtract(durabilidadAntesDeGolpe.multiply(new BigDecimal("0.1")))
				.compareTo(picoFino.getDurabilidad()), 0);
		
		durabilidadAntesDeGolpe = picoFino.getDurabilidad();
		picoFino.golpear(diamante);
		assertEquals(durabilidadAntesDeGolpe
				.subtract(durabilidadAntesDeGolpe.multiply(new BigDecimal("0.1")))
				.compareTo(picoFino.getDurabilidad()), 0);
	}
	
	@Test
	public void cuandoSeUsaPicoFinoContraMaterialesExceptoDiamante_NoDeberiaReducirSuDurabilidad() 
			throws Exception {
		
		Herramienta picoFino = HerramientaFactory.newPicoFino();
		
		Material madera = new Madera();
		Material piedra = new Piedra();
		Material metal = new Metal();
		
		BigDecimal durabilidadAntesDeGolpe = picoFino.getDurabilidad();
		picoFino.golpear(madera);
		assertEquals(durabilidadAntesDeGolpe, picoFino.getDurabilidad());
		
		durabilidadAntesDeGolpe = picoFino.getDurabilidad();
		picoFino.golpear(piedra);
		assertEquals(durabilidadAntesDeGolpe, picoFino.getDurabilidad());
		
		durabilidadAntesDeGolpe = picoFino.getDurabilidad();
		picoFino.golpear(metal);
		assertEquals(durabilidadAntesDeGolpe, picoFino.getDurabilidad());
	}
}