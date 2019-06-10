package fiuba.algo3.tp2.integracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import fiuba.algo3.tp2.terreno.PosicionableVacio;
import fiuba.algo3.tp2.terreno.casillero.CasilleroNoEncontradoException;
import org.junit.Test;

import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.terreno.Posicion;
import fiuba.algo3.tp2.terreno.Posicionable;
import fiuba.algo3.tp2.terreno.Terreno;
import fiuba.algo3.tp2.terreno.casillero.CasilleroOcupadoException;

public class TerrenoTest {
	
	@Test
	public void cuandoSeOcupaUnCasilleroVacioConUnJugador_AlObtenerElPosicionableDelCasilleroDeberiaDevolverElJugador() 
			throws Exception {
		
		Terreno terreno = new Terreno(100, 200);
		Posicionable jugador = new Jugador();
		Posicion posicion = new Posicion(5, 3);
		
		terreno.ocuparCasillero(jugador, posicion);
		Posicionable posicionableEnCasillero = 
				terreno.obtenerCasillero(posicion).obtenerPosicionable();
		
		assertEquals(jugador, posicionableEnCasillero);
	}
	
	@Test
	public void cuandoSeOcupaUnCasilleroVacioConUnaMadera_AlObtenerElPosicionableDelCasilleroDeberiaDevolverLaMadera() 
			throws Exception {
		
		Terreno terreno = new Terreno(100, 200);
		Posicionable madera = new Madera();
		Posicion posicion = new Posicion(5, 3);
		
		terreno.ocuparCasillero(madera, posicion);
		Posicionable posicionableEnCasillero = 
				terreno.obtenerCasillero(posicion).obtenerPosicionable();
		
		assertEquals(madera, posicionableEnCasillero);
	}
	
	@Test
	public void dadoUnCasilleroOcupadoConUnJugador_CuandoSeOcupaElMismoCasilleroConUnaMadera_DeberiaLanzarCasilleroOcupadoException() 
			throws Exception {
		
		Terreno terreno = new Terreno(100, 200);
		Posicionable jugador = new Jugador();
		Posicion posicion = new Posicion(5, 3);
		
		terreno.ocuparCasillero(jugador, posicion);
		
		Posicionable madera = new Madera();
		try {
			terreno.ocuparCasillero(madera, posicion);
			fail("Deberia lanzar CasilleroOcupadoException");
		} catch(Exception exception) {
			assertEquals(CasilleroOcupadoException.class, exception.getClass());
		}
	}
	
	@Test
	public void dadoUnCasilleroOcupadoConUnaMadera_CuandoSeOcupaElMismoCasilleroConUnJugador_DeberiaLanzarCasilleroOcupadoException() 
			throws Exception {
		
		Terreno terreno = new Terreno(100, 200);
		Posicionable madera = new Madera();
		Posicion posicion = new Posicion(5, 3);
		
		terreno.ocuparCasillero(madera, posicion);
		
		Posicionable jugador = new Jugador();
		try {
			terreno.ocuparCasillero(jugador, posicion);
			fail("Deberia lanzar CasilleroOcupadoException");
		} catch(Exception exception) {
			assertEquals(CasilleroOcupadoException.class, exception.getClass());
		}
	}

	@Test
	public void dadoUnCasilleroOcupadoConUnJugador_CuandoSeDesocupaElCasillero_ElCasilleroDeberiaContenerUnPosicionableVacio()
			throws CasilleroOcupadoException, CasilleroNoEncontradoException {

		Terreno terreno = new Terreno(100, 100);
		Posicion posicion = new Posicion(5, 5);
		Posicionable jugador = new Jugador();

		terreno.ocuparCasillero(jugador, posicion);
		terreno.desocuparCasillero(posicion);
		Posicionable posicionableEnCasillero = terreno.obtenerCasillero(posicion).obtenerPosicionable();

		assertEquals(PosicionableVacio.class, posicionableEnCasillero.getClass());
	}
}