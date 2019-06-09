package fiuba.algo3.tp2.terreno;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
		
		assertTrue(posicion.perteneceAFila(5));
	}
}
