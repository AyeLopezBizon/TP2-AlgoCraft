package fiuba.algo3.tp2.vista.inventario;

import fiuba.algo3.tp2.controlador.inventario.ContenedorCasilleroMesaDeTrabajoOnDragDropped;
import fiuba.algo3.tp2.controlador.inventario.ContenedorCasilleroMesaDeTrabajoOnMouseClicked;
import fiuba.algo3.tp2.modelo.herramienta.creador.MesaDeTrabajo;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.vista.ContenedorCasillero;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class ContenedorCasilleroMesaDeTrabajo extends ContenedorCasillero {
	
	private static final Background onDragEnterBackground = 
			new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY));
	private static final Background onDragExitBackground = null;
	
	private ImageView imageView;
	
	
	public ContenedorCasilleroMesaDeTrabajo(Inventario inventario, Posicion posicion, MesaDeTrabajo mesaDeTrabajo) {
		
		agregarEventosDeVista();
		
		setOnMouseClicked(new ContenedorCasilleroMesaDeTrabajoOnMouseClicked(posicion, mesaDeTrabajo, inventario));
		setOnDragDropped(new ContenedorCasilleroMesaDeTrabajoOnDragDropped(inventario, posicion, mesaDeTrabajo));
		
        imageView = new ImageView();
        imageView.fitWidthProperty().bind(widthProperty());
        imageView.fitHeightProperty().bind(heightProperty());
        
        getChildren().add(imageView);
	}
	
	/*
	 * Eventos que solo afectan a la vista
	 */
	private void agregarEventosDeVista() {
		
		setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != this &&
		                event.getDragboard().hasString()) {
		            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		        }
		        
		        event.consume();
		    }
		});
		
		setOnDragEntered(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		         if (event.getGestureSource() != this &&
		                 event.getDragboard().hasString()) {
		        	 
		        	 setBackground(onDragEnterBackground);
		         }
		         
		         event.consume();
		    }
		});
		
		setOnDragExited(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		    	
		    	setBackground(onDragExitBackground);
		    	
		        event.consume();
		    }
		});
	}

	@Override
	public void dibujar(Image imagen) {
		
		imageView.setImage(imagen);
	}
	
	public void limpiarCasillero() {
		imageView.setImage(null);
	}
}
