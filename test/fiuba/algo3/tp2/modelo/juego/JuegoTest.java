package fiuba.algo3.tp2.modelo.juego;

import fiuba.algo3.tp2.modelo.juego.Juego;
import fiuba.algo3.tp2.modelo.juego.NoSePudoInicializarJuegoException;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.terreno.Terreno;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JuegoTest {

	@Test
	public void AlObtenerJugadorDeJuego_DevuelveUnJugador() throws Exception {

		Juego juego = new Juego();
		juego.inicializar();

		assertEquals(Jugador.class, juego.obtenerJugador().getClass());
	}

	@Test
	public void AlObtenerTerrenoDeJuego_DevuelveUnTerreno() throws Exception {

		Juego juego = new Juego();
		juego.inicializar();

		assertEquals(Terreno.class, juego.obtenerTerreno().getClass());
	}
}
