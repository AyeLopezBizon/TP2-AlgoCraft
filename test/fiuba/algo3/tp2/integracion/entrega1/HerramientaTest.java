package fiuba.algo3.tp2.integracion.entrega1;

import fiuba.algo3.tp2.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class HerramientaTest {

	@Test
	public void dadaUnHachaDeMadera_CuandoSeCrea_DeberiaTenerDurabilidad100YFuerza2() {
		Herramienta hacha = new Hacha(new Madera());
		assertTrue(hacha.getDurabilidad()==100);
		assertTrue(hacha.getFuerza()==2);
	}
	
	@Test
	public void dadoUnPicoDeMadera_CuandoSeCrea_DeberiaTenerDurabilidad100YFuerza2() {
		Herramienta pico = new Pico(new Madera());
		assertTrue(pico.getDurabilidad()==100);
		assertTrue(pico.getFuerza()==2);
	}
	
	@Test
	public void dadaUnHachaDeMetal_CuandoSeCrea_DeberiaTenerDurabilidad400YFuerza10() {
		Herramienta hacha = new Hacha(new Metal());
		assertTrue(hacha.getDurabilidad()==400);
		assertTrue(hacha.getFuerza()==10);
	}
	
	@Test
	public void dadoUnPicoDeMetal_CuandoSeCrea_DeberiaTenerDurabilidad400YFuerza12() {
		Herramienta pico = new Pico(new Metal());
		assertTrue(pico.getDurabilidad()==400);
		assertTrue(pico.getFuerza()==12);
	}
	
	@Test
	public void dadoUnPicoFino_CuandoSeCrea_DeberiaTenerDurabilidad1000YFuerza20() {
		Herramienta picoFino = new PicoFino(new Metal()); //paquie aca
		assertTrue(picoFino.getDurabilidad()==1000);
		assertTrue(picoFino.getFuerza()==20);
	}
}
