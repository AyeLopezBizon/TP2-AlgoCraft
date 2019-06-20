package fiuba.algo3.tp2.vista.inicio.eventHandlers;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoHaciaDerecha;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.modelo.terreno.Terreno;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TerrenoOnKeyPressedHandler implements EventHandler<KeyEvent> {
	
	private Jugador jugador;
	private Terreno terreno;
	

	public TerrenoOnKeyPressedHandler(Jugador jugador, Terreno terreno) {
		this.jugador = jugador;
		this.terreno = terreno;
	}

	@Override
	public void handle(KeyEvent event) {
		if (event.getCode() == KeyCode.RIGHT) {
	        System.out.println("A key was pressed");
	        try {
				jugador.mover(new MovimientoHaciaDerecha(), terreno);
			} catch (CasilleroNoEncontradoException | CasilleroOcupadoException | CasilleroVacioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
}
