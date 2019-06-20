package fiuba.algo3.tp2.modelo.matriz.casillero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicionable;

public class EspacioCasilleroLibreTest {

	@Test
	public void dadoUnEspacioCasilleroLibre_CuandoSeObtieneElContenidoDelEspacio_DeberiaDevolverPosicionableVacio() {
		
		EspacioCasillero<Posicionable> espacio = new EspacioCasilleroLibre<Posicionable>();
		
		try {
			espacio.obtenerValor();
			fail("Deberia lanzar CasilleroVacioException");
		}catch(Exception e) {
			assertEquals(CasilleroVacioException.class, e.getClass());
		}
		
	}
	
	@Test
	public void dadoUnEspacioCasilleroLibre_CuandoSeOcupaElEspacioConUnJugador_DeberiaDevolverUnEspacioOcupadoQueContengaElJugador() 
			throws Exception {
		
		EspacioCasillero<Posicionable> espacio = new EspacioCasilleroLibre<Posicionable>();
		Posicionable jugador = new Jugador();
		
		EspacioCasillero<Posicionable> espacioOcupado = espacio.ocupar(jugador);
		
		assertEquals(jugador, espacioOcupado.obtenerValor());
	}
}
