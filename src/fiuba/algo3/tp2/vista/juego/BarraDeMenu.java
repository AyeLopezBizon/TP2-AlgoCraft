package fiuba.algo3.tp2.vista.juego;

import fiuba.algo3.tp2.controlador.juego.OpcionPantallaCompletaEventHandler;
import fiuba.algo3.tp2.controlador.juego.OpcionSalirEventHandler;
import fiuba.algo3.tp2.controlador.juego.OpcionSilenciarEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {
	
	private static final String CAPTION_MENU_ARCHIVO = "Archivo";
	private static final String CAPTION_MENU_VER = "Ver";
	private static final String CAPTION_MENU_SONIDO = "Sonido";
	
	private static final String CAPTION_MENU_SALIR = "Salir";
	private static final String CAPTION_MENU_PANTALLA_COMPLETA = "Pantalla completa";
	private static final String CAPTION_MENU_MUTE = "Mute";
	
	private MenuItem opcionPantallaCompleta = new MenuItem(CAPTION_MENU_PANTALLA_COMPLETA);
	
	
	public BarraDeMenu(Stage stage) {
		
		agregarMenuArchivo();
		agregarMenuVer(stage);
	    agregarMenuSonido();
	}
	
	private void agregarMenuArchivo() {
		
		Menu menuArchivo = new Menu(CAPTION_MENU_ARCHIVO);
		
		MenuItem opcionSalir = new MenuItem(CAPTION_MENU_SALIR);
	    opcionSalir.setOnAction(new OpcionSalirEventHandler());
		
		menuArchivo.getItems().addAll(opcionSalir);
		
		getMenus().add(menuArchivo);
	}

	private void agregarMenuVer(Stage stage) {
		
		Menu menuVer = new Menu(CAPTION_MENU_VER);
		
	    OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = 
	    		new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
	    opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);
	    opcionPantallaCompleta.setDisable(true);
	    
	    menuVer.getItems().addAll(opcionPantallaCompleta);
	    
	    getMenus().add(menuVer);
	}
	
	private void agregarMenuSonido() {
		
	    Menu menuSonido = new Menu(CAPTION_MENU_SONIDO);
	    
	    MenuItem opcionSilenciar = new MenuItem(CAPTION_MENU_MUTE);
	    OpcionSilenciarEventHandler opcionSilenciarEventHandler = new OpcionSilenciarEventHandler(opcionSilenciar);
	    opcionSilenciar.setOnAction(opcionSilenciarEventHandler);
	    
	    menuSonido.getItems().addAll(opcionSilenciar);
	
	    this.getMenus().addAll(menuSonido);
	}


	public void aplicacionMaximizada() {
		opcionPantallaCompleta.setDisable(false);
	}
}
