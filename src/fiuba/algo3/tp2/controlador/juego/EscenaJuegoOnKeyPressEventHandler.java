package fiuba.algo3.tp2.controlador.juego;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EscenaJuegoOnKeyPressEventHandler implements EventHandler<KeyEvent> {	
	
	private CombinacionTeclas combinacionTeclas;

    public EscenaJuegoOnKeyPressEventHandler(CombinacionTeclas combinacionTeclas) {
    	
    	this.combinacionTeclas = combinacionTeclas;
	}

	@Override
    public void handle(KeyEvent event) {
		
		combinacionTeclas.agregarTecla(event.getCode());
    }
}