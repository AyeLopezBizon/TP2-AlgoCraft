package fiuba.algo3.tp2.vista.inicio.eventHandlers;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.terreno.Terreno;
import fiuba.algo3.tp2.vista.juego.ContenedorJuego;
import fiuba.algo3.tp2.vista.juego.eventHandler.AplicacionOnKeyPressEventHandler;
import fiuba.algo3.tp2.vista.juego.terreno.ContenedorTerreno;
import fiuba.algo3.tp2.vista.juego.terreno.VistaTerreno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonComenzarPartidaEventHandler implements EventHandler<ActionEvent> {

	Stage stage;
	
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
		
		ContenedorTerreno contenedorTerreno = new ContenedorTerreno(terreno);		
		ContenedorJuego contenedorJuego = new ContenedorJuego(stage, contenedorTerreno);
		
		VistaTerreno vistaTerreno = new VistaTerreno(terreno, contenedorTerreno);
		vistaTerreno.dibujarTerreno();
		terreno.addObserver(vistaTerreno);
		
		EscenaJuego escenaJuego = new EscenaJuego(stage, contenedorJuego, jugador, terreno);
		
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
