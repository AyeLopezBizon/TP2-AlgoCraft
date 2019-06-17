package fiuba.algo3.tp2.juego;

import java.util.Arrays;
import java.util.Collection;

import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.terreno.Terreno;

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
	
	private static final Collection<Posicion> POSICIONES_INICIALES_PIEDRA = Arrays.asList(new Posicion[] {
			new Posicion(8, 8),
			new Posicion(9, 8),
			new Posicion(10, 8),
			new Posicion(11, 8),
			new Posicion(12, 8),
			new Posicion(8, 9),
			new Posicion(9, 9),
			new Posicion(10, 9),
			new Posicion(11, 9),
			new Posicion(12, 9),
			new Posicion(8, 10),
			new Posicion(9, 10),
			new Posicion(10, 10),
			new Posicion(11, 10),
			new Posicion(12, 10),
			new Posicion(8, 11),
			new Posicion(9, 11),
			new Posicion(10, 11),
			new Posicion(11, 11),
			new Posicion(12, 11)

	});
	
	private static final Collection<Posicion> POSICIONES_INICIALES_METAL = Arrays.asList(new Posicion[] {
			new Posicion(2, 10),
			new Posicion(3, 10),
			new Posicion(2, 11),
			new Posicion(3, 11),
			new Posicion(15, 15),
			new Posicion(16, 15),
			new Posicion(15, 16),
			new Posicion(16, 16)
	});
	
	private static final Collection<Posicion> POSICIONES_INICIALES_DIAMANTE = Arrays.asList(new Posicion[] {
			new Posicion(6, 16),
			new Posicion(7, 16),
			new Posicion(17, 5)
	});
	
	private Jugador jugador;
	private Terreno terreno;
	
	
	public Juego() throws Exception {
		
		terreno = new Terreno(CANTIDAD_COLUMNAS_TERRENO, CANTIDAD_FILAS_TERRENO);
		jugador = new Jugador();
		
		posicionarJugador();
		posicionarMateriales();
	}

	private void posicionarMateriales() throws Exception {
		
		try {
			posicionarMadera();
			posicionarPiedra();
			posicionarMetal();
			posicionarDiamante();
		} catch (CasilleroOcupadoException | CasilleroNoEncontradoException e) {
			throw new NoSePudoInicializarJuegoException(e);
		}
	}

	private void posicionarMadera() 
			throws Exception {
		
		for(Posicion posicionMadera : POSICIONES_INICIALES_MADERA) {
			Madera madera = new Madera();
			terreno.ocuparCasillero(madera, posicionMadera);
		}
	}
	
	private void posicionarPiedra() 
			throws Exception {
		
		for(Posicion posicionPiedra : POSICIONES_INICIALES_PIEDRA) {
			Piedra piedra = new Piedra();
			terreno.ocuparCasillero(piedra, posicionPiedra);
		}
	}
	
	private void posicionarMetal() 
			throws Exception {
		
		for(Posicion posicionMetal : POSICIONES_INICIALES_METAL) {
			Metal metal = new Metal();
			terreno.ocuparCasillero(metal, posicionMetal);
		}
	}
	
	private void posicionarDiamante() 
			throws Exception {
		
		for(Posicion posicionDiamante : POSICIONES_INICIALES_DIAMANTE) {
			Diamante diamante = new Diamante();
			terreno.ocuparCasillero(diamante, posicionDiamante);
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

	public OcupanteTerreno obtenerOcupanteTerreno(Posicion posicion) 
			throws Exception {
		
		return terreno.obtenerOcupanteTerreno(posicion);
	}
}
