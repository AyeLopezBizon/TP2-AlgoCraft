package fiuba.algo3.tp2.vista.inicio.eventHandlers;

import java.util.HashSet;
import java.util.Set;

import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.jugador.movimiento.MovimientoDiagonalInferiorDerecha;
import fiuba.algo3.tp2.jugador.movimiento.MovimientoDiagonalInferiorIzquierda;
import fiuba.algo3.tp2.jugador.movimiento.MovimientoDiagonalSuperiorDerecha;
import fiuba.algo3.tp2.jugador.movimiento.MovimientoDiagonalSuperiorIzquierda;
import fiuba.algo3.tp2.jugador.movimiento.MovimientoHaciaAbajo;
import fiuba.algo3.tp2.jugador.movimiento.MovimientoHaciaArriba;
import fiuba.algo3.tp2.jugador.movimiento.MovimientoHaciaDerecha;
import fiuba.algo3.tp2.jugador.movimiento.MovimientoHaciaIzquierda;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.terreno.Terreno;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;

public class EscenaJuego extends Scene {
	
	private Jugador jugador;
	private Terreno terreno;
	private Set<KeyCode> teclasPresioandas;
	
	
	public EscenaJuego(Parent root, Jugador jugador, Terreno terreno) {
		
		super(root);
		
		this.jugador = jugador;
		this.terreno = terreno;
		this.teclasPresioandas = new HashSet<KeyCode>();
	}
	
	public void presionarTecla(KeyCode code) {
		
		this.teclasPresioandas.add(code);
		try {
			moverJugador();
		} catch (CasilleroNoEncontradoException | CasilleroOcupadoException | CasilleroVacioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void soltarTecla(KeyCode code) {
		
		this.teclasPresioandas.remove(code);
	}
	
	private void moverJugador() throws CasilleroNoEncontradoException, CasilleroOcupadoException, CasilleroVacioException {
		
		if (teclasPresioandas.contains(KeyCode.UP) && teclasPresioandas.contains(KeyCode.RIGHT)) {
			jugador.mover(new MovimientoDiagonalSuperiorDerecha(), terreno);
		} else if (teclasPresioandas.contains(KeyCode.UP) && teclasPresioandas.contains(KeyCode.LEFT)) {
			jugador.mover(new MovimientoDiagonalSuperiorIzquierda(), terreno);
		} else if (teclasPresioandas.contains(KeyCode.DOWN) && teclasPresioandas.contains(KeyCode.RIGHT)) {
			jugador.mover(new MovimientoDiagonalInferiorDerecha(), terreno);
		} else if (teclasPresioandas.contains(KeyCode.DOWN) && teclasPresioandas.contains(KeyCode.LEFT)) {
			jugador.mover(new MovimientoDiagonalInferiorIzquierda(), terreno);
		} else if (teclasPresioandas.contains(KeyCode.RIGHT)) {
			jugador.mover(new MovimientoHaciaDerecha(), terreno);
	    } else if (teclasPresioandas.contains(KeyCode.LEFT)) {
			jugador.mover(new MovimientoHaciaIzquierda(), terreno);
	    } else if (teclasPresioandas.contains(KeyCode.UP)) {
			jugador.mover(new MovimientoHaciaArriba(), terreno);
	    } else if (teclasPresioandas.contains(KeyCode.DOWN)) {
			jugador.mover(new MovimientoHaciaAbajo(), terreno);
	    }
	}
}
