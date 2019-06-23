package fiuba.algo3.tp2.vista.inventario;

import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.modelo.jugador.inventario.EspacioVacioException;
import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

public class VistaCasilleroInventario extends Pane implements Observer {

	private Almacenable almacenable;
	private VistaAlmacenable vistaAlmacenable;
	private static Jugador jugador;

	@Override
	public void update(Observable o, Object arg) {
		
		Object[] parametros = ((Object[])arg);
		String accion = (String)parametros[0];
		
		if(accion.equals("ocuparCasillero")) {
			try {
				
				almacenable = (Almacenable)parametros[1];
				
				String nombreClaseVista = "fiuba.algo3.tp2.vista.inventario.Vista" + almacenable.getClass().getSimpleName();
				vistaAlmacenable = (VistaAlmacenable) Class.forName(nombreClaseVista)
						.getDeclaredConstructor(Pane.class, Almacenable.class)
						.newInstance(this, almacenable);
				
				almacenable.addObserver(vistaAlmacenable);
				
				setOnDragDetected(new EventHandler<MouseEvent>() {
				    public void handle(MouseEvent event) {
				        /* drag was detected, start a drag-and-drop gesture*/
				        /* allow any transfer mode */
				        Dragboard db = startDragAndDrop(TransferMode.ANY);
				        
				        /* Put a string on a dragboard */
				        ClipboardContent content = new ClipboardContent();
				        content.putString(almacenable.obtenerNumeroEspacioInventario().toString());
				        db.setContent(content);
				        
				        event.consume();
				    }
				});
				setOnMouseClicked(new EventHandler<MouseEvent>() {
				    @Override
				    public void handle(MouseEvent mouseEvent) {
				        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
				            if(mouseEvent.getClickCount() == 2){
				            	try {
									jugador.equipar(almacenable.obtenerNumeroEspacioInventario());
								} catch (EspacioVacioException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				            }
				        }
				    }
				});
				vistaAlmacenable.dibujar();
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
	
	public void dibujar(Integer numeroCasillero, Jugador jugador, Almacenable almacenable) {
		
		try {
			this.almacenable = almacenable;
			this.jugador = jugador;
			String nombreClaseVista = "fiuba.algo3.tp2.vista.inventario.Vista" + almacenable.getClass().getSimpleName();
		
			vistaAlmacenable = (VistaAlmacenable) Class.forName(nombreClaseVista)
					.getDeclaredConstructor(VistaCasilleroInventario.class, Almacenable.class)
					.newInstance(this, almacenable);
	
			almacenable.addObserver(vistaAlmacenable);
			
			setOnDragDetected(new EventHandler<MouseEvent>() {
			    public void handle(MouseEvent event) {
			        /* drag was detected, start a drag-and-drop gesture*/
			        /* allow any transfer mode */
			        Dragboard db = startDragAndDrop(TransferMode.ANY);
			        
			        /* Put a string on a dragboard */
			        ClipboardContent content = new ClipboardContent();
			        content.putString(almacenable.obtenerNumeroEspacioInventario().toString());
			        db.setContent(content);
			        
			        event.consume();
			    }
			});
			
			setOnMouseClicked(new EventHandler<MouseEvent>() {
			    @Override
			    public void handle(MouseEvent mouseEvent) {
			        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
			            if(mouseEvent.getClickCount() == 2){
			            	try {
								jugador.equipar(numeroCasillero);
							} catch (EspacioVacioException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			            }
			        }
			    }
			});
			vistaAlmacenable.dibujar();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void limpiarCasillero() {
		almacenable.deleteObserver(vistaAlmacenable);
		getChildren().clear();
	}
}
