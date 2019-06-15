package fiuba.algo3.tp2.terreno;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;

public class TerrenoTest {

	@Test
	public void dadoUnTerrenoDe100ColumnasY200Filas_CuandoSePosicionaUnJugadorEnLaPosicionColumna1YFila1_ElCasilleroDeEsaPosicionDeberiaContenerElJugador() 
			throws Exception {
		
		Terreno terreno = new Terreno(100, 200);
		OcupanteTerreno jugador = new Jugador();
		Posicion posicion = new Posicion(1,1);
		
		terreno.ocuparCasillero(jugador, posicion);
		
		assertEquals(jugador, terreno.obtenerOcupanteTerreno(new Posicion(1,1)));
	}
	
	@Test
	public void dadoUnTerrenoDe100ColumnasY200Filas_CuandoSePosicionaUnJugadorEnLaPosicionColumna100YFila200_ElCasilleroDeEsaPosicionDeberiaContenerElJugador() 
			throws Exception {
		
		Terreno terreno = new Terreno(100, 200);
		OcupanteTerreno jugador = new Jugador();
		Posicion posicion = new Posicion(100,200);
		
		terreno.ocuparCasillero(jugador, posicion);
		
		assertEquals(jugador, terreno.obtenerOcupanteTerreno(new Posicion(100,200)));
	}
	
	@Test
	public void dadoUnTerrenoDe100ColumnasY200Filas_CuandoSePosicionaUnJugadorEnLaPosicionColumna1YFila200_ElCasilleroDeEsaPosicionDeberiaContenerElJugador() 
			throws Exception {
		
		Terreno terreno = new Terreno(100, 200);
		OcupanteTerreno jugador = new Jugador();
		Posicion posicion = new Posicion(1,200);
		
		terreno.ocuparCasillero(jugador, posicion);
		
		assertEquals(jugador, terreno.obtenerOcupanteTerreno(new Posicion(1,200)));
	}
	
	@Test
	public void dadoUnTerrenoDe100ColumnasY200Filas_CuandoSePosicionaUnJugadorEnLaPosicionColumna100YFila1_ElCasilleroDeEsaPosicionDeberiaContenerElJugador() 
			throws Exception {
		
		Terreno terreno = new Terreno(100, 200);
		OcupanteTerreno jugador = new Jugador();
		Posicion posicion = new Posicion(100,1);
		
		terreno.ocuparCasillero(jugador, posicion);
		
		assertEquals(jugador, terreno.obtenerOcupanteTerreno(new Posicion(100,1)));
	}
	
	@Test
	public void dadoUnTerrenoDe100ColumnasY200Filas_CuandoSePosicionaUnJugadorEnLaPosicionColumna0YFila1_DeberiaLanzarCasilleroNoEncontradoException() 
			throws Exception {
		
		Terreno terreno = new Terreno(100, 200);
		OcupanteTerreno jugador = new Jugador();
		Posicion posicion = new Posicion(0,1);
		
		try {
			terreno.ocuparCasillero(jugador, posicion);
			fail("Deberia lanzar CasilleroNoEncontradoException");
		}catch(Exception exception) {
			assertEquals(CasilleroNoEncontradoException.class, exception.getClass());
		}
	}
	
	@Test
	public void dadoUnTerrenoDe100ColumnasY200Filas_CuandoSePosicionaUnJugadorEnLaPosicionColumna101YFila200_DeberiaLanzarCasilleroNoEncontradoException() 
			throws Exception {
		
		Terreno terreno = new Terreno(100, 200);
		OcupanteTerreno jugador = new Jugador();
		Posicion posicion = new Posicion(101,200);
		
		try {
			terreno.ocuparCasillero(jugador, posicion);
			fail("Deberia lanzar CasilleroNoEncontradoException");
		}catch(Exception exception) {
			assertEquals(CasilleroNoEncontradoException.class, exception.getClass());
		}
	}
	
	@Test
	public void dadoUnTerrenoDe100ColumnasY200Filas_CuandoSePosicionaUnJugadorEnLaPosicionColumna1YFila201_DeberiaLanzarCasilleroNoEncontradoException() 
			throws Exception {
		
		Terreno terreno = new Terreno(100, 200);
		OcupanteTerreno jugador = new Jugador();
		Posicion posicion = new Posicion(1,201);
		
		try {
			terreno.ocuparCasillero(jugador, posicion);
			fail("Deberia lanzar CasilleroNoEncontradoException");
		}catch(Exception exception) {
			assertEquals(CasilleroNoEncontradoException.class, exception.getClass());
		}
	}
	
	@Test
	public void dadoUnTerrenoDe100ColumnasY200Filas_CuandoSePosicionaUnJugadorEnLaPosicionColumna101YFila1_DeberiaLanzarCasilleroNoEncontradoException() 
			throws Exception {
		
		Terreno terreno = new Terreno(100, 200);
		OcupanteTerreno jugador = new Jugador();
		Posicion posicion = new Posicion(101,1);
		
		try {
			terreno.ocuparCasillero(jugador, posicion);
			fail("Deberia lanzar CasilleroNoEncontradoException");
		}catch(Exception exception) {
			assertEquals(CasilleroNoEncontradoException.class, exception.getClass());
		}
	}
}
