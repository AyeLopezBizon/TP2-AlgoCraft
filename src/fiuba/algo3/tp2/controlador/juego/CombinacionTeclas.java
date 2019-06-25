package fiuba.algo3.tp2.controlador.juego;

import java.util.HashSet;
import java.util.Set;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.matriz.direccion.Direccion;
import fiuba.algo3.tp2.vista.inventario.ContenedorInventario;
import fiuba.algo3.tp2.vista.juego.BarraDeMenu;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class CombinacionTeclas {
	
	private Set<KeyCode> teclasPresionadas;
	private Jugador jugador;
	private Stage stage;
	private BarraDeMenu menuBar;
	private ContenedorInventario contenedorInventario;
	
	
	public CombinacionTeclas(Stage stage, ContenedorInventario contenedorInventario, BarraDeMenu menuBar, Jugador jugador) {
		this.jugador = jugador;
		this.teclasPresionadas = new HashSet<KeyCode>();
		this.stage = stage;
		this.menuBar = menuBar;
		this.contenedorInventario = contenedorInventario;
	}
	
	public void agregarTecla(KeyCode tecla) {
		teclasPresionadas.add(tecla);
	}
	
	public void quitarTecla(KeyCode tecla) {
		teclasPresionadas.remove(tecla);
	}
	
	public AccionUsuario obtenerAccion() {
		
		if(teclasPresionadas.contains(KeyCode.ESCAPE)) {
			return new AccionUsuarioSalirPantallaCompleta(stage, menuBar);
		} else if(teclasPresionadas.contains(KeyCode.E)) {
			return new AccionUsuarioEquipar(jugador);
		} else if(teclasPresionadas.contains(KeyCode.TAB)) {
			return new AccionUsuarioAbrirInventario(contenedorInventario);
		} else if(teclasPresionadas.contains(KeyCode.SPACE)) {
			return new AccionUsuarioLanzarGolpe(jugador, obtenerDireccion());
		} else {
			return new AccionUsuarioMoverJugador(jugador, obtenerDireccion());
		}
	}

	private Direccion obtenerDireccion() {
		
		if (teclasPresionadas.contains(KeyCode.UP) && teclasPresionadas.contains(KeyCode.RIGHT)) {
			return Direccion.DIAGONAL_SUPERIOR_DERECHA;
		} else if (teclasPresionadas.contains(KeyCode.UP) && teclasPresionadas.contains(KeyCode.LEFT)) {
			return Direccion.DIAGONAL_SUPERIOR_IZQUIERDA;
		} else if (teclasPresionadas.contains(KeyCode.DOWN) && teclasPresionadas.contains(KeyCode.RIGHT)) {
			return Direccion.DIAGONAL_INFERIOR_DERECHA;
		} else if (teclasPresionadas.contains(KeyCode.DOWN) && teclasPresionadas.contains(KeyCode.LEFT)) {
			return Direccion.DIAGONAL_INFERIOR_IZQUIERDA;
		} else if (teclasPresionadas.contains(KeyCode.RIGHT)) {
			return Direccion.DERECHA;
	    } else if (teclasPresionadas.contains(KeyCode.LEFT)) {
	    	return Direccion.IZQUIERDA;
	    } else if (teclasPresionadas.contains(KeyCode.UP)) {
	    	return Direccion.ARRIBA;
	    } else if (teclasPresionadas.contains(KeyCode.DOWN)) {
	    	return Direccion.ABAJO;
	    } else {
	    	return null;
	    }
	}
}
