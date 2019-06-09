package fiuba.algo3.tp2.integracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.terreno.Posicion;

public class JuegoTest {
	
	@Test
	public void cuandoSeCreaUnJuego_DeberiaCrearseUnTerrenoConteniendoUnJugadorEnLaPosicionColumna1YFila1() 
			throws Exception {
		
		Juego juego = Juego.getInstance();
		
		assertTrue(new Posicion(1,1).esIgualA(juego.obtenerJugador().obtenerPosicion()));
	}
	
	@Test
	public void cuandoSeCreaUnJuego_DeberiaCrearseMaderaEnLasPosicionesCorrespondientes() 
			throws Exception {
		
		Juego juego = Juego.getInstance();
		
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(3, 3)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(4, 3)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(5, 3)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(6, 3)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(7, 3)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(8, 3)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(3, 4)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(4, 4)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(5, 4)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(6, 4)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(7, 4)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(8, 4)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(3, 5)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(4, 5)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(5, 5)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(6, 5)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(7, 5)).getClass());
		assertEquals(Madera.class, juego.obtenerPosicionable(new Posicion(8, 5)).getClass());
	}
}
