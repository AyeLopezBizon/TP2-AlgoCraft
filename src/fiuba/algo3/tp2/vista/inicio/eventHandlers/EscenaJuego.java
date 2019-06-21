package fiuba.algo3.tp2.vista.inicio.eventHandlers;

import java.util.HashSet;
import java.util.Set;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.jugador.inventario.EspacioVacioException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.modelo.matriz.direccion.Direccion;
import fiuba.algo3.tp2.modelo.terreno.Terreno;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class EscenaJuego extends Scene {
	
	private Jugador jugador;
	private Terreno terreno;
	private Set<KeyCode> teclasPresioandas;
	private Stage stage;
	
	
	public EscenaJuego(Stage stage, Parent root, Jugador jugador, Terreno terreno) {
		
		super(root);
		
		this.stage = stage;
		this.jugador = jugador;
		this.terreno = terreno;
		this.teclasPresioandas = new HashSet<KeyCode>();
	}
	
	public void presionarTecla(KeyCode code) {
		
		this.teclasPresioandas.add(code);
		try {
			realizarAccion();
		} catch (CasilleroNoEncontradoException | CasilleroOcupadoException | 
				CasilleroVacioException | EspacioVacioException e) {
		}
	}

	public void soltarTecla(KeyCode code) {
		
		this.teclasPresioandas.remove(code);
	}
	
	private void realizarAccion() 
			throws CasilleroNoEncontradoException, CasilleroOcupadoException, 
			CasilleroVacioException, EspacioVacioException {
		
		if(teclasPresioandas.contains(KeyCode.E)) {
			jugador.equipar(1);
		} else if(teclasPresioandas.contains(KeyCode.TAB)) {
			// abrirInventario();
		} else if(teclasPresioandas.contains(KeyCode.SPACE)) {
			
			if (teclasPresioandas.contains(KeyCode.UP) && teclasPresioandas.contains(KeyCode.RIGHT)) {
				jugador.lanzarGolpe(Direccion.DIAGONAL_SUPERIOR_DERECHA);
			} else if (teclasPresioandas.contains(KeyCode.UP) && teclasPresioandas.contains(KeyCode.LEFT)) {
				jugador.lanzarGolpe(Direccion.DIAGONAL_SUPERIOR_IZQUIERDA);
			} else if (teclasPresioandas.contains(KeyCode.DOWN) && teclasPresioandas.contains(KeyCode.RIGHT)) {
				jugador.lanzarGolpe(Direccion.DIAGONAL_INFERIOR_DERECHA);
			} else if (teclasPresioandas.contains(KeyCode.DOWN) && teclasPresioandas.contains(KeyCode.LEFT)) {
				jugador.lanzarGolpe(Direccion.DIAGONAL_INFERIOR_IZQUIERDA);
			} else if (teclasPresioandas.contains(KeyCode.RIGHT)) {
				jugador.lanzarGolpe(Direccion.DERECHA);
		    } else if (teclasPresioandas.contains(KeyCode.LEFT)) {
		    	jugador.lanzarGolpe(Direccion.IZQUIERDA);
		    } else if (teclasPresioandas.contains(KeyCode.UP)) {
		    	jugador.lanzarGolpe(Direccion.ARRIBA);
		    } else if (teclasPresioandas.contains(KeyCode.DOWN)) {
		    	jugador.lanzarGolpe(Direccion.ABAJO);
		    }
		} else {
			if (teclasPresioandas.contains(KeyCode.UP) && teclasPresioandas.contains(KeyCode.RIGHT)) {
				jugador.mover(Direccion.DIAGONAL_SUPERIOR_DERECHA);
			} else if (teclasPresioandas.contains(KeyCode.UP) && teclasPresioandas.contains(KeyCode.LEFT)) {
				jugador.mover(Direccion.DIAGONAL_SUPERIOR_IZQUIERDA);
			} else if (teclasPresioandas.contains(KeyCode.DOWN) && teclasPresioandas.contains(KeyCode.RIGHT)) {
				jugador.mover(Direccion.DIAGONAL_INFERIOR_DERECHA);
			} else if (teclasPresioandas.contains(KeyCode.DOWN) && teclasPresioandas.contains(KeyCode.LEFT)) {
				jugador.mover(Direccion.DIAGONAL_INFERIOR_IZQUIERDA);
			} else if (teclasPresioandas.contains(KeyCode.RIGHT)) {
				jugador.mover(Direccion.DERECHA);
		    } else if (teclasPresioandas.contains(KeyCode.LEFT)) {
				jugador.mover(Direccion.IZQUIERDA);
		    } else if (teclasPresioandas.contains(KeyCode.UP)) {
				jugador.mover(Direccion.ARRIBA);
		    } else if (teclasPresioandas.contains(KeyCode.DOWN)) {
				jugador.mover(Direccion.ABAJO);
		    }
		}
	}
}
