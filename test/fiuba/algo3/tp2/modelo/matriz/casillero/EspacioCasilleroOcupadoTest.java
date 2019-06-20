package fiuba.algo3.tp2.modelo.matriz.casillero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.material.Madera;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicionable;

public class EspacioCasilleroOcupadoTest {
	
	@Test
	public void dadoUnEspacioCasilleroOcupadoConUnJugador_CuandoSeObtieneElContenidoDelEspacio_DeberiaDevolverElJugador() 
			throws Exception {
		
		Posicionable jugador = new Jugador();
		EspacioCasillero<Posicionable> espacio = new EspacioCasilleroOcupado<Posicionable>(jugador);
		
		assertEquals(jugador, espacio.obtenerValor());
	}
	
	@Test
	public void cuandoSeOcupaUnEspacioCasilleroOcupado_DeberiaLanzarCasilleroOcupadoException() throws Exception {
		
		Posicionable jugador = new Jugador();
		EspacioCasillero<Posicionable> espacio = new EspacioCasilleroOcupado<Posicionable>(jugador);
		
		Posicionable madera = new Madera();
		try {
			espacio.ocupar(madera);
			fail("Deberia lanzar CasilleroOcupadoException");
		} catch(Exception exception) {
			assertEquals(CasilleroOcupadoException.class, exception.getClass());
		}
	}
}
