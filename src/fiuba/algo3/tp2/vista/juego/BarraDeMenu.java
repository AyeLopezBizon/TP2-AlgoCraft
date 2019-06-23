package fiuba.algo3.tp2.vista.juego;

import fiuba.algo3.tp2.vista.juego.eventHandler.OpcionPantallaCompletaEventHandler;
import fiuba.algo3.tp2.vista.juego.eventHandler.OpcionSalirEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {
	
	private MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");
	
	public BarraDeMenu(Stage stage) {
	
	    Menu menuArchivo = new Menu("Archivo");
	    Menu menuVer = new Menu("Ver");
	    Menu menuSonido = new Menu("Sonido");
	
	    MenuItem opcionSalir = new MenuItem("Salir");
	    opcionSalir.setOnAction(new OpcionSalirEventHandler());
	
	    OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
	    opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);
	    opcionPantallaCompleta.setDisable(true);
	    
	    MenuItem opcionSilenciar = new MenuItem("Mute");
	    OpcionSilenciarEventHandler opcionSilenciarEventHandler = new OpcionSilenciarEventHandler(opcionSilenciar);
	    opcionSilenciar.setOnAction(opcionSilenciarEventHandler);
	
	    menuArchivo.getItems().addAll(opcionSalir);
	    menuVer.getItems().addAll(opcionPantallaCompleta);
	    menuSonido.getItems().addAll(opcionSilenciar);
	
	    this.getMenus().addAll(menuArchivo, menuVer, menuSonido);
	}

	public void aplicacionMaximizada() {
		opcionPantallaCompleta.setDisable(false);
	}
}
