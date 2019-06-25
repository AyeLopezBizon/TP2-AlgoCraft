package fiuba.algo3.tp2.controlador.inventario;

import fiuba.algo3.tp2.modelo.herramienta.creador.MesaDeTrabajo;
import fiuba.algo3.tp2.modelo.herramienta.creador.PosicionIncorrectaException;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import fiuba.algo3.tp2.modelo.jugador.inventario.InventarioLlenoException;
import fiuba.algo3.tp2.modelo.jugador.inventario.NoSePudoAlmacenarItemException;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMaterial;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ContenedorCasilleroMesaDeTrabajoOnMouseClicked implements EventHandler<MouseEvent> {

	private Posicion posicion;
	private MesaDeTrabajo mesaDeTrabajo;
	private Inventario inventario;
	
	public ContenedorCasilleroMesaDeTrabajoOnMouseClicked(Posicion posicion, MesaDeTrabajo mesaDeTrabajo, Inventario inventario) {
		this.posicion = posicion;
		this.mesaDeTrabajo = mesaDeTrabajo;
		this.inventario = inventario;
	}

	@Override
	public void handle(MouseEvent mouseEvent) {
		
	    if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
	        if(mouseEvent.getClickCount() == 2){
	        	try {
	        		
	        		UnidadMaterial unidadMaterial = mesaDeTrabajo.obtenerPosicionable(posicion);
					inventario.almacenar(unidadMaterial);
					mesaDeTrabajo.quitarMaterial(posicion);
					
				} catch (PosicionIncorrectaException | InventarioLlenoException | NoSePudoAlmacenarItemException e) {
					e.printStackTrace();
				}
	        }
	    }
	}
}
