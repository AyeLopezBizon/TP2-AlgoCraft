package fiuba.algo3.tp2.vista.juego.eventHandler;

import fiuba.algo3.tp2.vista.inicio.eventHandlers.EscenaJuego;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class AplicacionOnKeyPressEventHandler implements EventHandler<KeyEvent> {	
	
	private EscenaJuego escena;

    public AplicacionOnKeyPressEventHandler(EscenaJuego escena) {
    	
    	this.escena = escena;
	}

	@Override
    public void handle(KeyEvent event) {
		
    	escena.presionarTecla(event.getCode());
    }
}