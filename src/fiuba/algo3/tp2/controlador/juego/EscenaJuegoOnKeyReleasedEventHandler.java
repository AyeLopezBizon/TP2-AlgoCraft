package fiuba.algo3.tp2.controlador.juego;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class EscenaJuegoOnKeyReleasedEventHandler implements EventHandler<KeyEvent> {

	private CombinacionTeclas combinacionTeclas;

	public EscenaJuegoOnKeyReleasedEventHandler(CombinacionTeclas combinacionTeclas) {
		
		this.combinacionTeclas = combinacionTeclas;
	}

	@Override
	public void handle(KeyEvent event) {
		
		combinacionTeclas.quitarTecla(event.getCode());
	}
}
