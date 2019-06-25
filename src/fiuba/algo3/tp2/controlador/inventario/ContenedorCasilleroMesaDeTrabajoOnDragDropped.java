package fiuba.algo3.tp2.controlador.inventario;

import fiuba.algo3.tp2.modelo.herramienta.creador.MesaDeTrabajo;
import fiuba.algo3.tp2.modelo.herramienta.creador.PosicionIncorrectaException;
import fiuba.algo3.tp2.modelo.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.modelo.jugador.inventario.EspacioVacioException;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;

public class ContenedorCasilleroMesaDeTrabajoOnDragDropped implements EventHandler<DragEvent> {
	
	private Inventario inventario;
	private Posicion posicion;
	private MesaDeTrabajo mesaDeTrabajo;
	
	public ContenedorCasilleroMesaDeTrabajoOnDragDropped(Inventario inventario, Posicion posicion, MesaDeTrabajo mesaDeTrabajo) {
		this.inventario = inventario;
		this.posicion = posicion;
		this.mesaDeTrabajo = mesaDeTrabajo;
	}

	@Override
	public void handle(DragEvent event) {
    	
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
           
        	Integer numeroEspacioInventario = Integer.valueOf(db.getString());
        	try {
        		
				Almacenable almacenable = inventario.obtenerAlmacenable(numeroEspacioInventario);
				almacenable.agregarAMesaDeTrabajo(mesaDeTrabajo, posicion);
				success = true;
				
			} catch (EspacioVacioException | PosicionIncorrectaException e) {
				e.printStackTrace();
			}
        }
        
        event.setDropCompleted(success);
        
        event.consume();
     }
}
