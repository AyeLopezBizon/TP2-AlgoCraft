package fiuba.algo3.tp2.vista.inicio.eventHandlers;

import java.util.HashSet;
import java.util.Set;

import fiuba.algo3.tp2.modelo.herramienta.golpe.DireccionGolpeAbajo;
import fiuba.algo3.tp2.modelo.herramienta.golpe.DireccionGolpeArriba;
import fiuba.algo3.tp2.modelo.herramienta.golpe.DireccionGolpeDerecha;
import fiuba.algo3.tp2.modelo.herramienta.golpe.DireccionGolpeInferiorDerecha;
import fiuba.algo3.tp2.modelo.herramienta.golpe.DireccionGolpeInferiorIzquierda;
import fiuba.algo3.tp2.modelo.herramienta.golpe.DireccionGolpeIzquierda;
import fiuba.algo3.tp2.modelo.herramienta.golpe.DireccionGolpeSuperiorDerecha;
import fiuba.algo3.tp2.modelo.herramienta.golpe.DireccionGolpeSuperiorIzquierda;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.jugador.inventario.EspacioVacioException;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoDiagonalInferiorDerecha;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoDiagonalInferiorIzquierda;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoDiagonalSuperiorDerecha;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoDiagonalSuperiorIzquierda;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoHaciaAbajo;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoHaciaArriba;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoHaciaDerecha;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoHaciaIzquierda;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;
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
				jugador.lanzarGolpe(new DireccionGolpeSuperiorDerecha(jugador, terreno));
			} else if (teclasPresioandas.contains(KeyCode.UP) && teclasPresioandas.contains(KeyCode.LEFT)) {
				jugador.lanzarGolpe(new DireccionGolpeSuperiorIzquierda(jugador, terreno));
			} else if (teclasPresioandas.contains(KeyCode.DOWN) && teclasPresioandas.contains(KeyCode.RIGHT)) {
				jugador.lanzarGolpe(new DireccionGolpeInferiorDerecha(jugador, terreno));
			} else if (teclasPresioandas.contains(KeyCode.DOWN) && teclasPresioandas.contains(KeyCode.LEFT)) {
				jugador.lanzarGolpe(new DireccionGolpeInferiorIzquierda(jugador, terreno));
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
