package fiuba.algo3.tp2.vista.inventario;

import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.herramienta.creador.MesaDeTrabajo;
import fiuba.algo3.tp2.modelo.herramienta.creador.PosicionIncorrectaException;
import fiuba.algo3.tp2.modelo.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.modelo.jugador.inventario.EspacioVacioException;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import fiuba.algo3.tp2.modelo.jugador.inventario.InventarioLlenoException;
import fiuba.algo3.tp2.modelo.jugador.inventario.NoSePudoAlmacenarItemException;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMaterial;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class VistaCasilleroMesaDeTrabajo extends Pane implements Observer {
	
	private static final Background onDragEnterBackground = 
			new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY));
	private static final Background onDragExitBackground = null;
	private VistaUnidadMaterial vista;
	private Almacenable almacenable;
	
	
	public VistaCasilleroMesaDeTrabajo(Inventario inventario, MesaDeTrabajo mesaDeTrabajo, Posicion posicion) {
		
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
		
		setOnDragDropped(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		    	
		        Dragboard db = event.getDragboard();
		        boolean success = false;
		        if (db.hasString()) {
		           
		        	Integer numeroEspacioInventario = Integer.valueOf(db.getString());
		        	try {
						almacenable = inventario.obtenerAlmacenable(numeroEspacioInventario);
						almacenable.agregarAMesaDeTrabajo(mesaDeTrabajo, posicion);
						success = true;
					} catch (EspacioVacioException | PosicionIncorrectaException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        
		        event.setDropCompleted(success);
		        
		        event.consume();
		     }
		});
		
		setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
		            if(mouseEvent.getClickCount() == 2){
		            	try {
		            		UnidadMaterial unidadMaterial = mesaDeTrabajo.obtenerPosicionable(posicion);
							inventario.almacenar(unidadMaterial);
							mesaDeTrabajo.quitarMaterial(posicion);
						} catch (PosicionIncorrectaException | InventarioLlenoException | NoSePudoAlmacenarItemException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
		        }
		    }
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		
		Object[] parametros = ((Object[])arg);
		String accion = (String)parametros[0];
		
		if(accion.equals("ocuparCasillero")) {
			try {
				
				UnidadMaterial unidadMaterial = (UnidadMaterial)parametros[1];
				
				String nombreClaseVista = "fiuba.algo3.tp2.vista.inventario.Vista" + unidadMaterial.getClass().getSimpleName();
				vista = (VistaUnidadMaterial) Class.forName(nombreClaseVista)
						.getDeclaredConstructor(Pane.class, Almacenable.class)
						.newInstance(this, unidadMaterial);
				
				vista.dibujar();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else if(accion.equals("desocuparCasillero")){
			limpiarCasillero();
		}
	}
	
	private void limpiarCasillero() {
		getChildren().clear();
	}
}
