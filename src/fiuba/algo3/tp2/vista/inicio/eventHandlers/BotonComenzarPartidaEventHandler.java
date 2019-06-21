package fiuba.algo3.tp2.vista.inicio.eventHandlers;

import fiuba.algo3.tp2.modelo.juego.Juego;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.terreno.Terreno;
import fiuba.algo3.tp2.vista.juego.BarraDeMenu;
import fiuba.algo3.tp2.vista.juego.ContenedorJuego;
import fiuba.algo3.tp2.vista.terreno.ContenedorTerreno;
import fiuba.algo3.tp2.vista.terreno.VistaTerreno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonComenzarPartidaEventHandler implements EventHandler<ActionEvent> {

	private Stage stage;
	
	public BotonComenzarPartidaEventHandler(Stage stage) {
		this.stage = stage;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		
		Juego juego = null;
		try {
			juego = new Juego();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Terreno terreno = juego.obtenerTerreno();
		Jugador jugador = juego.obtenerJugador();
		
		BarraDeMenu barraDeMenu = new BarraDeMenu(stage);
		ContenedorTerreno contenedorTerreno = new ContenedorTerreno(terreno);		
		ContenedorJuego contenedorJuego = new ContenedorJuego(stage, barraDeMenu, contenedorTerreno);
		
		VistaTerreno vistaTerreno = new VistaTerreno(terreno, contenedorTerreno);		
		EscenaJuego escenaJuego = new EscenaJuego(stage, contenedorJuego, barraDeMenu, jugador, terreno);
		
		AplicacionOnKeyPressEventHandler aplicacionOnKeyPressEventHandler = 
				new AplicacionOnKeyPressEventHandler(escenaJuego);
		escenaJuego.setOnKeyPressed(aplicacionOnKeyPressEventHandler);
		
		AplicacionOnKeyReleasedEventHandler aplicacionOnKeyReleasedEventHandler = 
				new AplicacionOnKeyReleasedEventHandler(escenaJuego);
		escenaJuego.setOnKeyReleased(aplicacionOnKeyReleasedEventHandler);
        
        try {
			juego.inicializar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
		stage.setScene(escenaJuego);
		stage.setFullScreenExitHint("");
		stage.setFullScreen(true);
	}
}
