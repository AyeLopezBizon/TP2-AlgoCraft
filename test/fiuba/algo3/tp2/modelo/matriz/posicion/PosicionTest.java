package fiuba.algo3.tp2.modelo.matriz.posicion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;

public class PosicionTest {
	
	@Test
	public void cuandoSeComparan2PosicionesConMismoNumeroDeFilaYMismoNumeroDeColumna_DeberianSerIguales() {
		
		Posicion unaPosicion = new Posicion(5, 3);
		Posicion otraPosicion = new Posicion(5, 3);
		
		assertTrue(unaPosicion.esIgualA(otraPosicion));
	}
	
	@Test
	public void cuandoSeComparan2PosicionesConDiferenteNumeroDeFilaYMismoNumeroDeColumna_NoDeberianSerIguales() {
		
		Posicion unaPosicion = new Posicion(5, 2);
		Posicion otraPosicion = new Posicion(5, 3);
		
		assertFalse(unaPosicion.esIgualA(otraPosicion));
	}

	@Test
	public void cuandoSeComparan2PosicionesConMismoNumeroDeFilaYDiferenteNumeroDeColumna_NoDeberianSerIguales() {
		
		Posicion unaPosicion = new Posicion(5, 3);
		Posicion otraPosicion = new Posicion(4, 3);
		
		assertFalse(unaPosicion.esIgualA(otraPosicion));
	}
	
	@Test
	public void cuandoSeComparan2PosicionesConDiferenteNumeroDeFilaYDiferenteNumeroDeColumna_NoDeberianSerIguales() {
		
		Posicion unaPosicion = new Posicion(5, 2);
		Posicion otraPosicion = new Posicion(4, 3);
		
		assertFalse(unaPosicion.esIgualA(otraPosicion));
	}
	
	@Test
	public void dadaUnaPosicionConNumeroDeFila4YNumeroDeColumna10_LaPosicionDeberiaPertenecerALaFila4() {
		
		Posicion posicion = new Posicion(10, 4);
		
		assertTrue(posicion.perteneceAFila(4));
	}
	
	@Test
	public void dadaUnaPosicionConNumeroDeFila4YNumeroDeColumna10_LaPosicionNoDeberiaPertenecerALaFila5() {
		
		Posicion posicion = new Posicion(10, 4);

		assertFalse(posicion.perteneceAFila(5));
	}

	@Test
	public void dadaUnaPosicionConNumeroDeFila10YNumeroDeColumna10_DeberiaTenerNumeroDeFila10YColumna11LuegoDeAvanzarColumna() {

		Posicion posicion = new Posicion(10, 10);
		Posicion posicionEsperada = new Posicion(11, 10);

		posicion = posicion.avanzarColumna();

		assertTrue(posicionEsperada.esIgualA(posicion));
	}

	@Test
	public void dadaUnaPosicionConNumeroDeFila10YNumeroDeColumna10_DeberiaTenerNumeroDeFila10YColumna9LuegoDeRetrocederColumna() {

		Posicion posicion = new Posicion(10, 10);
		Posicion posicionEsperada = new Posicion(9, 10);

		posicion = posicion.retrocederColumna();

		assertTrue(posicionEsperada.esIgualA(posicion));
	}

	@Test
	public void dadaUnaPosicionConNumeroDeFila10YNumeroDeColumna10_DeberiaTenerNumeroDeFila11YColumna10LuegoDeAvanzarFila() {

		Posicion posicion = new Posicion(10, 10);
		Posicion posicionEsperada = new Posicion(10, 11);

		posicion = posicion.avanzarFila();

		assertTrue(posicionEsperada.esIgualA(posicion));
	}

	@Test
	public void dadaUnaPosicionConNumeroDeFila10YNumeroDeColumna10_DeberiaTenerNumeroDeFila9YColumna10LuegoDeRetrocederFila() {

		Posicion posicion = new Posicion(10, 10);
		Posicion posicionEsperada = new Posicion(10, 9);

		posicion = posicion.retrocederFila();

		assertTrue(posicionEsperada.esIgualA(posicion));
	}
}
