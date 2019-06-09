package fiuba.algo3.tp2.integracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.terreno.Posicion;
import fiuba.algo3.tp2.terreno.Posicionable;
import fiuba.algo3.tp2.terreno.Terreno;
import fiuba.algo3.tp2.terreno.casillero.CasilleroOcupadoException;

public class TerrenoTest {
	/*
	@Test
	public void cuandoSeOcupaUnCasilleroVacioConUnJugador_AlObtenerElPosicionableDelCasilleroDeberiaDevolverElJugador() {
		
		Terreno terreno = new Terreno(100, 200);
		Posicionable jugador = new Jugador();
		Posicion posicion = new Posicion(5, 3);
		
		terreno.ocuparCasillero(jugador, posicion);
		Posicionable posicionableEnCasillero = terreno.getCasillero(posicion).getPosicionable();
		
		assertEquals(jugador, posicionableEnCasillero);
	}
	
	@Test
	public void cuandoSeOcupaUnCasilleroVacioConUnaMadera_AlObtenerElPosicionableDelCasilleroDeberiaDevolverLaMadera() {
		
		Terreno terreno = new Terreno(100, 200);
		Posicionable madera = new Madera();
		Posicion posicion = new Posicion(5, 3);
		
		terreno.ocuparCasillero(madera, posicion);
		Posicionable posicionableEnCasillero = terreno.getCasillero(posicion).getPosicionable();
		
		assertEquals(madera, posicionableEnCasillero);
	}
	
	@Test
	public void dadoUnCasilleroOcupadoConUnJugador_CuandoSeOcupaElMismoCasilleroConUnaMadera_DeberiaLanzarCasilleroOcupadoException() {
		
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
	public void dadoUnCasilleroOcupadoConUnaMadera_CuandoSeOcupaElMismoCasilleroConUnJugador_DeberiaLanzarCasilleroOcupadoException() {
		
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
	*/
}
