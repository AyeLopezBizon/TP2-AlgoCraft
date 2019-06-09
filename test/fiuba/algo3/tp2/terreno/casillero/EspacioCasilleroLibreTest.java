package fiuba.algo3.tp2.terreno.casillero;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.terreno.Posicionable;
import fiuba.algo3.tp2.terreno.PosicionableVacio;

public class EspacioCasilleroLibreTest {

	@Test
	public void dadoUnEspacioCasilleroLibre_CuandoSeObtieneElContenidoDelEspacio_DeberiaDevolverPosicionableVacio() {
		
		EspacioCasillero espacio = new EspacioCasilleroLibre();
		
		assertEquals(PosicionableVacio.class, espacio.obtenerPosicionable().getClass());
	}
	
	@Test
	public void dadoUnEspacioCasilleroLibre_CuandoSeOcupaElEspacioConUnJugador_DeberiaDevolverUnEspacioOcupadoQueContengaElJugador() 
			throws Exception {
		
		EspacioCasillero espacio = new EspacioCasilleroLibre();
		Posicionable jugador = new Jugador();
		
		EspacioCasillero espacioOcupado = espacio.ocupar(jugador);
		
		assertEquals(jugador, espacioOcupado.obtenerPosicionable());
	}
}
