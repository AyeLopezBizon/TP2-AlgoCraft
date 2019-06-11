package fiuba.algo3.tp2.herramienta.juego;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.NoSePudoInicializarJuegoException;
import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.terreno.Terreno;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JuegoTest {

	@Test
	public void AlObtenerJugadorDeJuego_DevuelveUnJugador() throws NoSePudoInicializarJuegoException {

		Juego juego = new Juego();

		assertEquals(Jugador.class, juego.obtenerJugador().getClass());
	}

	@Test
	public void AlObtenerTerrenoDeJuego_DevuelveUnTerreno() throws NoSePudoInicializarJuegoException {

		Juego juego = new Juego();

		assertEquals(Terreno.class, juego.obtenerTerreno().getClass());
	}
}
