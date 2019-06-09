package fiuba.algo3.tp2.juego;

import java.util.Arrays;
import java.util.Collection;

import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.terreno.Posicion;
import fiuba.algo3.tp2.terreno.Posicionable;
import fiuba.algo3.tp2.terreno.Terreno;
import fiuba.algo3.tp2.terreno.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.terreno.casillero.CasilleroOcupadoException;

public class Juego {
	
	private static final Integer CANTIDAD_COLUMNAS_TERRENO = 50;
	private static final Integer CANTIDAD_FILAS_TERRENO = 50;
	private static final Posicion POSICION_INICIAL_JUGADOR = new Posicion(1, 1);
	private static final Collection<Posicion> POSICIONES_INICIALES_MADERA = Arrays.asList(new Posicion[] {
			new Posicion(3, 3),
			new Posicion(4, 3),
			new Posicion(5, 3),
			new Posicion(6, 3),
			new Posicion(7, 3),
			new Posicion(8, 3),
			new Posicion(3, 4),
			new Posicion(4, 4),
			new Posicion(5, 4),
			new Posicion(6, 4),
			new Posicion(7, 4),
			new Posicion(8, 4),
			new Posicion(3, 5),
			new Posicion(4, 5),
			new Posicion(5, 5),
			new Posicion(6, 5),
			new Posicion(7, 5),
			new Posicion(8, 5)

	});
	
	private static Juego instance;
	
	private Jugador jugador;
	private Terreno terreno;
	
	
	public static Juego getInstance() 
			throws NoSePudoInicializarJuegoException {
		
		if(instance == null) {
			instance = createInstance();
		}
		
		return instance;
	}
	
	private synchronized static Juego createInstance() 
			throws NoSePudoInicializarJuegoException {
		
		if(instance == null) {
			instance = new Juego();
		}
		
		return instance;
	}
	
	private Juego() throws NoSePudoInicializarJuegoException {
		
		terreno = Terreno.createInstance(CANTIDAD_COLUMNAS_TERRENO, CANTIDAD_FILAS_TERRENO);
		jugador = Jugador.getInstance();
		
		posicionarJugador();
		posicionarMateriales();
	}
	
	private void posicionarMateriales() throws NoSePudoInicializarJuegoException {
		
		try {
			posicionarMadera();
		} catch (CasilleroOcupadoException | CasilleroNoEncontradoException e) {
			throw new NoSePudoInicializarJuegoException(e);
		}
	}

	private void posicionarMadera() 
			throws CasilleroOcupadoException, CasilleroNoEncontradoException {
		
		for(Posicion posicionMadera : POSICIONES_INICIALES_MADERA) {
			Madera madera = new Madera();
			terreno.ocuparCasillero(madera, posicionMadera);
		}
	}

	private void posicionarJugador() throws NoSePudoInicializarJuegoException {
		
		try {
			terreno.ocuparCasillero(jugador, POSICION_INICIAL_JUGADOR);
		} catch (CasilleroOcupadoException | CasilleroNoEncontradoException e) {
			throw new NoSePudoInicializarJuegoException(e);
		}
	}

	public Jugador obtenerJugador() {
		
		return jugador;
	}
	
	public Terreno obtenerTerreno() {
		
		return terreno;
	}

	public Posicionable obtenerPosicionable(Posicion posicion) 
			throws CasilleroNoEncontradoException {
		
		return terreno.obtenerCasillero(posicion).obtenerPosicionable();
	}
}
