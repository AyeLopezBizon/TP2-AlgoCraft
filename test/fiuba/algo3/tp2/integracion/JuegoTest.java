package fiuba.algo3.tp2.integracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;
import fiuba.algo3.tp2.matriz.posicion.Posicion;

public class JuegoTest {
	
	@Test
	public void cuandoSeCreaUnJuego_DeberiaCrearseUnTerrenoConteniendoUnJugadorEnLaPosicionColumna1YFila1() 
			throws Exception {
		
		Juego juego = new Juego();
		juego.inicializar();
		
		assertTrue(new Posicion(1,1).esIgualA(juego.obtenerJugador().obtenerPosicion()));
	}
	
	@Test
	public void cuandoSeCreaUnJuego_DeberiaCrearseMaderaEnLasPosicionesCorrespondientes() 
			throws Exception {
		
		Juego juego = new Juego();
		juego.inicializar();
		
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(3, 3)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(4, 3)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(5, 3)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(6, 3)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(7, 3)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(8, 3)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(3, 4)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(4, 4)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(5, 4)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(6, 4)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(7, 4)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(8, 4)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(3, 5)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(4, 5)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(5, 5)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(6, 5)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(7, 5)).getClass());
		assertEquals(Madera.class, juego.obtenerOcupanteTerreno(new Posicion(8, 5)).getClass());
	}
	
	@Test
	public void cuandoSeCreaUnJuego_DeberiaCrearsePiedraEnLasPosicionesCorrespondientes() 
			throws Exception {
		
		Juego juego = new Juego();
		juego.inicializar();
		
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(8, 8)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(9, 8)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(10, 8)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(11, 8)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(12, 8)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(8, 9)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(9, 9)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(10, 9)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(11, 9)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(12, 9)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(8, 10)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(9, 10)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(10, 10)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(11, 10)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(12, 10)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(8, 11)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(9, 11)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(10, 11)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(11, 11)).getClass());
		assertEquals(Piedra.class, juego.obtenerOcupanteTerreno(new Posicion(12, 11)).getClass());
	}
	
	@Test
	public void cuandoSeCreaUnJuego_DeberiaCrearseMetalEnLasPosicionesCorrespondientes() 
			throws Exception {
		
		Juego juego = new Juego();
		juego.inicializar();
		
		assertEquals(Metal.class, juego.obtenerOcupanteTerreno(new Posicion(2, 10)).getClass());
		assertEquals(Metal.class, juego.obtenerOcupanteTerreno(new Posicion(3, 10)).getClass());
		assertEquals(Metal.class, juego.obtenerOcupanteTerreno(new Posicion(2, 11)).getClass());
		assertEquals(Metal.class, juego.obtenerOcupanteTerreno(new Posicion(3, 11)).getClass());
		
		assertEquals(Metal.class, juego.obtenerOcupanteTerreno(new Posicion(15, 15)).getClass());
		assertEquals(Metal.class, juego.obtenerOcupanteTerreno(new Posicion(16, 15)).getClass());
		assertEquals(Metal.class, juego.obtenerOcupanteTerreno(new Posicion(15, 16)).getClass());
		assertEquals(Metal.class, juego.obtenerOcupanteTerreno(new Posicion(16, 16)).getClass());
	}
	
	@Test
	public void cuandoSeCreaUnJuego_DeberiaCrearseDiamanteEnLasPosicionesCorrespondientes() 
			throws Exception {
		
		Juego juego = new Juego();
		juego.inicializar();
		
		assertEquals(Diamante.class, juego.obtenerOcupanteTerreno(new Posicion(6, 16)).getClass());
		assertEquals(Diamante.class, juego.obtenerOcupanteTerreno(new Posicion(7, 16)).getClass());
		assertEquals(Diamante.class, juego.obtenerOcupanteTerreno(new Posicion(17, 5)).getClass());
	}
}
