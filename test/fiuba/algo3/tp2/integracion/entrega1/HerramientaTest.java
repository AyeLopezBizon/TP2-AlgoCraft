package fiuba.algo3.tp2.integracion.entrega1;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import fiuba.algo3.tp2.herramienta.*;
import fiuba.algo3.tp2.material.*;

public class HerramientaTest {

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
		assertEquals(pico.getFuerza(),new BigDecimal(2));
	}

	@Test 
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraMaderaCubo_DeberiaDisminuirLaDurabilidadEn2()
	throws Exception{
		
		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		Material maderaCubo = new Madera();

		BigDecimal durabilidad = pico.getDurabilidad();
		
		pico.golpear(maderaCubo);		
		
		assertEquals(pico.getDurabilidad(), durabilidad.subtract(new BigDecimal(2)));
	}

	@Test
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraPiedraCubo_DeberiaDisminuirLaDurabilidadEn2()
	throws Exception{

		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		Material piedra = new Piedra();
		BigDecimal durabilidad = pico.getDurabilidad();
		
		pico.golpear(piedra);
		
		assertEquals(pico.getDurabilidad(), durabilidad.subtract(new BigDecimal(2)));
	}

	@Test
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraMetalCubo_DeberiaDisminuirLaDurabilidadEn2()
	throws Exception{

		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		Material metal = new Metal();
		BigDecimal durabilidad = pico.getDurabilidad();

		pico.golpear(metal);
		
		assertEquals(pico.getDurabilidad(), durabilidad.subtract(new BigDecimal(2)));

	}

	@Test
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraDiamanteCubo_DeberiaDisminuirLaDurabilidadEn2()
	throws Exception{

		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		Material diamante = new Diamante();
		BigDecimal durabilidad = pico.getDurabilidad();

		pico.golpear(diamante);

		assertEquals(pico.getDurabilidad(), durabilidad.subtract(new BigDecimal(2)));

	}

	//Pruebas Hacha de piedra
	@Test
	public void dadaUnHachaDePiedra_CuandoSeCrea_DeberiaTenerDurabilidad200YFuerza5() {
		Herramienta hacha = HerramientaFactory.newHachaDePiedra();
		assertEquals(hacha.getDurabilidad(),new BigDecimal(200));
		assertEquals(hacha.getFuerza(),new BigDecimal(5));
	}

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

	//Pruebas Pico de piedra
	@Test
	public void dadoUnPicoDePiedra_CuandoSeCrea_DeberiaTenerDurabilidad200YFuerza4(){
		Herramienta pico = HerramientaFactory.newPicoDePiedra();
		assertEquals(pico.getDurabilidad().floatValue(),200, 0);
		assertEquals(pico.getFuerza(), new BigDecimal(4));
	}
	
/*
	@Test
	public void dadoUnPicodePiedra_CuandoSeUsaUnaVezContraMaderaCubo_DeberiaDesminuirlaDurabilidadEn2Coma6()
	throws Exception{
		Herramienta pico = HerramientaFactory.newPicoDePiedra();
		Material madera = new Madera();

		BigDecimal durabilidad = pico.getDurabilidad();

		pico.golpear(madera);
		
		assertEquals(pico.getDurabilidad(), new BigDecimal(197.3334));

	}
*/
	
	//Pruebas Hacha de metal
	@Test
	public void dadaUnHachaDeMetal_CuandoSeCrea_DeberiaTenerDurabilidad400YFuerza10() {
		Herramienta hacha = HerramientaFactory.newHachaDeMetal();
		assertEquals(hacha.getDurabilidad(),new BigDecimal(400));
		assertEquals(hacha.getFuerza(), new BigDecimal(10));
	}

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
/*
	//Pruebas Pico de metal
	@Test
	public void dadoUnPicoDeMetal_CuandoSeCrea_DeberiaTenerDurabilidad400YFuerza12() {
		Herramienta pico = HerramientaFactory.newPicoDeMetal();
		assertEquals(pico.getDurabilidad(), new BigDecimal(400));
		assertEquals(pico.getFuerza(), new BigDecimal(12));
	}

	//Pruebas Pico fino
	@Test
	public void dadoUnPicoFino_CuandoSeCrea_DeberiaTenerDurabilidad1000YFuerza20() {
		Herramienta picoFino = HerramientaFactory.newPicoDePiedra();
		assertEquals(picoFino.getDurabilidad(), new BigDecimal(1000));
		assertEquals(picoFino.getFuerza(), new BigDecimal(20));
	}
*/
}
