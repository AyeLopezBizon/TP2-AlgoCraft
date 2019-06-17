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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
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
		} catch (CasilleroNoEncontradoException | CasilleroOcupadoException | CasilleroVacioException e) {
		}
	}

	public void soltarTecla(KeyCode code) {
		
		this.teclasPresioandas.remove(code);
	}
	
	private void realizarAccion() throws CasilleroNoEncontradoException, CasilleroOcupadoException, CasilleroVacioException {
		
		if(teclasPresioandas.contains(KeyCode.TAB)) {
			// abrirInventario();
		} else if(teclasPresioandas.contains(KeyCode.SPACE)) {
			
			if (teclasPresioandas.contains(KeyCode.UP) && teclasPresioandas.contains(KeyCode.RIGHT)) {
				jugador.lanzarGolpe(new DireccionGolpeSuperiorDerecha(jugador, terreno));
			} else if (teclasPresioandas.contains(KeyCode.UP) && teclasPresioandas.contains(KeyCode.LEFT)) {
				jugador.lanzarGolpe(new DireccionGolpeSuperiorDerecha(jugador, terreno));
			} else if (teclasPresioandas.contains(KeyCode.DOWN) && teclasPresioandas.contains(KeyCode.RIGHT)) {
				jugador.lanzarGolpe(new DireccionGolpeSuperiorDerecha(jugador, terreno));
			} else if (teclasPresioandas.contains(KeyCode.DOWN) && teclasPresioandas.contains(KeyCode.LEFT)) {
				jugador.lanzarGolpe(new DireccionGolpeSuperiorDerecha(jugador, terreno));
			} else if (teclasPresioandas.contains(KeyCode.RIGHT)) {
				System.out.println("GOLPE");
				jugador.lanzarGolpe(new DireccionGolpeDerecha(jugador, terreno));
		    } else if (teclasPresioandas.contains(KeyCode.LEFT)) {
		    	jugador.lanzarGolpe(new DireccionGolpeIzquierda(jugador, terreno));
		    } else if (teclasPresioandas.contains(KeyCode.UP)) {
		    	jugador.lanzarGolpe(new DireccionGolpeArriba(jugador, terreno));
		    } else if (teclasPresioandas.contains(KeyCode.DOWN)) {
		    	jugador.lanzarGolpe(new DireccionGolpeAbajo(jugador, terreno));
		    }
		} else {
			System.out.println("MOVIMIENTO");
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
}
