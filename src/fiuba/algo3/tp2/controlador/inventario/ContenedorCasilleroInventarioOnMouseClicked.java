package fiuba.algo3.tp2.controlador.inventario;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.jugador.inventario.EspacioVacioException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ContenedorCasilleroInventarioOnMouseClicked implements EventHandler<MouseEvent> {

	private Jugador jugador;
	private Integer numeroEspacioInventario;
	

	public ContenedorCasilleroInventarioOnMouseClicked(Jugador jugador, Integer numeroEspacioInventario) {
		this.jugador = jugador;
		this.numeroEspacioInventario = numeroEspacioInventario;
	}

	@Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
            if(mouseEvent.getClickCount() == 2){
            	try {
					jugador.equipar(numeroEspacioInventario);
				} catch (EspacioVacioException e) {
					e.printStackTrace();
				}
            }
        }
    }
}
