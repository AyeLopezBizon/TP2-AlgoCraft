package fiuba.algo3.tp2.integracion.entrega1;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import fiuba.algo3.tp2.herramienta.*;
import fiuba.algo3.tp2.material.*;

public class HerramientaTest {
/*
	//Pruebas Hacha de madera
	@Test
	public void dadaUnHachaDeMadera_CuandoSeCrea_DeberiaTenerDurabilidad100YFuerza2() {
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

	//Pruebas Pico de madera
	
	@Test
	public void dadoUnPicoDeMadera_CuandoSeCrea_DeberiaTenerDurabilidad100YFuerza2() {
		
		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		assertEquals(pico.getDurabilidad().intValue(),100); 
		assertEquals(pico.getFuerza(),(Integer)2);
	}

	@Test 
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraMaderaCubo_DeberiaDisminuirLaDurabilidadEn2()
	throws Exception{
		
		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		Material maderaCubo = new Madera();

		float durabilidad = pico.getDurabilidad().floatValue();
		
		pico.golpear(maderaCubo);		
		
		assertEquals(pico.getDurabilidad().floatValue(), durabilidad - 2, 0.0);
	}

	@Test
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraPiedraCubo_DeberiaDisminuirLaDurabilidadEn2()
	throws Exception{

		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		Material piedra = new Piedra();
		float durabilidad = pico.getDurabilidad().floatValue();
		
		pico.golpear(piedra);
		
		assertEquals(pico.getDurabilidad().floatValue(), durabilidad - 2, 0.0);
	}

	@Test
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraMetalCubo_DeberiaDisminuirLaDurabilidadEn2()
	throws Exception{

		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		Material metal = new Metal();
		float durabilidad = pico.getDurabilidad().floatValue();

		pico.golpear(metal);
		
		assertEquals(pico.getDurabilidad().floatValue(), durabilidad - 2, 0.0);
	}

	@Test
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraDiamanteCubo_DeberiaDisminuirLaDurabilidadEn2()
	throws Exception{

		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		Material diamante = new Diamante();
		float durabilidad = pico.getDurabilidad().floatValue();

		pico.golpear(diamante);

		assertEquals(pico.getDurabilidad().floatValue(), durabilidad - 2, 0.0);
	}
/*
	//Pruebas Hacha de piedra
	@Test
	public void dadaUnHachaDePiedra_CuandoSeCrea_DeberiaTenerDurabilidad200YFuerza5() {
		Herramienta hacha = new Hacha(new PiedraHerramienta(5));
		assertTrue(hacha.getDurabilidad()==200);
		assertTrue(hacha.getFuerza()==5);
	}
*/
	@Test
	public void dadaUnHachaDePiedra_CuandoSeUsaUnaVezContraMadera_DeberiaDisminuirLaDurabilidadEn5() throws MaterialDestruidoNoSePuedeGolpearException {
		Herramienta hachaDePiedra = HerramientaFactory.newHachaDePiedra();
		Material maderaCubo = new Madera();

		BigDecimal durabilidad = hachaDePiedra.getDurabilidad();

		hachaDePiedra.golpear(maderaCubo);

		assertEquals(durabilidad.subtract(new BigDecimal(5)), hachaDePiedra.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDePiedra_CuandoSeUsaUnaVezContraPiedra_DeberiaDisminuirLaDurabilidadEn5() throws MaterialDestruidoNoSePuedeGolpearException {

		Herramienta hachaDePiedra = HerramientaFactory.newHachaDePiedra();
		Material piedraCubo = new Piedra();

		BigDecimal durabilidad = hachaDePiedra.getDurabilidad();

		hachaDePiedra.golpear(piedraCubo);

		assertEquals(durabilidad.subtract(new BigDecimal(5)), hachaDePiedra.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDePiedra_CuandoSeUsaUnaVezContraMetal_DeberiaDisminuirLaDurabilidadEn5() throws MaterialDestruidoNoSePuedeGolpearException {
		Herramienta hachaDePiedra = HerramientaFactory.newHachaDePiedra();
		Material metalCubo = new Metal();

		BigDecimal durabilidad = hachaDePiedra.getDurabilidad();

		hachaDePiedra.golpear(metalCubo);

		assertEquals(durabilidad.subtract(new BigDecimal(5)), hachaDePiedra.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDePiedra_CuandoSeUsaUnaVezContraDiamante_DeberiaDisminuirLaDurabilidadEn5() throws MaterialDestruidoNoSePuedeGolpearException {
		Herramienta hachaDePiedra = HerramientaFactory.newHachaDePiedra();
		Material diamanteCubo = new Diamante();

		BigDecimal durabilidad = hachaDePiedra.getDurabilidad();

		hachaDePiedra.golpear(diamanteCubo);

		assertEquals(durabilidad.subtract(new BigDecimal(5)), hachaDePiedra.getDurabilidad());
	}
/*
	//Pruebas Pico de piedra
	@Test
	public void dadoUnPicoDePiedra_CuandoSeCrea_DeberiaTenerDurabilidad200YFuerza4(){
		Herramienta pico = new Pico(new PiedraHerramienta(4));
		assertTrue(pico.getDurabilidad()==200);
		assertTrue(pico.getFuerza()==4);
	}
	*/
/*
	@Test
	public void dadoUnPicodePiedra_CuandoSeUsaUnaVezContraMaderaCubo_DeberiaDesminuirlaDurabilidadEn2Coma6(){
		Herramienta pico = new Pico(new Piedra(4));
		MaterialCubo maderaCubo = new MaderaCubo();

		float durabilidad = pico.getDurabilidad();

		pico.usar(maderaCubo);

		assertTrue(pico.getDurabilidad() == (durabilidad - 2.6666f));

	}
*/
	/*
	//Pruebas Hacha de metal
	@Test
	public void dadaUnHachaDeMetal_CuandoSeCrea_DeberiaTenerDurabilidad400YFuerza10() {
		Herramienta hacha = new Hacha(new MetalHerramienta());
		assertTrue(hacha.getDurabilidad()==400);
		assertTrue(hacha.getFuerza()==10);
	}
*/
	@Test
	public void dadaUnHachaDeMetal_CuandoSeUsaUnaVezContraMadera_DeberiaDisminuirLaDurabilidadEn5() throws MaterialDestruidoNoSePuedeGolpearException {

		Herramienta hachaDeMetal = HerramientaFactory.newHachaDeMetal();
		Material madera = new Madera();

		BigDecimal durabilidad = hachaDeMetal.getDurabilidad();

		hachaDeMetal.golpear(madera);

		assertEquals(durabilidad.subtract(new BigDecimal(5)) , hachaDeMetal.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDeMetal_CuandoSeUsaUnaVezContraPiedra_DeberiaDisminuirLaDurabilidadEn5() throws MaterialDestruidoNoSePuedeGolpearException {

		Herramienta hachaDeMetal = HerramientaFactory.newHachaDeMetal();
		Material piedra = new Piedra();

		BigDecimal durabilidad = hachaDeMetal.getDurabilidad();

		hachaDeMetal.golpear(piedra);

		assertEquals(durabilidad.subtract(new BigDecimal(5)), hachaDeMetal.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDeMetal_CuandoSeUsaUnaVezContraMetal_DeberiaDisminuirLaDurabilidadEn5() throws MaterialDestruidoNoSePuedeGolpearException {

		Herramienta hachaDeMetal = HerramientaFactory.newHachaDeMetal();
		Material metal = new Metal();

		BigDecimal durabilidad = hachaDeMetal.getDurabilidad();

		hachaDeMetal.golpear(metal);

		assertEquals(durabilidad.subtract(new BigDecimal(5)) , hachaDeMetal.getDurabilidad());
	}

	@Test
	public void dadaUnHachaDeMetal_CuandoSeUsaUnaVezContraDiamante_DeberiaDisminuirLaDurabilidadEn5() throws MaterialDestruidoNoSePuedeGolpearException {

		Herramienta hachaDeMetal = HerramientaFactory.newHachaDeMetal();
		Material diamante = new Diamante();

		BigDecimal durabilidad = hachaDeMetal.getDurabilidad();

		hachaDeMetal.golpear(diamante);

		assertEquals(durabilidad.subtract(new BigDecimal(5)), hachaDeMetal.getDurabilidad());
	}

/*	//Pruebas Pico de metal
	@Test
	public void dadoUnPicoDeMetal_CuandoSeCrea_DeberiaTenerDurabilidad400YFuerza12() {
		Herramienta pico = new Pico(new MetalHerramienta());
		assertTrue(pico.getDurabilidad()==400);
		assertTrue(pico.getFuerza()==12);
	}

	//Pruebas Pico fino
	@Test
	public void dadoUnPicoFino_CuandoSeCrea_DeberiaTenerDurabilidad1000YFuerza20() {
		Herramienta picoFino = new PicoFino(new MetalHerramienta());
		assertTrue(picoFino.getDurabilidad()==1000);
		assertTrue(picoFino.getFuerza()==20);
	}
*/
}
