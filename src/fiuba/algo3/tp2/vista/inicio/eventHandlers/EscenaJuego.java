package fiuba.algo3.tp2.vista.inicio.eventHandlers;

import fiuba.algo3.tp2.controlador.CombinacionTeclas;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.terreno.Terreno;
import fiuba.algo3.tp2.vista.inventario.ContenedorInventario;
import fiuba.algo3.tp2.vista.juego.BarraDeMenu;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class EscenaJuego extends Scene {
	
	private CombinacionTeclas combinacionTeclas;
	
	
	public EscenaJuego(Stage stage, Parent root, ContenedorInventario contenedorInventario, BarraDeMenu menuBar, Jugador jugador, Terreno terreno) {
		
		super(root);
		this.combinacionTeclas = new CombinacionTeclas(stage, contenedorInventario, menuBar, jugador);
	}
	
	public void presionarTecla(KeyCode tecla) {
		
		combinacionTeclas.agregarTecla(tecla);
		combinacionTeclas.obtenerAccion().ejecutar();
	}

	public void soltarTecla(KeyCode tecla) {
		
		combinacionTeclas.quitarTecla(tecla);
	}
}
	