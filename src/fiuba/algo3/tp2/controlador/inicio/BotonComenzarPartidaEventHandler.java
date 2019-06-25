package fiuba.algo3.tp2.controlador.inicio;

import fiuba.algo3.tp2.controlador.juego.CombinacionTeclas;
import fiuba.algo3.tp2.controlador.juego.EscenaJuegoOnKeyPressEventHandler;
import fiuba.algo3.tp2.controlador.juego.EscenaJuegoOnKeyReleasedEventHandler;
import fiuba.algo3.tp2.modelo.herramienta.creador.CreadorHerramienta;
import fiuba.algo3.tp2.modelo.herramienta.creador.MesaDeTrabajoVacia;
import fiuba.algo3.tp2.modelo.juego.Juego;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.terreno.Terreno;
import fiuba.algo3.tp2.vista.inventario.ContenedorInventario;
import fiuba.algo3.tp2.vista.juego.BarraDeMenu;
import fiuba.algo3.tp2.vista.juego.ContenedorJuego;
import fiuba.algo3.tp2.vista.juego.ContenedorPrincipal;
import fiuba.algo3.tp2.vista.sonido.ReproductorSonido;
import fiuba.algo3.tp2.vista.sonido.Sonido;
import fiuba.algo3.tp2.vista.terreno.ContenedorTerreno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonComenzarPartidaEventHandler implements EventHandler<ActionEvent> {

	private Stage stage;
	
	public BotonComenzarPartidaEventHandler(Stage stage) {
		this.stage = stage;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		
		try {
			
			ReproductorSonido.reproducir(Sonido.CLICK);
			
			// Creacion del modelo
			Juego juego = new Juego();
			Terreno terreno = juego.obtenerTerreno();
			Jugador jugador = juego.obtenerJugador();
			MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();			
			CreadorHerramienta creadorHerramienta = new CreadorHerramienta();
			
			// Creacion de contenedores
			BarraDeMenu barraDeMenu = new BarraDeMenu(stage);
			ContenedorTerreno contenedorTerreno = new ContenedorTerreno(terreno);
			ContenedorInventario contenedorInventario = new ContenedorInventario(jugador, mesaDeTrabajo, creadorHerramienta);
			ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(contenedorTerreno, contenedorInventario);
			ContenedorJuego contenedorJuego = new ContenedorJuego(stage, barraDeMenu, contenedorPrincipal);
			
			CombinacionTeclas combinacionTeclas = new CombinacionTeclas(stage, contenedorInventario, barraDeMenu, jugador);
			
			Scene escenaJuego = new Scene(contenedorJuego);
			escenaJuego.setOnKeyPressed(new EscenaJuegoOnKeyPressEventHandler(combinacionTeclas));
			escenaJuego.setOnKeyReleased(new EscenaJuegoOnKeyReleasedEventHandler(combinacionTeclas));
	        
			// Inicializacion del juego
			juego.inicializar();
	        
			stage.setScene(escenaJuego);
			stage.setFullScreenExitHint("");
			stage.setFullScreen(true);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
