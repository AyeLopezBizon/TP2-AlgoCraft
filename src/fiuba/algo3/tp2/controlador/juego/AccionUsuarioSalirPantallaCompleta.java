package fiuba.algo3.tp2.controlador.juego;

import fiuba.algo3.tp2.vista.juego.BarraDeMenu;
import javafx.stage.Stage;

public class AccionUsuarioSalirPantallaCompleta implements AccionUsuario {

	private Stage stage;
	private BarraDeMenu menuBar;
	

	public AccionUsuarioSalirPantallaCompleta(Stage stage, BarraDeMenu menuBar) {
		this.stage = stage;
		this.menuBar = menuBar;
	}

	@Override
	public void ejecutar() {
		
		stage.setMaximized(true);
        menuBar.aplicacionMaximizada();
	}
}
