package fiuba.algo3.tp2.modelo.matriz.casillero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.material.Madera;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicionable;

public class FilaCasilleroTest {
	
	@Test
	public void dadaUnaFilaCasilleroCon50Casilleros_CuandoSeOcupaElCasillero1ConUnJugador_ElCasilleroDeberiaContenerElJugador() 
			throws Exception {
		
		FilaCasillero<Posicionable> filaCasillero = new FilaCasillero<Posicionable>(1, 50);
		Posicionable jugador = new Jugador();
		
		filaCasillero.ocuparCasillero(jugador, new Posicion(1, 1));
		
		assertEquals(jugador, filaCasillero.obtenerCasillero(new Posicion(1, 1)).obtenerValor());
	}
	
	@Test
	public void dadaUnaFilaCasilleroCon50Casilleros_CuandoSeOcupaElCasillero50ConUnJugador_ElCasilleroDeberiaContenerElJugador() 
			throws Exception {
		
		FilaCasillero<Posicionable> filaCasillero = new FilaCasillero<Posicionable>(1, 50);
		Posicionable jugador = new Jugador();
		
		filaCasillero.ocuparCasillero(jugador, new Posicion(50, 1));
		
		assertEquals(jugador, filaCasillero.obtenerCasillero(new Posicion(50, 1)).obtenerValor());
	}

	@Test
	public void dadaUnaFilaCasilleroCon50Casilleros_CuandoSeOcupaElCasillero0ConUnJugador_DeberiaLanzarCasilleroNoEncontradoException() 
			throws Exception {
		
		FilaCasillero<Posicionable> filaCasillero = new FilaCasillero<Posicionable>(1, 50);
		Posicionable jugador = new Jugador();
		
		try {
			filaCasillero.ocuparCasillero(jugador, new Posicion(0, 1));
			fail("Deberia lanzar CasilleroNoEncontradoException");
		} catch(Exception exception) {
			assertEquals(CasilleroNoEncontradoException.class, exception.getClass());
		}
	}
	
	@Test
	public void dadaUnaFilaCasilleroCon50Casilleros_CuandoSeOcupaElCasillero51ConUnJugador_DeberiaLanzarCasilleroNoEncontradoException() 
			throws Exception {
		
		FilaCasillero<Posicionable> filaCasillero = new FilaCasillero<Posicionable>(1, 50);
		Posicionable jugador = new Jugador();
		
		try {
			filaCasillero.ocuparCasillero(jugador, new Posicion(51, 1));
			fail("Deberia lanzar CasilleroNoEncontradoException");
		} catch(Exception exception) {
			assertEquals(CasilleroNoEncontradoException.class, exception.getClass());
		}
	}
	
	@Test
	public void dadaUnaFilaCasilleroCon50CasillerosQueTieneOcupadoElCasillero1_CuandoSeOcupaElCasillero1ConUnJugador_DeberiaLanzarCasilleroOcupadoException() 
			throws Exception {
		
		FilaCasillero<Posicionable> filaCasillero = new FilaCasillero<Posicionable>(1, 50);
		Posicionable madera = new Madera();
		filaCasillero.ocuparCasillero(madera, new Posicion(1, 1));
		
		Posicionable jugador = new Jugador();
		
		try {
			filaCasillero.ocuparCasillero(jugador, new Posicion(1, 1));
			fail("Deberia lanzar CasilleroOcupadoException");
		}catch(Exception exception) {
			assertEquals(CasilleroOcupadoException.class, exception.getClass());
		}
		
	}
	
	@Test
	public void dadaUnaFilaCasilleroConNumeroFila1Con50Casilleros_DeberiaContenerElCasilleroConPosicionNumeroFila1YNumeroColumna1() {
		
		FilaCasillero<Posicionable> filaCasillero = new FilaCasillero<Posicionable>(1, 50);
		
		assertTrue(filaCasillero.contieneCasillero(new Posicion(1, 1)));
	}
	
	@Test
	public void dadaUnaFilaCasilleroConNumeroFila1Con50Casilleros_DeberiaContenerElCasilleroConPosicionNumeroFila1YNumeroColumna50() {
		
		FilaCasillero<Posicionable> filaCasillero = new FilaCasillero<Posicionable>(1, 50);
		
		assertTrue(filaCasillero.contieneCasillero(new Posicion(50, 1)));
	}
	
	@Test
	public void dadaUnaFilaCasilleroConNumeroFila1Con50Casilleros_NoDeberiaContenerElCasilleroConPosicionNumeroFila2YNumeroColumna1() {
		
		FilaCasillero<Posicionable> filaCasillero = new FilaCasillero<Posicionable>(1, 50);
		
		assertFalse(filaCasillero.contieneCasillero(new Posicion(1, 5)));
	}
	
	@Test
	public void dadaUnaFilaCasilleroConNumeroFila1Con50Casilleros_NoDeberiaContenerElCasilleroConPosicionNumeroFila1YNumeroColumna51() {
		
		FilaCasillero<Posicionable> filaCasillero = new FilaCasillero<Posicionable>(1, 50);
		
		assertFalse(filaCasillero.contieneCasillero(new Posicion(51, 1)));
	}

	@Test
	public void dadaUnaFilaCasilleroCon50Casilleros_CuandoSeDesocupaElCasillero1ConUnJugador_ElCasilleroDeberiaContenerUnPosicionableVacio()
			throws Exception {

		FilaCasillero<Posicionable> filaCasillero = new FilaCasillero<Posicionable>(1, 50);
		Posicion posicion = new Posicion(1,1);
		Posicionable jugador = new Jugador();

		filaCasillero.ocuparCasillero(jugador, posicion);
		filaCasillero.desocuparCasillero(posicion);
		
		try {
			filaCasillero.obtenerCasillero(posicion).obtenerValor();
		} catch(Exception e) {
			assertEquals(CasilleroVacioException.class, e.getClass());
		}
	}
}