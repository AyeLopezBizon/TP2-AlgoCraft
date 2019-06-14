package fiuba.algo3.tp2.matriz.casillero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Vacio;
import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;
import fiuba.algo3.tp2.jugador.Jugador;

public class CasilleroTest {

	@Test
	public void cuandoSeCreaUnCasilleroConPosicionNumeroFila3YNumeroColumna5_DeberiaTenerEsaPosicion() {
		
		Posicion posicion = new Posicion(5, 3);
		Casillero casillero = new Casillero(posicion);
		
		assertTrue(casillero.tienePosicion(new Posicion(5, 3)));
	}
	
	@Test
	public void cuandoSeCreaUnCasilleroConPosicionNumeroFila3YNumeroColumna5_NoDeberiaTenerLaPosicionNumeroFila4YNumeroColumna6() {
		
		Posicion posicion = new Posicion(5, 3);
		Casillero casillero = new Casillero(posicion);
		
		assertFalse(casillero.tienePosicion(new Posicion(6, 4)));
	}
	
	@Test
	public void cuandoSeCreaUnCasillero_DeberiaContenerUnPosicionableVacio() 
			throws Exception {
		
		Posicion posicion = new Posicion(5, 3);
		Casillero casillero = new Casillero(posicion);
		
		assertEquals(Vacio.class, casillero.obtenerPosicionable().getClass());
	}
	
	@Test
	public void cuandoSeOcupaUnCasilleroVacioConUnJugador_DeberiaContenerEseJugador() 
			throws Exception {
		
		Posicion posicion = new Posicion(5, 3);
		Casillero casillero = new Casillero(posicion);
		Posicionable jugador = new Jugador();
		
		casillero.ocuparCasillero(jugador);
		
		assertEquals(jugador, casillero.obtenerPosicionable());
	}
	
	@Test
	public void cuandoSeOcupaUnCasilleroOcupado_DeberiaLanzarCasilleroOcupadoException() 
			throws Exception {
		
		Posicion posicion = new Posicion(5, 3);
		Casillero casillero = new Casillero(posicion);
		Posicionable jugador = new Jugador();
		
		casillero.ocuparCasillero(jugador);
		
		Posicionable madera = new Madera();
		
		try {
			casillero.ocuparCasillero(madera);
			fail("Deberia lanzar CasilleroOcupadoException");
		} catch(Exception exception) {
			assertEquals(CasilleroOcupadoException.class, exception.getClass());
		}
	}

	@Test
	public void cuandoSeDesocupaUnCasilleroOcupado_DeberiaPasarAContenerUnPosicionableVacio() throws CasilleroOcupadoException {

		Posicion posicion = new Posicion(5, 5);
		Casillero casillero = new Casillero(posicion);
		Posicionable jugador = new Jugador();

		casillero.ocuparCasillero(jugador);
		casillero.desocuparCasillero();

		assertEquals(Vacio.class, casillero.obtenerPosicionable().getClass());
	}
}