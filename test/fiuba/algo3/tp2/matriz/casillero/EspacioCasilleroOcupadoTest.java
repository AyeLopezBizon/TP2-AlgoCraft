package fiuba.algo3.tp2.matriz.casillero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public class EspacioCasilleroOcupadoTest {
	
	@Test
	public void dadoUnEspacioCasilleroOcupadoConUnJugador_CuandoSeObtieneElContenidoDelEspacio_DeberiaDevolverElJugador() {
		
		Posicionable jugador = new Jugador();
		EspacioCasillero espacio = new EspacioCasilleroOcupado(jugador);
		
		assertEquals(jugador, espacio.obtenerPosicionable());
	}
	
	@Test
	public void cuandoSeOcupaUnEspacioCasilleroOcupado_DeberiaLanzarCasilleroOcupadoException() {
		
		Posicionable jugador = new Jugador();
		EspacioCasillero espacio = new EspacioCasilleroOcupado(jugador);
		
		Posicionable madera = new Madera();
		try {
			espacio.ocupar(madera);
			fail("Deberia lanzar CasilleroOcupadoException");
		} catch(Exception exception) {
			assertEquals(CasilleroOcupadoException.class, exception.getClass());
		}
	}
}
