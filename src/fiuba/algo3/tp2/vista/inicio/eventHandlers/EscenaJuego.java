package fiuba.algo3.tp2.vista.inicio.eventHandlers;

import fiuba.algo3.tp2.controlador.CombinacionTeclas;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.terreno.Terreno;
import fiuba.algo3.tp2.vista.juego.BarraDeMenu;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class EscenaJuego extends Scene {
	
	private Jugador jugador;
	private Terreno terreno;
	private CombinacionTeclas combinacionTeclas;
	private Stage stage;
	
	
	public EscenaJuego(Stage stage, Parent root, BarraDeMenu menuBar, Jugador jugador, Terreno terreno) {
		
		super(root);
		
		this.stage = stage;
		this.jugador = jugador;
		this.terreno = terreno;
		this.combinacionTeclas = new CombinacionTeclas(stage, menuBar, jugador);
	}
	
	public void presionarTecla(KeyCode tecla) {
		
		combinacionTeclas.agregarTecla(tecla);
		combinacionTeclas.obtenerAccion().ejecutar();
	}

	public void soltarTecla(KeyCode tecla) {
		
		combinacionTeclas.quitarTecla(tecla);
	}
}
