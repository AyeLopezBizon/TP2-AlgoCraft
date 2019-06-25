package fiuba.algo3.tp2.controlador.juego;

import fiuba.algo3.tp2.vista.sonido.ReproductorSonido;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class OpcionSilenciarEventHandler implements EventHandler<ActionEvent> {
	
	private boolean silenciado = false;
	private MenuItem opcion;
	
    public OpcionSilenciarEventHandler(MenuItem opcion) {
    	this.opcion = opcion;
	}

	@Override
    public void handle(ActionEvent actionEvent) {
    	
    	silenciado = !silenciado;
    	
        ReproductorSonido.silenciar(silenciado);
        opcion.setText((silenciado) ? "Unmute" : "Mute"); 
    }

}
