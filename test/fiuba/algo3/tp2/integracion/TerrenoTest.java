package fiuba.algo3.tp2.integracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;
import fiuba.algo3.tp2.terreno.Terreno;
import fiuba.algo3.tp2.terreno.OcupanteTerreno;

public class TerrenoTest {
	
	@Test
	public void cuandoSeOcupaUnCasilleroVacioConUnJugador_AlObtenerElPosicionableDelCasilleroDeberiaDevolverElJugador() 
			throws Exception {
		
		Terreno terreno = new Terreno(100, 200);
		OcupanteTerreno jugador = new Jugador();
		Posicion posicion = new Posicion(5, 3);
		
		terreno.ocuparCasillero(jugador, posicion);
		Posicionable posicionableEnCasillero = 
				terreno.obtenerPosicionable(posicion);
		
		assertEquals(jugador, posicionableEnCasillero);
	}
	
	@Test
	public void cuandoSeOcupaUnCasilleroVacioConUnaMadera_AlObtenerElPosicionableDelCasilleroDeberiaDevolverLaMadera() 
			throws Exception {
		
		Terreno terreno = new Terreno(100, 200);
		OcupanteTerreno madera = new Madera();
		Posicion posicion = new Posicion(5, 3);
		
		terreno.ocuparCasillero(madera, posicion);
		Posicionable posicionableEnCasillero = 
				terreno.obtenerPosicionable(posicion);
		
		assertEquals(madera, posicionableEnCasillero);
	}
	
	@Test
	public void dadoUnCasilleroOcupadoConUnJugador_CuandoSeOcupaElMismoCasilleroConUnaMadera_DeberiaLanzarCasilleroOcupadoException() 
			throws Exception {
		
		Terreno terreno = new Terreno(100, 200);
		OcupanteTerreno jugador = new Jugador();
		Posicion posicion = new Posicion(5, 3);
		
		terreno.ocuparCasillero(jugador, posicion);
		
		OcupanteTerreno madera = new Madera();
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
		OcupanteTerreno madera = new Madera();
		Posicion posicion = new Posicion(5, 3);
		
		terreno.ocuparCasillero(madera, posicion);
		
		OcupanteTerreno jugador = new Jugador();
		try {
			terreno.ocuparCasillero(jugador, posicion);
			fail("Deberia lanzar CasilleroOcupadoException");
		} catch(Exception exception) {
			assertEquals(CasilleroOcupadoException.class, exception.getClass());
		}
	}

	@Test
	public void dadoUnCasilleroOcupadoConUnJugador_CuandoSeDesocupaElCasillero_ElCasilleroDeberiaContenerUnPosicionableVacio()
			throws Exception {

		Terreno terreno = new Terreno(100, 100);
		Posicion posicion = new Posicion(5, 5);
		OcupanteTerreno jugador = new Jugador();

		terreno.ocuparCasillero(jugador, posicion);
		terreno.desocuparCasillero(posicion);
		
		try {
			terreno.obtenerPosicionable(posicion);
			fail("Deberia lanzar CasilleroVacioException");
		}catch(Exception e) {
			assertEquals(CasilleroVacioException.class, e.getClass());
		}

		
	}
}