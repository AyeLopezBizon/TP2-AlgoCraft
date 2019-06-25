package fiuba.algo3.tp2.controlador.inventario;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.jugador.inventario.InventarioLlenoException;
import fiuba.algo3.tp2.modelo.jugador.inventario.NoSePudoAlmacenarItemException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ContenedorHerramientaActivaOnDoubleClickHandler implements EventHandler<MouseEvent> {
	
	private Jugador jugador;

	public ContenedorHerramientaActivaOnDoubleClickHandler(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public void handle(MouseEvent mouseEvent) {
		
	    if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
	        if(mouseEvent.getClickCount() == 2){
	        	try {
					jugador.desequipar();
				} catch (InventarioLlenoException | NoSePudoAlmacenarItemException e) {
				}
	        }
	    }
	}
}
