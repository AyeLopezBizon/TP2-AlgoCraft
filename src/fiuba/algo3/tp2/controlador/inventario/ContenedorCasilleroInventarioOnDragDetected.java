package fiuba.algo3.tp2.controlador.inventario;

import fiuba.algo3.tp2.vista.inventario.ContenedorCasilleroInventario;
import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class ContenedorCasilleroInventarioOnDragDetected implements EventHandler<MouseEvent> {

	private Integer numeroEspacioInventario;
	private ContenedorCasilleroInventario contenedorCasilleroInventario;
	

	public ContenedorCasilleroInventarioOnDragDetected(ContenedorCasilleroInventario contenedorCasilleroInventario,
			Integer numeroEspacioInventario) {
		this.numeroEspacioInventario = numeroEspacioInventario;
		this.contenedorCasilleroInventario = contenedorCasilleroInventario;
	}
	
	@Override
	public void handle(MouseEvent event) {
    	
        Dragboard db = contenedorCasilleroInventario.startDragAndDrop(TransferMode.ANY);
        
        ClipboardContent content = new ClipboardContent();
        content.putString(numeroEspacioInventario.toString());
        db.setContent(content);
        
        event.consume();
    }
}
