package fiuba.algo3.tp2.matriz.casillero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public class CasilleroTest {

	@Test
	public void cuandoSeCreaUnCasilleroConPosicionNumeroFila3YNumeroColumna5_DeberiaTenerEsaPosicion() {
		
		Posicion posicion = new Posicion(5, 3);
		Casillero<Posicionable> casillero = new Casillero<Posicionable>(posicion);
		
		assertTrue(casillero.tienePosicion(new Posicion(5, 3)));
	}
	
	@Test
	public void cuandoSeCreaUnCasilleroConPosicionNumeroFila3YNumeroColumna5_NoDeberiaTenerLaPosicionNumeroFila4YNumeroColumna6() {
		
		Posicion posicion = new Posicion(5, 3);
		Casillero<Posicionable> casillero = new Casillero<Posicionable>(posicion);
		
		assertFalse(casillero.tienePosicion(new Posicion(6, 4)));
	}
	
	@Test
	public void cuandoSeCreaUnCasillero_DeberiaContenerUnPosicionableVacio() 
			throws Exception {
		
		Posicion posicion = new Posicion(5, 3);
		Casillero<Posicionable> casillero = new Casillero<Posicionable>(posicion);
		
		try {
			casillero.obtenerValor().getClass();
			fail("Deberia lanzar CasilleroVacioException");
		}catch(Exception e){
			assertEquals(CasilleroVacioException.class, e.getClass());
		}
	}
	
	@Test
	public void cuandoSeOcupaUnCasilleroVacioConUnJugador_DeberiaContenerEseJugador() 
			throws Exception {
		
		Posicion posicion = new Posicion(5, 3);
		Casillero<Posicionable> casillero = new Casillero<Posicionable>(posicion);
		Posicionable jugador = new Jugador();
		
		casillero.ocuparCasillero(jugador);
		
		assertEquals(jugador, casillero.obtenerValor());
	}
	
	@Test
	public void cuandoSeOcupaUnCasilleroOcupado_DeberiaLanzarCasilleroOcupadoException() 
			throws Exception {
		
		Posicion posicion = new Posicion(5, 3);
		Casillero<Posicionable> casillero = new Casillero<Posicionable>(posicion);
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
	public void cuandoSeDesocupaUnCasilleroOcupado_DeberiaPasarAContenerUnPosicionableVacio() throws Exception {

		Posicion posicion = new Posicion(5, 5);
		Casillero<Posicionable> casillero = new Casillero<Posicionable>(posicion);
		Posicionable jugador = new Jugador();

		casillero.ocuparCasillero(jugador);
		casillero.desocuparCasillero();
		
		try {
			casillero.desocuparCasillero();
			fail("Deberia lanzar CasilleroVacioException");
		}catch(Exception e){
			assertEquals(CasilleroVacioException.class, e.getClass());
		}
		
	}
}